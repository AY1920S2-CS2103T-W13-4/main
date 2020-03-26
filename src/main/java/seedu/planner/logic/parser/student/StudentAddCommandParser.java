package seedu.planner.logic.parser.student;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_MAJOR;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_NAME;

import java.util.stream.Stream;

import seedu.planner.logic.commands.student.StudentAddCommand;
import seedu.planner.logic.parser.ArgumentMultimap;
import seedu.planner.logic.parser.ArgumentTokenizer;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.Prefix;
import seedu.planner.logic.parser.exceptions.ParseException;
import seedu.planner.model.student.Major;
import seedu.planner.model.student.Name;
import seedu.planner.model.student.Student;
import seedu.planner.model.student.TimeTableMap;
import seedu.planner.model.util.SampleDataUtil;


/**
 * Parses input arguments and creates a new EditCommand object
 */
public class StudentAddCommandParser implements Parser<StudentAddCommand> {

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public StudentAddCommand parse(String args) throws ParseException {
        requireNonNull(args);

        // NOTE: the concatenation " " is a workaround for `ArgumentTokenizer` treating the first argument as the
        // preamble
        // TODO: use ArgumentTokenizer for all subcommands
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(" " + args, PREFIX_NAME, PREFIX_MAJOR);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_MAJOR)
            || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, StudentAddCommand.MESSAGE_USAGE));
        }

        // TODO: remove references to AddressBook's `person.Name` class so we can use our own `student.Name`
        /*
        Name abName = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        Name name = new Name(abName.fullName);
        Major major  = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
        */

        Name name = new Name(argMultimap.getValue(PREFIX_NAME).get());
        Major major = new Major(argMultimap.getValue(PREFIX_MAJOR).get());
        TimeTableMap timeTableMap = SampleDataUtil.getSampleTimeTableMap();

        Student student = new Student(name, major, timeTableMap);

        return new StudentAddCommand(student);
    }
}
