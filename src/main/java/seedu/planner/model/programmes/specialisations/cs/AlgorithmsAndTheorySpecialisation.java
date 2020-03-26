package seedu.planner.model.programmes.specialisations.cs;

import java.util.ArrayList;

import seedu.planner.model.module.ModuleCode;

public class AlgorithmsAndTheorySpecialisation extends GenericCsSpecialisation {

    public AlgorithmsAndTheorySpecialisation() {
        setName("Algorithms And Theory");
        primaries = new ArrayList<>();
        electives = new ArrayList<>();

        primaries.add(new ModuleCode("CS3230"));
        primaries.add(new ModuleCode("CS3236"));
        primaries.add(new ModuleCode("CS4231"));
        primaries.add(new ModuleCode("CS4232"));
        primaries.add(new ModuleCode("CS4234"));

        electives.add(new ModuleCode("CS3233"));
        electives.add(new ModuleCode("CS4257"));
        electives.add(new ModuleCode("CS4261"));
        electives.add(new ModuleCode("CS4268"));
        electives.add(new ModuleCode("CS4269"));
        electives.add(new ModuleCode("CS4330"));
        electives.add(new ModuleCode("CS5230"));
        electives.add(new ModuleCode("CS5234"));
        electives.add(new ModuleCode("CS5236"));
        electives.add(new ModuleCode("CS5237"));
        electives.add(new ModuleCode("CS5238"));
        electives.add(new ModuleCode("CS5330"));
    }

    public String toString() {
        return "Algorithms And Theory";
    }


}
