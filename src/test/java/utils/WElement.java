package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WElement {

    private WebDriver driver;
    private WebDriverWait wait;
    private By locator;
    private WebElement element;


    private WElement(){
        this.driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private WElement(By locator){
        this(); //bunu yapmasaydık driver çalışmayacaktı.bu class'ın methodu. yani parametresi olmayan hayali constructor'un this'i
        this.locator = locator;
        this.element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        //class'daki locatoru WebElement'ın içine attık. elemente çevirmiş olduk.
    }
    public static WElement $(By locator){
        return new WElement(locator);
    }
    public WElement click(){
        element.click();
        return this;
    }

    public WElement sendKy(String str){
        element.sendKeys(str);
        return this;  //this ne anlama geliyor WElement anlamına geliyor.
    }

    public void openUrl(String url){
        driver.get(url);
    }
    public static void open(String url){
        new WElement().openUrl(url);
        //WElement oluşturduğumda parametresi olmayan boş constructor çalışacak.sonra openUrl() methodu çalışacak
        //static yapıyorum çünkü private olan methodumu static ile diğer class lardan çağırabileyim.
    }
    public WElement scrollIntoView() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }
    public WElement shouldBe(Conditions conditions){
        switch (conditions){
            case VİSİBLE:
            case EXİST:
            case APPEAR:
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            case CLİCKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
        }
        return this;
    }
}
