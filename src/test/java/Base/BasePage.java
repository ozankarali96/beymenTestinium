package Base;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.List;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;


public class BasePage extends BaseTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver,60);
    }



    public void goUrl(String url){
        driver.get(url);
    }


    public WebElement findElement(By by){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    public void click(By by){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();

    }
    public void sendKeys(By by,String text){
        findElement(by).sendKeys(text);
    }
    public void clear(By by){
        findElement(by).clear();
    }
    public List<WebElement> listElements(By by) {
        return driver.findElements(by);
    }

    public void writeTxt(By by1,By by2)  throws IOException {
        String  productDetail = findElement(by1).getText();
        String  productPrice = findElement(by2).getText();
        FileWriter w = new FileWriter("C:\\Users\\ekaroza\\OneDrive - Ericsson\\Desktop\\TestiniumGittiGidiyor\\productDetail.txt");
        BufferedWriter out = new BufferedWriter(w);
        out.write(productDetail);
        out.write(productPrice);
        out.flush();
    }
    public void clickEnter(By by){

        driver.findElement(by).sendKeys(Keys.ENTER);
    }


    public String dataReadTest(int productNo) throws Exception {
        File src = new File("C:\\Users\\ekaroza\\OneDrive - Ericsson\\Desktop\\TestiniumGittiGidiyor\\test.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fis);
        XSSFSheet sheet = xsf.getSheetAt(0);
        String data1 = sheet.getRow(productNo).getCell(0).getStringCellValue();
        return data1;
}

    }
