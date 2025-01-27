package seedu.staffsnap.logic.commands;

import static seedu.staffsnap.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.staffsnap.logic.commands.CommandTestUtil.showEmployeeAtIndex;
import static seedu.staffsnap.testutil.TypicalEmployees.getTypicalAddressBook;
import static seedu.staffsnap.testutil.TypicalIndexes.INDEX_FIRST_EMPLOYEE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.staffsnap.model.Model;
import seedu.staffsnap.model.ModelManager;
import seedu.staffsnap.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListCommand.
 */
public class ListCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListCommand(), model, ListCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showEmployeeAtIndex(model, INDEX_FIRST_EMPLOYEE);
        assertCommandSuccess(new ListCommand(), model, ListCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
