package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.*;
import site.nomoreparties.stellarburgers.userDeletion.User;
import site.nomoreparties.stellarburgers.userDeletion.UserClient;
import site.nomoreparties.stellarburgers.userDeletion.UserCredentials;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class PersonalAccountTest {

    TestData testData = new TestData();
    String name;
    String email;
    String password;

    @Before
    public void setUp() {
        User user = testData.getRandomUserTestData();
        name = user.getName();
        email = user.getEmail();
        password = user.getPassword();

        RegisterPage registerPage = open(RegisterPage.URL, RegisterPage.class);
        registerPage.setRegistrationForm(name, email, password);
        registerPage.clickRegisterButton();
        webdriver().shouldHave(url(LoginPage.URL));

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setLoginForm(email, password);
        loginPage.clickSubmitButton();
        webdriver().shouldHave(url(ConstructorPage.URL));

        HeaderPage headerPage = page(HeaderPage.class);
        headerPage.clickPersonalAccountButton();
        webdriver().shouldHave(url(PersonalAccountProfilePage.URL));
    }

    @After
    public void tearDown() {
        UserClient userClient = new UserClient();
        UserCredentials credentials = UserCredentials.builder().email(email).password(password).build();

        ValidatableResponse loginResponse = userClient.loginWithCorrectCredentials(credentials);
        int responseStatusCode = loginResponse.extract().statusCode();

        if (responseStatusCode == 200) {
            String token = loginResponse.extract().path("accessToken").toString().substring(7);
            userClient.delete(token);
        }
    }

    @Test
    @DisplayName("Logout from the system on personal account page")
    public void logoutFromPersonalAccountButton() {
        PersonalAccountProfilePage personalAccountProfilePage = page(PersonalAccountProfilePage.class);
        personalAccountProfilePage.clickLogoutButton();
        webdriver().shouldHave(url(LoginPage.URL));
    }

    @Test
    @DisplayName("By click construction button user redirects from personal account to homepage")
    public void constructorButtonRedirectsFromPersonalAccountToHomepage() {
        HeaderPage headerPage = page(HeaderPage.class);

        headerPage.clickConstructorButton();
        webdriver().shouldHave(url(ConstructorPage.URL));
    }

    @Test
    @DisplayName("By click logo user redirects from personal account to homepage")
    public void logoRedirectsFromPersonalAccountToHomepage() {
        HeaderPage headerPage = page(HeaderPage.class);

        headerPage.clickLogo();
        webdriver().shouldHave(url(ConstructorPage.URL));
    }

}