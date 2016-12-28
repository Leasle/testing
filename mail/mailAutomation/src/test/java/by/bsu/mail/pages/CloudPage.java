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

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sergey on 12/27/2016.
 */

public class CloudPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://mail.ru/";

    @FindBy(xpath = "//div[span[text()='Создать']]")
    private WebElement createButton;

    @FindBy(xpath = "//a[span[text()='Папку']]")
    private WebElement createFolderButton;

    @FindBy(className = "layer__input")
    private WebElement inputNameFolder;

    @FindBy(xpath = "//button[span[text()='Добавить']]")
    private WebElement addFolderButton;

    @FindBy(xpath = "//div[span[text()='TestFolder']]")
    private WebElement fileLink;

    @FindBy(xpath = "//div[span[text()='Удалить']]")
    private WebElement removeButton;

    @FindBy(xpath = "//button[span[text()='Удалить']]")
    private WebElement removeBtnOnRemoveLayer;

    @FindBy(className = "layer_trashbin-tutorial")
    private WebElement divAfterRemove;

    public CloudPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean isFolderCreated() {
        WebElement createdFolder = driver.findElement(By.xpath("//div[@data-id='/TestFolder']"));

        return createdFolder.isDisplayed();
    }

    public void createNewFolder(String folderName) {
        WebDriverWait wait = new WebDriverWait(driver, 3000);

        /* Проверяю, что я на нужной странице */
        WebElement logo = driver.findElement(By.className("pm-logo__link__pic"));
        System.out.println(logo.getAttribute("alt").equals("Облако@Mail.Ru"));
        System.out.println(logo.getAttribute("alt"));

        createButton.click();
        createFolderButton.click();
        inputNameFolder.sendKeys(folderName);
        addFolderButton.click();
    }

    public boolean deleteFile() {
        WebDriverWait wait = new WebDriverWait(driver, 3000);

        if (!isFolderCreated()) return false;

        fileLink.click();

        /* Ждём пока загрузится файл */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='TestFolder']")));

        removeButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("layer_remove")));

        removeBtnOnRemoveLayer.click();

        return divAfterRemove.isDisplayed();
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
