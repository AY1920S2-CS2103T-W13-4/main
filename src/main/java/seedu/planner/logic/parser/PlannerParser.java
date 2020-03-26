package seedu.planner.logic.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.AddCommand;
import seedu.planner.logic.commands.ClearCommand;
import seedu.planner.logic.commands.Command;
import seedu.planner.logic.commands.DeleteCommand;
import seedu.planner.logic.commands.EditCommand;
import seedu.planner.logic.commands.ExitCommand;
import seedu.planner.logic.commands.FindCommand;
import seedu.planner.logic.commands.HelpCommand;
import seedu.planner.logic.commands.ListCommand;
import seedu.planner.logic.commands.RemarkCommand;
import seedu.planner.logic.commands.declare.DeclareCommand;
import seedu.planner.logic.commands.major.MajorCommand;
import seedu.planner.logic.commands.module.ModuleCommand;
import seedu.planner.logic.commands.specialisation.SpecialisationCommand;
import seedu.planner.logic.commands.student.StudentCommand;
import seedu.planner.logic.commands.timetable.TimeTableCommand;
import seedu.planner.logic.parser.declare.DeclareCommandParser;
import seedu.planner.logic.parser.exceptions.ParseException;
import seedu.planner.logic.parser.module.ModuleCommandParser;
import seedu.planner.logic.parser.specialisation.SpecialisationCommandParser;
import seedu.planner.logic.parser.student.StudentCommandParser;
import seedu.planner.logic.parser.timetable.TimeTableCommandParser;

/**
 * Parses user input.
 */
public class PlannerParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case RemarkCommand.COMMAND_WORD:
            return new RemarkCommandParser().parse(arguments);

        case DeclareCommand.COMMAND_WORD:
            return new DeclareCommandParser().parse(arguments);

        case StudentCommand.COMMAND_WORD:
            return new StudentCommandParser().parse(arguments);

        case ModuleCommand.COMMAND_WORD:
            return new ModuleCommandParser().parse(arguments);

        case MajorCommand.COMMAND_WORD:
            return new MajorCommandParser().parse(arguments);

        case TimeTableCommand.COMMAND_WORD:
            return new TimeTableCommandParser().parse(arguments);

        case SpecialisationCommand.COMMAND_WORD:
            return new SpecialisationCommandParser().parse(arguments);

        default:
            throw new ParseException(Messages.MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
