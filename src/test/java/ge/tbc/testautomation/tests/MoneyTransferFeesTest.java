package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.steps.MoneyTransfersSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// i don't remember exact name of the scenario, and it's absent in final-project-1
// i don't have access to zephyr anymore so i can't check, but i know it was 30th
@Test(description = "Verify money transfer fees calculator shows results", groups = {"SCRUM-T30"})
@Epic("Money transfers")
@Feature("Money transfer fees calculator")
public class MoneyTransferFeesTest extends BaseTest {
    @BeforeClass
    public void initialize() {
        moneyTransfersSteps = new MoneyTransfersSteps(page);
    }

    @Test(priority = 1)
    @Story("Navigate to money transfers page")
    @Severity(SeverityLevel.CRITICAL)
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
    @Story("Open the fees calculator")
    @Severity(SeverityLevel.NORMAL)
    public void goToMoneyTransferFeesCalculator() {
        moneyTransfersSteps
                .scrollToMoneyTransferFeesCalculator()
                .clickOnMoneyTransferFeesCalculator();
    }

    @Test(priority = 3, dependsOnMethods = "goToMoneyTransferFeesCalculator")
    @Story("Select transfer currency")
    @Severity(SeverityLevel.NORMAL)
    public void pickCurrency() {
        moneyTransfersSteps
                .clickOnRandomCurrency();
    }

    @Test(priority = 4, dependsOnMethods = "pickCurrency")
    @Story("Enter transfer amount")
    @Severity(SeverityLevel.NORMAL)
    public void enterSum() {
        moneyTransfersSteps
                .enterRandomTransferSum();
    }

    @Test(priority = 5, dependsOnMethods = "enterSum")
    @Story("Select destination country and verify results")
    @Severity(SeverityLevel.CRITICAL)
    public void pickCountry() {
        moneyTransfersSteps
                .clickOnRandomCountry()
                .verifyResults();
    }
}
