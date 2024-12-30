package pageModel;

import org.openqa.selenium.By; // Selenium'un `By` sınıfı, web elemanlarını bulmak için kullanılır.
import org.openqa.selenium.WebDriver; // WebDriver arayüzü, tarayıcı ile etkileşim kurmayı sağlar.

public class QaJobsModel extends BaseModel { // QaJobsModel, BaseModel sınıfından miras alır.

    // "See all QA jobs" butonunu temsil eden bir locator (bulucu) tanımlanıyor.
    public static By seeAllQaJobs = By.xpath("//a[contains(text(),'See all QA jobs')]");
    // Bu XPath, "See all QA jobs" metnini içeren bir `<a>` (link) elemanını bulur.

    // Constructor (Yapıcı Metot)
    public QaJobsModel(WebDriver webDriver) {
        super(webDriver); // BaseModel'deki constructor'ı çağırarak WebDriver örneğini gönderir.
    }

    // "See all QA jobs" butonuna tıklayan bir metot.
    public void clickSeeAllQaJobs() {
        clickElement(seeAllQaJobs); // BaseModel'de tanımlı `clickElement` metodu kullanılarak butona tıklanır.
    }

}