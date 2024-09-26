package HomeWork6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateFolder extends BaseView {

    public CreateFolder(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "name")
    public WebElement nameNewFolder;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement addFolder;

    @Step("Вводим название новой папки")
    public CreateFolder fillFolderName(String nameFolder) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
        nameNewFolder.sendKeys(nameFolder);
        return this;
    }

    @Step("Клик на кнопку \"Добавить папку\"")
    public CreateFolder addNewFolder() {
        addFolder.click();
        return this;
    }
}
