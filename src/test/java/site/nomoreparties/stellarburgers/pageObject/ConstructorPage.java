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

    @FindBy(how = How.XPATH, using = ".//div/h2[text()='Соусы']")
    private SelenideElement saucesHeader;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement bunsAnchor;

    @FindBy(how = How.XPATH, using = ".//div/h2[text()='Булки']")
    private SelenideElement bunsHeader;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingsAnchor;

    @FindBy(how = How.XPATH, using = ".//div/h2[text()='Начинки']")
    private SelenideElement fillingsHeader;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;

    @Step("Click on Sauces")
    public void clickSauces() {
        saucesAnchor.shouldBe(Condition.visible);
        saucesAnchor.click();
    }

    @Step("Check sauces header is visible")
    public void checkSaucesHeaderIsVisible() {
        saucesHeader.shouldBe(Condition.visible);
    }

    @Step("Click on Buns")
    public void clickBuns() {
        bunsAnchor.shouldBe(Condition.visible);
        bunsAnchor.click();
    }

    @Step("Check buns header is visible")
    public void checkBunsHeaderIsVisible() {
        bunsHeader.shouldBe(Condition.visible);
    }

    @Step("Click on Fillings")
    public void clickFillings() {
        fillingsAnchor.shouldBe(Condition.visible);
        fillingsAnchor.click();
    }

    @Step("Check fillings header is visible")
    public void checkFillingsHeaderIsVisible() {
        fillingsHeader.shouldBe(Condition.visible);
    }

    @Step("Click login button on homepage")
    public void clickLoginButton() {
        loginButton.click();
    }

}