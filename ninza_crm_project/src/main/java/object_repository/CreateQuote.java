package object_repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.FileUtility;
import generic_utility.MyWebDriverUtility;

public class CreateQuote {
    public CreateQuote(WebDriver driver){
        PageFactory.initElements(driver, CreateQuote.this);
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

    @FindBy(name="quoteStage")
    private WebElement quoteStageTF;
    public WebElement getQuoteStageTF(){
        return quoteStageTF;
    }

    @FindBy(xpath ="//label[text()='Opportunity']/..//button")
    private WebElement addOpportunityBtn;
    public WebElement getAddOpportunityBtn(){
        return addOpportunityBtn;
    }

    @FindBy(xpath ="//label[text()='Contact']/..//button")
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

    @FindBy(xpath ="//label[text()='Shipping City']/..//input")
    private WebElement shippingCityTF;
    public WebElement getShippingCityTF(){
        return shippingCityTF;
    }

    @FindBy(xpath ="//label[text()='Billing State']/..//input")
    private WebElement billingStateTF;
    public WebElement getBillingStateTF(){
        return billingStateTF;
    }

    @FindBy(xpath ="//label[text()='Shipping State']/..//input")
    private WebElement shippingStateTF;
    public WebElement getShippingStateTF(){
        return shippingStateTF;
    }

    @FindBy(xpath ="//label[text()='Billing Postal Code']/..//input")
    private WebElement billingPostalCodeTF;
    public WebElement getBillingPostalCodeTF(){
        return billingPostalCodeTF;
    }

    @FindBy(xpath ="//label[text()='Shipping Postal Code']/..//input")
    private WebElement shippingPostalCodeTF;
    public WebElement getShippingPostalCodeTF(){
        return shippingPostalCodeTF;
    }

    @FindBy(xpath ="//label[text()='Billing Country']/..//input")
    private WebElement billingCountryTF;
    public WebElement getBillingCountryTF(){
        return billingCountryTF;
    }

    @FindBy(xpath ="//label[text()='Shipping Country']/..//input")
    private WebElement shippingCountryTF;
    public WebElement getShippingCountryTF(){
        return shippingCountryTF;
    }

    @FindBy(xpath ="//button[text()='Add Product']")
    private WebElement addProductBtn;
    public WebElement getAddProductBtn(){
        return addProductBtn;
    }

    @FindBy(xpath ="//button[text()='Create Quote']")
    private WebElement createQuoteBtn;
    public WebElement getCreateQuoteBtn(){
        return createQuoteBtn;
    }

    public void fillQuoteCredentials(WebDriver driver) throws IOException{
        FileUtility fu = new FileUtility();
        MyWebDriverUtility mwdu = new MyWebDriverUtility(driver);

        String subject = fu.getDataFromExcelFile("CreateQuote", 1, 0);
        String validTill = fu.getDataFromExcelFile("CreateQuote", 1, 1);
        String quoteStage = fu.getDataFromExcelFile("CreateQuote", 1, 2);
        String billingAddress = fu.getDataFromExcelFile("CreateQuote", 1, 3);
        String billingPOBox = fu.getDataFromExcelFile("CreateQuote", 1, 4);
        String billingCity = fu.getDataFromExcelFile("CreateQuote", 1, 5);
        String billingState = fu.getDataFromExcelFile("CreateQuote", 1, 6);
        String billingPostalCode = fu.getDataFromExcelFile("CreateQuote", 1, 7);
        String billingCountry = fu.getDataFromExcelFile("CreateQuote", 1, 8);
        String shippingAddress = fu.getDataFromExcelFile("CreateQuote", 1, 9);
        String shippingPOBox = fu.getDataFromExcelFile("CreateQuote", 1, 10);
        String shippingCity = fu.getDataFromExcelFile("CreateQuote", 1, 11);
        String shippingState = fu.getDataFromExcelFile("CreateQuote", 1, 12);
        String shippingPostalCode = fu.getDataFromExcelFile("CreateQuote", 1, 13);
        String shippingCountry = fu.getDataFromExcelFile("CreateQuote", 1, 14);
        
        getSubjectTF().sendKeys(subject);
        getValidTillTF().sendKeys(validTill);
        getQuoteStageTF().sendKeys(quoteStage);

        String hId = driver.getWindowHandle();
        getAddOpportunityBtn().click();
        mwdu.switchWindowById(hId);
        SelectOpportunity so = new SelectOpportunity(driver);
        mwdu.waitForElementToBeVisible(so.getSearchCriteriaDD());
        mwdu.selectFromDDusingVisibleText(so.getSearchCriteriaDD(), "Opportunity Name");
        so.getSearchInput().sendKeys(fu.getDataFromExcelFile("CreateOpportunity", 1, 0));
        so.getSelectButton().click();
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
        getShippingCityTF().sendKeys(shippingCity);
        getShippingStateTF().sendKeys(shippingState);
        getShippingPostalCodeTF().sendKeys(shippingPostalCode);
        getShippingCountryTF().sendKeys(shippingCountry);


        getAddProductBtn().click();
        mwdu.switchWindowById(hId);
        SelectProduct sp = new SelectProduct(driver);
        mwdu.waitForElementToBeVisible(sp.getSearchCriteriaDD());
        mwdu.selectFromDDusingVisibleText(sp.getSearchCriteriaDD(), "Product Name");
        sp.getSearchInput().sendKeys(fu.getDataFromExcelFile("CreateProduct", 1, 0));
        sp.getSelectButton().click();
        driver.switchTo().window(hId);

        getCreateQuoteBtn().click();
    }
}
