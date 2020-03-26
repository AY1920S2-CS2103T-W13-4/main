package seedu.planner.model.util;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.planner.model.AddressBook;
import seedu.planner.model.Planner;
import seedu.planner.model.ReadOnlyAddressBook;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.person.Address;
import seedu.planner.model.person.Email;
import seedu.planner.model.person.Name;
import seedu.planner.model.person.Person;
import seedu.planner.model.person.Phone;
import seedu.planner.model.student.Enrollment;
import seedu.planner.model.student.Major;
import seedu.planner.model.student.Student;
import seedu.planner.model.student.TimeTable;
import seedu.planner.model.student.TimeTableMap;
import seedu.planner.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[]{
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                getTagSet("colleagues"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    public static Planner getSamplePlanner() {
        Planner samplePlanner = new Planner();
        Student student = SampleDataUtil.getSampleStudent();
        samplePlanner.addStudent(student);
        samplePlanner.activateStudent(student); // TODO: allow serialization of planner with no active student
        return samplePlanner;
    }

    public static Student getSampleStudent() {
        Student sampleStudent = new Student(new seedu.planner.model.student.Name("Mark"), new Major("CS"),
            SampleDataUtil.getSampleTimeTableMap());
        return sampleStudent;
    }

    public static TimeTableMap getSampleTimeTableMap() {
        TimeTableMap timeTableMap = new TimeTableMap();
        return timeTableMap;
    }

    /**
     * Returns a non-empty (@code TimeTableMap) which (@code Student) can immediately use.
     *
     * @return Non-empty (@code TimeTableMap)
     */
    public static TimeTable getSampleTimeTable() {
        TimeTable timeTable = new TimeTable();
        timeTable.addEnrollment(new Enrollment(new ModuleCode("CS2040"), Optional.empty(), 4));
        return timeTable;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
            .map(Tag::new)
            .collect(Collectors.toSet());
    }

}
