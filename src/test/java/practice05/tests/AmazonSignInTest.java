package practice05.tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice05.pages.AmazonSignInPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class AmazonSignInTest {

    //        Go to the Amazon website
//        Click on sign in button
//        Send e mail by using faker
//        Click on continue
//        Assert "There was a problem"  message
//        Click on "Need help?"
//        Click on "Forgot your Password?"
//        Verify the text "Password assistance"
//        Navigate back
//        Click on "Create your account" button
//        Verify the text "Create account"

    AmazonSignInPage amazonSignInPage=new AmazonSignInPage();
    @Test
    public void amazonSignInTest() throws InterruptedException {
        //        Go to the Amazon website
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        //        Click on sign in button
        amazonSignInPage.signInTab.click();
        //        Send e mail by using faker
        amazonSignInPage.emailBox.sendKeys(Faker.instance().internet().emailAddress());
        //        Click on continue
        amazonSignInPage.continueButton.click();
//        Assert "There was a problem"  message
        String warningMessage =amazonSignInPage.warningMessage.getText();
        Assert.assertEquals(warningMessage,"There was a problem");
        //        Click on "Need help?"
        amazonSignInPage.needHelpLink.click();
        //        Click on "Forgot your Password?"
        amazonSignInPage.forgotPasswordLink.click();
        //        Verify the text "Password assistance"
        boolean displayed= amazonSignInPage.passwordAssistant.isDisplayed();
        Assert.assertTrue(displayed);
//        Navigate back
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().back();

        amazonSignInPage.createAccountButton.click();

        String createAccountText=amazonSignInPage.createAccountText.getText();
        Assert.assertEquals(createAccountText, "Create account");


        Thread.sleep(2000);
        Driver.closeDriver();

    }
}
