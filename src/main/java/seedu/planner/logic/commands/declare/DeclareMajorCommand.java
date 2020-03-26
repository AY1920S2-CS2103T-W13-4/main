package seedu.planner.logic.commands.declare;

import static java.util.Objects.requireNonNull;

import seedu.planner.commons.util.CollectionUtil;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.ModelManager;
import seedu.planner.model.programmes.ComputerScienceProgramme;
import seedu.planner.model.student.Major;
import seedu.planner.model.student.Student;


public class DeclareMajorCommand extends DeclareCommand {
    public static final String COMMAND_WORD = "major";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'" + getQualifiedCommand(COMMAND_WORD)
        + "' command not implemented yet";

    // TODO: write usage message
    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Deletes the person identified by the index number used in the displayed person list.\n"
        + "Parameters: INDEX (must be a positive integer)\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " 1";

    public static final String MESSAGE_EDIT_MAJOR_SUCCESS = "Changed major to: %1$s";

    private final Major major;

    public DeclareMajorCommand(Major major) {
        CollectionUtil.requireAllNonNull(major);

        this.major = major;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Student editedStudent) {
        return String.format(MESSAGE_EDIT_MAJOR_SUCCESS, editedStudent.getMajor().major);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Student student = model.getActiveStudent();
        major.setDegreeProgramme(new ComputerScienceProgramme(model));
        student.setMajor(major);

        Student editedStudent = new Student(student.getName(), student.getDegrees(), major);
        assert (model instanceof ModelManager);
        model.setActiveStudent(editedStudent);

        //return new CommandResult(MESSAGE_NOT_IMPLEMENTED_YET);
        return new CommandResult(generateSuccessMessage(editedStudent));
    }
}
