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
 * Created by Sergey on 12/27/2016.
 */

public class CloudPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://mail.ru/";

//    @FindBy(xpath = "//*[@title=\"Создать\"]")
//    @FindBy(xpath = "/html/body/div[2]/div[1]/div[5]/div[1]/div/div[1]/div/div/div/div/div[2]/div/div[2]")
    @FindBy(className = "b-dropdown__ctrl")
    private WebElement createButton;

//    @FindBy(xpath = "//a[@data-name='folder']")
//    @FindBy(xpath = "/html/body/div[2]/div[1]/div[5]/div[1]/div/div[1]/div/div/div/div/div[2]/div/div[2]/a[1]")
    @FindBy(className = "b-dropdown__list__item")
    private WebElement createFolderButton;

//    @FindBy(xpath = "//input[@class='layer__input']")
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[5]/div[5]/div[1]/div/div[1]/div/div/div/div/div/form/div[1]/input")
//    @FindBy(className = "layer__input")
    private WebElement inputNameFolder;

    @FindBy(xpath = "//button[@class='btn btn_main btn_neighboring']")
//    @FindBy(xpath = "/html/body/div[2]/div[1]/div[5]/div[5]/div[1]/div/div[1]/div/div/div/div/div/form/div[3]/div[1]/button[1]")
    private WebElement addFolderButton;

//    @FindBy(xpath = "//div[@data-id='/TestFolder']")
//    private WebElement createdFolder;

//    @FindBy(xpath = "/html/body/div[2]/div[1]/div[5]/div[1]/div/div[1]/div/div/div/div/div[2]/div/div[3]/div/div/div/button")
//    @FindBy(className = "btn btn_layer_close")
//    private WebElement closeButton;


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
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("btn btn_layer_close")));

//        closeButton.click();

        createButton.click();

//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("b-dropdown__list")));

        createFolderButton = driver.findElements(By.className("b-dropdown__list__item")).get(1);

        createFolderButton.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("layer__input")));

        inputNameFolder = driver.findElement(By.className("layer__input"));

        inputNameFolder.sendKeys(folderName);
        addFolderButton.click();

//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-id='/TestFolder']")));
    }

//    public String getCurrentRepositoryName() {
//        return linkCurrentRepository.getText();
//    }

    public boolean deleteFile() {
        WebElement firstElement = driver.findElement(By.className("b-collection__item b-collection__item_datalist b-collection__item_datalist-mode-thumb b-collection__item_axis-y b-collection__item_first"));

        WebElement selectElement = firstElement.findElement(By.className("js-checkbox b-checkbox js-item-checkbox b-checkbox_in-thumb"));

        selectElement.click();

        WebElement removeButton = driver.findElement(By.className("b-toolbar__btn b-toolbar__btn_remove"));
        removeButton.click();

        WebElement removeBtn = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[5]/div[5]/div[12]/div/div[1]/div/div/div/div/div/div[3]/div[1]/button[1]"));
        removeBtn.click();

        WebElement divAfterRemove = driver.findElement(By.className("layer_trashbin-tutorial"));
        return divAfterRemove.isDisplayed();
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
