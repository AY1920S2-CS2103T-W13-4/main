package seedu.planner.model.module;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javafx.collections.ObservableList;

/**
 * A list of Module that enforces uniqueness between its elements and does not allow nulls.
 * A module is considered unique by comparing using {@code Module#isSameModule(Module)}. As such, adding and updating of
 * modules uses Module#isSameModule(Module) for equality so as to ensure that the module being added or updated is
 * unique in terms of identity in the UniqueModuleList. However, the removal of a module uses Module#equals(Object) so
 * as to ensure that the module with exactly the same fields will be removed.
 * <p>
 * Supports a minimal set of list operations.
 *
 * @see Module#isSameModule(Module)
 */
public class UniqueModuleList implements Iterable<Module> {

    private final HashMap<ModuleCode, Module> internalList = new HashMap<>();

    /**
     * Returns true if the list contains an equivalent module as the given argument.
     */
    public boolean contains(ModuleCode toCheck) {
        requireNonNull(toCheck);
        return internalList.containsKey(toCheck);
    }

    public boolean contains(Module toCheck) {
        requireNonNull(toCheck);
        return internalList.containsKey(toCheck.getModuleCode());
    }

    /**
     * Adds a module to the list.
     * The module must not already exist in the list.
     */
    public void add(Module toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            // throw new DuplicateModuleException(); TODO
        }
        internalList.put(toAdd.getModuleCode(), toAdd);
    }

    public Module getModule(ModuleCode moduleCode) {
        return internalList.get(moduleCode);
    }

    /**
     * Removes the equivalent module from the list.
     * The module must exist in the list.
     */
    public void remove(Module toRemove) {
        requireNonNull(toRemove);
        internalList.remove(toRemove.getModuleCode());
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Module> asUnmodifiableObservableList() {
        return null;
    }

    @Override
    public Iterator<Module> iterator() {
        return internalList.values().iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof UniqueModuleList // instanceof handles nulls
            && internalList.equals(((UniqueModuleList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    /**
     * Returns true if {@code modules} contains only unique modules.
     */
    private boolean modulesAreUnique(List<Module> modules) {
        for (int i = 0; i < modules.size() - 1; i++) {
            for (int j = i + 1; j < modules.size(); j++) {
                if (modules.get(i).isSameModule(modules.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return internalList.size() == 0;
    }
}
