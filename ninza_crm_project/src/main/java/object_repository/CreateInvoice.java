package object_repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.FileUtility;
import generic_utility.MyWebDriverUtility;

public class CreateInvoice {
    WebDriver driver;
    MyWebDriverUtility mwdu;

    public CreateInvoice(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, CreateInvoice.this);
    }

    @FindBy(name = "subject")
    private WebElement subjectTF;

    public WebElement getSubjectTF() {
        return subjectTF;
    }

    @FindBy(name = "status")
    private WebElement statusTF;
    public WebElement getStatusTF() {
        return statusTF;
    }

    @FindBy(name = "validTill")
    private WebElement validTillTF;
    public WebElement getValidTillTF() {
        return validTillTF;
    }

    @FindBy(xpath = "//label[text()='Contact']/..//button")
    private WebElement addContactBtn;
    public WebElement getAddContactBtn() {
        return addContactBtn;
    }

    @FindBy(xpath = "//label[text()='Sales Order']/..//button")
    private WebElement addSalesOrderBtn;
    public WebElement getAddSalesOrderBtn() {
        return addSalesOrderBtn;
    }

    @FindBy(name = "dueDate")
    private WebElement dueDateTF;
    public WebElement getDueDateTF() {
        return dueDateTF;
    }

    @FindBy(xpath = "//label[text()='Billing Address']/..//textarea")
    private WebElement billingAddTA;
    public WebElement getBillingAddTA() {
        return billingAddTA;
    }

    @FindBy(xpath = "//label[text()='Shipping Address']/..//textarea")
    private WebElement shippingAddTA;
    public WebElement getShippingAddTA() {
        return shippingAddTA;
    }

    @FindBy(xpath = "//label[text()='Billing PO Box']/..//input")
    private WebElement billingPOBoxTF;
    public WebElement getBillingPOBoxTF() {
        return billingPOBoxTF;
    }

    @FindBy(xpath = "//label[text()='Shipping PO Box']/..//input")
    private WebElement shippingPOBoxTF;
    public WebElement getShippingPOBoxTF() {
        return shippingPOBoxTF;
    }

    @FindBy(xpath = "//label[text()='Billing City']/..//input")
    private WebElement billingCityTF;
    public WebElement getBillingCityTF() {
        return billingCityTF;
    }

    @FindBy(xpath = "//label[text()='Shipping City']/..//input")
    private WebElement shippingCityTF;
    public WebElement getShippingCityTF() {
        return shippingCityTF;
    }

    @FindBy(xpath = "//label[text()='Billing State']/..//input")
    private WebElement billingStateTF;
    public WebElement getBillingStateTF() {
        return billingStateTF;
    }

    @FindBy(xpath = "//label[text()='Shipping State']/..//input")
    private WebElement shippingStateTF;
    public WebElement getShippingStateTF() {
        return shippingStateTF;
    }

    @FindBy(xpath = "//label[text()='Billing Postal Code']/..//input")
    private WebElement billingPostalCodeTF;
    public WebElement getBillingPostalCodeTF() {
        return billingPostalCodeTF;
    }

    @FindBy(xpath = "//label[text()='Shipping Postal Code']/..//input")
    private WebElement shippingPostalCodeTF;
    public WebElement getShippingPostalCodeTF() {
        return shippingPostalCodeTF;
    }

    @FindBy(xpath = "//label[text()='Billing Country']/..//input")
    private WebElement billingCountryTF;
    public WebElement getBillingCountryTF() {
        return billingCountryTF;
    }

    @FindBy(xpath = "//label[text()='Shipping Country']/..//input")
    private WebElement shippingCountryTF;
    public WebElement getShippingCountryTF() {
        return shippingCountryTF;
    }

    @FindBy(xpath = "//button[text()='Add Product']")
    private WebElement addProductBtn;
    public WebElement getAddProductBtn() {
        return addProductBtn;
    }

    @FindBy(xpath = "//button[text()='Create Invoice']")
    private WebElement createInvoiceBtn;
    public WebElement getCreateInvoiceBtn() {
        return createInvoiceBtn;
    }

    public void createInvoice() throws IOException {
        FileUtility fu = new FileUtility();
        mwdu = new MyWebDriverUtility(driver);

        String subject = fu.getDataFromExcelFile("CreateInvoice", 1, 0);
        String status = fu.getDataFromExcelFile("CreateInvoice", 1, 1);
        String validTill = fu.getDataFromExcelFile("CreateInvoice", 1, 2);
        String dueDate = fu.getDataFromExcelFile("CreateInvoice", 1, 3);
        String billingAddress = fu.getDataFromExcelFile("CreateInvoice", 1, 4);
        String billingPOBox = fu.getDataFromExcelFile("CreateInvoice", 1, 5);
        String billingCity = fu.getDataFromExcelFile("CreateInvoice", 1, 6);
        String billingState = fu.getDataFromExcelFile("CreateInvoice", 1, 7);
        String billingPostalCode = fu.getDataFromExcelFile("CreateInvoice", 1, 8);
        String billingCountry = fu.getDataFromExcelFile("CreateInvoice", 1, 9);
        String shippingAddress = fu.getDataFromExcelFile("CreateInvoice", 1, 10);
        String shippingPOBox = fu.getDataFromExcelFile("CreateInvoice", 1, 11);
        String shippingCity = fu.getDataFromExcelFile("CreateInvoice", 1, 12);
        String shippingState = fu.getDataFromExcelFile("CreateInvoice", 1, 13);
        String shippingPostalCode = fu.getDataFromExcelFile("CreateInvoice", 1, 14);
        String shippingCountry = fu.getDataFromExcelFile("CreateInvoice", 1, 15);

        getSubjectTF().sendKeys(subject);
        getStatusTF().sendKeys(status);
        getValidTillTF().sendKeys(validTill);
        getDueDateTF().sendKeys(dueDate);

        String hId = driver.getWindowHandle();
        
        getAddContactBtn().click();
        mwdu.switchWindowById(hId);
        SelectContact sc = new SelectContact(driver);
        mwdu.waitForElementToBeVisible(sc.getSearchCriteriaDD());
        mwdu.selectFromDDusingVisibleText(sc.getSearchCriteriaDD(), "Organization");
        sc.getSearchInput().sendKeys(fu.getDataFromExcelFile("CreateContact", 1, 0));
        sc.getSelectButton().click();
        driver.switchTo().window(hId);

        getAddSalesOrderBtn().click();
        mwdu.switchWindowById(hId);
        SelectSalesOrder so = new SelectSalesOrder(driver);
        mwdu.waitForElementToBeVisible(so.getSearchCriteriaDD());
        mwdu.selectFromDDusingVisibleText(so.getSearchCriteriaDD(), "Subject");
        so.getSearchInput().sendKeys(fu.getDataFromExcelFile("CreateSalesOrder", 1, 0));
        so.getSelectButton().click();
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

        getCreateInvoiceBtn().click();
    }
}
