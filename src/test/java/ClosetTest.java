import Entity.Item;
import Entity.Seller;
import Pages.CityListPage;
import Pages.ItemPage;
import Pages.MainPage;
import Pages.SellerPage;
import Steps.TestSteps;
import aquality.appium.mobile.application.AqualityServices;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static Steps.TestSteps.*;

@Log4j2
public class ClosetTest {
    private static final String CITY_NAME = "Dubai";

    @BeforeTest
    public void beforeTest() {
        AqualityServices.getApplication();
    }

    @Test
    public void tempTest1(){
        clickOnCityLabel();
        typeCityName(CITY_NAME);
        confirmCityName();
        Assert.assertEquals(CITY_NAME,getCityName());
        selectFirstItem();
        Assert.assertTrue(checkItemName(),"the item has the same name");
        Assert.assertEquals(getFirstItem(),getSecondItem(),"the item data is correct");
        clickOnSeller();
        Assert.assertEquals(getFirstSeller(),getSecondSeller(),"the seller data is correct");
    }

    @AfterTest
    public void afterTest(){
        if (AqualityServices.isApplicationStarted()) {
            AqualityServices.getApplication().quit();
        };

    }


    @Ignore
    @Test
    public void tempTest2() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "HTC U11");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9");

        capabilities.setCapability(MobileCapabilityType.APP, "C:\\1\\YandexDisk\\A1qa\\SecretCloset1.com.apk");
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }

        driver.context((String) contextNames.toArray()[contextNames.toArray().length - 1]);

        //driver.wait();

        //wait for display

        driver.findElementById("com.zdv.secretcloset:id/tvToolbarCity").click();

        try {
            driver.findElementById("android:id/button1").click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        driver.findElementById("com.zdv.secretcloset:id/etSearchTest").setValue("Dubai"); // /*Los Angeles*/ com.zdv.secretcloset:id/tvCityItemName

        driver.findElementById("com.zdv.secretcloset:id/tvCityItemName").click(); //city name confirmed

        driver.findElementById("com.zdv.secretcloset:id/tvToolbarCity").getText().equals("Dubai");

        driver.findElementById("com.zdv.secretcloset:id/rlBanner").findElementById("com.zdv.secretcloset:id/tvBrand").getText();
        driver.findElementById("com.zdv.secretcloset:id/rlBanner").findElementById("com.zdv.secretcloset:id/tvBrand").getText();
        /*
//first data
        com.zdv.secretcloset:id/tvBrand

        com.zdv.secretcloset:id/tvSumm
        com.zdv.secretcloset:id/tvDiscount
        com.zdv.secretcloset:id/tvPrice
//in item data
        com.zdv.secretcloset:id/tvItemBrand //name of item

        com.zdv.secretcloset:id/tvItemOriginalPrice
        com.zdv.secretcloset:id/tvItemDiscount
        com.zdv.secretcloset:id/tvItemPrice

                //seller before
        com.zdv.secretcloset:id/tvItemSellerName
        com.zdv.secretcloset:id/tvItemSellerCity
                //seller data
        android.widget.TextView //class
        com.zdv.secretcloset:id/tvItemSellerCity

                //add
        com.zdv.secretcloset:id/tvAdditionalPrice
        com.zdv.secretcloset:id/tvAdditionalOriginal
        com.zdv.secretcloset:id/tvAdditionalDiscount

*/





    }
}
