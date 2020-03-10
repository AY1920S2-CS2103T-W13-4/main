package seedu.address.model;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;
import seedu.address.model.student.Student;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents the in-memory model of the address book data.
 */
public class PlannerModelManager extends ModelManager {
    private static final Logger logger = LogsCenter.getLogger(PlannerModelManager.class);

    private final Planner planner;
    //private final ModuleBook moduleBook;
    //private final FilteredList<Module> filteredmodules;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public PlannerModelManager(Planner planner) {
        super();
        requireAllNonNull(planner);

        // logger.fine("Initializing with address book: " + addressBook + " and user prefs " + userPrefs);

        this.planner = planner;
        //this.moduleBook = new ModuleBook(moduleBook);
        //filteredmodules = new FilteredList<>(this.moduleBook.getModuleList());

        // this.userPrefs = new UserPrefs(userPrefs);
    }

    public PlannerModelManager() {
        this(new Planner());
    }


    //=========== Planner ================================================================================

    public void setPlanner(Planner planner) {
        this.planner.resetData();
    }

    public Planner getPlanner() {
        return planner;
    }

    /*public ObservableList<Module> getFilteredModuleList() {
        return filteredmodules;
    }

    public void updateFilteredModuleList(Predicate<Module> predicate) {
        requireNonNull(predicate);
        filteredmodules.setPredicate(predicate);
    }*/

    public void addStudent(Student student) {
        requireAllNonNull(student);
        planner.addStudent(student);
    }


}
