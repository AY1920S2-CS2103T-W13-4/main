package seedu.planner.model.module;

import static java.util.Objects.requireNonNull;

public class Description {
    public static final String MESSAGE_CONSTRAINS = "Description cannot be null";

    public final String value;

    public Description(String description) {
        requireNonNull(description);
        value = description;
    }

    @Override
    public String toString() {
        return value;
    }
}
