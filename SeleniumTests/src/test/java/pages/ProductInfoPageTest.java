package pages;

import org.example.base.TestBase;
import org.example.pages.HomePage;
import org.example.pages.ProductInfoPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductInfoPageTest extends TestBase {
    HomePage homePage;
    ProductInfoPage productInfoPage;

    public ProductInfoPageTest(){
        super();
    }
   @BeforeTest
    public void setUp(){
        inicialization();
        homePage = new HomePage();
        productInfoPage = new ProductInfoPage();
        productInfoPage = homePage.gotoProductInfoPage();
   }
   @AfterTest
    public void closeBrowser(){
        driver.quit();
   }
   @Test(priority = 1)
    public void verifiedCurrentURL(){
       Assert.assertEquals(productInfoPage.getTitlePage(),"Koszulka West Ham United – Selenium Shop Automatyzacja Testów"," Błędna nazwa tytułu strony");
       takeScreen("test 1");
   }
   @Test(priority = 2)
    public void  verifiedProductName(){
        Assert.assertEquals(productInfoPage.getProoductName(),"KOSZULKA WEST HAM UNITED","Błędna nazwa produktu");
        takeScreen("test 2");
   }
   @Test(priority = 3)
    public void verifiedProductPrice(){
        Assert.assertEquals(productInfoPage.getProductPrice(),"90,00 ZŁ","Błędna cena produktu");
        takeScreen("test 3");
   }
   @Test(priority = 4)
    public void verifiedProductCount(){
        Assert.assertEquals(productInfoPage.getProductCount(),"1","Błędna liczba produktu");
        takeScreen("test 4");
   }
   @Test(priority = 5)
   public void verifiedProductAddInfo(){
        productInfoPage.clickAddToCartButton();
        Assert.assertEquals(productInfoPage.getProductAddInto(),"“Koszulka West Ham United” został dodany do koszyka.","Błedne informacje o dodanym produkcie");
        takeScreen("test 5");
   }


}
