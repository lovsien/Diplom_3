package site.nomoreparties.stellarburgers;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.LoginPage;
import site.nomoreparties.stellarburgers.pageObject.RegisterPage;
import userDeletion.UserClient;
import userDeletion.UserCredentials;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class RegistrationTest {

    final String name = "Вася";
    final String email = "Asdf@mail.com";
    final String correctPassword = "12345678";
    final String password5digits = "12345";
    final String password6digits = "123456";

    @After
    public void tearDown() {
        UserClient userClient = new UserClient();
        UserCredentials credentials = UserCredentials.builder().email(email).password(correctPassword).build();

        ValidatableResponse loginResponse = userClient.loginWithCorrectCredentials(credentials);
        int responseStatusCode = loginResponse.extract().statusCode();

        if (responseStatusCode == 200) {
            String token = loginResponse.extract().path("accessToken").toString().substring(7);
            userClient.delete(token);
        }
    }

    @Test
    public void userCanRegisterWithCorrectData() {
        RegisterPage registerPage = open(RegisterPage.URL, RegisterPage.class);

        registerPage.setRegistrationForm(name, email, correctPassword);
        registerPage.checkIncorrectPasswordMessageDoesNotAppear();

        registerPage.clickRegisterButton();
        registerPage.checkExistingUserMessageDoesNotAppear();
        webdriver().shouldHave(url(LoginPage.URL));
    }

    @Test
    public void errorMessageAppearWhenPassword5Digits() {
        RegisterPage registerPage = open(RegisterPage.URL, RegisterPage.class);

        registerPage.setRegistrationForm(name, email, password5digits);
        registerPage.clickRegisterButton();
        registerPage.checkIncorrectPasswordErrorMessage();
    }

    @Test
    public void errorMessageDoesNotAppearWhenPassword6Digits() {
        RegisterPage registerPage = open(RegisterPage.URL, RegisterPage.class);

        registerPage.setRegistrationForm(name, email, password6digits);
        registerPage.checkIncorrectPasswordMessageDoesNotAppear();
    }

}