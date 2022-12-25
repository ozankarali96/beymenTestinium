package Constants;

import org.openqa.selenium.By;

public class Constants {
    public static final String URL_BEYMEN = "https://www.beymen.com/";
    public static final String HOMEPAGE_TITLE = "Beymen.com – Türkiye’nin Tek Dijital Lüks Platformu";
    public static final By CLOSE_POPUP = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    public static final By CLOSE_POPUP2 = By.id("genderManButton");

    public static final By BTN_SEARCH_BOX = By.xpath("//input[@class='default-input o-header__search--input']");;

    public static final By BTN_PRODUCT_LIST = By.xpath("//div[@class='m-productImageList']");

    public static final By BTN_ADD_BASKET = By.id("addBasket");

    public static final By BTN_PRODUCT_SIZE = By.xpath("//span[@class='m-variation__item']");

    public static final By TXT_PRICE = By.id("priceNew");

    public static final By BTN_GO_BASKET = By.xpath("//button[@class='m-notification__button btn']");

    public static final By TXT_BASKET_PRICE = By.xpath("//span[@class='m-productPrice__salePrice']");

    public static final By AMOUNT_LIST_BOX = By.xpath("//select[@class='a-selectControl -small']");
    public static final By AMOUNT_LIST_BOX2 = By.xpath("//option [@value='2']");

    public static final By DOUBLE_PRICE = By.xpath("//span[@class='m-productPrice__salePrice']");

    public static final By DELETE_PRODUCT = By.id("removeCartItemBtn0-key-0");
    public static final By TXT_EMPTY_BASKET = By.xpath("(//strong[@class='m-empty__messageTitle'])[1]");

    public static final By TXT_PRODUCT_NAME = By.xpath("//span[@class='m-basket__productInfoName']");
    public static final By TXT_PRODUCT_PRICE = By.xpath("//span[@class='m-productPrice__salePrice']");







}
