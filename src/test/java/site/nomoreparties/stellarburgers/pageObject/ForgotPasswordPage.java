package site.nomoreparties.stellarburgers.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    final static public String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//form/button")
    private SelenideElement submitButton;

    @FindBy(how = How.XPATH, using = ".//div/p/a")
    private SelenideElement loginLink;

    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

}
