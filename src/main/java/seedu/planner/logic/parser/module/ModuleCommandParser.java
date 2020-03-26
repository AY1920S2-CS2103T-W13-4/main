package seedu.planner.logic.parser.module;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.HelpCommand;
import seedu.planner.logic.commands.module.ModuleAddCommand;
import seedu.planner.logic.commands.module.ModuleCommand;
import seedu.planner.logic.commands.module.ModuleGradeCommand;
import seedu.planner.logic.commands.module.ModuleListCommand;
import seedu.planner.logic.commands.module.ModuleRemoveCommand;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.exceptions.ParseException;

public class ModuleCommandParser implements Parser<ModuleCommand> {
    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+) ?(?<arguments>.*)");

    /**
     * Parses user subcommand input into command for execution.
     *
     * @param userInput user subcommand input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public ModuleCommand parse(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        switch (commandWord) {
        case ModuleAddCommand.COMMAND_WORD:
            return new ModuleAddCommandParser().parse(arguments);

        case ModuleRemoveCommand.COMMAND_WORD:
            return new ModuleRemoveCommandParser().parse(arguments);

        case ModuleListCommand.COMMAND_WORD:
            return new ModuleListCommand();

        case ModuleGradeCommand.COMMAND_WORD:
            return new ModuleGradeCommandParser().parse(arguments);

        default:
            throw new ParseException(Messages.MESSAGE_UNKNOWN_COMMAND);
        }
    }
}
