package seedu.planner.storage;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.model.ReadOnlyPlanner;
import seedu.planner.model.module.SemesterData;


/**
 * An Immutable ModuleList that is serializable to JSON format.
 */
public class JsonSerializableSemesterData {

    private int semester;
    private String examDate;
    private int examDuration;
    private List<JsonSerializableLesson> timetable;

    /**
     * Constructs a {@code JsonSerializableModule} with the given persons.
     */
    @JsonCreator
    public JsonSerializableSemesterData(
            @JsonProperty("semester") int semester,
            @JsonProperty("examDate") String examDate,
            @JsonProperty("examDuration") int examDuration,
            @JsonProperty("timetable") List<JsonSerializableLesson> timetable
    ) {
        this.semester = semester;
        this.examDate = examDate;
        this.examDuration = examDuration;
        this.timetable = timetable;
    }

    /**
     * Converts a given {@code ReadOnlyPlanner} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializablePlanner}.
     */
    public JsonSerializableSemesterData(ReadOnlyPlanner source) {
        // TODO: Don't think we will need to use this. KIV
        // modules.addAll(source.getModuleList().stream().map(JsonAdaptedModule::new).collect(Collectors.toList()));
    }

    /**
     * Converts this planner book into the model's {@code Planner} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public SemesterData toModelType() {
        return new SemesterData(
                semester,
                examDate,
                examDuration,
                null
        );
    }

}
