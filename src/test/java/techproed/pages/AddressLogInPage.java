package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AddressLogInPage {

    public AddressLogInPage(){

        //PageFactory is used initialize the page objects
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //Locating username
    @FindBy(id="session_email")
    public WebElement userName;

    //Locating the pwd
    @FindBy(id="session_password")
    public WebElement password;

    //locating the logın button
    @FindBy(name = "commit")
    public  WebElement logInButton;


}
