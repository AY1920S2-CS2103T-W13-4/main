package seedu.planner.model.programmes;

import java.util.List;

import seedu.planner.model.graduation.GraduationRequirement;
import seedu.planner.model.module.ModuleCode;


public abstract class Programme {
    protected String name;
    protected List<GraduationRequirement> graduationRequirementList;

    public String getName() {
        return name;
    }

    public List<GraduationRequirement> getGraduationRequirementList() {
        return graduationRequirementList;
    }

    public abstract boolean isFulfilled(List<ModuleCode> moduleCodes);
}
