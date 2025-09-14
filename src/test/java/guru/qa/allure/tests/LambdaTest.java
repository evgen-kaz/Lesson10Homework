package guru.qa.allure.tests;

import com.codeborne.selenide.Condition;
import guru.qa.allure.tests.steps.StepTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest extends TestBase {

    @Test
    public void testLambdaStepIssueSearch() {

        step("Открываем главную страницу", () -> {
            open("");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(byText("Search or jump to...")).click();
            $("input#query-builder-test").setValue(REPOSITORY).submit();
        });

        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Проверяем наличие Issue", () -> {
            $(withText(NAME_TAB)).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedStep() {
        StepTest steps = new StepTest();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.shouldSeeIssue(NAME_TAB);
    }
}