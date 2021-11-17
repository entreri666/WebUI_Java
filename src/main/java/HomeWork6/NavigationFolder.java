package HomeWork6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationFolder extends BaseView {

    public NavigationFolder(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='sideBarContent']/div/nav/div/div/span")
    public WebElement createFolder;

    @Step("Клик на кнопку \"Новая папка\"")
    public NavigationFolder newFolder() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='button2__txt']")));
        createFolder.click();
        return this;
    }
}
