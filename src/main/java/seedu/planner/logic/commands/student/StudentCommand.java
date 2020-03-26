package seedu.planner.logic.commands.student;

import seedu.planner.logic.commands.Command;

/**
 * Base command for subcommands involving queries about students.
 */
public abstract class StudentCommand extends Command {

    public static final String COMMAND_WORD = "student";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ":\n"
        + "Subcommands: add, remove, active, grade\n"
        + "Example: " + COMMAND_WORD + " active 1";


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
