package site.nomoreparties.stellarburgers;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import site.nomoreparties.stellarburgers.userDeletion.User;

public class TestData {

    @Step("Create random data for test")
    public User getRandomUserTestData() {
        final String name = RandomStringUtils.randomAlphabetic(4);
        final String email = RandomStringUtils.randomAlphabetic(4).toLowerCase() + "@mail.com";
        final String password = RandomStringUtils.randomAlphabetic(8);

        return User.builder().name(name).email(email).password(password).build();
    }

}
