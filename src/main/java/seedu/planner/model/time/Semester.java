package seedu.planner.model.time;

public enum Semester {
    ONE("Semester 1"),
    TWO("Semester 2"),
    SPECIAL_ONE("Special Semester 1"),
    SPECIAL_TWO("Special Semester 2");

    public static final String MESSAGE_CONSTRAINTS = "Semester can be one of the following: "
        + Semester.values().toString();
    private String name;

    Semester(String name) {
        this.name = name;
    }

    public String getAction() {
        return this.name;
    }
}
