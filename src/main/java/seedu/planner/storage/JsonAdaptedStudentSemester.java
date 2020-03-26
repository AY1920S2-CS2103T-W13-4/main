package seedu.planner.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.model.time.SemesterYear;
import seedu.planner.model.time.StudentSemester;

public class JsonAdaptedStudentSemester {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "StudentSemester's %s field is missing!";

    private final JsonAdaptedSemesterYear semYear;
    private final int degreeYear;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedStudentSemester(@JsonProperty("semYear") JsonAdaptedSemesterYear semYear,
                                      @JsonProperty("degreeYear") int degreeYear) {
        this.semYear = semYear;
        this.degreeYear = degreeYear;
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedStudentSemester(StudentSemester source) {
        semYear = new JsonAdaptedSemesterYear(source.getSemesterYear());
        degreeYear = source.getDegreeYear();
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public StudentSemester toModelType() throws IllegalValueException {

        if (semYear == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                SemesterYear.class.getSimpleName()));
        }
        // TODO: validate input
        /*if (!SemesterYear.isValidSemesterYear(semYear)) {
            throw new IllegalValueException(SemesterYear.MESSAGE_CONSTRAINTS);
        }*/
        final SemesterYear modelSemYear = semYear.toModelType();

        // TODO: validate degreeYear
        final int modelDegreeYear = degreeYear;
        return new StudentSemester(modelSemYear, modelDegreeYear);
    }
}
