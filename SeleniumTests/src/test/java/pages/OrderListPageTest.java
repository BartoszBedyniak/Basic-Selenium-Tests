package pages;

import org.example.base.TestBase;
import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.example.pages.OrderListPage;
import org.example.pages.ProductInfoPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrderListPageTest extends TestBase {
    HomePage homePage;
    OrderListPage orderListPage;
    ProductInfoPage productInfoPage;
    CartPage cartPage;

    @BeforeTest
    public void setUp(){
        inicialization();
        homePage = new HomePage();
        productInfoPage = new ProductInfoPage();
        orderListPage = new OrderListPage();
        cartPage = new CartPage();


        productInfoPage = homePage.gotoProductInfoPage();
        productInfoPage.clickAddToCartButton();
        cartPage = productInfoPage.goToCartPage();
        orderListPage = cartPage.goToOrderListPage();
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
    @Test(priority = 1)
    public void verifiedTitlePage(){
        Assert.assertEquals(orderListPage.getTitlePage(),orderListPage.correctTitleOrderListPage);
    }
    @Test(priority = 2)
    public void verifiedProductName(){
        Assert.assertEquals(orderListPage.getProductName(),"Koszulka West Ham United","Błędna nazwa koszulki");
    }
    @Test(priority = 3)
    public void verifiedProductPrice(){
        Assert.assertEquals(orderListPage.getProductPrice(),"90,00 zł","Błedna cena");
    }
    @Test(priority = 4)
    public void checkFreeShippingButton(){
        Assert.assertTrue(orderListPage.isSelectedFreeShippingRadioButton(),"Jest nie zaznaczony");
    }
    @Test(priority = 5)
    public  void verifiedProductSumPrice(){
        Assert.assertEquals(orderListPage.getPriceAmount(),"90,00 zł","Błędna cena");
    }
}
