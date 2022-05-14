package site.nomoreparties.stellarburgers.pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public class RegisterPage {

    final static public String URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = ".//form/fieldset[1]/div/div/input")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = ".//form/fieldset[2]/div/div/input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//fieldset/div/p")
    private SelenideElement errorIncorrectPasswordMessage;

    @FindBy(how = How.XPATH, using = ".//form/button")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//div[@class='Auth_login__3hAey']/p")
    private SelenideElement errorExistingUserMessage;

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

    @Step("Check the error message of incorrect password appears when password's length is less than six digits")
    public void checkIncorrectPasswordErrorMessage() {
        errorIncorrectPasswordMessage.shouldBe(visible).shouldHave(text("Некорректный пароль"));
    }

    @Step("Check the error message of incorrect password does not appear when password's length is six and more digits")
    public void checkIncorrectPasswordMessageDoesNotAppear() {
        errorIncorrectPasswordMessage.shouldNotBe(visible);
    }

    @Step("Check the error message of existing user does not appear when click on register button")
    public void checkExistingUserMessageDoesNotAppear() {
        errorExistingUserMessage.shouldNotBe(visible);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    @Step("Click the login link on the registration page")
    public void clickLoginLink() {
        loginLink.shouldHave(href("/login"));
        loginLink.click();
    }

    @Step("Set the registration form")
    public void setRegistrationForm(String name, String email, String password) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
    }

}