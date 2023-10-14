package seedu.staffsnap.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.staffsnap.logic.commands.exceptions.CommandException;
import seedu.staffsnap.model.Model;
import seedu.staffsnap.model.ModelManager;
import seedu.staffsnap.model.UserPrefs;
import seedu.staffsnap.model.applicant.Descriptor;

import static seedu.staffsnap.testutil.TypicalApplicants.getApplicantsSortedByName;
import static seedu.staffsnap.testutil.TypicalApplicants.getApplicantsSortedByPhone;
import static seedu.staffsnap.testutil.TypicalApplicants.getUnsortedAddressBook;

class SortCommandTest {

    private Model model;

    @Test
    void execute_sortName() {
        model = new ModelManager(getUnsortedAddressBook(), new UserPrefs());
        try {
            new SortCommand(Descriptor.NAME).execute(model);
        } catch (CommandException e) {
            throw new RuntimeException(e);
        }
        assert(model.getFilteredApplicantList().equals(getApplicantsSortedByName()));
    }

    @Test
    void execute_sortPhone() {
        model = new ModelManager(getUnsortedAddressBook(), new UserPrefs());
        try {
            new SortCommand(Descriptor.PHONE).execute(model);
        } catch (CommandException e) {
            throw new RuntimeException(e);
        }
        assert(model.getFilteredApplicantList().equals(getApplicantsSortedByPhone()));
    }
}