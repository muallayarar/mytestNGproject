package practice05.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AmazonSignInPage {

    public AmazonSignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement signInTab;

    @FindBy(id = "ap_email")
    public WebElement emailBox;


    @FindBy(id = "continue")
    public WebElement continueButton;


    @FindBy(xpath = "//h4[@class='a-alert-heading']")
    public WebElement warningMessage;

    @FindBy(xpath = "//span[@class='a-expander-prompt']")
    public WebElement needHelpLink;

    @FindBy(id = "auth-fpp-link-bottom")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//h1")
    public WebElement passwordAssistant;

    @FindBy(id = "createAccountSubmit")
    public WebElement createAccountButton;

    @FindBy(xpath = "//h1[@class='a-spacing-small']")
    public WebElement createAccountText;











}
