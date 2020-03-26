package seedu.planner.model.graduation;

import java.util.List;

import seedu.planner.model.module.ModuleCode;

public abstract class GraduationRequirement {

    protected ModuleCode moduleCode;

    public ModuleCode getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(ModuleCode moduleCode) {
        this.moduleCode = moduleCode;
    }

    public abstract boolean isFulfilled(List<ModuleCode> moduleCodes);

    protected String getStatusIcon(boolean done) {
        return done ? "Y" : "X";
    }

    @Override
    public String toString() {
        return moduleCode.toString();
    }

    public String getString(List<ModuleCode> moduleCodes) {
        return "[" + getStatusIcon(isFulfilled(moduleCodes)) + "] " + moduleCode.toString();
    }
}
