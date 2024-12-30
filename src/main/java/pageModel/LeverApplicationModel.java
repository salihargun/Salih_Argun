package pageModel;

import org.openqa.selenium.By; // Web elemanlarını bulmak için kullanılır.
import org.openqa.selenium.WebDriver; // WebDriver tarayıcı ile etkileşimi sağlar.

public class LeverApplicationModel extends BaseModel { // `LeverApplicationModel` sınıfı, `BaseModel` sınıfından türetilmiştir.

    // "Submit your application" başlığı için locator:
    public By leverApplication = By.xpath("//h4[contains(text(),'Submit your application')]");

    // Constructor (Yapıcı Metot):
    public LeverApplicationModel(WebDriver webDriver) {
        super(webDriver); // `BaseModel`'in yapıcı metodunu çağırır ve WebDriver'ı ayarlar.
    }

    /**
     * Lever Application sayfasının açıldığını kontrol eder ve başlık metnini döner.
     * @return Sayfadaki başlık metni (örneğin: "Submit your application").
     */
    public String checkIfLeverApplicationPageOpen() {
        return getText(leverApplication); // "leverApplication" locators'ından alınan metni döner.
    }
}