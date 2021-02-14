package Steps;

import Entity.Item;
import Entity.Seller;
import Pages.CityListPage;
import Pages.ItemPage;
import Pages.MainPage;
import Pages.SellerPage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TestSteps {
    private static String firstCityName;
    private static MainPage mainPage = new MainPage();
    private static CityListPage cityListPage = new CityListPage();
    private static ItemPage itemPage = new ItemPage();
    private static SellerPage sellerPage = new SellerPage();

    private static Item firstItem = new Item();
    private static Item secondItem = new Item();

    private static Seller firstSeller = new Seller();
    private static Seller secondSeller = new Seller();

    public static void clickOnCityLabel(){
        firstCityName = mainPage.getActualCityName();
        while (firstCityName.equals("--")) {
            log.debug("application is still loading. City name: "+mainPage.getActualCityName());
            firstCityName = mainPage.getActualCityName();
        }
        mainPage.goToCityListPage();
    }

    public static void typeCityName(String city){
        cityListPage.clickOkIfItPresent();
        cityListPage.setCityName(city);
    }

    public static void confirmCityName(){
        cityListPage.confirmCityName();
    }

    public static String getCityName() {
        while (firstCityName.equals(mainPage.getActualCityName())) {
            log.debug("application page is still loading. City name: " + mainPage.getActualCityName());
        }
        return mainPage.getActualCityName();
    }

    public static void selectFirstItem() {
        firstItem.setName(mainPage.getNameOfItem());
        firstItem.setDiscount(mainPage.getDiscountOfItem());
        firstItem.setOriginalPrise(mainPage.getPriceOfItem());
        firstItem.setActualPrise(mainPage.getActualPriceOfItem());
        mainPage.goToItemPage();
        secondItem.setName(itemPage.getItemName());
        secondItem.setActualPrise(itemPage.getItemPrice());
        secondItem.setDiscount(itemPage.getItemDiscount());
        secondItem.setOriginalPrise(itemPage.getOriginalItemPrise());
    }

    public static boolean checkItemName() {
        return firstItem.getName().equals(itemPage.getItemName());
    }

    public static Item getFirstItem() {
        return firstItem;
    }

    public static Item getSecondItem() {
        return secondItem;
    }

    public static void clickOnSeller(){
        firstSeller.setName(itemPage.getSellerName());
        firstSeller.setCity(itemPage.getSellerCityNameFrom());
        itemPage.goToSellerPage();
        secondSeller.setName(sellerPage.getSellerName());
        secondSeller.setCity(sellerPage.getSellerCityNameFrom());
    }

    public static Seller getFirstSeller() {
        return firstSeller;
    }

    public static Seller getSecondSeller() {
        return secondSeller;
    }





}
