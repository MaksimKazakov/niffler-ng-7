package guru.qa.niffler.test.web;

import com.codeborne.selenide.Selenide;
import guru.qa.niffler.config.Config;
import guru.qa.niffler.page.LoginPage;
import guru.qa.niffler.page.MainPage;
import org.apache.kafka.common.protocol.types.Field;
import org.junit.jupiter.api.Test;

public class SpendingWebTest {

    private static final Config CFG = Config.getInstance();

    @Test
    void categoryDescriptionShouldBeEditedByTableAction(){
        final String newSpendingName = "Бензин АИ-95";
        Selenide.open(CFG.frontUrl(), LoginPage.class)
                .doLogin("max", "12345")
                .editSpending("Бензин")
                .editSpendingDescription(newSpendingName);
        new MainPage().checkThatTableContains(newSpendingName);
    }
}
