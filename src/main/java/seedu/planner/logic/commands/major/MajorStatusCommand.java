package seedu.planner.logic.commands.major;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.graduation.GraduationRequirement;
import seedu.planner.model.student.Student;

public class MajorStatusCommand extends MajorCommand {
    public static final String COMMAND_WORD = "status";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Lists the current progress of graduating with a given major";

    public static final String MESSAGE_SUCCESS = "Listed the graduation requirement status:\n%1$s";

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
        List<GraduationRequirement> graduationRequirementList = model.getActiveStudent().getMajor()
            .getGraduationRequirements();
        StringBuffer sb = new StringBuffer();
        boolean isFirst = true;
        for (GraduationRequirement graduationRequirement : graduationRequirementList) {
            if (!isFirst) {
                sb.append("\n");
            }
            sb.append(graduationRequirement.getString(model.getActiveStudent().getAllEnrolledModules()));
        }
        return new CommandResult(String.format(MESSAGE_SUCCESS, sb.length() == 0 ? "[None]" : sb.toString()));
    }
}
