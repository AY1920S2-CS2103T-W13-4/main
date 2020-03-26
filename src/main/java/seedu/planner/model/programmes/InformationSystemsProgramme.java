package seedu.planner.model.programmes;

import java.util.ArrayList;
import java.util.Arrays;

import seedu.planner.model.graduation.CompoundGraduationRequirement;
import seedu.planner.model.graduation.SingleGraduationRequirement;
import seedu.planner.model.module.ModuleCode;

public class InformationSystemsProgramme extends DegreeProgramme {

    public InformationSystemsProgramme() { // TODO: Load from JSON or XML
        graduationRequirementList = new ArrayList<>();
        graduationRequirementList.add(new CompoundGraduationRequirement("University Level Requirements",
            20, new ArrayList<>(Arrays.asList(
            new CompoundGraduationRequirement("Human Cultures", 4, null),
            new CompoundGraduationRequirement("Thinking and Expression", 4, null),
            new CompoundGraduationRequirement("Singapore Studies", 4, null),
            new SingleGraduationRequirement(new ModuleCode("GEQ1000")),
            new SingleGraduationRequirement(new ModuleCode("GER1000"))
        ))));
        graduationRequirementList.add(new CompoundGraduationRequirement("Programme Requirements", 72,
            new ArrayList<>(Arrays.asList(
                new CompoundGraduationRequirement("Core Modules", 72, new ArrayList<>(Arrays.asList(
                    new SingleGraduationRequirement(new ModuleCode("CS1010J")),
                    new SingleGraduationRequirement(new ModuleCode("CS1231")),
                    new SingleGraduationRequirement(new ModuleCode("IS1103")),
                    new SingleGraduationRequirement(new ModuleCode("CS2030")),
                    new SingleGraduationRequirement(new ModuleCode("CS2040")),
                    new SingleGraduationRequirement(new ModuleCode("CS2102")),
                    new SingleGraduationRequirement(new ModuleCode("CS2105")),
                    new SingleGraduationRequirement(new ModuleCode("IS2101")),
                    new SingleGraduationRequirement(new ModuleCode("IS2102")),
                    new SingleGraduationRequirement(new ModuleCode("IS2103")),
                    new SingleGraduationRequirement(new ModuleCode("IS3103")),
                    new SingleGraduationRequirement(new ModuleCode("IS3106")),
                    new SingleGraduationRequirement(new ModuleCode("IS4100")),
                    new SingleGraduationRequirement(new ModuleCode("IS4103")),
                    new SingleGraduationRequirement(new ModuleCode("MA1301")),
                    new CompoundGraduationRequirement("Mathematics", 4, new ArrayList<>(Arrays.asList(
                        new SingleGraduationRequirement(new ModuleCode("MA1312")),
                        new SingleGraduationRequirement(new ModuleCode("MA1521"))
                    ))),
                    new SingleGraduationRequirement(new ModuleCode("ST2334"))
                ))),
                new CompoundGraduationRequirement("Programme Electives", 24, new ArrayList<>(Arrays.asList(

                ))),
                new CompoundGraduationRequirement("Internship or Dissertation", 12,
                    new ArrayList<>(Arrays.asList(
                        new SingleGraduationRequirement(new ModuleCode("IS4010")),
                        new SingleGraduationRequirement(new ModuleCode("CP4101"))
                    )))
            ))));
        graduationRequirementList.add(new CompoundGraduationRequirement("Unrestricted Electives", 32,
            null));
    }
}
