package seedu.planner.logic.commands.student;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import javafx.collections.ObservableList;
import seedu.planner.commons.core.Messages;
import seedu.planner.commons.core.index.Index;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.student.Student;


/**
 * Sets the currently selected student in the student list.
 */
public class StudentActiveCommand extends StudentCommand {
    public static final String COMMAND_WORD = "active";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'" + getQualifiedCommand(COMMAND_WORD)
        + "' command not implemented yet";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Sets the student from the student list as the active student.\n"
        + "Parameters: INDEX (must be a positive integer) \n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " 1";

    public static final String MESSAGE_ACTIVE_STUDENT_SUCCESS = "Set student as active: %1$s";

    private final Index index;

    public StudentActiveCommand(Index index) {
        requireAllNonNull(index);
        this.index = index;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Student student) {
        return String.format(MESSAGE_ACTIVE_STUDENT_SUCCESS, student);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        ObservableList<Student> lastShownList = model.getStudentList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Student student = lastShownList.get(index.getZeroBased());
        model.activateStudent(student);

        return new CommandResult(generateSuccessMessage(student));
    }
}
