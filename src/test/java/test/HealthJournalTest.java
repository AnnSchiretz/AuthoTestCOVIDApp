package test;

import org.testng.annotations.Test;
import test.base.BaseTest;

public class HealthJournalTest extends BaseTest {
    @Test
    public void healthJournalBadResult(){
        mainPage.goToHealthJournal();
        healthJournal.selectSymptoms("Кашель");
        healthJournal.continueStep();
        healthJournal.badResult();
    }

    @Test
    public void healthJournalPositiveResult(){
        mainPage.goToHealthJournal();
        healthJournal.haveNotSymptoms();
    }
}
