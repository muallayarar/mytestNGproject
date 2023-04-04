package practice05.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class SearchProductPage {

    public SearchProductPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//img[@alt='Website for automation practice']")
    public WebElement homePageVisibility;

    @FindBy(xpath = "//a[@href='/products']")
    public WebElement productsLink ;

    @FindBy(xpath = "//h2[text()='All Products']")
    public WebElement productsPageVisibility;

    @FindBy(id = "search_product")
    public WebElement searchProductButton;

    @FindBy(id = "submit_search")
    public WebElement productSubmitButton;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement textOfSearchedProducts;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
    public WebElement viewProduct;

    @FindBy(xpath = "(//p)[4]")
    public WebElement availability;

    @FindBy(xpath = "(//p)[5]")
    public WebElement condition;

    @FindBy(xpath = "(//p)[6]]")
    public WebElement brand ;

}


