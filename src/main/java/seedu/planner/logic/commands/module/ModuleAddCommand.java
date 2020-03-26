package seedu.planner.logic.commands.module;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Optional;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.module.Module;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.student.Enrollment;

/**
 * Adds a module to the selected timetable.
 */
public class ModuleAddCommand extends ModuleCommand {
    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Adds the module to list of enrolled modules.\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " CS2030";

    public static final String MESSAGE_ADD_MODULE_SUCCESS = "Added module to timetable: %1$s";
    public static final String MESSAGE_ADD_MODULE_ALREADY_EXISTS = "Module is already in timetable: %1$s";
    public static final String MESSAGE_ADD_MODULE_INVALID = "Module code does not exist: %1$s";


    private final ModuleCode moduleCode;

    public ModuleAddCommand(ModuleCode moduleCode) {
        requireAllNonNull(moduleCode);
        this.moduleCode = moduleCode;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateModuleDoesNotExists(ModuleCode moduleCode) {
        return String.format(MESSAGE_ADD_MODULE_INVALID, moduleCode.value);
    }


    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateDuplicateMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_ADD_MODULE_ALREADY_EXISTS, moduleCode.value);
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

        // Check if module is duplicate in active timetable
        // TODO: have an option to check globally (across all timetables) to prevent duplicate enrollments
        if (model.hasEnrollment(moduleCode)) {
            throw new CommandException(generateDuplicateMessage(moduleCode));
        }

        // Check if module exists in module database
        Module module = model.getPlanner().getModules().getModule(moduleCode);
        if (module == null) {
            throw new CommandException(generateModuleDoesNotExists(moduleCode));
        }

        Enrollment enrollment = new Enrollment(moduleCode, Optional.empty(), module.getModuleCredit());
        model.addEnrollment(enrollment);
        return new CommandResult(generateSuccessMessage(moduleCode));
    }
}
