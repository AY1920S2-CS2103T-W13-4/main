package seedu.planner.logic.parser.declare;

import static java.util.Objects.requireNonNull;

import seedu.planner.logic.commands.declare.DeclareMajorCommand;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.exceptions.ParseException;
import seedu.planner.model.student.Major;


public class DeclareMajorCommandParser implements Parser<DeclareMajorCommand> {
    //private static final Prefix PREFIX_DECLARE_MAJOR = new Prefix("r/");

    /**
     * Parses the given {@code String} of arguments in the context of the DeclareMajorCommand
     * and returns a DeclareMajorCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public DeclareMajorCommand parse(String args) throws ParseException {
        requireNonNull(args);

        try {
            Major major = new Major(args);
            return new DeclareMajorCommand(major);
        } catch (IllegalArgumentException e) {
            throw new ParseException(e.getMessage());
        }
    }
}
