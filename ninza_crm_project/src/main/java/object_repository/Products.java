package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {
    public Products(WebDriver driver){
        PageFactory.initElements(driver, Products.this);
    }

    @FindBy(xpath="//span[text()='Add Product']")
    private WebElement createProductBtn;
    public WebElement getCreateProductBtn(){
        return createProductBtn;
    }
    
}
