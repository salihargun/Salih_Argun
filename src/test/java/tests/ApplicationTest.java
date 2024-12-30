package tests;

import org.testng.Assert;
import pageModel.*;
import org.testng.annotations.Test;

public class ApplicationTest extends BaseTest {

    @Test
    public void JabApplicationTest() {
        // Testte kullanılan sayfa modeli nesneleri oluşturuluyor.
        HomeModel homeModel = new HomeModel(webDriver);
        CareersModel careersModel = new CareersModel(webDriver);
        OpenPositionsModel openPositionsModel = new OpenPositionsModel(webDriver);
        LeverApplicationModel leverApplicationModel = new LeverApplicationModel(webDriver);
        PositionDetailsModel positionDetailsModel = new PositionDetailsModel(webDriver);
        QaJobsModel qaJobsModel = new QaJobsModel(webDriver);

        // Siteye gidilir ve anasayfa açılır.
        homeModel.openSiteAddress(DataModel.Data.pageUrl); // `pageUrl` değişkenindeki adrese gider.
        Assert.assertTrue(homeModel.checkIfHomePageOpen(), "Insider sayfasi acilmadi");
        // Insider anasayfasının açıldığını doğrular. Açılmadıysa hata mesajı gösterilir.

        homeModel.clickCompany();
        homeModel.clickCareersMenu();

        // Kariyer sayfasındaki içerikler kontrol edilir.
        careersModel.checkIfCareerPageBlocks(); // Kariyer sayfasında belirli blokların göründüğünü kontrol eder.
        careersModel.clickSeeAllTeams(); // "See All Teams" butonuna tıklanır.
        careersModel.clickQualityAssurace(); // "Quality Assurance" (QA) ekibi sekmesine tıklanır.
        qaJobsModel.clickSeeAllQaJobs(); // QA işleri için "See All QA Jobs" butonuna tıklanır.

        openPositionsModel.selectFilterByLocation(DataModel.Data.positionLocationName); // Lokasyon filtresi seçilir.
        openPositionsModel.selectFilterByDepartment(DataModel.Data.positionDepartmentName); // Departman filtresi seçilir.

        Assert.assertTrue(openPositionsModel.checkIfPositionListItem().size() > 0, "Is listesinde Quality Assurance pozisyonu listelenmedi");

        openPositionsModel.checkIfPositionList(); // Pozisyonların listelendiğini doğrular.
        openPositionsModel.clickApplyNow(); // İlk listedeki pozisyona başvuru yapılır.
        positionDetailsModel.checkIfPositionDetails(); // Pozisyon detayları sayfasının göründüğünü doğrular.
        positionDetailsModel.clickApplyForThisJob(); // "Apply for this Job" butonuna tıklanır.

        // Başvuru sayfasının açıldığı kontrol edilir.
        Assert.assertEquals("SUBMIT YOUR APPLICATION", leverApplicationModel.checkIfLeverApplicationPageOpen(), "Lever Application sayfasi acilmadi");
    }
}