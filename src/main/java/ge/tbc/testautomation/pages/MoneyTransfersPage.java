package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class MoneyTransfersPage {
    public Locator moneyTransferFeesTab;
    public Locator currencyDropdown;
    public Locator countryDropdown;
    public Locator dropdownOptions;
    public Locator transferSumInput;
    public Locator transferFeeResults;

    public MoneyTransfersPage(Page page) {
        moneyTransferFeesTab = page.locator("app-money-transfer-fee-calculator-section")
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions())
                .getByText("გზავნილის გაგზავნის საკომისიო");

        // there is no stable way to differentiate between the two dropdowns on the given page,
        // i could've matched "GEL" text here but if it changes the locator won't work anymore
        // so i went for the xpath i used in final-project-1
        currencyDropdown = page.locator("//input[@id='tbcx-text-input-1']//parent::div//following-sibling::div//i");
        countryDropdown = page.locator("tbcx-dropdown-selector")
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions())
                .getByText("აირჩიე ქვეყანა"); // not likely to change

        dropdownOptions = page.locator("//div/tbcx-dropdown-popover-item");
        transferSumInput = page.locator("tbcx-input-with-selector").getByRole(AriaRole.TEXTBOX);
        transferFeeResults = page.locator("tbcx-pw-money-transfer-fee-calculator tbcx-pw-money-transfer-system-card");
    }
}
