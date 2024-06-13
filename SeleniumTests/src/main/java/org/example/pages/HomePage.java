package org.example.pages;

import org.example.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends TestBase {
    @FindBy(xpath = "//a[contains(text(),'Koszulka West Ham United')]")
    WebElement nameTshirt;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public ProductInfoPage gotoProductInfoPage(){
        wait.until(ExpectedConditions.visibilityOf(nameTshirt));
        nameTshirt.click();
        return  new ProductInfoPage();
    }




}