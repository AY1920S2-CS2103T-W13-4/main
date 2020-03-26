package seedu.planner.model.programmes.specialisations;

import java.util.ArrayList;
import java.util.List;

import seedu.planner.model.graduation.GraduationRequirement;
import seedu.planner.model.module.ModuleCode;

public abstract class GenericSpecialisation {

    private String name;

    private List<GraduationRequirement> graduationRequirements = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<GraduationRequirement> getGraduationRequirements() {
        return graduationRequirements;
    }

    public abstract boolean isFulfilled(List<ModuleCode> moduleCodes);

    public String toString() {
        return name;
    }
}
