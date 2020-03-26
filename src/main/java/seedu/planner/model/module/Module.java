package seedu.planner.model.module;

import java.util.List;

import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.model.time.Semester;

public class Module {

    private String acadYear;
    private String preclusion;
    private String description;
    private String title;
    private String department;
    private String faculty;
    private String workload;
    private String prerequisite;
    private String moduleCredit;
    private ModuleCode moduleCode;
    private List<SemesterData> semesterData;
    private String prereqTree;
    private String fulfillRequirements;

    public Module(
        String acadYear,
        String preclusion,
        String description,
        String title,
        String department,
        String faculty,
        String workload,
        String prerequisite,
        String moduleCredit,
        String moduleCode,
        List<SemesterData> semesterData,
        String prereqTree,
        String fulfillRequirements

    ) throws IllegalValueException {
        this.acadYear = acadYear;
        this.preclusion = preclusion;
        this.description = description;
        this.title = title;
        this.department = department;
        this.faculty = faculty;
        this.workload = workload;
        this.prerequisite = prerequisite;
        this.moduleCredit = moduleCredit;
        this.moduleCode = new ModuleCode(moduleCode);
        this.semesterData = semesterData;
        this.prereqTree = prereqTree;
        this.fulfillRequirements = fulfillRequirements;
    }

    public ModuleCode getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(ModuleCode moduleCode) {
        this.moduleCode = moduleCode;
    }

    public boolean isSameModule(Module module) {
        return false; // TODO
    }

    public int getModuleCredit() {
        // TODO: make `moduleCredit` an `int`
        return Integer.parseInt(moduleCredit);
    }

    public void setModuleCredit(String moduleCredit) {
        this.moduleCredit = moduleCredit;
    }

    public String getModuleTitle() {
        return title;
    }

    public List<SemesterData> getSemesterName() {
        return semesterData;
    }

    public Semester convertSem(String semesterName) {
        String convertedValue;
        switch (semesterName) {
        case "Semester 1":
            convertedValue = "ONE";
            break;
        case "Semester 2":
            convertedValue = "TWO";
            break;
        case "Special Semester 1":
            convertedValue = "SPECIAL_ONE";
            break;
        case "Special Semester 2":
            convertedValue = "SPECIAL_TWO";
            break;
        default:
            convertedValue = "NULL";
            break;
        }
        return Semester.valueOf(convertedValue);

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

    public String getWorkload() {
        return workload;
    }

    public void setWorkload(String workload) {
        this.workload = workload;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public List<SemesterData> getSemesterData() {
        return semesterData;
    }

    public void setSemesterData(List<SemesterData> semesterData) {
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
