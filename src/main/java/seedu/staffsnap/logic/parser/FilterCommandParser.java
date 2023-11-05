package seedu.staffsnap.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.staffsnap.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_GREATER_THAN_SCORE;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_INTERVIEW;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_LESS_THAN_SCORE;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_POSITION;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_STATUS;

import java.util.List;

import seedu.staffsnap.logic.commands.FilterCommand;
import seedu.staffsnap.logic.parser.exceptions.ParseException;
import seedu.staffsnap.model.applicant.CustomFilterPredicate;
import seedu.staffsnap.model.applicant.Email;
import seedu.staffsnap.model.applicant.Name;
import seedu.staffsnap.model.applicant.Phone;
import seedu.staffsnap.model.applicant.Position;
import seedu.staffsnap.model.applicant.Status;
import seedu.staffsnap.model.interview.Interview;


/**
 * Parses input arguments and creates a new FilterCommand object
 */
public class FilterCommandParser implements Parser<FilterCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FilterCommand
     * and returns a FilterCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public FilterCommand parse(String args) throws ParseException {
        requireNonNull(args);
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCommand.MESSAGE_FAILURE));
        }
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL,
                        PREFIX_POSITION, PREFIX_INTERVIEW, PREFIX_STATUS, PREFIX_LESS_THAN_SCORE,
                        PREFIX_GREATER_THAN_SCORE);


        if (argMultimap.getValue(PREFIX_NAME).isEmpty() &&
                argMultimap.getValue(PREFIX_PHONE).isEmpty() &&
                argMultimap.getValue(PREFIX_EMAIL).isEmpty() &&
                argMultimap.getValue(PREFIX_POSITION).isEmpty() &&
                argMultimap.getValue(PREFIX_INTERVIEW).isEmpty() &&
                argMultimap.getValue(PREFIX_STATUS).isEmpty() &&
                argMultimap.getValue(PREFIX_LESS_THAN_SCORE).isEmpty() &&
                argMultimap.getValue(PREFIX_GREATER_THAN_SCORE).isEmpty()
        ) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCommand.MESSAGE_FAILURE));
        }

        Name name = null;
        Phone phone = null;
        Email email = null;
        Position position = null;
        List<Interview> interviewList = null;
        Status status = null;
        Double lessThanScore = null;
        Double greaterThanScore = null;
        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_POSITION,
                PREFIX_STATUS, PREFIX_LESS_THAN_SCORE, PREFIX_GREATER_THAN_SCORE);
        if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
            name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        }
        if (argMultimap.getValue(PREFIX_PHONE).isPresent()) {
            phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
        }
        if (argMultimap.getValue(PREFIX_EMAIL).isPresent()) {
            email = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get());
        }
        if (argMultimap.getValue(PREFIX_POSITION).isPresent()) {
            position = ParserUtil.parsePosition(argMultimap.getValue(PREFIX_POSITION).get());
        }
        if (argMultimap.getValue(PREFIX_INTERVIEW).isPresent()) {
            interviewList = ParserUtil.parseInterviews(argMultimap.getAllValues(PREFIX_INTERVIEW));
        }
        if (argMultimap.getValue(PREFIX_STATUS).isPresent()) {
            status = ParserUtil.parseStatus(argMultimap.getValue(PREFIX_STATUS).get());
        }
        if (argMultimap.getValue(PREFIX_LESS_THAN_SCORE).isPresent()) {
            lessThanScore = ParserUtil.parseScore(argMultimap.getValue(PREFIX_LESS_THAN_SCORE).get());
        }
        if (argMultimap.getValue(PREFIX_GREATER_THAN_SCORE).isPresent()) {
            greaterThanScore = ParserUtil.parseScore(argMultimap.getValue(PREFIX_GREATER_THAN_SCORE).get());
        }
        return new FilterCommand(new CustomFilterPredicate(name, phone, email, position, interviewList, status,
                lessThanScore, greaterThanScore));
    }

}
