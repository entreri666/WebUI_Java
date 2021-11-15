package HomeWork6;

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

    public NavigationFolder newFolder() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='button2__txt']")));
        createFolder.click();
        return this;
    }
}
