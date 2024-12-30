package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CareersModel extends BaseModel {

    // Sayfa öğelerinin locator'ları (Bulunacak elemanlar)
    public By careersPageHead = By.id("page-head");
    public static By ourStoryBlocks = By.xpath("//h2[contains(text(),'Our story')]");
    public static By teamsBlocks = By.xpath("//a[contains(text(),'See all teams')]");
    public static By locationBlocks = By.xpath("//h3[contains(text(),'Our Locations')]");
    public static By lifeAtInsiderBlocks = By.xpath("//h2[contains(text(),'Life at Insider')]");
    public By btnFindYourDreamJob = By.xpath("//*[@id='page-head']/div/div/div[1]/div/div/a");
    public static By careerFind = By.xpath("//*[@id=\"career-find-our-calling\"]/div/div/div[1]/h3");
    public static By qualityAssurace = By.xpath("//h3[contains(text(),'Quality Assurance')]");
    public static By businessIntelligence = By.xpath("//h3[contains(text(),'Business Intelligence')]");

    // Constructor, BaseModel sınıfından WebDriver nesnesini alır
    public CareersModel(WebDriver webDriver) {
        super(webDriver);
    }

    // "See All Teams" butonuna tıklama fonksiyonu
    public void clickSeeAllTeams() {
        scrollToElement(careerFind); // İlgili öğeye kaydırma yap
        sleep(2000); // Sayfanın yüklenmesini bekler
        clickElement(teamsBlocks); // "See all teams" butonuna tıklar
    }

    // "Quality Assurance" öğesine tıklama fonksiyonu
    public void clickQualityAssurace() {
        sleep(1000); // Sayfanın yüklenmesini bekler
        scrollToElement(businessIntelligence); // "Business Intelligence" öğesine kaydırma yap
        sleep(2000); // Sayfanın yüklenmesini bekler
        clickElement(qualityAssurace); // "Quality Assurance" öğesine tıklar
    }

    // Kariyer sayfasındaki tüm blokların görünür olup olmadığını kontrol etme fonksiyonu
    public void checkIfCareerPageBlocks() {
        scrollToElement(ourStoryBlocks); // "Our Story" bloğuna kaydırma yap
        sleep(2000); // Sayfanın yüklenmesini bekler
        // "Our Story" bloğunun görünür olup olmadığını kontrol eder
        Assert.assertTrue(displayed(ourStoryBlocks), "Our Story Block gorulmedi");

        scrollToElement(teamsBlocks); // "Teams" bloğuna kaydırma yap
        sleep(2000); // Sayfanın yüklenmesini bekler
        // "Teams" bloğunun görünür olup olmadığını kontrol eder
        Assert.assertTrue(displayed(teamsBlocks), "Teams Block gorulmedi");

        scrollToElement(locationBlocks); // "Location" bloğuna kaydırma yap
        sleep(2000); // Sayfanın yüklenmesini bekler
        // "Location" bloğunun görünür olup olmadığını kontrol eder
        Assert.assertTrue(displayed(locationBlocks), "Location Block gorulmedi");

        scrollToElement(lifeAtInsiderBlocks); // "Life at Insider" bloğuna kaydırma yap
        sleep(2000); // Sayfanın yüklenmesini bekler
        // "Life at Insider" bloğunun görünür olup olmadığını kontrol eder
        Assert.assertTrue(displayed(lifeAtInsiderBlocks), "Life At Insider gorulmedi");
    }
}