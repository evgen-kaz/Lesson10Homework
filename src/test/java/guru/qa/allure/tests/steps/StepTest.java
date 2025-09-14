package guru.qa.allure.tests.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepTest {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(byText("Search or jump to...")).click();
        $("input#query-builder-test").setValue(repo).submit();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Проверяем наличие Issue")
    public void shouldSeeIssue(String tab) {
        $(withText(tab)).should(Condition.exist);
    }
}
