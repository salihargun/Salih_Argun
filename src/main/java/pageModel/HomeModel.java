package pageModel;

import org.openqa.selenium.By; // Web elemanlarını bulmak için kullanılır.
import org.openqa.selenium.WebDriver; // WebDriver, tarayıcı ile etkileşimde bulunmak için kullanılır.

public class HomeModel extends BaseModel { // HomeModel, BaseModel'den türetilmiştir ve ana sayfa işlemleri için kullanılır.

    // Ana sayfadaki öğelere karşılık gelen locator'lar:
    public static By mainHead = By.id("navigation"); // Ana sayfa başlık öğesi (id ile).
    public static By careersMenu = By.xpath("//a[contains(text(),'Careers')]"); // "Careers" menü öğesi (xpath ile).
    public static By btnCompany = By.xpath("//*[@id='navbarNavDropdown']/ul[1]/li[6]"); // Şirket menüsüne ait buton (xpath ile).
    public static By btnAccept = By.id("wt-cli-accept-btn"); // Çerezleri kabul etme butonu (id ile).

    // Yapıcı (Constructor) metot: WebDriver nesnesini alır ve BaseModel'deki yapılandırmayı başlatır.
    public HomeModel(WebDriver webDriver) {
        super(webDriver); // WebDriver'ı BaseModel'e ileterek WebDriver'ı başlatır.
    }

    /**
     * Belirtilen URL'yi açmak için kullanılan metot.
     * @param pageUrl Açılacak sayfanın URL'si.
     */
    public void openSiteAddress(String pageUrl){
        webDriver.get(pageUrl); // Tarayıcıda belirtilen URL'yi açar.
    }

    /**
     * Ana sayfanın yüklendiğini doğrulamak için kullanılan metot.
     * Ana sayfa başlığı öğesinin görünürlüğünü kontrol eder.
     * @return Ana sayfanın yüklendiğine dair true/false.
     */
    public boolean checkIfHomePageOpen(){
        return displayed(mainHead); // Ana sayfa başlığının görünüp görünmediğini kontrol eder.
    }

    /**
     * "Company" butonuna tıklama işlemini gerçekleştirir.
     * Çerez kabul butonuna tıklamadan önce işlemi başlatır.
     */
    public void clickCompany(){
        clickElement(btnAccept); // Çerez kabul butonuna tıklar.
        sleep(1000); // 1 saniye bekler.
        clickElement(btnCompany); // "Company" butonuna tıklar.
    }

    /**
     * "Careers" menüsüne tıklama işlemini gerçekleştirir.
     */
    public void clickCareersMenu(){
        clickElement(careersMenu); // "Careers" menüsüne tıklar.
    }
}