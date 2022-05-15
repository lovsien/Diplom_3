package site.nomoreparties.stellarburgers.pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAccountProfilePage {

    final static public String URL = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(how = How.CLASS_NAME, using = "Account_button__14Yp3")
    private SelenideElement logoutButton;

    @Step("Click logout button")
    public void clickLogoutButton() {
        logoutButton.click();
    }

}