package pageModel;

import org.openqa.selenium.By; // Web elemanlarını bulmak için kullanılır.
import org.openqa.selenium.WebDriver; // Tarayıcı ile etkileşim kurmayı sağlar.
import org.testng.Assert; // TestNG'nin doğrulama (assertion) işlemleri için kullanılır.

public class PositionDetailsModel extends BaseModel { // PositionDetailsModel, BaseModel sınıfından miras alır.

    // Pozisyon detay sayfasındaki önemli elementlerin locators (bulucular) tanımı:
    public By positionDetailsPage = By.className("posting-headline"); // Pozisyon detay sayfasının başlığı.
    public By position = By.cssSelector("div.posting-headline > h2"); // Pozisyonun başlık metni.
    public By btnApplyForThisJob = By.cssSelector("div.postings-btn-wrapper > a"); // "Apply For This Job" butonu.
    public By positionDescription = By.cssSelector("div:nth-child(2) > div> h3"); // Pozisyon açıklaması bölümü.
    public By positionRequirements = By.cssSelector("div:nth-child(3) > div > h3"); // Pozisyon gereksinimleri bölümü.

    // Constructor (Yapıcı Metot):
    public PositionDetailsModel(WebDriver webDriver) {
        super(webDriver); // `BaseModel`'de tanımlı constructor çağrılarak WebDriver örneği atanır.
    }

    // Pozisyon detay sayfasının doğru şekilde açıldığını ve gerekli öğelerin göründüğünü kontrol eder.
    public void checkIfPositionDetails() {
        windowHandle(); // Yeni bir tarayıcı sekmesine geçiş yapılmasını sağlar.

        Assert.assertTrue(displayed(positionDetailsPage), "Pozisyon detay sayfasi acilmadi");
        Assert.assertTrue(displayed(btnApplyForThisJob), "Apply For This Job butonu gorulmedi");
        Assert.assertEquals(DataModel.Data.chosenPosition, getText(position), "Pozisyon bilgisi yanlis");
        Assert.assertTrue(displayed(positionRequirements), "Gereksinimler alani bilgiler gorulmedi");
        Assert.assertTrue(displayed(positionDescription), "Aciklama alani bilgileri gorulmedi");
    }

    // "Apply For This Job" butonuna tıklayan metot.
    public void clickApplyForThisJob() {
        clickElement(btnApplyForThisJob); // BaseModel'deki tıklama işlemini kullanır.
    }
}