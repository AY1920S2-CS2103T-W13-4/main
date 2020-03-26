package seedu.planner.logic.commands.module;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.module.ModuleCode;


/**
 * Removes a module from the selected timetable.
 */
public class ModuleRemoveCommand extends ModuleCommand {
    public static final String COMMAND_WORD = "remove";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'" + getQualifiedCommand(COMMAND_WORD)
        + "' command not implemented yet";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Removes the module from list of enrolled modules.\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + "CS2030";

    public static final String MESSAGE_ADD_MODULE_SUCCESS = "Removed module from timetable: %1$s";
    public static final String MESSAGE_ADD_MODULE_NOT_EXISTS = "Module does not exist in timetable: %1$s";

    private final ModuleCode moduleCode;

    public ModuleRemoveCommand(ModuleCode moduleCode) {
        requireAllNonNull(moduleCode);

        this.moduleCode = moduleCode;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateFailureMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_ADD_MODULE_NOT_EXISTS, moduleCode.value);
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_ADD_MODULE_SUCCESS, moduleCode.value);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // Check if active student and timetable exists
        if (model.getActiveStudent() == null) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }
        if (model.getActiveTimeTable() == null) {
            throw new CommandException(Messages.MESSAGE_NO_TIMETABLE_ACTIVE);
        }

        // Check if module is present in active timetable
        if (!model.hasEnrollment(moduleCode)) {
            throw new CommandException(generateFailureMessage(moduleCode));
        }

        model.removeEnrollment(moduleCode);

        return new CommandResult(generateSuccessMessage(moduleCode));
    }
}
