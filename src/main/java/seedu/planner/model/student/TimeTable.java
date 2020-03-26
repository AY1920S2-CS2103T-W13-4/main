package seedu.planner.model.student;

import java.util.List;
import java.util.stream.Collectors;

import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.module.UniqueEnrollmentList;

public class TimeTable {
    private UniqueEnrollmentList enrollments = new UniqueEnrollmentList();

    public TimeTable() {
    }

    public TimeTable(List<Enrollment> enrollments) {
        enrollments.forEach(this.enrollments::add);
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public void removeEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
    }

    public boolean hasEnrollment(Enrollment enrollment) {
        return enrollments.contains(enrollment);
    }

    public Enrollment getEnrollment(ModuleCode moduleCode) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getModuleCode().equals(moduleCode)) {
                return enrollment;
            }
        }
        throw new NullPointerException(String.format("Key %s does not exist", moduleCode));
    }

    public UniqueEnrollmentList getEnrollments() {
        return enrollments;
        //return enrollments.asUnmodifiableObservableList(); // TODO: replace with ObservableList<Enrollment>
    }

    public void setEnrollments(UniqueEnrollmentList enrollments) {
        this.enrollments = enrollments;
    }

    public List<ModuleCode> getModuleCodes() {
        return enrollments.stream().map(Enrollment::getModuleCode).collect(Collectors.toList());
    }

    public boolean hasModuleCode(ModuleCode moduleCode) {
        return enrollments.stream().anyMatch(enrollment -> enrollment.getModuleCode().equals(moduleCode));
    }

    public void removeModuleCode(ModuleCode moduleCode) {
        enrollments.removeIf(enrollment -> enrollment.getModuleCode().equals(moduleCode));
    }
}
