package HomeWork8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestCreateFolder {
    @Given("^I am authorized$")
    public void iAmAuthorized() {
        Selenide.open("https://account.mail.ru");
        new MailLogin().fillLogin("test_gb00@mail.ru").submitLogin().fillPassword("3SfSyTIaeo4").submitLogin();
    }

    @Given("^Я открываю окно создания папки$")
    public void openNewFolderWindow() {
        new NavigationFolder().newFolder();
    }

    @When("^Я ввожу название папки$")
    public void enterNameFolder() {
        new CreateNewFolder().fillFolderName("test folder");
    }

    @And("^Я нажимаю кнопку добавить папку$")
    public void addFolderButton() {
        new CreateNewFolder().addNewFolder();
    }

    @Then("^Я вижу созданную папку в дереве папок$")
    public void iSeeNewFolder() {
        new NavigationFolder().successMessage.shouldBe(Condition.visible);
        Selenide.closeWebDriver();
    }
}
