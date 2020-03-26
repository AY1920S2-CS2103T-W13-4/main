package seedu.planner.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");

    public static final Prefix PREFIX_GRADE = new Prefix("grade/");
    public static final Prefix PREFIX_MAJOR = new Prefix("major/");
    public static final Prefix PREFIX_MINOR = new Prefix("minor/");
    public static final Prefix PREFIX_STUDENT_YEAR = new Prefix("year/");
    public static final Prefix PREFIX_STUDENT_SEM = new Prefix("sem/");
}
