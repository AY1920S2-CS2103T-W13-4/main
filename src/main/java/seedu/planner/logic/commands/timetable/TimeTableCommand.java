package seedu.planner.logic.commands.timetable;

import seedu.planner.logic.commands.Command;


/**
 * Base command for subcommands involving queries about timetables.
 */
public abstract class TimeTableCommand extends Command {

    public static final String COMMAND_WORD = "timetable";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": Modifies the timetable of the currently active student.\n"
        + "Subcommands: add remove active\n"
        + "Example: " + COMMAND_WORD + " active year/1 sem/ONE";


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
