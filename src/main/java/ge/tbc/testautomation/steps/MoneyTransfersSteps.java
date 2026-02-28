package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.MoneyTransfersPage;
import io.qameta.allure.Step;

import java.util.Random;

public class MoneyTransfersSteps {
    Page page;
    MoneyTransfersPage moneyTransfersPage;

    Random rand;

    public MoneyTransfersSteps(Page page) {
        this.page = page;
        moneyTransfersPage = new MoneyTransfersPage(page);

        rand = new Random();
    }

    @Step("Scroll to the money transfer fees calculator")
    public MoneyTransfersSteps scrollToMoneyTransferFeesCalculator() {
        moneyTransfersPage.moneyTransferFeesTab.scrollIntoViewIfNeeded();

        return this;
    }

    @Step("Click on the money transfer fees calculator tab")
    public MoneyTransfersSteps clickOnMoneyTransferFeesCalculator() {
        moneyTransfersPage.moneyTransferFeesTab.click();

        return this;
    }

    @Step("Select a random currency from the dropdown")
    public MoneyTransfersSteps clickOnRandomCurrency() {
        moneyTransfersPage.currencyDropdown.click();

        moneyTransfersPage.dropdownOptions.first().hover();
        var currencyCount = moneyTransfersPage.dropdownOptions.count();

        moneyTransfersPage.dropdownOptions
                .nth(rand.nextInt(currencyCount))
                .click();

        return this;
    }

    @Step("Enter a random transfer sum into the input field")
    public MoneyTransfersSteps enterRandomTransferSum() {
        var randomTransferSum = rand.nextDouble(Constants.CURRENCY_UPPER_BOUND);

        if (randomTransferSum < 0) {
            randomTransferSum = -randomTransferSum;
        }

        var formattedTransferSum = String.format("%.2f", randomTransferSum);

        moneyTransfersPage.transferSumInput.clear();
        moneyTransfersPage.transferSumInput.fill(formattedTransferSum);

        return this;
    }

    @Step("Select a random country from the dropdown")
    public MoneyTransfersSteps clickOnRandomCountry() {
        moneyTransfersPage.countryDropdown.click();

        moneyTransfersPage.dropdownOptions.first().hover();
        var countryCount = moneyTransfersPage.dropdownOptions.count();

        moneyTransfersPage.dropdownOptions
                .nth(rand.nextInt(countryCount))
                .click();

        return this;
    }

    @Step("Verify that transfer fee results are displayed or log their absence")
    public MoneyTransfersSteps verifyResults() {
        try {
            moneyTransfersPage.transferFeeResults.first().waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(10000));
        }
        catch(TimeoutError e) {
            System.out.println("No transfer options for the given sum, currency and/or country.");
        }

        return this;
    }
}
