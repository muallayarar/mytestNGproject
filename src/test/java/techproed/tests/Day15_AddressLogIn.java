package techproed.tests;

import org.testng.annotations.Test;
import techproed.pages.AddressLogInPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day15_AddressLogIn {
    AddressLogInPage addressLogInPage=new AddressLogInPage();
    @Test
    public void logInTest(){
        //going to the page
        Driver.getDriver().get(ConfigReader.getProperty("address_url"));
        //sending username
        addressLogInPage.userName.sendKeys(ConfigReader.getProperty("address_username"));
        //sending password
        addressLogInPage.password.sendKeys(ConfigReader.getProperty("address_password"));
        //clicking on login button
        addressLogInPage.logInButton.click();
    }
}
