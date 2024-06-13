package org.example.pages;

import org.example.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderListPage extends TestBase {
    public OrderListPage() {
        PageFactory.initElements(driver, this);
    }
    public String correctTitleOrderListPage ="Zamówienie – Selenium Shop Automatyzacja Testów";

    @FindBy(xpath = "//*[@id='order_review']/table/tbody/tr/td[1]")
    WebElement productName;
    @FindBy(xpath = "//*[@id='order_review']/table/tbody/tr/td[2]/span")
    WebElement productPrice;
    @FindBy(id = "shipping_method_0_free_shipping2")
    WebElement freeShippingRadioButton;
    @FindBy(xpath="//*[@id='order_review']/table/tfoot/tr[3]/td/strong/span")
    WebElement priceAmount;

    public String getProductName(){
        wait.until(ExpectedConditions.visibilityOf(productName));
        String text = productName.getText().replace("  × 1","");
     return text;
    }
    public String getProductPrice(){
        wait.until(ExpectedConditions.visibilityOf(productPrice));
        String text = productPrice.getText();
        return text;
    }
    public String getPriceAmount(){
        wait.until(ExpectedConditions.visibilityOf(priceAmount));
        String text = priceAmount.getText();
        return text;
    }
    public boolean isSelectedFreeShippingRadioButton(){
        wait.until(ExpectedConditions.visibilityOf(freeShippingRadioButton));
        if(freeShippingRadioButton.isSelected()){
            return true;
        }else{
            return false;
        }
    }



}
