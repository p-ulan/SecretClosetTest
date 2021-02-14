import aquality.appium.mobile.application.AqualityServices;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Steps.TestSteps.*;

@Log4j2
public class ClosetTest {
    private static final String CITY_NAME = "Dubai";

    @BeforeTest
    public void beforeTest() {
        AqualityServices.getApplication();
    }

    @Test
    public void tempTest1() {
        clickOnCityLabel();
        typeCityName(CITY_NAME);
        confirmCityName();
        Assert.assertEquals(CITY_NAME, getCityName());
        selectFirstItem();
        Assert.assertTrue(checkItemName(), "the item has the same name");
        Assert.assertEquals(getFirstItem(), getSecondItem(), "the item data is correct");
        clickOnSeller();
        Assert.assertEquals(getFirstSeller(),getSecondSeller(),"the seller data is correct");
    }

    @AfterTest
    public void afterTest(){
        if (AqualityServices.isApplicationStarted()) {
            AqualityServices.getApplication().quit();
        }
    }
}
