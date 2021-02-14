package Pages;

import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class ItemPage extends Screen {

    public ItemPage() {
        super(By.id("android:id/content"), "Item page");
    }

    private final ILabel itemName = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemBrand"), "Item name");
    private final ILabel originalItemPrise = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemOriginalPrice"), "Original item prise");
    private final ILabel itemDiscount = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemDiscount"), "Item discount");
    private final ILabel itemPrice = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemPrice"), "Item price");

    private final ILabel sellerName = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerName"), "Seller name");
    private final ILabel sellerCityFrom = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerCity"), "Seller city from");

    public String getItemName() {
        return itemName.getText();
    }

    public String getOriginalItemPrise() {
        return originalItemPrise.getText();
    }

    public String getItemDiscount() {
        return itemDiscount.getText();
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    public String getSellerName() {
        return sellerName.getText();
    }

    public String getSellerCityNameFrom() {
        return sellerCityFrom.getText();
    }

    public void goToSellerPage() {
        sellerName.click();
    }

}
