package seedu.planner.model.programmes;

import java.util.ArrayList;
import java.util.Arrays;

import seedu.planner.model.Model;
import seedu.planner.model.graduation.CompoundGraduationRequirement;
import seedu.planner.model.graduation.FocusAreaGraduationRequirement;
import seedu.planner.model.graduation.SingleGraduationRequirement;
import seedu.planner.model.graduation.WildcardGraduationRequirement;
import seedu.planner.model.module.ModuleCode;

public class ComputerScienceProgramme extends DegreeProgramme {

    public ComputerScienceProgramme(Model model) { // TODO: Load from JSON or XML
        graduationRequirementList = new ArrayList<>();
        graduationRequirementList.add(new CompoundGraduationRequirement("University Level Requirements",
            20, new ArrayList<>(Arrays.asList(
            new WildcardGraduationRequirement("Human Cultures", 4, "GEH.*"),
            new WildcardGraduationRequirement("Thinking and Expression", 4, "GET.*"),
            new WildcardGraduationRequirement("Singapore Studies", 4, "GES.*"),
            new SingleGraduationRequirement(new ModuleCode("GEQ1000")),
            new SingleGraduationRequirement(new ModuleCode("GER1000"))
        ))));
        graduationRequirementList.add(new CompoundGraduationRequirement("Programme Requirements", 108,
            new ArrayList<>(Arrays.asList(
                new CompoundGraduationRequirement("Computer Science Foundation", 36, new ArrayList<>(Arrays.asList(
                    new SingleGraduationRequirement(new ModuleCode("CS1101S")),
                    new SingleGraduationRequirement(new ModuleCode("CS1231S")),
                    new SingleGraduationRequirement(new ModuleCode("CS2030")),
                    new SingleGraduationRequirement(new ModuleCode("CS2040S")),
                    new SingleGraduationRequirement(new ModuleCode("CS2100")),
                    new SingleGraduationRequirement(new ModuleCode("CS2103T")),
                    new SingleGraduationRequirement(new ModuleCode("CS2105")),
                    new SingleGraduationRequirement(new ModuleCode("CS2106")),
                    new SingleGraduationRequirement(new ModuleCode("CS3230"))
                ))),
                new CompoundGraduationRequirement("Computer Science Breadth and Depth", 44,
                    new ArrayList<>(Arrays.asList(
                        new FocusAreaGraduationRequirement(model),
                        new CompoundGraduationRequirement("Focus Area", 24, null),
                        new CompoundGraduationRequirement("Computer Systems Team Project", 8, null),
                        new CompoundGraduationRequirement("Industrial Experience Requirement", 12,
                            null)
                    ))),

                new CompoundGraduationRequirement("IT Professionalism", 12, new ArrayList<>(Arrays.asList(
                    new SingleGraduationRequirement(new ModuleCode("IS1103")),
                    new SingleGraduationRequirement(new ModuleCode("CS2101")),
                    new SingleGraduationRequirement(new ModuleCode("ES2660"))
                ))),
                new CompoundGraduationRequirement("Mathematics and Sciences", 16,
                    new ArrayList<>(Arrays.asList(
                        new SingleGraduationRequirement(new ModuleCode("MA1521")),
                        new SingleGraduationRequirement(new ModuleCode("MA1101R")),
                        new SingleGraduationRequirement(new ModuleCode("ST2334")),
                        new CompoundGraduationRequirement("One Science Module", 4, null)
                    )))
            ))));
        graduationRequirementList.add(new CompoundGraduationRequirement("Unrestricted Electives", 32,
            null));
    }
}
