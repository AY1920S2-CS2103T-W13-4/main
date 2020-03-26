package seedu.planner.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.model.student.Enrollment;
import seedu.planner.model.student.TimeTable;

public class JsonAdaptedTimeTable {
    private final List<JsonAdaptedEnrollment> enrollments = new ArrayList<>();

    @JsonCreator
    public JsonAdaptedTimeTable(List<JsonAdaptedEnrollment> enrollments) {
        this.enrollments.addAll(enrollments);
    }

    public JsonAdaptedTimeTable(TimeTable source) {
        enrollments.addAll(source.getEnrollments().stream()
            .map(JsonAdaptedEnrollment::new)
            .collect(Collectors.toList()));
    }

    @JsonValue
    public List<JsonAdaptedEnrollment> getEnrollments() {
        return enrollments;
    }

    public TimeTable toModelType() throws IllegalValueException {
        final List<Enrollment> modelEnrollments = new ArrayList<>();
        for (JsonAdaptedEnrollment enrollment : enrollments) {
            modelEnrollments.add(enrollment.toModelType());
        }
        return new TimeTable(modelEnrollments);
    }
}
