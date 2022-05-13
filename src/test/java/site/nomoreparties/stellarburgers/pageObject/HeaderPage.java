package site.nomoreparties.stellarburgers.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderPage {

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/header/nav/div/a")
    private SelenideElement logo;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/header/nav/a")
    private SelenideElement personalAccountButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/header/nav/ul/li[2]/a")
    private SelenideElement ordersQueueButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/header/nav/ul/li[1]/a")
    private SelenideElement constructorButton;

}
