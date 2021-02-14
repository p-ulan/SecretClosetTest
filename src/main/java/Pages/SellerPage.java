package Pages;

import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class SellerPage extends Screen {

    public SellerPage() {
        super(By.id("android:id/content"), "Seller page");
    }

    private final ILabel sellerName = getElementFactory().getLabel(By.className("android.widget.TextView"), "Seller name");
    private final ILabel sellerCityFrom = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerCity"), "Seller city from");

    public String getSellerName() {
        return sellerName.getText();
    }

    public String getSellerCityNameFrom() {
        return sellerCityFrom.getText();
    }
}
