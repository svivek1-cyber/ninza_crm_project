package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrders {
    public SalesOrders(WebDriver driver) {
        PageFactory.initElements(driver, SalesOrders.this);
    }

    @FindBy(xpath="//span[text()='Create Order']")
    private WebElement createProductBtn;
    public WebElement getCreateProductBtn(){
        return createProductBtn;
    }
}
