package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;


public class LoginPageStep {

    LoginPage login = new LoginPage();
   HomePage homePage = new HomePage();
    @Given("I am on the Sauce Demo Login Page")
    public void iAmOnTheSauceDemoLoginPage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("I fill the account information for account StandardUser into the Username field and the Password field")
    public void i_fill_the_account_information_for_account_standard_user_into_the_username_field_and_the_password_field() {
       login.userName.sendKeys(ConfigReader.getProperty("username"));
       login.userPassword.sendKeys(ConfigReader.getProperty("loginpassword"));

    }


    @And("I click the Login Button")
    public void iClickTheLoginButton() {
    login.loginButton.click();

    }

    @Then("I am redirected to the Sauce Demo Main Page")
    public void iAmRedirectedToTheSauceDemoMainPage() {
    }

    @And("I verify the App Logo exists")
    public void iVerifyTheAppLogoExists() {
        Assert.assertTrue(homePage.appLogo.isDisplayed());



    }

    @When("I fill the account information for account LockedOutUser into the Username field and the Password field")
    public void iFillTheAccountInformationForAccountLockedOutUserIntoTheUsernameFieldAndThePasswordField() {
        login.userName.sendKeys(ConfigReader.getProperty("usernameFail"));
        login.userPassword.sendKeys(ConfigReader.getProperty("loginpasswordFail"));


    }

    @Then("I verify the Error Message contains the text {string}")
    public void iVerifyTheErrorMessageContainsTheText(String error) {

        String resultText = login.errorText.getText();
        System.out.println(resultText);

        Assert.assertTrue(resultText.contains(error));

    }
}
