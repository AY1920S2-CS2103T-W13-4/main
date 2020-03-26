package seedu.planner.model.module;

import static java.util.Objects.requireNonNull;

public class Credit {
    public static final String MESSAGE_CONSTRAINS = "Credits cannot be null";

    public final int value;


    public Credit(String credit) {
        this(Integer.parseInt(credit));
    }

    public Credit(int credit) {
        requireNonNull(credit);
        value = credit;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
