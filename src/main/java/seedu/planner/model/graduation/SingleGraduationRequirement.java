package seedu.planner.model.graduation;

import java.util.List;

import seedu.planner.model.module.ModuleCode;


public class SingleGraduationRequirement extends GraduationRequirement {

    public SingleGraduationRequirement(ModuleCode moduleCode) {
        this.moduleCode = moduleCode;
    }

    public boolean isFulfilled(List<ModuleCode> moduleCodes) {
        return moduleCodes.contains(moduleCode);
    }

}
