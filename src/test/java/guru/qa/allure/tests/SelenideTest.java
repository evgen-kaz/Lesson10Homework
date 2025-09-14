package guru.qa.allure.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {
    @Test
    public void testIssueSearch() {
        open("");
        $(byText("Search or jump to...")).click();
        $("input#query-builder-test").setValue("evgen-kaz/Lesson9").submit();
        $(linkText("evgen-kaz/Lesson9")).click();
        $(withText("Issues")).should(Condition.exist);
    }
}
