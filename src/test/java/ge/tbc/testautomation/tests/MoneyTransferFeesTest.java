package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.steps.MoneyTransfersSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// i don't remember exact name of the scenario, and it's absent in final-project-1
// i don't have access to zephyr anymore so i can't check, but i know it was 30th
@Test(groups = {"SCRUM-T30"})
public class MoneyTransferFeesTest extends BaseTest {
    @BeforeClass
    public void initialize() {
        moneyTransfersSteps = new MoneyTransfersSteps(page);
    }

    @Test(priority = 1)
    public void goToMoneyTransfersPage() {
        commonSteps
                .openMenu(isMobile);

        if (isMobile) {
            commonSteps
                    .unfoldOtherProductsSection();
        }

        commonSteps.clickOnMoneyTransfersPageLink();
    }

    @Test(priority = 2, dependsOnMethods = "goToMoneyTransfersPage")
    public void goToMoneyTransferFeesCalculator() {
        moneyTransfersSteps
                .scrollToMoneyTransferFeesCalculator()
                .clickOnMoneyTransferFeesCalculator();
    }

    @Test(priority = 3, dependsOnMethods = "goToMoneyTransferFeesCalculator")
    public void pickCurrency() {
        moneyTransfersSteps
                .clickOnRandomCurrency();
    }

    @Test(priority = 4, dependsOnMethods = "pickCurrency")
    public void enterSum() {
        moneyTransfersSteps
                .enterRandomTransferSum();
    }

    @Test(priority = 5, dependsOnMethods = "enterSum")
    public void pickCountry() {
        moneyTransfersSteps
                .clickOnRandomCountry()
                .verifyResults();
    }
}
