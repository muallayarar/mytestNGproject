package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtil;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day16_ExcelLogİn {
    ExcelUtil excelUtil;
    HomePage homePage;
    LoginPage loginPage;
    List<Map<String,String>> testData; //we will store excel data in this java object as a list

    public void login(){
        //going to url
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //initializing the pages
        homePage=new HomePage();
        loginPage=new LoginPage();


        //GOING TO THE LOGIN PAGE FIRST TIME
        try{
            //if there is any exception, then keep going
            //will be used AFTER the 1st login since USERID is avaliable AFTER 1ST LOGİN
            homePage.homePageLogInButton.click();
        }catch (Exception e){
        }

        //GOING TO THE LOGIN PAGE AFTER FIRST TIME
            try{
                //if there is any exception, then keep going
                //will be used only at the 1st login since homeLoginButton is avaliable
                //logging out
            homePage.userID.click();
            homePage.logoutLink.click();
            homePage.OK.click();

        }catch (Exception e){
        }
    }

    @Test
    public void customerLogin() throws IOException {
        //path
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
        //customer sheet name
        String customerSheetName ="customer_info";
        //use excel util
        excelUtil=new ExcelUtil(path, customerSheetName);
        //getting the data from the excel using excel util method
        testData=excelUtil.getDataList();
        System.out.println(testData);

        for (Map<String ,String> eachData: testData){
            login();
//            Not that we are on login page, we can send username, password, and click on login button
            ReusableMethods.waitFor(1);
            loginPage.username.sendKeys(eachData.get("username"));
            ReusableMethods.waitFor(1);
            loginPage.password.sendKeys(eachData.get("password").substring(0,5));
            ReusableMethods.waitFor(1);
            loginPage.loginButton.click();
            ReusableMethods.waitFor(1);
//            Asserting making sure login is successful
            ReusableMethods.verifyElementDisplayed(homePage.userID);
            ReusableMethods.getScreenshot(eachData.get("username"));
        }

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

//login 4 times
//    customer@bluerentalcars.com   12345
//    customer1@bluerentalcars.com  12346
//    customer2@bluerentalcars.com  12347
//    customer3@bluerentalcars.com  12348
/*
SUDO CODE
1st login:customer@bluerentalcars.com   12345
try{//using try catch cause 2nd time login button will not be there
click homepage login  ->>> 2nd time no such element exception,
if you don't use try catch test case fails and stops
}catch(Exception e){
}
---------------------------------
2nd, 3rd, 4th login
try{
click on user id ->>> 1st login, these elements will not be there, throws no such element exception, so used try catch
click on log out
click on OK
click homepage login
}catch(Exception e){
}
-----------------------------------
//for all steps
for{
send username -> get excel data
send password -> get excel data
click login button
do assertion
take screenshot
}
-------
 */



}
