package seedu.planner.model.module;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.planner.model.student.Enrollment;

/**
 * A list of ModuleCode that enforces uniqueness between its elements and does not allow nulls.
 * A module code is considered unique by comparing using {@code ModuleCode#equals(Object)}.
 * As such, adding, updating and removal of module codes uses (@code ModuleCode#equals(Object)).
 * <p>
 * Supports a minimal set of list operations.
 */
public class UniqueEnrollmentList implements Iterable<Enrollment> {

    private final ObservableList<Enrollment> internalList = FXCollections.observableArrayList();
    private final ObservableList<Enrollment> internalUnmodifiableList =
        FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent module as the given argument.
     */
    public boolean contains(Enrollment toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::equals);
    }

    /**
     * Adds a module to the list.
     * The module must not already exist in the list.
     */
    public void add(Enrollment toAdd) {
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
    public void setModuleCode(Enrollment target, Enrollment editedEnrollment) {
        requireAllNonNull(target, editedEnrollment);

        int index = internalList.indexOf(target);
        if (index == -1) {
            // throw new ModuleNotFoundException(); TODO
        }

        if (!target.equals(editedEnrollment) && contains(editedEnrollment)) {
            // throw new DuplicateModuleException(); TODO
        }

        internalList.set(index, editedEnrollment);
    }

    /**
     * Removes the equivalent module from the list.
     * The module must exist in the list.
     */
    public void remove(Enrollment toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            // throw new ModuleNotFoundException(); TODO
        }
    }

    public void setModules(UniqueEnrollmentList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code modules}.
     * {@code modules} must not contain duplicate modules.
     */
    public void setEnrollments(List<Enrollment> enrollments) {
        requireAllNonNull(enrollments);
        if (!enrollmentsAreUnique(enrollments)) {
            // throw new DuplicateModuleException(); TODO
        }

        internalList.setAll(enrollments);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Enrollment> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Enrollment> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof UniqueEnrollmentList // instanceof handles nulls
            && internalList.equals(((UniqueEnrollmentList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    /**
     * Returns true if {@code modules} contains only unique modules.
     */
    private boolean enrollmentsAreUnique(List<Enrollment> enrollments) {
        for (int i = 0; i < enrollments.size() - 1; i++) {
            for (int j = i + 1; j < enrollments.size(); j++) {
                if (enrollments.get(i).equals(enrollments.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public Stream<Enrollment> stream() {
        return asUnmodifiableObservableList().stream();
    }

    public void removeIf(Predicate<? super Enrollment> predicate) {
        internalList.removeIf(predicate);
    }
}
