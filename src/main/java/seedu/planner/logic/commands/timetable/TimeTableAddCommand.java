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
 * Adds a timetable to the currently selected student's timetable list.
 */
public class TimeTableAddCommand extends TimeTableCommand {
    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'" + getQualifiedCommand(COMMAND_WORD)
        + "' command not implemented yet";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Adds a timetable with the given semester to the active student.\n"
        + "Parameters: "
        + "[" + PREFIX_STUDENT_YEAR + "YEAR] "
        + "[" + PREFIX_STUDENT_SEM + "SEMESTER] \n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " year/1 sem/ONE";

    public static final String MESSAGE_ADD_TIMETABLE_SUCCESS = "Added timetable to semester: %1$s";
    public static final String MESSAGE_EXISTING_SEMESTER = "Semester already exists in list of timetables: %1$s";

    private final StudentSemester studentSemester;

    public TimeTableAddCommand(StudentSemester studentSemester) {
        requireAllNonNull(studentSemester);
        this.studentSemester = studentSemester;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(StudentSemester semesterYear) {
        return String.format(MESSAGE_ADD_TIMETABLE_SUCCESS, semesterYear);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Student activeStudent = model.getActiveStudent();
        if (activeStudent == null) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }

        // TODO: validate semester

        if (model.getPlanner().hasSemester(studentSemester)) {
            throw new CommandException(String.format(MESSAGE_EXISTING_SEMESTER, studentSemester));
        }

        model.addSemesterTimeTable(studentSemester);

        return new CommandResult(generateSuccessMessage(studentSemester));
    }
}
