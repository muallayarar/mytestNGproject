package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.Homework1Page;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;


public class Homework1Test {
    //Name:
    //Require user to login for reservation
    //Description:
    //User should see a message when user tries to book a car while not logged in
    //Acceptance Criteria:
    //As customer, I should be able to see error message, when I try to book a car while not logged in
    //Message: Please first login
    //Given user is on the login page
    //And tries to book a car
   // And click continue reservation
   // Then user see the warning message: Please first login
    Homework1Page homework1Page=new Homework1Page();
    Faker faker=new Faker();
    @Test
    public void homework1Test(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
         //sending username
        homework1Page.email.sendKeys(ConfigReader.getProperty("app_customer_username"));
        //sending password
        homework1Page.password.sendKeys(ConfigReader.getProperty("app_customer_password"));
        //clicking on login button
        homework1Page.loginButton.click();

        homework1Page.selectCar.sendKeys("Audi Q8");
        homework1Page.pickUpAddress.sendKeys(faker.address().streetAddress());
        homework1Page.dropOffAddress.sendKeys(faker.address().streetAddress());
        homework1Page.pickUpDate.sendKeys("18.09.2076");
        homework1Page.pickUpTime.sendKeys("16.31");
        homework1Page.dropOffDate.sendKeys("18.10.2076");
        homework1Page.dropOffTime.sendKeys("17.33");
        homework1Page.continueButton.click();

        homework1Page.cardNo.sendKeys(faker.business().creditCardNumber());
        homework1Page.cardName.sendKeys(faker.name().fullName());
        homework1Page.dateOfCreditCard.sendKeys(faker.business().creditCardExpiry());
        homework1Page.cvc.sendKeys(faker.number().digits(3));
        homework1Page.checkBox.click();
        homework1Page.completeReservation.click();





    }
}
