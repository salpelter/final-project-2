package ge.tbc.testautomation.util;

import ge.tbc.testautomation.data.models.SectionComponentsItem;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ValidationHelper {
    public static void validateTitles(List<SectionComponentsItem> sectionComponents, List<String> actualTitles) {
        int i = 0;
        for (int j = 0; j < sectionComponents.size(); j++) {
            var sectionComponent = sectionComponents.get(j);

            // because of the structure of the api, unwanted section (carousel in this case)
            // is also included so below i'm excluding it from the comparison
            if (!sectionComponent.getType().equals("ctaSection")) {
                continue;
            }

            var apiTitle = sectionComponent.getInputs().getTitle();
            var actualTitle = actualTitles.get(i);

            Assert.assertEquals(actualTitle, apiTitle);
            i++;
        }
    }

    public static void validateListItems(List<SectionComponentsItem> sectionComponents, List<String> actualListItems) {
        var apiListItems = new ArrayList<String>();

        for (int i = 0; i < sectionComponents.size(); i++) {
            var sectionComponent = sectionComponents.get(i);
            var list = sectionComponent.getInputs().getList();

            if (list == null || list.isEmpty()) {
                continue;
            }

            for (int j = 0; j < list.size(); j++) {
                apiListItems.add(list.get(j).getLabel());
            }
        }

        Assert.assertEquals(apiListItems, actualListItems);
    }
}
