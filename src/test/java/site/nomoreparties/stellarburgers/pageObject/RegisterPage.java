package site.nomoreparties.stellarburgers.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    final static public String URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = "./form/fieldset[1]/div/div/input")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = ".//form/fieldset[2]/div/div/input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//form/fieldset[3]/div/div/input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//form/button")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//div/div/p/a")
    private SelenideElement loginLink;

    public void setNameField(String name) {
        nameField.setValue(name);
    }

    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void setRegistrationForm(String name, String email, String password) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
    }

}