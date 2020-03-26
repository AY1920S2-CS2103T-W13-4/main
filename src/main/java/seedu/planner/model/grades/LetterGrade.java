package seedu.planner.model.grades;

import java.util.OptionalDouble;

public enum LetterGrade {
    A_PLUS(5.0),
    A(5.0),
    A_MINUS(4.5),
    B_PLUS(4.0),
    B(3.5),
    B_MINUS(3.0),
    C_PLUS(2.5),
    C(2.0),
    D_PLUS(1.5),
    D(1.0),
    F(0.0),
    CS,
    CU,
    W,
    EXE;

    public final OptionalDouble points;
    public final boolean isSu;

    LetterGrade(double points) {
        this.points = OptionalDouble.of(points);
        this.isSu = false;
    }

    LetterGrade() {
        this.points = OptionalDouble.empty();
        this.isSu = true;
    }
}
