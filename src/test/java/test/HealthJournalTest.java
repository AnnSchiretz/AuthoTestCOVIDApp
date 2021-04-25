package test;

import org.testng.annotations.Test;
import test.base.BaseTest;

public class HealthJournalTest extends BaseTest {

    @Test
    public void healthJournalBadResult() {
        mainPage.goToHealthJournal();
        healthJournal.selectSymptoms("Кашель", "Слабость");
        healthJournal.continueStep();
        healthJournal.badResult("Кашель", "Слабость");
    }

    @Test
    public void healthJournalPositiveResult() {
        mainPage.goToHealthJournal();
        healthJournal.haveNotSymptoms();
    }
}
