package by.bsu.mail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Sergey on 16.11.2016.
 */
public class ThemePage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://mail.ru/";

    @FindBy(xpath = "//a[@class='js-link pm-toolbar__button__inner  pm-toolbar__button__inner_noicon' and span/span='Темы']")
    private WebElement themeButton;

    @FindBy(xpath = "//div[@id='theme']")
    private WebElement themeImg;

    @FindBy(xpath = "//a[@style='background-image:url(https://img.imgsmail.ru/r/themes/t1015/settings__preview_big.jpg);']")
    private WebElement themeIcon;

    private WebDriver driver;

    public ThemePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean changeTheme() {

        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("js-link pm-toolbar__button__inner  pm-toolbar__button__inner_noicon")));

        themeButton.click();
        themeIcon.click();

        wait.until(ExpectedConditions.attributeToBeNotEmpty(themeImg, "style"));

        return themeImg.getAttribute("style").equals("background-image: url(\"//img.imgsmail.ru/r/themes/t1015/bg/1440x900.jpg\");");
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }
}
