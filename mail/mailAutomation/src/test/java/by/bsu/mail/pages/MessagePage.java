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
public class MessagePage extends AbstractPage {
    private final String BASE_URL = "https://mail.ru/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "ph_mail")
    private WebElement mailButton;

    @FindBy(xpath = "//a[@class='b-toolbar__btn js-shortcut']")
    private WebElement writeMessageButton;

    @FindBy(xpath = "//textarea[@class='js-input compose__labels__input']")
    private WebElement whomElement;

    @FindBy(xpath = "//div[@class='b-toolbar__btn b-toolbar__btn_ b-toolbar__btn_false js-shortcut']")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@class='is-compose-empty_in']/form/div/button[@class='btn btn_stylish btn_main confirm-ok']")
    private WebElement confirmButton;

    @FindBy(className = "message-sent__title")
    private WebElement successTitle;

    @FindBy(xpath = "//a[@id=\"PH_projectsMenu_button\"]")
    private WebElement allProjectsButton;

//    @FindBy(xpath = "/html/body/div[2]/div/div[5]/div/div/div/div/div/div/div/div/div/div/div/div/div/div[3]/table/tbody/tr/td[1]/span[2]/span/span/span[2]/a[4]")
//    @FindBy(xpath = "//a[@data-title='Облако']")
    @FindBy(xpath = "/html/body/div[2]/div/div[5]/div/div/div/div/div/div/div/div/div/div/div/div/div/div[5]/div[2]/div/div[1]/div[2]/div/span/span[2]/span[14]/a")
    private WebElement cloudButton;

    private WebDriver driver;

    public MessagePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void mailPage() {
        mailButton.click();
    }

    public boolean isMessageSended() {
        return successTitle.isDisplayed();
    }

    public void createNewMessage(String whom, String messageBody) {
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("b-toolbar__btn js-shortcut")));

        writeMessageButton.click();
        whomElement.sendKeys(whom);
        sendButton.click();
        confirmButton.click();
    }

    public void chooseCloudLink() {
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("b-toolbar__btn js-shortcut")));

//        allProjectsButton.click();

//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@data-title='Облако']")));

        cloudButton.click();

        driver.navigate().to(cloudButton.getAttribute("href"));
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }
}
