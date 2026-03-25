package object_repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.FileUtility;
import generic_utility.MyWebDriverUtility;

public class CreateSalesOrder {
    WebDriver driver;
    MyWebDriverUtility mwdu;

    public CreateSalesOrder(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, CreateSalesOrder.this);
    }

    @FindBy(name="subject")
    private WebElement subjectTF;
    public WebElement getSubjectTF(){
        return subjectTF;
    }

    @FindBy(name="validTill")
    private WebElement validTillTF;
    public WebElement getValidTillTF(){
        return validTillTF;
    }

    @FindBy(name="status")
    private WebElement statusTF;
    public WebElement getStatusTF(){
        return statusTF;
    }

    @FindBy(xpath="//label[text()='Opportunity']/..//button")
    private WebElement addOpportunityBtn;
    public WebElement getAddOpportunityBtn(){
        return addOpportunityBtn;
    }

    @FindBy(xpath="//label[text()='Quote']/..//button")
    private WebElement addQuoteBtn;
    public WebElement getAddQuoteBtn(){
        return addQuoteBtn;
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

    @FindBy(xpath ="//button[text()='Create Sales Order']")
    private WebElement createSalesOrderBtn;
    public WebElement getCreateSalesOrderBtn(){
        return createSalesOrderBtn;
    }

    public void createSalesOrder() throws IOException{
        FileUtility fu = new FileUtility();
        mwdu = new MyWebDriverUtility(driver);

        String subject = fu.getDataFromExcelFile("CreateSalesOrder", 1, 0);
        String validTill = fu.getDataFromExcelFile("CreateSalesOrder", 1, 1);
        String status = fu.getDataFromExcelFile("CreateSalesOrder", 1, 2);
        String billingAddress = fu.getDataFromExcelFile("CreateSalesOrder", 1, 3);
        String billingPOBox = fu.getDataFromExcelFile("CreateSalesOrder", 1, 4);
        String billingCity = fu.getDataFromExcelFile("CreateSalesOrder", 1, 5);
        String billingState = fu.getDataFromExcelFile("CreateSalesOrder", 1, 6);
        String billingPostalCode = fu.getDataFromExcelFile("CreateSalesOrder", 1, 7);
        String billingCountry = fu.getDataFromExcelFile("CreateSalesOrder", 1, 8);
        String shippingAddress = fu.getDataFromExcelFile("CreateSalesOrder", 1, 9);
        String shippingPOBox = fu.getDataFromExcelFile("CreateSalesOrder", 1, 10);
        String City = fu.getDataFromExcelFile("CreateSalesOrder", 1, 11);
        String State = fu.getDataFromExcelFile("CreateSalesOrder", 1, 12);
        String PostalCode = fu.getDataFromExcelFile("CreateSalesOrder", 1, 13);
        String Country = fu.getDataFromExcelFile("CreateSalesOrder", 1, 14);
        
        getSubjectTF().sendKeys(subject);
        getValidTillTF().sendKeys(validTill);
        getStatusTF().sendKeys(status);

        String hId = driver.getWindowHandle();

        getAddOpportunityBtn().click();
        mwdu.switchWindowById(hId);
        SelectOpportunity so = new SelectOpportunity(driver);
        mwdu.waitForElementToBeVisible(so.getSearchCriteriaDD());
        mwdu.selectFromDDusingVisibleText(so.getSearchCriteriaDD(), "Opportunity Name");
        so.getSearchInput().sendKeys(fu.getDataFromExcelFile("CreateOpportunity", 1, 0));
        so.getSelectButton().click();
        driver.switchTo().window(hId);

        getAddQuoteBtn().click();
        mwdu.switchWindowById(hId);
        SelectQuote sq = new SelectQuote(driver);
        mwdu.waitForElementToBeVisible(sq.getSearchCriteriaDD());
        mwdu.selectFromDDusingVisibleText(sq.getSearchCriteriaDD(), "Subject");
        sq.getSearchInput().sendKeys(fu.getDataFromExcelFile("CreateQuote", 1, 0));
        sq.getSelectButton().click();
        driver.switchTo().window(hId);

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

        getCreateSalesOrderBtn().click();
    }


}
