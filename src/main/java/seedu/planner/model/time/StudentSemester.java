package seedu.planner.model.time;

import java.util.Objects;

public class StudentSemester {
    protected final SemesterYear semYear;
    protected final int degreeYear;

    public StudentSemester(SemesterYear semYear, int degreeYear) {
        this.semYear = semYear;
        this.degreeYear = degreeYear;
    }

    public SemesterYear getSemesterYear() {
        return semYear;
    }

    public int getDegreeYear() {
        return degreeYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(semYear, degreeYear);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof StudentSemester)) {
            return false;
        } else {
            return semYear.equals(((StudentSemester) other).semYear)
                && degreeYear == ((StudentSemester) other).degreeYear;
        }
    }

    @Override
    public String toString() {
        return String.format("Year %d, %s", degreeYear, semYear);
    }
}
