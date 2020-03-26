package seedu.planner.logic.commands.major;

import seedu.planner.logic.commands.Command;

/**
 * Base command for subcommands involving queries about student majors.
 */
public abstract class MajorCommand extends Command {

    public static final String COMMAND_WORD = "major";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ":\n"
        + "Subcommands: status, set\n"
        + "Example: " + COMMAND_WORD + " set CS";


    /**
     * Returns the (@code COMMAND_NAME) concatenated with the name of the input (@code subCommand).
     *
     * @param subCommand
     * @return Qualified name
     */
    public static String getQualifiedCommand(String subCommand) {
        return COMMAND_WORD + " " + subCommand;
    }
}
