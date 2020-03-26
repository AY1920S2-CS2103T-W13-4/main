package seedu.planner.model.graduation;

import java.util.List;

import seedu.planner.model.Model;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.programmes.specialisations.GenericSpecialisation;

public class FocusAreaGraduationRequirement extends GraduationRequirement {

    private GenericSpecialisation genericSpecialisation = null;

    public FocusAreaGraduationRequirement(Model model) {
        try {
            genericSpecialisation = model.getActiveStudent().getSpecialisation();
        } catch (Exception e) {
            return;
        }
    }

    public boolean isFulfilled(List<ModuleCode> moduleCodes) {
        if (genericSpecialisation == null) {
            return false;
        }
        return genericSpecialisation.isFulfilled(moduleCodes);
    }

    public GenericSpecialisation getGenericSpecialisation() {
        return genericSpecialisation;
    }

    public void setGenericSpecialisation(GenericSpecialisation genericSpecialisation) {
        this.genericSpecialisation = genericSpecialisation;
    }

    public String getString(List<ModuleCode> moduleCodes) {
        try {
            return "[" + getStatusIcon(isFulfilled(moduleCodes)) + "] ";
            // return "[" + getStatusIcon(isFulfilled(moduleCodes)) + "] " + genericSpecialisation.toString();
        } catch (Exception e) {
            return "???";
        }
    }
}
