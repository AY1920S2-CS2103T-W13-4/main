package seedu.planner.logic.parser.module;

import static java.util.Objects.requireNonNull;

import seedu.planner.logic.commands.module.ModuleRemoveCommand;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.exceptions.ParseException;
import seedu.planner.model.module.ModuleCode;

public class ModuleRemoveCommandParser implements Parser<ModuleRemoveCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the DeclareMajorCommand
     * and returns a DeclareMajorCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public ModuleRemoveCommand parse(String args) throws ParseException {
        requireNonNull(args);

        try {
            ModuleCode moduleCode = new ModuleCode(args);
            return new ModuleRemoveCommand(moduleCode);
        } catch (IllegalArgumentException e) {
            throw new ParseException(e.getMessage());
        }
    }
}
