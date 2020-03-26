package seedu.planner.logic.commands.specialisation;

import seedu.planner.logic.commands.Command;

public abstract class SpecialisationCommand extends Command {

    public static final String COMMAND_WORD = "specialisation";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ":\n"
        + "1. Algorithms & Theory\n"
        + "2. Artificial Intelligence\n"
        + "3. Computer Graphics and Games\n"
        + "4. Computer Security\n"
        + "5. Database Systems\n"
        + "6. Multimedia Information Retrieval\n"
        + "7. Networking and Distributed Systems\n"
        + "8. Parallel Computing\n"
        + "9. Programming Languages\n"
        + "10. Software Engineering\n"
        + "Subcommands: set\n"
        + "Example: " + COMMAND_WORD + " set 1";


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
