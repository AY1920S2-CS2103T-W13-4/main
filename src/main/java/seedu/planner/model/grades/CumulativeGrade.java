package seedu.planner.model.grades;

import java.util.OptionalDouble;

public class CumulativeGrade {
    protected int numSu;
    protected int totalCredits;
    protected double totalGradePoints;
    protected int totalGradedCredits;
    protected int totalSuCredits;

    public CumulativeGrade(int numSu, int totalCredits, double totalGradePoints, int totalGradedCredits,
                           int totalSuCredits) {
        this.numSu = numSu;
        this.totalCredits = totalCredits;
        this.totalGradePoints = totalGradePoints;
        this.totalGradedCredits = totalGradedCredits;
        this.totalSuCredits = totalSuCredits;
    }

    public CumulativeGrade() {
        this(0, 0, 0, 0, 0);
    }

    /**
     * Accumulates the letter grade to the counter.
     *
     * @param gradePoint Grade points, from 0.0 to 5.0
     * @param credits    Number of credits
     */
    private void accumulateGraded(double gradePoint, int credits) {
        totalCredits += credits;
        totalGradePoints += gradePoint * credits;
        totalGradedCredits += credits;
    }

    /**
     * Accumulates module credits and the S/U to the counter.
     *
     * @param credits Number of credits
     */
    private void accumulateSu(int credits) {
        totalCredits += credits;
        numSu++;
        totalSuCredits += credits;
    }

    /**
     * Accumulates pending module credits. This does not affect the calculated CAP.
     * The number of S/U modules declared is not affected.
     *
     * @param credits Number of credits
     */
    public void accumulatePending(int credits) {
        totalCredits += credits;
    }

    public void accumulate(Grade grade, int credits) {
        if (grade.isSu || grade.letterGrade.isSu) {
            accumulateSu(credits);
        } else {
            accumulateGraded(grade.getGradePoint().getAsDouble(), credits);
        }
    }

    public OptionalDouble getAverage() {
        if (totalGradedCredits > 0) {
            return OptionalDouble.of(totalGradePoints / (double) totalGradedCredits);
        } else {
            return OptionalDouble.empty();
        }
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public int getTotalGradedCredits() {
        return totalGradedCredits;
    }

    public Object getTotalSuCredits() {
        return totalSuCredits;
    }
}
