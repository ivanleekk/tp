package seedu.staffsnap.logic.parser;

import static seedu.staffsnap.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.staffsnap.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.staffsnap.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.staffsnap.commons.core.index.Index;
import seedu.staffsnap.logic.commands.StatusCommand;
import seedu.staffsnap.model.applicant.Status;



class StatusCommandParserTest {

    private StatusCommandParser parser = new StatusCommandParser();

    @Test
    void parse_validArgs_returnsStatusCommand() {
        StatusCommand expectedStatusCommand = new StatusCommand(Index.fromOneBased(1), Status.OFFERED);
        assertParseSuccess(parser, "1 s/ o", expectedStatusCommand);
    }

    @Test
    void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, StatusCommand.MESSAGE_USAGE));
    }

    @Test
    void parse_missingStatus_throwsParseException() {
        assertParseFailure(parser, "1", String.format(MESSAGE_INVALID_COMMAND_FORMAT, StatusCommand.MESSAGE_NO_STATUS));
    }

    @Test
    void parse_missingIndex_throwsParseException() {
        assertParseFailure(parser, " s/o", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                StatusCommand.MESSAGE_NO_INDEX));
    }
}
