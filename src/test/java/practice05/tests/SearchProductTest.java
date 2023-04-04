package practice05.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import practice05.pages.SearchProductPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class SearchProductTest {
    //1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Products' button
//5. Verify user is navigated to ALL PRODUCTS page successfully
//6. Enter product name in search input and click search button
//7. Verify 'SEARCHED PRODUCTS' is visible
//8. Verify all the product features related to search are visible

    SearchProductPage searchProductPage=new SearchProductPage();

    @Test
    public void searchProductTest() throws InterruptedException {
       //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExercise_url"));
        //3. Verify that home page is visible successfully
        String homePageURL= Driver.getDriver().getCurrentUrl();
        System.out.println(homePageURL);
        Assert.assertEquals(homePageURL,"https://automationexercise.com/");
        //4. Click on 'Products' button
        searchProductPage.productsLink.click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        boolean isAllProductsDisplayed=searchProductPage.productsPageVisibility.isDisplayed();
        Assert.assertTrue(isAllProductsDisplayed);
        //6. Enter product name in search input and click search button
        searchProductPage.searchProductButton.sendKeys("Blue Top");
        searchProductPage.productSubmitButton.click();
        //7. Verify 'SEARCHED PRODUCTS' is visible
        searchProductPage.textOfSearchedProducts.isDisplayed();
        //8. Verify all the product features related to search are visible

        Thread.sleep(2000);
        searchProductPage.viewProduct.click();

        Assert.assertTrue(searchProductPage.availability.getText().contains("In Stock"));
        Assert.assertTrue(searchProductPage.condition.getText().contains("New"));
        Assert.assertTrue(searchProductPage.brand.getText().contains("Polo"));


      Driver.closeDriver();

    }
}
