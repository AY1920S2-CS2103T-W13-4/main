package seedu.planner.model.student;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.AppUtil.checkArgument;

/**
 * Represents a Student's graduation Year in the application.
 * Guarantees: immutable; is valid as declared in {@link #isValidGraduationYear(int)}
 */
public class GraduationYear {

    public static final String MESSAGE_CONSTRAINTS =
        "Student IDs should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final int graduationYear;

    /**
     * Constructs a {@code Name}.
     *
     * @param year A valid name.
     */
    public GraduationYear(int year) {
        requireNonNull(year);
        checkArgument(isValidGraduationYear(year), MESSAGE_CONSTRAINTS);
        graduationYear = year;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidGraduationYear(int test) {
        return Integer.toString(test).matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return Integer.toString(graduationYear);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof GraduationYear // instanceof handles nulls
            && graduationYear == (((GraduationYear) other).graduationYear)); // state check
    }

    @Override
    public int hashCode() {
        return graduationYear;
    }

}
