package seedu.staffsnap.logic.parser;

import static seedu.staffsnap.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_ASCENDING;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_DESCENDING;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_DESCRIPTOR;
import static seedu.staffsnap.logic.parser.ParserUtil.arePrefixesPresent;

import seedu.staffsnap.logic.commands.SortCommand;
import seedu.staffsnap.logic.parser.exceptions.ParseException;
import seedu.staffsnap.model.applicant.Descriptor;

/**
 * Parses input arguments and creates a new SortCommand object
 */
public class SortCommandParser implements Parser<SortCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public SortCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_DESCRIPTOR, PREFIX_ASCENDING, PREFIX_DESCENDING);

        if (!arePrefixesPresent(argMultimap, PREFIX_DESCRIPTOR)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_DESCRIPTOR);
        Descriptor descriptor = ParserUtil.parseDescriptor(argMultimap.getValue(PREFIX_DESCRIPTOR).get());

        // default behaviour is to sort in ascending order if none are specified, or if both are specified
        boolean isDescendingOrder = false;
        if (argMultimap.getValue(PREFIX_DESCENDING).isPresent()) {
            isDescendingOrder = true;
        }
        if (argMultimap.getValue(PREFIX_ASCENDING).isPresent()) {
            isDescendingOrder = false;
        }

        return new SortCommand(descriptor, isDescendingOrder);
    }
}
