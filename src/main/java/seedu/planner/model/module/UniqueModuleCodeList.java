package seedu.planner.model.module;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * A list of ModuleCode that enforces uniqueness between its elements and does not allow nulls.
 * A module code is considered unique by comparing using {@code ModuleCode#equals(Object)}.
 * As such, adding, updating and removal of module codes uses (@code ModuleCode#equals(Object)).
 * <p>
 * Supports a minimal set of list operations.
 */
public class UniqueModuleCodeList implements Iterable<ModuleCode> {

    private final ObservableList<ModuleCode> internalList = FXCollections.observableArrayList();
    private final ObservableList<ModuleCode> internalUnmodifiableList =
        FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent module as the given argument.
     */
    public boolean contains(ModuleCode toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::equals);
    }

    /**
     * Adds a module to the list.
     * The module must not already exist in the list.
     */
    public void add(ModuleCode toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            // throw new DuplicateModuleException(); TODO
        }
        internalList.add(toAdd);
    }

    /**
     * Replaces the module {@code target} in the list with {@code editedModuleCode}.
     * {@code target} must exist in the list.
     * The module identity of {@code editedModuleCode} must not be the same as another existing module in the list.
     */
    public void setModuleCode(ModuleCode target, ModuleCode editedModuleCode) {
        requireAllNonNull(target, editedModuleCode);

        int index = internalList.indexOf(target);
        if (index == -1) {
            // throw new ModuleNotFoundException(); TODO
        }

        if (!target.equals(editedModuleCode) && contains(editedModuleCode)) {
            // throw new DuplicateModuleException(); TODO
        }

        internalList.set(index, editedModuleCode);
    }

    /**
     * Removes the equivalent module from the list.
     * The module must exist in the list.
     */
    public void remove(ModuleCode toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            // throw new ModuleNotFoundException(); TODO
        }
    }

    public void setModules(UniqueModuleCodeList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code modules}.
     * {@code modules} must not contain duplicate modules.
     */
    public void setModules(List<ModuleCode> modules) {
        requireAllNonNull(modules);
        if (!modulesAreUnique(modules)) {
            // throw new DuplicateModuleException(); TODO
        }

        internalList.setAll(modules);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<ModuleCode> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<ModuleCode> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof UniqueModuleCodeList // instanceof handles nulls
            && internalList.equals(((UniqueModuleCodeList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    /**
     * Returns true if {@code modules} contains only unique modules.
     */
    private boolean modulesAreUnique(List<ModuleCode> modules) {
        for (int i = 0; i < modules.size() - 1; i++) {
            for (int j = i + 1; j < modules.size(); j++) {
                if (modules.get(i).equals(modules.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
