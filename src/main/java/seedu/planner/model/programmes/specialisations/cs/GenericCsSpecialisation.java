package seedu.planner.model.programmes.specialisations.cs;

import java.util.List;
import java.util.regex.Pattern;

import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.programmes.specialisations.GenericSpecialisation;

public abstract class GenericCsSpecialisation extends GenericSpecialisation {

    protected List<ModuleCode> primaries;
    protected List<ModuleCode> electives;

    public boolean isFulfilled(List<ModuleCode> moduleCodes) {
        int minModules = 3;
        int minNumOf4k = 1;
        int modules = 0;
        int numOf4k = 0;
        for (ModuleCode moduleCode : moduleCodes) {
            if (primaries.contains(moduleCode)) {
                modules++;
                if (Pattern.matches("...[456].*", moduleCode.value)) {
                    numOf4k++;
                }
            }
        }
        return numOf4k >= minNumOf4k && modules >= minModules;
    }
}
