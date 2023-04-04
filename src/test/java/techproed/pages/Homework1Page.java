package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class Homework1Page {

    public Homework1Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "formBasicEmail")
    public WebElement email;

    @FindBy(id = "formBasicPassword")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(name = "car")
    public WebElement selectCar;

    @FindBy(name = "pickUpLocation")
    public WebElement pickUpAddress;

    @FindBy(name = "dropOfLocation")
    public WebElement dropOffAddress;

    @FindBy(name = "pickUpDate")
    public WebElement pickUpDate;

    @FindBy(name = "pickUpTime")
    public WebElement pickUpTime;

    @FindBy(name = "dropOffDate")
    public WebElement dropOffDate;

    @FindBy(name = "dropOffTime")
    public WebElement dropOffTime;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueButton;

    @FindBy(name = "cardNo")
    public WebElement cardNo;

    @FindBy(name = "nameOnCard")
    public WebElement cardName;

    @FindBy(name = "expireDate")
    public WebElement dateOfCreditCard;

    @FindBy(name = "cvc")
    public WebElement cvc;

    @FindBy(name = "contract")
    public WebElement checkBox;

    @FindBy(xpath = "//button[text()=' Complete Reservation']")
    public WebElement completeReservation;
}
