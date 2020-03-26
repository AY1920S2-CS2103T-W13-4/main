package seedu.planner.model.student;

import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_MAJOR;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_NAME;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.planner.model.grades.CumulativeGrade;
import seedu.planner.model.grades.Grade;
import seedu.planner.model.graduation.FocusAreaGraduationRequirement;
import seedu.planner.model.graduation.GraduationRequirement;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.programmes.DegreeProgramme;
import seedu.planner.model.programmes.specialisations.GenericSpecialisation;
import seedu.planner.model.time.StudentSemester;

/**
 * Represents a Student in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Student {

    // Timetables
    public final TimeTableMap timeTableMap;
    // Identity fields
    private Name name;
    private Degrees degrees;
    private Major major;
    private GenericSpecialisation specialisation;

    /**
     * Every field must be present and not null.
     */
    public Student(Name name) {
        this(name, new Degrees(), null);
    }

    // TODO: add `degrees` field in `JsonAdaptedStudent` and remove this constructor
    public Student(Name name, Major major) {
        requireAllNonNull(name);
        this.name = name;
        this.degrees = null;
        this.major = major;
        this.timeTableMap = new TimeTableMap();
    }

    public Student(Name name, Major major, TimeTableMap timeTableMap) {
        requireAllNonNull(name, major, timeTableMap);
        this.name = name;
        this.degrees = null;
        this.major = major;
        this.timeTableMap = timeTableMap;
    }

    public Student(Name name, Degrees degrees, Major major) {
        requireAllNonNull(name);
        this.name = name;
        this.degrees = degrees;
        this.major = major;
        this.timeTableMap = new TimeTableMap();
    }

    public Name getName() {
        return name;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Degrees getDegrees() {
        return degrees;
    }

    public TimeTableMap getTimeTableMap() {
        return timeTableMap;
    }

    public boolean addDegrees(DegreeProgramme degree) {
        this.degrees.addDegree(degree);
        return true;
    }


    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Student)) {
            return false;
        }

        Student otherStudent = (Student) other;
        // TODO: initialize and compare `degrees`
        return otherStudent.getName().equals(getName())
            && otherStudent.getMajor().equals(getMajor())
            //&& otherStudent.getDegrees().equals(getDegrees())
            && otherStudent.getTimeTableMap().equals(getTimeTableMap());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, major, timeTableMap);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(PREFIX_NAME).append(getName()).append(" ")
            .append(PREFIX_MAJOR).append(getMajor());
        return builder.toString();
    }

    public boolean isSameStudent(Student student) {
        return this.equals(student);
    }

    public TimeTable getTimeTable(StudentSemester activeSemester) {
        return timeTableMap.get(activeSemester);
    }

    public void setTimeTable(StudentSemester activeSemester, TimeTable timeTable) {
        timeTableMap.put(activeSemester, timeTable);
    }

    public void removeTimeTable(StudentSemester keyToRemove) {
        if (!timeTableMap.containsKey(keyToRemove)) {
            throw new IllegalArgumentException("Semester does not exist in timetable list");
        }
        timeTableMap.remove(keyToRemove);
    }

    public List<StudentSemester> getStudentSemesters() {
        return new ArrayList<>(timeTableMap.keySet());
    }

    /**
     * Returns a list mof (@code ModuleCode) taken across all timetables.
     *
     * @return List of all modules enrolled.
     */
    public ObservableList<ModuleCode> getAllEnrolledModules() {
        ObservableList<ModuleCode> allModules = FXCollections.observableArrayList();
        for (TimeTable timeTable : timeTableMap.values()) {
            allModules.addAll(timeTable.getModuleCodes());
        }
        return allModules;
    }

    public ObservableList<Enrollment> getAllEnrollments() {
        ObservableList<Enrollment> allEnrollments = FXCollections.observableArrayList();
        for (TimeTable timeTable : timeTableMap.values()) {
            allEnrollments.addAll(timeTable.getEnrollments().asUnmodifiableObservableList());
        }
        return allEnrollments;
    }

    public GenericSpecialisation getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(GenericSpecialisation specialisation) {
        this.specialisation = specialisation;
        for (GraduationRequirement graduationRequirement : this.major.getDegreeProgramme()
            .getGraduationRequirementList()) {
            if (graduationRequirement instanceof FocusAreaGraduationRequirement) {
                FocusAreaGraduationRequirement focusAreaGraduationRequirement =
                    (FocusAreaGraduationRequirement) graduationRequirement;
                focusAreaGraduationRequirement.setGenericSpecialisation(specialisation);
            }
        }
    }

    public CumulativeGrade getCumulativeGrade() {
        CumulativeGrade cumulativeGrade = new CumulativeGrade();
        for (Enrollment enrollment : getAllEnrollments()) {
            Optional<Grade> optionalGrade = enrollment.getGrade();
            if (optionalGrade.isPresent()) {
                OptionalDouble gradePoint = enrollment.getGradePoint();
                cumulativeGrade.accumulate(optionalGrade.get(), enrollment.getCredit());
            } else {
                cumulativeGrade.accumulatePending(enrollment.getCredit());
            }
        }
        return cumulativeGrade;
    }
}
