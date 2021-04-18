package test;

import org.testng.annotations.Test;
import test.base.BaseTest;

public class HealthJournalTest extends BaseTest {
    @Test
    public void healthJournal(){
        mainPage.goToHealthJournal();
        healthJournal.selectSymptoms("Кашель");
        healthJournal.continueStep();
        healthJournal.badResult();
    }
}
