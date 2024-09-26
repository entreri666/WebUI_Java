package HomeWork6;

import org.openqa.selenium.WebDriver;

public class MainPageMail extends BaseView {
    NavigationFolder navigationFolder;

    public MainPageMail(WebDriver driver) {
        super(driver);
        navigationFolder = new NavigationFolder(driver);
    }
}
