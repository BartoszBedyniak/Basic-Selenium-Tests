package org.example.pages;

import org.example.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductInfoPage extends TestBase {

    public ProductInfoPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@class='product_title entry-title']")
    private WebElement productName;
    @FindBy(xpath ="//*[@class='woocommerce-Price-amount amount']")
    private WebElement productPrice;
    @FindBy(xpath = "//input[@name='quantity']")
    private WebElement productCount;
    @FindBy(xpath = "//button[@name='add-to-cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='woocommerce-message']")
    private WebElement productAddInfo;
    @FindBy(xpath = "//a[@class='button wc-forward']")
    private WebElement checkCartButton;

    public String getProoductName(){
        wait.until(ExpectedConditions.visibilityOf(productName));
        String productNameString = productName.getText();
        return productNameString;
    }
    public String getProductPrice(){
        wait.until(ExpectedConditions.visibilityOf(productName));
        String productPriceString = productPrice.getText();
        return productPriceString;
    }
    public String getProductCount(){
        wait.until(ExpectedConditions.visibilityOf(productCount));
        String productCountString = productCount.getAttribute("value");
        return productCountString;
    }
    public void clickAddToCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }
    public String getProductAddInto(){
        wait.until(ExpectedConditions.visibilityOf(productAddInfo));
        String productInfo=productAddInfo.getText().replace("Zobacz koszyk\n","");
        return productInfo;
    }
    public CartPage goToCartPage(){
        wait.until(ExpectedConditions.visibilityOf(checkCartButton));
        checkCartButton.click();
        return new CartPage();
    }




}
