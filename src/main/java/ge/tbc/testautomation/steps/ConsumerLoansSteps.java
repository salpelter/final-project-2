package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ConsumerLoansPage;

import java.util.List;

public class ConsumerLoansSteps {
    Page page;
    ConsumerLoansPage consumerLoansPage;

    public List<String> titles;
    public List<String> listItems;

    public ConsumerLoansSteps(Page page) {
        this.page = page;
        consumerLoansPage = new ConsumerLoansPage(page);
    }

    public ConsumerLoansSteps retrievePageTitles() {
        consumerLoansPage.titles.first().hover();
        this.titles = consumerLoansPage.titles.allInnerTexts();

        return this;
    }

    public ConsumerLoansSteps retrievePageListItems() {
        consumerLoansPage.listItems.first().hover();
        this.listItems = consumerLoansPage.listItems.allInnerTexts();

        return this;
    }
}
