package seedu.staffsnap.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_GREATER_THAN_SCORE;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_LESS_THAN_SCORE;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_POSITION;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_STATUS;

import seedu.staffsnap.commons.util.ToStringBuilder;
import seedu.staffsnap.logic.Messages;
import seedu.staffsnap.model.Model;
import seedu.staffsnap.model.applicant.CustomFilterPredicate;



/**
 * Finds and lists all applicants in address book whose name contains any of the argument keywords.
 * Keyword matching is case-insensitive.
 */
public class FilterCommand extends Command {

    public static final String COMMAND_WORD = "filter";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Filters all applicants who match the descriptor."
            + " Possible fields include:" + "\n"
            + PREFIX_NAME + " [NAME], "
            + PREFIX_EMAIL + " [EMAIL], "
            + PREFIX_POSITION + " [POSITION], "
            + PREFIX_PHONE + " [PHONE], "
            + PREFIX_STATUS + " [STATUS], "
            + PREFIX_LESS_THAN_SCORE + " [SCORE], "
            + PREFIX_GREATER_THAN_SCORE + " [SCORE]";
    public static final String MESSAGE_FAILURE = "Please add at least one field to filter by."
            + " Possible fields include:" + "\n"
            + PREFIX_NAME + " [NAME], "
            + PREFIX_EMAIL + " [EMAIL], "
            + PREFIX_POSITION + " [POSITION], "
            + PREFIX_PHONE + " [PHONE], "
            + PREFIX_STATUS + " [STATUS], "
            + PREFIX_LESS_THAN_SCORE + " [SCORE], "
            + PREFIX_GREATER_THAN_SCORE + " [SCORE]";

    public static final String MESSAGE_SCORE_PARSE_FAILURE = "Score in lts/ or gts/ has to be a number between 0.0 "
            + "and 10.0 inclusive.";

    private final CustomFilterPredicate predicate;

    public FilterCommand(CustomFilterPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredApplicantList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_APPLICANTS_LISTED_OVERVIEW, model.getFilteredApplicantList().size()));
    }

    /**
     * Checks if the two FilterCommand objects are equivalent, by comparing the equivalence of their predicates.
     * @param other Other FilterCommand.
     * @return true if equals, false if not equals.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FilterCommand)) {
            return false;
        }

        FilterCommand otherFilterCommand = (FilterCommand) other;
        return predicate.equals(otherFilterCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }
}
