package HomeWork6;

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

    public CreateFolder fillFolderName(String nameFolder) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
        nameNewFolder.sendKeys(nameFolder);
        return this;
    }

    public CreateFolder addNewFolder() {
        addFolder.click();
        return this;
    }
}
