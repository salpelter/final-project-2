package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ConsumerLoansPage;
import io.qameta.allure.Step;

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

    @Step("Retrieve all page titles from the consumer loans page")
    public ConsumerLoansSteps retrievePageTitles() {
        consumerLoansPage.titles.first().hover();
        this.titles = consumerLoansPage.titles.allInnerTexts();

        return this;
    }

    @Step("Retrieve all list items from the consumer loans page")
    public ConsumerLoansSteps retrievePageListItems() {
        consumerLoansPage.listItems.first().hover();
        this.listItems = consumerLoansPage.listItems.allInnerTexts();

        return this;
    }
}
