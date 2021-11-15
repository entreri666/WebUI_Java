package HomeWork6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageMail extends BaseView{

    @FindBy(name = "username")
    public WebElement inputLogin;

    @FindBy(name = "password")
    public WebElement inputPassword;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement buttonLogin;

    public LoginPageMail fillLogin (String login){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='submit']")));
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPageMail fillPassword (String password){
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("password"))));
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPageMail submitLogin (){
        buttonLogin.click();
        return this;
    }

    public LoginPageMail(WebDriver driver) {
        super(driver);
    }
}
