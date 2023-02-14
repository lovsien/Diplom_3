package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
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
    @Description("Logged user should have an ability to log out from the system")
    public void logoutFromPersonalAccountButton() {
        PersonalAccountProfilePage personalAccountProfilePage = page(PersonalAccountProfilePage.class);
        personalAccountProfilePage.clickLogoutButton();
        personalAccountProfilePage.checkURLIsLoginPage();
    }

    @Test
    @DisplayName("By click construction button user redirects from personal account to homepage")
    @Description("Create new user and log in. Go to Personal Account. Then click on Constructor button in Header. " +
            "It will redirect you to homepage.")
    public void constructorButtonRedirectsFromPersonalAccountToHomepage() {
        HeaderPage headerPage = page(HeaderPage.class);

        headerPage.clickConstructorButton();
        headerPage.checkURlIsHomepage();
    }

    @Test
    @DisplayName("By click logo user redirects from personal account to homepage")
    @Description("Create new user and log in. Go to Personal Account. Then click on logo in Header. " +
            "It will redirect you to homepage.")
    public void logoRedirectsFromPersonalAccountToHomepage() {
        HeaderPage headerPage = page(HeaderPage.class);

        headerPage.clickLogo();
        headerPage.checkURlIsHomepage();
    }

}