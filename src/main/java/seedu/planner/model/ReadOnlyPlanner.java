package seedu.planner.model;

import java.util.Optional;

import javafx.collections.ObservableList;
import seedu.planner.model.grades.Grade;
import seedu.planner.model.module.Module;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.module.UniqueModuleList;
import seedu.planner.model.student.Student;
import seedu.planner.model.time.StudentSemester;


/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyPlanner {

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate persons.
     */

    Student getActiveStudent();

    ObservableList<Student> getStudentList();

    ObservableList<Module> getModuleList();


    UniqueModuleList getModules();


    ObservableList<ModuleCode> getActiveModuleCodes();

    boolean hasSemester(StudentSemester semester);

    Optional<Grade> getModuleGrade(ModuleCode moduleCode);

    ObservableList<ModuleCode> getEnrolledModulesList();

}
