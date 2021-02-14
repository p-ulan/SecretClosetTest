package Pages;

import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

import java.util.List;

public class MainPage extends Screen {

    public MainPage() {
        super(By.id("android:id/content"), "Main Page of app");
    }

    private final IButton toolbarCity = getElementFactory().getButton(By.id("com.zdv.secretcloset:id/tvToolbarCity"), "City");
    private final ILabel firstItem = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/rlBanner"), "first item");
    private final ILabel firstItemName = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvBrand"), "first item name");
    private final ILabel firstItemPrice = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvSumm"), "first item price");
    private final ILabel firstItemActualPrise = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvPrice"), "first item actual price");
    private final ILabel firstItemDiscount = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvDiscount"), "first item discount");

    private final List items = getElementFactory().findElements(By.id("com.zdv.secretcloset:id/rlBanner"), ElementType.LABEL);

    public void goToCityListPage() {
        toolbarCity.click();
    }

    public String getActualCityName() {
        toolbarCity.state().waitForDisplayed();
        return toolbarCity.getText();
    }

    //methods for the first item only

    public void goToItemPage() {
        firstItem.click();
    }

    public String getNameOfItem() {
        return firstItemName.getText();
    }

    public String getPriceOfItem() {
        return firstItemPrice.getText();
    }

    public String getActualPriceOfItem() {
        return firstItemActualPrise.getText();
    }

    public String getDiscountOfItem() {
        return firstItemDiscount.getText();
    }

    //methods for the list of items

    public void goToItemPage(int pageNum) {
        ILabel item = (ILabel) items.get(pageNum + 1);
        item.click();
    }

    public int getNumOfItemsOnPage() {
        return items.size();
    }

}
