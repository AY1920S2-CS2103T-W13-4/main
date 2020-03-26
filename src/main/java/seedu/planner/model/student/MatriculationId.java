package seedu.planner.model.student;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.AppUtil.checkArgument;

/**
 * Represents a Student's ID in the application.
 * Guarantees: immutable; is valid as declared in {@link #isValidStudentId(String)}
 */
public class MatriculationId {

    public static final String MESSAGE_CONSTRAINTS =
        "Student IDs should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String id;

    /**
     * Constructs a {@code Name}.
     *
     * @param studentId A valid name.
     */
    public MatriculationId(String studentId) {
        requireNonNull(studentId);
        checkArgument(isValidStudentId(studentId), MESSAGE_CONSTRAINTS);
        id = studentId;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidStudentId(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof MatriculationId // instanceof handles nulls
            && id.equals(((MatriculationId) other).id)); // state check
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
