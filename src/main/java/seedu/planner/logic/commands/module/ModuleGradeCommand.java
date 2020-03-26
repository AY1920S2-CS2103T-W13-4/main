package seedu.planner.logic.commands.module;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_GRADE;

import java.util.Optional;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.grades.Grade;
import seedu.planner.model.grades.LetterGrade;
import seedu.planner.model.module.Module;
import seedu.planner.model.module.ModuleCode;


/**
 * Sets the grade of a module in the selected timetable.
 */
public class ModuleGradeCommand extends ModuleCommand {
    public static final String COMMAND_WORD = "grade";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": If GRADE is specified, sets the grade of the module specified.\n"
        + "Otherwise, displays grade of module specified.\n"
        + "Parameters: "
        + "MODULE_CODE "
        + "[" + PREFIX_GRADE + "GRADE]\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " CS2030 grade/A";

    public static final String MESSAGE_SET_GRADE_SUCCESS = "Set grade of module %1$s to: %2$s";
    public static final String MESSAGE_VIEW_GRADE_SUCCESS = "Grade of module %1$s: %2$s";
    public static final String MESSAGE_MODULE_INVALID = "Module code does not exist: %1$s";
    public static final String MESSAGE_MODULE_NOT_ENROLLED = "Module not in selected timetable: %1$s";


    private final ModuleCode moduleCode;
    private final LetterGrade letterGrade;
    private final boolean isWrite;

    public ModuleGradeCommand(ModuleCode moduleCode, LetterGrade grade) {
        requireAllNonNull(moduleCode, grade);
        this.moduleCode = moduleCode;
        this.letterGrade = grade;
        this.isWrite = true;
    }

    public ModuleGradeCommand(ModuleCode moduleCode) {
        requireAllNonNull(moduleCode);
        this.moduleCode = moduleCode;
        this.letterGrade = null;
        this.isWrite = false;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateModuleInvalidMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_MODULE_INVALID, moduleCode.value);
    }


    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateModuleNotEnrolledMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_MODULE_NOT_ENROLLED, moduleCode.value);
    }

    private String generateViewGradeSuccessMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_VIEW_GRADE_SUCCESS, moduleCode.value, "Pending");
    }

    private String generateViewGradeSuccessMessage(ModuleCode moduleCode, Grade grade) {
        return String.format(MESSAGE_VIEW_GRADE_SUCCESS, moduleCode.value, grade);
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSetGradeSuccessMessage(ModuleCode moduleCode, LetterGrade grade) {
        return String.format(MESSAGE_SET_GRADE_SUCCESS, moduleCode.value, grade);
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

        // Check if module exists in module database
        Module module = model.getPlanner().getModules().getModule(moduleCode);
        if (module == null) {
            throw new CommandException(generateModuleInvalidMessage(moduleCode));
        }

        // Check if module is duplicate in active timetable
        // TODO: have an option to check globally (across all timetables) to prevent duplicate enrollments
        if (!model.hasEnrollment(moduleCode)) {
            throw new CommandException(generateModuleNotEnrolledMessage(moduleCode));
        }

        if (isWrite) {
            model.setModuleGrade(moduleCode, new Grade(letterGrade, false));
            return new CommandResult(generateSetGradeSuccessMessage(moduleCode, letterGrade));
        } else {
            Optional<Grade> optionalGrade = model.getModuleGrade(moduleCode);
            if (optionalGrade.isPresent()) {
                return new CommandResult(generateViewGradeSuccessMessage(moduleCode, optionalGrade.get()));
            } else {
                return new CommandResult(generateViewGradeSuccessMessage(moduleCode));
            }
        }
    }
}
