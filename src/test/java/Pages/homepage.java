package Pages;

import Base.BasePage;
import Base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import static Constants.Constants.*;

public class homepage extends BasePage {
    private static Logger logger = (Logger) LogManager.getLogger(homepage.class);

    public homepage(WebDriver driver) {
        super(driver);
    }


    public homepage goBeymen() {
        goUrl(URL_BEYMEN);
        return this;
    }

    public homepage closePopUp()  {

        click(CLOSE_POPUP);
        logger.info("Pop-up kapatıldı");
        click(CLOSE_POPUP2);
        logger.info("Gender seçildi");
        String title = BaseTest.driver.getTitle();
        Assert.assertEquals(HOMEPAGE_TITLE, title);
        logger.info("Anasayfa başlığı kontrol edildi");
        return this;
    }

    public homepage search() throws Exception {

        sendKeys(BTN_SEARCH_BOX, dataReadTest(0));
        Thread.sleep(1000);
        clear(BTN_SEARCH_BOX);
        sendKeys(BTN_SEARCH_BOX, dataReadTest(1));
        Thread.sleep(1000);
        clickEnter(BTN_SEARCH_BOX);
        return this;
    }

    public homepage randomProductSelect() {
        List<WebElement> links = listElements(BTN_PRODUCT_LIST);
        int number = new Random().nextInt(links.size());
        links.get(number).click();
        logger.info("Rastgele ürün seçildi");
        return this;
    }

    public homepage addToBasket() {
        click(BTN_PRODUCT_SIZE);
        logger.info("Ürün bedeni seçildi");
        click(BTN_ADD_BASKET);
        logger.info("Sepete ürün eklendi");
        return this;

    }

    public homepage assertion() throws  IOException {
        String productPrice = findElement(TXT_PRICE).getText();
        System.out.println(productPrice);
        click(BTN_GO_BASKET);
        String productPriceBasket = findElement(TXT_BASKET_PRICE).getText();
        System.out.println(productPriceBasket);
        Assert.assertEquals(productPrice, productPriceBasket);
        logger.info("Sepetteki ürün ile ürün detay sayfasındaki ürünün doğruluğu karşılaştırıldı");
        click(AMOUNT_LIST_BOX);

        click(AMOUNT_LIST_BOX2);

        String pageDoublePrice = findElement(DOUBLE_PRICE).getText().replace("(", "");
        System.out.println(pageDoublePrice);
        String doublePrice = findElement(TXT_BASKET_PRICE).getText().replace("(", "");
        System.out.println(doublePrice);
        Assert.assertEquals(pageDoublePrice, doublePrice);
        logger.info("Ürün sayısının iki olduğu kontrol edildi.");
        String productPriceTxt = findElement(TXT_PRODUCT_NAME).getText();
        System.out.println(productPriceTxt);
        String productNameTxt = findElement(TXT_PRODUCT_PRICE).getText();
        System.out.println(productNameTxt);
        writeTxt(TXT_PRODUCT_NAME, TXT_PRODUCT_PRICE);
        logger.info("Ürün bilgileri txt dosyasına eklendi.");
        return this;
    }

    public homepage deleteProduct() {
        click(DELETE_PRODUCT);
        String msg = findElement(TXT_EMPTY_BASKET).getText();
        System.out.println(msg);
        String msg2 = "FAVORILERINIZDE ÜRÜN BULUNMAMAKTADIR";
        Assert.assertEquals(msg, msg2);
        logger.info("Ürün silindi ve silinmiş olduğu kontrol edildi.");

        return this;
    }


}