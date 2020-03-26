package seedu.planner.logic.commands.student;

import static java.util.Objects.requireNonNull;

import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.grades.CumulativeGrade;
import seedu.planner.model.grades.Grade;
import seedu.planner.model.student.Enrollment;
import seedu.planner.model.student.Student;
import seedu.planner.model.student.TimeTable;
import seedu.planner.model.time.StudentSemester;

/**
 * Lists the grade of the currently selected student.
 */
public class StudentGradeCommand extends StudentCommand {
    public static final String COMMAND_WORD = "grade";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'" + getQualifiedCommand(COMMAND_WORD)
        + "' command not implemented yet";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Display average grade of active student.\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD);

    public static final String MESSAGE_SUCCESS = "Grade of active student %1$s: %2$s\n"
        + "Enrolled in %3$d MCs total, %4$d MCs are graded, %5$d MCs are declared S/U.\n"
        + "Grade for each module:\n%6$s";

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Student activeStudent, CumulativeGrade cumulativeGrade) {
        OptionalDouble gradeValue = cumulativeGrade.getAverage();

        StringBuffer sb = new StringBuffer();

        for (Map.Entry<StudentSemester, TimeTable> entry : activeStudent.getTimeTableMap().entrySet()) {
            StudentSemester sem = entry.getKey();
            TimeTable timeTable = entry.getValue();

            sb.append("\n");
            sb.append(sem.toString());

            for (Enrollment enrollment : timeTable.getEnrollments()) {
                sb.append("\n");
                sb.append(enrollment.getModuleCode().value);
                sb.append(String.format(" (%d MCs): ", enrollment.getCredit()));

                Optional<Grade> optionalGrade = enrollment.getGrade();
                if (optionalGrade.isPresent()) {
                    sb.append(optionalGrade.get().toString());
                } else {
                    sb.append("Pending");
                }
            }

            sb.append("\n");
        }

        return String.format(MESSAGE_SUCCESS,
            activeStudent,
            gradeValue.isPresent() ? String.format("%.2f/5.00", gradeValue.getAsDouble()) : "-/5.00",
            cumulativeGrade.getTotalCredits(),
            cumulativeGrade.getTotalGradedCredits(),
            cumulativeGrade.getTotalSuCredits(),
            sb.toString());
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // Check if active student and timetable exists
        if (model.getActiveStudent() == null) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }

        Student activeStudent = model.getActiveStudent();
        CumulativeGrade cumulativeGrade = activeStudent.getCumulativeGrade();

        return new CommandResult(generateSuccessMessage(activeStudent, cumulativeGrade));
    }
}
