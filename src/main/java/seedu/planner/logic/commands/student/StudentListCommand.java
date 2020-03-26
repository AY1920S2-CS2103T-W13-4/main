package seedu.planner.logic.commands.student;

import static java.util.Objects.requireNonNull;

import javafx.collections.ObservableList;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.student.Student;


/**
 * Lists all students in the student list.
 */
public class StudentListCommand extends StudentCommand {
    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'" + getQualifiedCommand(COMMAND_WORD)
        + "' command not implemented yet";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": List students in the student list.\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD);

    public static final String MESSAGE_SUCCESS = "Listed students in student list:\n%1$s";

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(ObservableList<Student> students) {
        StringBuffer sb = new StringBuffer();
        boolean isFirst = true;
        for (int i = 0; i < students.size(); ++i) {
            Student student = students.get(i);
            if (!isFirst) {
                sb.append("\n");
            }
            sb.append(i + 1);
            sb.append(": ");
            sb.append(student);
            isFirst = false;
        }

        return String.format(MESSAGE_SUCCESS, sb.length() == 0 ? "[None]" : sb.toString());
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        ObservableList<Student> lastShownList = model.getStudentList();

        return new CommandResult(generateSuccessMessage(lastShownList));
    }
}
