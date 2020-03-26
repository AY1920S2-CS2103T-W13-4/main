package seedu.planner.logic.commands.module;

import seedu.planner.logic.commands.Command;

/**
 * Base command for subcommands involving queries about modules.
 */
public abstract class ModuleCommand extends Command {

    public static final String COMMAND_WORD = "module";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ":\n"
        + "Subcommands: add, remove, list, grade\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " CS2030";


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
