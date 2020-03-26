package seedu.planner.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.planner.logic.commands.CommandTestUtil.DESC_AMY;
import static seedu.planner.logic.commands.CommandTestUtil.DESC_BOB;
import static seedu.planner.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.planner.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.planner.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.planner.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.planner.logic.commands.major.MajorSetCommand;
import seedu.planner.logic.commands.major.MajorStatusCommand;
import seedu.planner.model.Model;
import seedu.planner.model.ModelManager;
import seedu.planner.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for EditCommand.
 */
public class MajorStatusTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_majorStatus_success() {
        String major = "CS";
        MajorSetCommand majorSetCommand = new MajorSetCommand(major);
        String expectedMessage = String.format(MajorSetCommand.MESSAGE_SUCCESS, major);
        MajorStatusCommand majorStatusCommand = new MajorStatusCommand();
    }

    @Test
    public void equals() {
        final EditCommand standardCommand = new EditCommand(INDEX_FIRST_PERSON, DESC_AMY);

        // same values -> returns true
        EditPersonDescriptor copyDescriptor = new EditPersonDescriptor(DESC_AMY);
        EditCommand commandWithSameValues = new EditCommand(INDEX_FIRST_PERSON, copyDescriptor);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new EditCommand(INDEX_SECOND_PERSON, DESC_AMY)));

        // different descriptor -> returns false
        assertFalse(standardCommand.equals(new EditCommand(INDEX_FIRST_PERSON, DESC_BOB)));
    }

}
