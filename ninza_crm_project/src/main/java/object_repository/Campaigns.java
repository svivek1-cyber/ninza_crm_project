package object_repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaigns {
    public Campaigns(WebDriver driver){
        PageFactory.initElements(driver, Campaigns.this);
    }

    @FindBy(xpath="//span[text()='Create Campaign']")
    private WebElement createCampaignBtn;
    public WebElement getCreateCampaignBtn(){
        return createCampaignBtn;
    }

    @FindBy(xpath="//input[@type='button' and @value='Delete']")
    private WebElement deleteBtn;
    public WebElement getDeleteBtn(){
        return deleteBtn;
    }

    @FindBy(xpath="//div[@role='alert']")
    private WebElement alert;
    public WebElement getAlert(){
        return alert;
    }
    
    @FindBy(linkText="Contacts")
    private WebElement contactsLink;
    public WebElement getContactsLink(){
        return contactsLink;
    }
    
    @FindBy(linkText="Leads")
    private WebElement leadsLink;
    public WebElement getLeadsLink(){
        return leadsLink;
    }
    
    @FindBy(linkText="Opportunities")
    private WebElement opportunitiesLink;
    public WebElement getOpportunitiesLink(){
        return opportunitiesLink;
    }
    
    @FindBy(linkText="Products")
    private WebElement productsLink;
    public WebElement getProductsLink(){
        return productsLink;
    }
    
    @FindBy(linkText="Quotes")
    private WebElement quotesLink;
    public WebElement getQuotesLink(){
        return quotesLink;
    }
    
    @FindBy(linkText="Purchase Order")
    private WebElement purchaseOrderLink;
    public WebElement getPurchaseOrderLink(){
        return purchaseOrderLink;
    }
    
    @FindBy(linkText="Sales Order")
    private WebElement salesOrderLink;
    public WebElement getSalesOrderLink(){
        return salesOrderLink;
    }
    
    @FindBy(linkText="Invoice")
    private WebElement invoiceLink;
    public WebElement getInvoiceLink(){
        return invoiceLink;
    }
    
    @FindBy(xpath="//div[@class='user-icon']")
    private WebElement userIcon;
    public WebElement getUserIcon(){
        return userIcon;
    }
    
    @FindBy(xpath = "//div[text()='Logout ']")
    private WebElement logoutbtn;
    public WebElement getLogoutbtn(){
        return logoutbtn;
    }

    @FindBy(xpath="//input[@type='text']")
    public WebElement searchTF;
    public WebElement getSearchTF() {
        return searchTF;
    }

    @FindBy(xpath="//select")
    private WebElement searchInDD;
    public WebElement getSearchInDD() {
        return searchInDD;
    }

    @FindBy(xpath="//i[@title='Delete']")
    private List<WebElement> deleteIcons;
    public List<WebElement> getDeleteIcons() {
        return deleteIcons;
    }
}
