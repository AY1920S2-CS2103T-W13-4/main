package seedu.address.model.module;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Person;

/**
 * Jackson-friendly version of {@link Person}.
 */
public class JsonAdaptedModule {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Module's %s field is missing!";

    private final String ModuleCode;
    private final String ModuleTitle;
    private final String AcadYear;
    private final String SemesterName;
    private final String Faculty;
    private final String Department;
    private final String ModuleDescription;
    private final String CrossModule;
    private final String ModuleCredit;
    private final String Workload;
    private final String Prerequisite;
    private final String Preclusion;
    private final String Corequisite;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedModule(
        @JsonProperty("ModuleCode") String ModuleCode,
        @JsonProperty("ModuleTitle") String ModuleTitle,
        @JsonProperty("AcadYear") String AcadYear,
        @JsonProperty("SemesterName") String SemesterName,
        @JsonProperty("Faculty") String Faculty,
        @JsonProperty("Department") String Department,
        @JsonProperty("ModuleDescription") String ModuleDescription,
        @JsonProperty("CrossModule") String CrossModule,
        @JsonProperty("ModuleCredit") String ModuleCredit,
        @JsonProperty("Workload") String Workload,
        @JsonProperty("Prerequisite") String Prerequisite,
        @JsonProperty("Preclusion") String Preclusion,
        @JsonProperty("Corequisite") String Corequisite

        ) {
        this.ModuleCode = ModuleCode;
        this.ModuleTitle = ModuleTitle;
        this.AcadYear = AcadYear;
        this.SemesterName = SemesterName;
        this.Faculty = Faculty;
        this.Department = Department;
        this.ModuleDescription = ModuleDescription;
        this.CrossModule = CrossModule;
        this.ModuleCredit = ModuleCredit;
        this.Workload = Workload;
        this.Prerequisite = Prerequisite;
        this.Preclusion = Preclusion;
        this.Corequisite = Corequisite;

    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedModule(Module module) {
        this.ModuleCode = module.ModuleCode.toString();
        this.ModuleTitle = module.ModuleTitle;
        this.AcadYear = module.AcadYear;
        this.SemesterName = module.SemesterName.toString();
        this.Faculty = module.Faculty;
        this.Department = module.Department;
        this.ModuleDescription = module.ModuleDescription.toString();
        this.CrossModule = module.CrossModule;
        this.ModuleCredit = module.ModuleCredit.toString();
        this.Workload = module.Workload;
        this.Prerequisite = module.Prerequisite;
        this.Preclusion = module.Preclusion;
        this.Corequisite = module.Corequisite;
    }

    /**
     * Converts this Jackson-friendly adapted Module object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Module toModelType() throws IllegalValueException {
//        if (name == null) { // TODO Data validation
//            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
//        }
//        if (!Name.isValidName(name)) {
//            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
//        }
//        final Name modelName = new Name(name);
//
//        if (major == null) {
//            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Major.class.getSimpleName()));
//        }
//        if (!Major.isValidMajor(major)) {
//            throw new IllegalValueException(Major.MESSAGE_CONSTRAINTS);
//        }
//        final Major modelMajor = new Major(major);
        return new Module(ModuleCode, ModuleTitle, AcadYear, SemesterName, Faculty, Department, ModuleDescription, CrossModule, ModuleCredit, Workload, Prerequisite, Preclusion, Corequisite);
    }
}
