package seedu.planner.model.student;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.AppUtil.checkArgument;

import java.util.List;

import seedu.planner.model.graduation.GraduationRequirement;
import seedu.planner.model.programmes.ComputerScienceProgramme;
import seedu.planner.model.programmes.DegreeProgramme;
import seedu.planner.model.programmes.InformationSystemsProgramme;

/**
 * Represents a Student's name in the application.
 * Guarantees: immutable; is valid as declared in {@link #isValidMajor(String)}
 */
public class Major {

    public static final String MESSAGE_CONSTRAINTS =
        "Majors should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String major;

    private DegreeProgramme degreeProgramme;

    /**
     * Constructs a {@code Name}.
     *
     * @param major A valid major.
     */
    public Major(String major) {
        requireNonNull(major);
        checkArgument(isValidMajor(major), MESSAGE_CONSTRAINTS);
        if (major.equals("CS")) {
            this.degreeProgramme = new ComputerScienceProgramme(null);
        } else if (major.equals("IS")) {
            this.degreeProgramme = new InformationSystemsProgramme();
        }
        this.major = major;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidMajor(String test) {
        return test.matches(VALIDATION_REGEX) && (test.equals("CS") || test.equals("IS"));
    }

    public DegreeProgramme getDegreeProgramme() {
        return degreeProgramme;
    }

    public void setDegreeProgramme(DegreeProgramme degreeProgramme) {
        this.degreeProgramme = degreeProgramme;
    }

    public List<GraduationRequirement> getGraduationRequirements() {
        return degreeProgramme.getGraduationRequirementList();
    }

    @Override
    public String toString() {
        return major;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof Major // instanceof handles nulls
            && major.equals(((Major) other).major)); // state check
    }

    @Override
    public int hashCode() {
        return major.hashCode();
    }

}
