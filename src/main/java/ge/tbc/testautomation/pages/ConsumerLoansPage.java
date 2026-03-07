package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ConsumerLoansPage {
    public Locator titles;
    public Locator listItems;

    public ConsumerLoansPage(Page page) {
        titles = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setLevel(1));

        listItems = page.locator("tbcx-pw-list")
                .getByRole(AriaRole.LISTITEM)
                .locator(".tbcx-list-item__text");
    }
}
