package seedu.planner.logic.commands.timetable;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_STUDENT_SEM;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_STUDENT_YEAR;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.student.Student;
import seedu.planner.model.time.StudentSemester;


/**
 * Sets a timetable as the currently selected timetable in the currently selected student's timetable list.
 */
public class TimeTableActiveCommand extends TimeTableCommand {
    public static final String COMMAND_WORD = "active";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'" + getQualifiedCommand(COMMAND_WORD)
        + "' command not implemented yet";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Sets the active timetable of the active student.\n"
        + "Parameters: "
        + "[" + PREFIX_STUDENT_YEAR + "YEAR] "
        + "[" + PREFIX_STUDENT_SEM + "SEMESTER] \n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " year/1 sem/ONE";

    public static final String MESSAGE_ACTIVE_TIMETABLE_SUCCESS = "Set semester as active: %1$s";
    public static final String MESSAGE_INVALID_SEMESTER = "Semester does not exist in list of timetables: %1$s";

    private final StudentSemester studentSemester;

    public TimeTableActiveCommand(StudentSemester studentSemester) {
        requireAllNonNull(studentSemester);
        this.studentSemester = studentSemester;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(StudentSemester semesterYear) {
        return String.format(MESSAGE_ACTIVE_TIMETABLE_SUCCESS, semesterYear);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Student activeStudent = model.getActiveStudent();
        if (activeStudent == null) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }

        // TODO: validate semester
        /*
        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
         */

        if (!model.getPlanner().hasSemester(studentSemester)) {
            throw new CommandException(String.format(MESSAGE_INVALID_SEMESTER, studentSemester));
        }

        model.activateSemester(studentSemester);

        return new CommandResult(generateSuccessMessage(studentSemester));
    }
}
