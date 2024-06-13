package org.example.pages;

import org.example.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends TestBase{

    public CartPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "shipping_method_0_free_shipping2")
    WebElement freeShippingRadioButton;
    @FindBy(xpath = "//*[@class='checkout-button button alt wc-forward']")
    WebElement goOrderListButton;

    public boolean checkFreeShippingRadioButton() {
        wait.until(ExpectedConditions.visibilityOf(freeShippingRadioButton));
        if (freeShippingRadioButton.isSelected()) {
            return true;
        } else {
            return false;
        }
    }
    public OrderListPage goToOrderListPage(){
        wait.until(ExpectedConditions.visibilityOf(goOrderListButton));
        goOrderListButton.click();
        return new OrderListPage();
    }
}