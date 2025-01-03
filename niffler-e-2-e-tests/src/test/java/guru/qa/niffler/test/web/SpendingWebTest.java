package guru.qa.niffler.test.web;

import com.codeborne.selenide.Selenide;
import guru.qa.niffler.config.Config;
import guru.qa.niffler.jupiter.BrowserExtension;
import guru.qa.niffler.jupiter.Spending;
import guru.qa.niffler.model.CurrencyValues;
import guru.qa.niffler.model.SpendJson;
import guru.qa.niffler.page.LoginPage;
import guru.qa.niffler.page.MainPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BrowserExtension.class)
public class SpendingWebTest {

    private static final Config CFG = Config.getInstance();

    @Spending(
            category = "АВТО",
            description = "Бензин",
            username = "max",
            amount = 15000.0,
            currency = CurrencyValues.RUB

    )

    @Test
    void categoryDescriptionShouldBeEditedByTableAction(SpendJson spend) {
        final String newSpendingName = "Бензин АИ-95";
        Selenide.open(CFG.frontUrl(), LoginPage.class)
                .doLogin("max", "12345")
                .editSpending(spend.description())
                .editSpendingDescription(newSpendingName);
        new MainPage().checkThatTableContains(newSpendingName);
    }
}
