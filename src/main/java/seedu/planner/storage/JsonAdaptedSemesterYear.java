package seedu.planner.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.model.student.Name;
import seedu.planner.model.time.Semester;
import seedu.planner.model.time.SemesterYear;

public class JsonAdaptedSemesterYear {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "SemesterYear's %s field is missing!";

    protected final String sem;
    protected final int academicYear;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedSemesterYear(@JsonProperty("sem") String sem, @JsonProperty("academicYear") int academicYear) {
        this.sem = sem;
        this.academicYear = academicYear;
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedSemesterYear(SemesterYear source) {
        sem = source.getSemester().toString();
        academicYear = source.getAcademicYear();
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public SemesterYear toModelType() throws IllegalValueException {

        if (sem == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        final Semester modelSem = Semester.valueOf(sem);
        final int modelAcademicYear = academicYear;

        return new SemesterYear(modelSem, modelAcademicYear);
    }
}
