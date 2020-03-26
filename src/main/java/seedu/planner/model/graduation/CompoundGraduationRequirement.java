package seedu.planner.model.graduation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import seedu.planner.model.module.ModuleCode;

public class CompoundGraduationRequirement extends GraduationRequirement {

    protected AggregationType aggregationType;
    protected String name;
    // protected int minMCs;
    protected List<GraduationRequirement> graduationRequirementList = new ArrayList<>();

    public CompoundGraduationRequirement(String name, int minMCs, List<GraduationRequirement> requirements) {
        this.name = name;
        // this.minMCs = minMCs;
        this.graduationRequirementList = requirements;
        aggregationType = AggregationType.ALL;
    }

    public CompoundGraduationRequirement(String name, int minMCs, List<GraduationRequirement> requirements,
                                         AggregationType aggregationType) {
        this.name = name;
        // this.minMCs = minMCs;
        this.graduationRequirementList = requirements;
        this.aggregationType = aggregationType;
    }

    public boolean isFulfilled(List<ModuleCode> moduleCodes) {
        if (graduationRequirementList == null) {
            return false;
        }
        switch (aggregationType) {
        case ANY:
            for (GraduationRequirement requirement : graduationRequirementList) {
                if (requirement.isFulfilled(moduleCodes)) {
                    return true;
                }
            }
            return false;
        case ALL:
            for (GraduationRequirement requirement : graduationRequirementList) {
                if (!requirement.isFulfilled(moduleCodes)) {
                    return false;
                }
            }
            return true;
        default:
            return false;
        }
    }


    public String getString(List<ModuleCode> moduleCodes) {
        StringBuilder sb = new StringBuilder();
        String buffer;
        sb.append("[" + getStatusIcon(isFulfilled(moduleCodes)) + "] " + name + "\n");
        if (graduationRequirementList != null) {
            Iterator<GraduationRequirement> iterator = graduationRequirementList.iterator();
            while (iterator.hasNext()) {
                buffer = iterator.next().getString(moduleCodes);
                for (String line : buffer.split("\n")) {
                    sb.append("    " + line + "\n");
                }
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String buffer;
        sb.append("[X] " + name + "\n");
        if (graduationRequirementList != null) {
            Iterator<GraduationRequirement> iterator = graduationRequirementList.iterator();
            while (iterator.hasNext()) {
                buffer = iterator.next().toString();
                for (String line : buffer.split("\n")) {
                    sb.append("    " + line + "\n");
                }
            }
        }
        return sb.toString();
    }
}
