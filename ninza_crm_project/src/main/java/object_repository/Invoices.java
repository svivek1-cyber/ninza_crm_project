package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Invoices {
    public Invoices(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//span[text()='Create Invoice']")
    private WebElement createInvoiceBtn;
    public WebElement getCreateInvoiceBtn(){
        return createInvoiceBtn;
    }
}
