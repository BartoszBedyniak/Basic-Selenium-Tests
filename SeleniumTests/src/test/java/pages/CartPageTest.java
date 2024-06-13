package pages;

import org.example.base.TestBase;
import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.example.pages.ProductInfoPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartPageTest extends TestBase {
    HomePage homePage;
    ProductInfoPage productInfoPage;
    CartPage cartPage;
    @BeforeTest
    public void setUp(){
        inicialization();
        homePage = new HomePage();
        productInfoPage = new ProductInfoPage();
        cartPage = new CartPage();

        productInfoPage = homePage.gotoProductInfoPage();
        productInfoPage.clickAddToCartButton();
        cartPage = productInfoPage.goToCartPage();
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
    @Test(priority = 1)
    public void verifiedTitlePage(){
        Assert.assertEquals(productInfoPage.getTitlePage(),"Koszyk – Selenium Shop Automatyzacja Testów","Błędny tytuł strony");
        takeScreen("test 5");
    }
    @Test(priority = 2)
    public void verifiedFreeShippingRadioButton(){
        Assert.assertTrue(cartPage.checkFreeShippingRadioButton(),"Przycisk nie jest zaznaczony");
    }
}
