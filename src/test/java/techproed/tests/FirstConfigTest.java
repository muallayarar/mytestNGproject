package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class FirstConfigTest {

    @Test
    public void firstConfigTest(){

        //Driver.getDriver().get("https://www.techproeducation.com");
        //ConfigReader.getProperty("url_techproed") RETURNS https://www.techproeducation.com
        Driver.getDriver().get(ConfigReader.getProperty("url_techproed"));
        Driver.closeDriver();
    }
}
