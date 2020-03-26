package seedu.planner.model.time;

import java.util.Objects;

public class SemesterYear {
    public static final String MESSAGE_CONSTRAINTS = "Semester year should be valid.";
    // TODO: figure out required constraints

    protected final Semester sem;
    // TODO: support academic year in Student operations

    public SemesterYear(Semester sem, int academicYear) {
        this.sem = sem;
        // this.academicYear = academicYear;
    }

    public Semester getSemester() {
        return sem;
    }

    public int getAcademicYear() {
        // return academicYear;
        return -1;
    }

    // TODO: validate StudentSemester and academicYear
    public boolean isValidSemesterYear() {
        return sem != null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sem);
        // return Objects.hash(sem, academicYear);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof SemesterYear)) {
            return false;
        } else {
            return sem.equals(((SemesterYear) other).sem);
            // && academicYear == ((SemesterYear) other).academicYear;
        }
    }

    @Override
    public String toString() {
        return String.format("AY ?/? %s", sem.toString());
        // return String.format("AY %d/%d %s", academicYear, academicYear+1, sem.toString());
    }
}
