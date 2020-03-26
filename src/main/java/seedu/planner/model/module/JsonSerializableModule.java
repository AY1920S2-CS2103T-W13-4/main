package seedu.planner.model.module;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.model.ReadOnlyPlanner;

/**
 * An Immutable ModuleList that is serializable to JSON format.
 */
public class JsonSerializableModule {

    public static final String MESSAGE_DUPLICATE_MODULE = "Module list contains duplicate module(s).";

    private String acadYear;
    private String preclusion;
    private String description;
    private String title;
    private String department;
    private String faculty;
    private String prerequisite;
    private String moduleCredit;
    private String moduleCode;
    private List<JsonSerializableSemesterData> semesterData;
    private String prereqTree;
    private String fulfillRequirements;

    /**
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableModule(ReadOnlyPlanner source) {
        // TODO: Don't think we will need to use this. KIV
        // modules.addAll(source.getModuleList().stream().map(JsonAdaptedModule::new).collect(Collectors.toList()));
    }

    /**
     * Constructs a {@code JsonSerializableModule} with the given Module.
     */
    @JsonCreator
    public JsonSerializableModule(
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
        @JsonProperty("semesterData") List<JsonSerializableSemesterData> semesterData,
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

    public static String getMessageDuplicateModule() {
        return MESSAGE_DUPLICATE_MODULE;
    }

    /**
     * Converts this module into the model's {@code Module} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public Module toModelType() throws IllegalValueException {
        return new Module(
            this.acadYear,
            this.preclusion,
            this.description,
            this.title,
            this.department,
            this.faculty,
            null, // this.workload,
            this.prerequisite,
            this.moduleCredit,
            this.moduleCode.replaceAll("[^a-zA-Z0-9]", ""),
            this.semesterData.stream().map(x -> x.toModelType()).collect(Collectors.toList()), // this.semesterData,
            this.prereqTree,
            this.fulfillRequirements
        );
    }

    public String getAcadYear() {
        return acadYear;
    }

    public void setAcadYear(String acadYear) {
        this.acadYear = acadYear;
    }

    public String getPreclusion() {
        return preclusion;
    }

    public void setPreclusion(String preclusion) {
        this.preclusion = preclusion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public String getModuleCredit() {
        return moduleCredit;
    }

    public void setModuleCredit(String moduleCredit) {
        this.moduleCredit = moduleCredit;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public List<JsonSerializableSemesterData> getSemesterData() {
        return semesterData;
    }

    public void setSemesterData(List<JsonSerializableSemesterData> semesterData) {
        this.semesterData = semesterData;
    }

    public String getPrereqTree() {
        return prereqTree;
    }

    public void setPrereqTree(String prereqTree) {
        this.prereqTree = prereqTree;
    }

    public String getFulfillRequirements() {
        return fulfillRequirements;
    }

    public void setFulfillRequirements(String fulfillRequirements) {
        this.fulfillRequirements = fulfillRequirements;
    }
}
