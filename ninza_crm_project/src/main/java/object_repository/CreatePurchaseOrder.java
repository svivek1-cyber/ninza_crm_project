package object_repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.FileUtility;
import generic_utility.MyWebDriverUtility;

public class CreatePurchaseOrder {
    public CreatePurchaseOrder(WebDriver driver){
        PageFactory.initElements(driver, CreatePurchaseOrder.this);
    }

    @FindBy(name="subject")
    private WebElement subjectTF;
    public WebElement getSubjectTF(){
        return subjectTF;
    }

    @FindBy(name="dueDate")
    private WebElement dueDateTF;
    public WebElement getDueDateTF(){
        return dueDateTF;
    }

    @FindBy(name="status")
    private WebElement statusTF;
    public WebElement getStatusTF(){
        return statusTF;
    }

    @FindBy(xpath="//label[text()='Contact']/..//button")
    private WebElement addContactBtn;
    public WebElement getAddContactBtn(){
        return addContactBtn;
    }
    
    @FindBy(xpath ="//label[text()='Billing Address']/..//textarea")
    private WebElement billingAddTA;
    public WebElement getBillingAddTA(){
        return billingAddTA;
    }

    @FindBy(xpath ="//label[text()='Shipping Address']/..//textarea")
    private WebElement shippingAddTA;
    public WebElement getShippingAddTA(){
        return shippingAddTA;
    }

    @FindBy(xpath ="//label[text()='Billing PO Box']/..//input")
    private WebElement billingPOBoxTF;
    public WebElement getBillingPOBoxTF(){
        return billingPOBoxTF;
    }

    @FindBy(xpath ="//label[text()='Shipping PO Box']/..//input")
    private WebElement shippingPOBoxTF;
    public WebElement getShippingPOBoxTF(){
        return shippingPOBoxTF;
    }

    @FindBy(xpath ="//label[text()='Billing City']/..//input")
    private WebElement billingCityTF;
    public WebElement getBillingCityTF(){
        return billingCityTF;
    }

    @FindBy(xpath ="//label[text()='City']/..//input")
    private WebElement cityTF;
    public WebElement getCityTF(){
        return cityTF;
    }

    @FindBy(xpath ="//label[text()='Billing State']/..//input")
    private WebElement billingStateTF;
    public WebElement getBillingStateTF(){
        return billingStateTF;
    }

    @FindBy(xpath ="//label[text()='State']/..//input")
    private WebElement stateTF;
    public WebElement getStateTF(){
        return stateTF;
    }

    @FindBy(xpath ="//label[text()='Billing Postal Code']/..//input")
    private WebElement billingPostalCodeTF;
    public WebElement getBillingPostalCodeTF(){
        return billingPostalCodeTF;
    }

    @FindBy(xpath ="//label[text()='Postal Code']/..//input")
    private WebElement postalCodeTF;
    public WebElement getPostalCodeTF(){
        return postalCodeTF;
    }

    @FindBy(xpath ="//label[text()='Billing Country']/..//input")
    private WebElement billingCountryTF;
    public WebElement getBillingCountryTF(){
        return billingCountryTF;
    }

    @FindBy(xpath ="//label[text()='Country']/..//input")
    private WebElement countryTF;
    public WebElement getCountryTF(){
        return countryTF;
    }

    @FindBy(xpath ="//button[text()='Add Product']")
    private WebElement addProductBtn;
    public WebElement getAddProductBtn(){
        return addProductBtn;
    }

    @FindBy(xpath ="//button[text()='Create Purchase Order']")
    private WebElement createPurchaseOrderBtn;
    public WebElement getCreatePurchaseOrderBtn(){
        return createPurchaseOrderBtn;
    }

    public void createPurchaseOrder(WebDriver driver) throws IOException{
        FileUtility fu = new FileUtility();
        MyWebDriverUtility mwdu = new MyWebDriverUtility(driver);

        String subject = fu.getDataFromExcelFile("CreatePurchaseOrder", 1, 0);
        String dueDate = fu.getDataFromExcelFile("CreatePurchaseOrder", 1, 1);
        String status = fu.getDataFromExcelFile("CreatePurchaseOrder", 1, 2);
        String billingAddress = fu.getDataFromExcelFile("CreatePurchaseOrder", 1, 3);
        String billingPOBox = fu.getDataFromExcelFile("CreatePurchaseOrder", 1, 4);
        String billingCity = fu.getDataFromExcelFile("CreatePurchaseOrder", 1, 5);
        String billingState = fu.getDataFromExcelFile("CreatePurchaseOrder", 1, 6);
        String billingPostalCode = fu.getDataFromExcelFile("CreatePurchaseOrder", 1, 7);
        String billingCountry = fu.getDataFromExcelFile("CreatePurchaseOrder", 1, 8);
        String shippingAddress = fu.getDataFromExcelFile("CreatePurchaseOrder", 1, 9);
        String shippingPOBox = fu.getDataFromExcelFile("CreatePurchaseOrder", 1, 10);
        String City = fu.getDataFromExcelFile("CreatePurchaseOrder", 1, 11);
        String State = fu.getDataFromExcelFile("CreatePurchaseOrder", 1, 12);
        String PostalCode = fu.getDataFromExcelFile("CreatePurchaseOrder", 1, 13);
        String Country = fu.getDataFromExcelFile("CreatePurchaseOrder", 1, 14);
        
        getSubjectTF().sendKeys(subject);
        getDueDateTF().sendKeys(dueDate);
        getStatusTF().sendKeys(status);

        String hId = driver.getWindowHandle();

        getAddContactBtn().click();
        mwdu.switchWindowById(hId);
        SelectContact sc = new SelectContact(driver);
        mwdu.waitForElementToBeVisible(sc.getSearchCriteriaDD());
        mwdu.selectFromDDusingVisibleText(sc.getSearchCriteriaDD(), "Organization");
        sc.getSearchInput().sendKeys(fu.getDataFromExcelFile("CreateContact", 1, 0));
        sc.getSelectButton().click();
        driver.switchTo().window(hId);

        getBillingAddTA().sendKeys(billingAddress);
        getBillingPOBoxTF().sendKeys(billingPOBox);
        getBillingCityTF().sendKeys(billingCity);
        getBillingStateTF().sendKeys(billingState);
        getBillingPostalCodeTF().sendKeys(billingPostalCode);
        getBillingCountryTF().sendKeys(billingCountry);
        getShippingAddTA().sendKeys(shippingAddress);
        getShippingPOBoxTF().sendKeys(shippingPOBox);
        getCityTF().sendKeys(City);
        getStateTF().sendKeys(State);
        getPostalCodeTF().sendKeys(PostalCode);
        getCountryTF().sendKeys(Country);

        getAddProductBtn().click();
        mwdu.switchWindowById(hId);
        SelectProduct sp = new SelectProduct(driver);
        mwdu.waitForElementToBeVisible(sp.getSearchCriteriaDD());
        mwdu.selectFromDDusingVisibleText(sp.getSearchCriteriaDD(), "Product Name");
        sp.getSearchInput().sendKeys(fu.getDataFromExcelFile("CreateProduct", 1, 0));
        sp.getSelectButton().click();
        driver.switchTo().window(hId);

        getCreatePurchaseOrderBtn().click();
    }

}
