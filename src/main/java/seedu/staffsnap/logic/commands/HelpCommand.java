package seedu.staffsnap.logic.commands;

import seedu.staffsnap.model.Model;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {
    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_HELP_MESSAGE = "Here are a few basic commands to get you started."
            + "\nAdd"
            + "\nEdit"
            + "\nList"
            + "\nDelete"
            + "\nFind"
            + "\nSort"
            + "\nClear"
            + "\nExit"
            + "\nFilter";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(SHOWING_HELP_MESSAGE, false, false);
    }
}
