package site.nomoreparties.stellarburgers.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderPage {

    @FindBy(how = How.XPATH, using = ".//header/nav/div/a")
    private SelenideElement logo;

    @FindBy(how = How.XPATH, using = ".//header/nav/a")
    private SelenideElement personalAccountButton;

    @FindBy(how = How.XPATH, using = ".//header/nav/ul/li[1]/a")
    private SelenideElement constructorButton;

    @Step("Click on personal account button in header")
    public void clickPersonalAccountButton() {
        personalAccountButton.click();
    }

    public void checkButtonHasHrefToAccount() {
        personalAccountButton.shouldHave(Condition.href("/account"));
    }

    @Step("Click on constructor button")
    public void clickConstructorButton() {
        constructorButton.click();
    }

    @Step("Click on logo")
    public void clickLogo() {
        logo.click();
    }

}