package site.nomoreparties.stellarburgers.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConstructorPage {

    final static public String URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesAnchor;

    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']/..")
    private SelenideElement saucesTab;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsAnchor;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']/..")
    private SelenideElement bunsTab;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingsAnchor;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']/..")
    private SelenideElement fillingsTab;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;

    @Step("Click on Sauces")
    public void clickSauces() {
        saucesAnchor.shouldBe(Condition.visible);
        saucesAnchor.click();
    }

    @Step("Check scrolling to sauces")
    public void checkScrollToSaucesIsWorking() {
        saucesTab.shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
    }

    @Step("Click on Buns")
    public void clickBuns() {
        bunsAnchor.shouldBe(Condition.visible);
        bunsAnchor.click();
    }

    @Step("Check scrolling to buns")
    public void checkScrollToBunsIsWorking() {
        bunsTab.shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
    }

    @Step("Click on Fillings")
    public void clickFillings() {
        fillingsAnchor.shouldBe(Condition.visible);
        fillingsAnchor.click();
    }

    @Step("Check scrolling to fillings")
    public void checkScrollToFillingsIsWorking() {
        fillingsTab.shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
    }

    @Step("Click login button on homepage")
    public void clickLoginButton() {
        loginButton.click();
    }

}