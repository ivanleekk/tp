package seedu.staffsnap.logic.commands;

import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_FILENAME;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import seedu.staffsnap.logic.Messages;
import seedu.staffsnap.logic.commands.exceptions.CommandException;
import seedu.staffsnap.logic.parser.CsvApplicantParser;
import seedu.staffsnap.logic.parser.exceptions.ParseException;
import seedu.staffsnap.model.Model;
import seedu.staffsnap.model.applicant.Applicant;


/**
 * Imports applicants from a CSV file and adds them to the applicant book.
 */
public class ImportCommand extends Command {
    public static final String COMMAND_WORD = "import";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Imports applicants from a CSV file.\n"
            + "Parameters: "
            + PREFIX_FILENAME + "FILENAME\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_FILENAME + "applicants.csv";

    public static final String MESSAGE_SUCCESS_SINGULAR = "Imported %d applicant from %s";
    public static final String MESSAGE_SUCCESS_PLURAL = "Imported %d applicants from %s";
    public static final String MESSAGE_INVALID_CSV_FORMAT = "The csv file has an invalid format!";
    public static final String MESSAGE_INVALID_FILENAME = "The file name provided is not a valid csv file!";
    public static final String MESSAGE_DUPLICATE_APPLICANT = "The csv file contains applicants that are "
            + "already in Staff-Snap:\n%s";
    public static final String MESSAGE_CSV_CONTAINS_DUPLICATE = "The csv file contains duplicate applicants:\n%s";
    public static final String MESSAGE_FILE_NOT_FOUND = "File not found: %s";
    public static final String FILENAME_VALIDATION_REGEX = "[-_. A-Za-z0-9]+\\.csv";

    private final String fileName;

    public ImportCommand(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Applicant> applicantsToImport;
        try {
            applicantsToImport = CsvApplicantParser.parse(fileName);
        } catch (IOException ioe) {
            throw new CommandException(String.format(MESSAGE_FILE_NOT_FOUND, fileName));
        } catch (ParseException pe) {
            throw new CommandException(MESSAGE_INVALID_CSV_FORMAT);
        }

        // checks if the csv file contains duplicate applicants
        if (containsDuplicates(applicantsToImport)) {
            List<Applicant> duplicateApplicantInCsv = getDuplicateApplicantsInCsv(applicantsToImport);
            String duplicateApplicantsInCsvString = duplicateApplicantInCsv.stream()
                    .map(Messages::format)
                    .collect(Collectors.joining(",\n"));
            throw new CommandException(String.format(MESSAGE_CSV_CONTAINS_DUPLICATE,
                    duplicateApplicantsInCsvString));
        }

        // checks if the csv file contains applicants already in Staff-Snap
        if (hasDuplicateApplicants(applicantsToImport, model)) {
            List<Applicant> duplicateApplicantsInModel = getDuplicateApplicantsInModel(applicantsToImport, model);
            String duplicateApplicantsInModelString = duplicateApplicantsInModel.stream()
                    .map(Messages::format)
                    .collect(Collectors.joining(",\n"));
            throw new CommandException(String.format(MESSAGE_DUPLICATE_APPLICANT,
                    duplicateApplicantsInModelString));
        }

        for (Applicant applicant : applicantsToImport) {
            model.addApplicant(applicant);
        }

        return new CommandResult(String.format(
                applicantsToImport.size() == 1 ? MESSAGE_SUCCESS_SINGULAR : MESSAGE_SUCCESS_PLURAL,
                applicantsToImport.size(),
                fileName));
    }

    private boolean containsDuplicates(List<Applicant> applicantsToImport) {
        return applicantsToImport.stream().anyMatch(applicant -> applicantsToImport.stream()
                .filter(applicant::isSameApplicant).count() > 1);
    }

    private boolean hasDuplicateApplicants(List<Applicant> applicantsToImport, Model model) {
        return applicantsToImport.stream().anyMatch(model::hasApplicant);
    }

    // Solution below adapted by
    // https://stackoverflow.com/questions/203984/how-do-i-remove-repeated-elements-from-arraylist
    private List<Applicant> getDuplicateApplicantsInCsv(List<Applicant> applicantsToImport) {
        return new ArrayList<>(new LinkedHashSet<>(
                applicantsToImport.stream().filter(applicant -> applicantsToImport.stream()
                .filter(applicant::isSameApplicant).count() > 1).collect(Collectors.toList())));
    }

    // Solution below adapted by
    // https://stackoverflow.com/questions/203984/how-do-i-remove-repeated-elements-from-arraylist
    private List<Applicant> getDuplicateApplicantsInModel(List<Applicant> applicantsToImport, Model model) {
        return new ArrayList<>(new LinkedHashSet<>(
                applicantsToImport.stream().filter(model::hasApplicant).collect(Collectors.toList())));
    }
}
