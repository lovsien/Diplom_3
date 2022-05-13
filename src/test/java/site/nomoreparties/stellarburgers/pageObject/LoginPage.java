package site.nomoreparties.stellarburgers.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    final static public String URL = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH, using = ".//form/fieldset[1]/div/div/input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//form/fieldset[2]/div/div/input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//form/button")
    private SelenideElement submitButton;

    @FindBy(how = How.XPATH, using = ".//div/p[1]/a")
    private SelenideElement registrationLink;

    @FindBy(how = How.XPATH, using = ".//div/p[2]/a")
    private SelenideElement forgotPasswordLink;

    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickRegistrationLink() {
        registrationLink.click();
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    public void setLoginForm(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
    }

}