package seedu.planner.model.module;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.planner.commons.exceptions.IllegalValueException;

/**
 * Jackson-friendly version of {@link Module}.
 */
public class JsonAdaptedModule {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Module's %s field is missing!";

    private final String acadYear;
    private final String preclusion;
    private final String description;
    private final String title;
    private final String department;
    private final String faculty;
    // private final String workload;
    private final String prerequisite;
    private final String moduleCredit;
    private final String moduleCode;
    private final List<JsonAdaptedSemesterData> semesterData;
    private final String prereqTree;
    private final String fulfillRequirements;

    /**
     * Constructs a {@code JsonAdaptedModule} with the given module details.
     */
    @JsonCreator
    public JsonAdaptedModule(
        @JsonProperty("acadYear") String acadYear,
        @JsonProperty("preclusion") String preclusion,
        @JsonProperty("description") String description,
        @JsonProperty("title") String title,
        @JsonProperty("department") String department,
        @JsonProperty("faculty") String faculty,
        // @JsonProperty("workload") String workload,
        @JsonProperty("prerequisite") String prerequisite,
        @JsonProperty("moduleCredit") String moduleCredit,
        @JsonProperty("moduleCode") String moduleCode,
        @JsonProperty("semesterData") List<JsonAdaptedSemesterData> semesterData,
        @JsonProperty("prereqTree") String prereqTree,
        @JsonProperty("fulfillRequirements") String fulfillRequirements

    ) {
        this.acadYear = acadYear;
        this.preclusion = preclusion;
        this.description = description;
        this.title = title;
        this.department = department;
        this.faculty = faculty;
        // this.workload = workload;
        this.prerequisite = prerequisite;
        this.moduleCredit = moduleCredit;
        this.moduleCode = moduleCode;
        this.semesterData = semesterData;
        this.prereqTree = prereqTree;
        this.fulfillRequirements = fulfillRequirements;

    }

    /**
     * Converts a given {@code Module} into this class for Jackson use.
     */
    public JsonAdaptedModule(Module module) {
        this.acadYear = module.getAcadYear();
        this.preclusion = module.getPreclusion();
        this.description = module.getDescription();
        this.title = module.getTitle();
        this.department = module.getDepartment();
        this.faculty = module.getFaculty();
        // this.workload = module.workload;
        this.prerequisite = module.getPrerequisite();
        this.moduleCredit = module.getModuleTitle();
        this.moduleCode = module.getAcadYear().toString();
        this.semesterData = module.getSemesterData().stream().map(JsonAdaptedSemesterData::new)
            .collect(Collectors.toList());
        this.prereqTree = module.getPrereqTree();
        this.fulfillRequirements = module.getFulfillRequirements();
    }

    /**
     * Converts this Jackson-friendly adapted Module object into the model's {@code Module} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted module.
     */
    public Module toModelType() throws IllegalValueException {
        return new Module(
            acadYear,
            preclusion,
            description,
            title,
            department,
            faculty,
            null, // workload,
            prerequisite,
            moduleCredit,
            moduleCode,
            semesterData.stream().map(x -> x.toModelType()).collect(Collectors.toList()),
            prereqTree,
            fulfillRequirements
        );
    }
}
