package seedu.planner.model.module;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.planner.commons.exceptions.IllegalValueException;

/**
 * Jackson-friendly version of {@link SemesterData}.
 */
class JsonAdaptedSemesterData {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "SemesterData's %s field is missing!";

    private final int semester;
    private final String examDate;
    private final int examDuration;
    private final List<JsonAdaptedLesson> timetable;

    /**
     * Constructs a {@code JsonAdaptedSemesterData} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedSemesterData(
        @JsonProperty("semester") int semester,
        @JsonProperty("examDate") String examDate,
        @JsonProperty("examDuration") int examDuration,
        @JsonProperty("timetable") List<JsonAdaptedLesson> timetable
    ) {
        this.semester = semester;
        this.examDate = examDate;
        this.examDuration = examDuration;
        this.timetable = timetable;
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedSemesterData(SemesterData semesterData) {
        this.semester = semesterData.getSemester();
        this.examDate = semesterData.getExamDate();
        this.examDuration = semesterData.getExamDuration();
        this.timetable = semesterData.getTimetable().stream().map(JsonAdaptedLesson::new).collect(Collectors.toList());
    }

    /**
     * Converts this Jackson-friendly adapted Module object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public SemesterData toModelType() {
        return new SemesterData(
            semester,
            examDate,
            examDuration,
            timetable.stream().map(x -> x.toModelType()).collect(Collectors.toList())
        );
    }
}
