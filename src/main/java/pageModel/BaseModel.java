package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseModel {

    protected WebDriver webDriver;

    // Constructor: WebDriver'ı alarak BaseModel sınıfının oluşturulmasını sağlar
    protected BaseModel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // Bekleme süresi tanımlanır, sayfa elemanlarının yüklenmesini beklerken kullanılacaktır
    Duration duration = Duration.ofSeconds(1000);

    // WebDriver kullanarak öğe bulur ve görünür olana kadar bekler
    protected WebElement findElement(By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return webDriver.findElement(by);
    }

    // Verilen öğeye tıklar ve öğe tıklanabilir olana kadar bekler
    protected void clickElement(By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, duration);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }

    // Verilen öğeden metni alır
    protected String getText(By by) {
        return findElement(by).getText();
    }

    // Verilen öğenin sayfada görünüp görünmediğini kontrol eder
    protected boolean displayed(By by) {
        return webDriver.findElement(by).isDisplayed();
    }

    // Yeni sekmeye geçiş yapar
    protected void windowHandle() {
        String currentTabHandle = webDriver.getWindowHandle();
        String newTabHandle = webDriver.getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(currentTabHandle))
                .findFirst()
                .get();
        webDriver.switchTo().window(newTabHandle);
    }

    // Verilen locator ile öğeleri bulur ve görünür olana kadar bekler
    protected List<WebElement> findElements(By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return webDriver.findElements(by);
    }

    // Verilen süre kadar bekleme yapar
    protected void sleep(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // Verilen öğeye mouse ile gider
    protected void moveToElement(By by) {
        Actions actionProvider = new Actions(webDriver);
        actionProvider.moveToElement(findElement(by)).build().perform();
    }

    // Locator parametrelerini ayarlamak için kullanılır
    protected By setLocatorParameters(By by, String name) {
        String test = by.toString().replace("By.xpath: ", "");
        test = test.replace("{1}", name);
        return new By.ByXPath(test);
    }

    // Sayfada verilen öğeye kaydırma yapar
    protected void scrollToElement(By by) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", findElement(by));
    }

    // Verilen öğeye metin gönderir
    protected void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    // WebElement öğesine mouse ile gider
    protected void moveToElements(WebElement byElement) {
        new Actions(webDriver).moveToElement(byElement).perform();
    }

    // Verilen WebElement öğesine kaydırma yapar
    protected void scrollToElements(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Verilen WebElement öğesine tıklar
    protected void clickElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, duration);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    // Verilen öğe için belirli bir attribute'un değerini alır
    protected String getAttribute(By by, String value) {
        return findElement(by).getAttribute(value);
    }

    // Sayfada belirli bir mesafe kadar kaydırma yapar
    protected void scrollToElement(String scroll) {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0," + scroll + ")");
    }
}