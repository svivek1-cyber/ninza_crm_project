package object_repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.FileUtility;
import generic_utility.MyWebDriverUtility;

public class CreateProduct {
    WebDriver driver;
    MyWebDriverUtility mwdu;

    public CreateProduct(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, CreateProduct.this);
    }

    @FindBy(name="productName")
    private WebElement productNameTF;
    public WebElement getProductNameTF(){
        return productNameTF;
    }

    @FindBy(name="productCategory")
    private WebElement productCategoryDD;
    public WebElement getProductCategoryDD(){
        return productCategoryDD;
    }

    @FindBy(name="quantity")
    private WebElement quantityTF;
    public WebElement getQuantityTF(){
        return quantityTF;
    }

    @FindBy(name="price")
    private WebElement priceTF;
    public WebElement getPriceTF(){
        return priceTF;
    }

    @FindBy(name="vendorId")
    private WebElement vendorIdDD;
    public WebElement getVendorIdDD(){
        return vendorIdDD;
    }

    @FindBy(xpath="//button[@type='submit']")
    private WebElement addButton;
    public WebElement getAddButton(){
        return addButton;
    }
    
    public void createProduct() throws IOException{
        FileUtility fu = new FileUtility();
        mwdu = new MyWebDriverUtility(driver);

        String productName = fu.getDataFromExcelFile("CreateProduct", 1, 0);
        String quantity = fu.getDataFromExcelFile("CreateProduct", 1, 1);
        String price = fu.getDataFromExcelFile("CreateProduct", 1, 2);

        getProductNameTF().sendKeys(productName);
        mwdu.selectFromDDusingVisibleText(getProductCategoryDD(), "Electronics");
        getQuantityTF().sendKeys(quantity);
        mwdu.selectFromDDusingValue(getVendorIdDD(), "VID_001");
        getPriceTF().clear();
        getPriceTF().sendKeys(price);

        getAddButton().click();
    }

}
