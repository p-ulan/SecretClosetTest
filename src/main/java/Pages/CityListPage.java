package Pages;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class CityListPage extends Screen {

    public CityListPage() {
        super(By.id("android:id/content"), "City list page");
    }

    private final IButton okButtonOnAlert = getElementFactory().getButton(By.id("android:id/button1"), "Ok");
    private final ITextBox cityNameInput = getElementFactory().getTextBox(By.id("com.zdv.secretcloset:id/etSearchTest"), "city name input field");
    private final IButton confirmCityNameBtn = getElementFactory().getButton(By.id("com.zdv.secretcloset:id/tvCityItemName"), "city name");

    public void clickOkIfItPresent() {
        try {
            okButtonOnAlert.click();
        } catch (Exception e) {
            log.info("The alert window doesn't exist");
            e.printStackTrace();
        }
    }

    public void setCityName(String s) {
        cityNameInput.clearAndType(s);
    }

    public void confirmCityName() {
        confirmCityNameBtn.click();
    }

}
