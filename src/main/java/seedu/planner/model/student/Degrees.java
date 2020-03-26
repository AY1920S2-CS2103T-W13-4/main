package seedu.planner.model.student;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.AppUtil.checkArgument;

import java.util.ArrayList;
import java.util.List;

import seedu.planner.model.programmes.DegreeProgramme;

/**
 * Represents a Student's graduation Year in the application.
 * Guarantees: immutable; is valid as declared in {@link #isValidDegreeProgramme(DegreeProgramme)}
 */
public class Degrees {

    public static final String MESSAGE_CONSTRAINTS =
        "Degrees should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    private List<DegreeProgramme> degrees;

    public Degrees() {
        this.degrees = new ArrayList<>();
    }

    /**
     * Constructs a {@code Degrees}.
     *
     * @param degree A valid DegreeProgramme.
     */
    public Degrees(DegreeProgramme degree) {
        requireNonNull(degree);
        checkArgument(isValidDegreeProgramme(degree), MESSAGE_CONSTRAINTS);
        this.degrees = new ArrayList<>();
        this.degrees.add(degree);
    }

    /**
     * Constructs a {@code Name}.
     *
     * @param degrees A list of valid DegreeProgrammes.
     */
    public Degrees(List<DegreeProgramme> degrees) {
        requireNonNull(degrees);
        for (DegreeProgramme degree : degrees) {
            checkArgument(isValidDegreeProgramme(degree), MESSAGE_CONSTRAINTS);
        }
        this.degrees = degrees;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidDegreeProgramme(DegreeProgramme test) {
        return true;
        // return Integer.toString(test).matches(VALIDATION_REGEX);
    }

    public boolean addDegree(DegreeProgramme degree) {
        this.degrees.add(degree);
        return true;
    }

    public List<DegreeProgramme> getDegrees() {
        return degrees;
    }

    public boolean addDegrees(List<DegreeProgramme> degree) {
        this.degrees.addAll(degree);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (DegreeProgramme degree : degrees) {
            sb.append("\n" + degree.toString());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof Degrees // instanceof handles nulls
            && degrees == (((Degrees) other).degrees)); // state check
    }

    @Override
    public int hashCode() {
        return this.degrees.hashCode();
    }

}
