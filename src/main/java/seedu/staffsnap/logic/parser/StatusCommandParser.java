package seedu.staffsnap.logic.parser;

import static seedu.staffsnap.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.staffsnap.logic.parser.CliSyntax.PREFIX_STATUS;
import static seedu.staffsnap.logic.parser.ParserUtil.arePrefixesPresent;

import seedu.staffsnap.commons.core.index.Index;
import seedu.staffsnap.logic.commands.StatusCommand;
import seedu.staffsnap.logic.parser.exceptions.ParseException;
import seedu.staffsnap.model.applicant.Status;


/**
 * Parses inputs and returns a StatusCommand
 */
public class StatusCommandParser implements Parser<StatusCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public StatusCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_STATUS);

        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, StatusCommand.MESSAGE_USAGE));
        }

        Index index = null;
        Status status = null;

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_STATUS);

        if (!arePrefixesPresent(argMultimap, PREFIX_STATUS)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, StatusCommand.MESSAGE_NO_STATUS));
        }

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, StatusCommand.MESSAGE_NO_INDEX));
        }

        if (argMultimap.getValue(PREFIX_STATUS).isPresent()) {
            status = ParserUtil.parseStatus(argMultimap.getValue(PREFIX_STATUS).get());
        }
        if (status == null) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, Status.MESSAGE_CONSTRAINTS));
        }
        return new StatusCommand(index, status);
    }

}
