package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrders {
    public PurchaseOrders(WebDriver driver) {
        PageFactory.initElements(driver, PurchaseOrders.this);
    }

    @FindBy(xpath="//span[text()='Create Order']")
    private WebElement createPurchaseOrderBtn;
    public WebElement getCreatePurchaseOrderBtn(){
        return createPurchaseOrderBtn;
    }
}
