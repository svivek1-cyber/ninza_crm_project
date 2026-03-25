package object_repository;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import generic_utility.FileUtility;

public class CreateContact {
    WebDriver driver;
    public CreateContact(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, CreateContact.this);
    }

    
    @FindBy(name="organizationName")
    private WebElement organizationNameTF;
    public WebElement getOrganizationNameTF(){
        return organizationNameTF;
    }
    
    @FindBy(name="title")
    private WebElement titleTF;
    public WebElement getTitleTF(){
        return titleTF;
    }
    
    @FindBy(name="department")
    private WebElement departmentTF;
    public WebElement getDepartmentTF(){
        return departmentTF;
    }
    
    @FindBy(name="officePhone")
    private WebElement officePhoneTF;
    public WebElement getOfficePhoneTF(){
        return officePhoneTF;
    }
    
    @FindBy(name="contactName")
    private WebElement contactNameTF;
    public WebElement getContactNameTF(){
        return contactNameTF;
    }
    
    @FindBy(name="mobile")
    private WebElement mobileTF;
    public WebElement getMobileTF(){
        return mobileTF;
    }
    
    @FindBy(name="email")
    private WebElement emailTF;
    public WebElement getEmailTF(){
        return emailTF;
    }
    
    @FindBy(xpath="//input[@type='text']/..//button")
    private WebElement addCompaignButton;
    public WebElement getAddCompaignButton(){
        return addCompaignButton;
    }
    
    @FindBy(xpath="//button[@type='submit']")
    private WebElement createContactBtn;
    public WebElement getCreateContactBtn(){
        return createContactBtn;
    }

    public void createContact() throws IOException{
        FileUtility fu = new FileUtility();

        String organizationName = fu.getDataFromExcelFile("CreateContact", 1, 0);
        String title = fu.getDataFromExcelFile("CreateContact", 1, 1);
        String department = fu.getDataFromExcelFile("CreateContact", 1, 2);
        String officePhone = fu.getDataFromExcelFile("CreateContact", 1, 3);
        String contactName = fu.getDataFromExcelFile("CreateContact", 1, 4);
        String mobile = fu.getDataFromExcelFile("CreateContact", 1, 5);
        String email = fu.getDataFromExcelFile("CreateContact", 1, 6);

        
        getOrganizationNameTF().sendKeys(organizationName);
        getTitleTF().sendKeys(title);
        getDepartmentTF().sendKeys(department);
        getOfficePhoneTF().sendKeys(officePhone);
        getContactNameTF().sendKeys(contactName);
        getMobileTF().sendKeys(mobile);
        getEmailTF().sendKeys(email);

        String hId = driver.getWindowHandle();
        getAddCompaignButton().click();
        Set<String> allId = driver.getWindowHandles();
        for(String id:allId){
            if(!id.equals(hId)){
                driver.switchTo().window(id);
                break;
            }
        }

        SelectCampaign sc = new SelectCampaign(driver);
        Select s = new Select(sc.getSearchCriteriaDD());
        s.selectByVisibleText("Campaign Name");

        sc.getSearchInput().sendKeys(fu.getDataFromExcelFile("CreateCampaign", 1, 0));
        sc.getSelectButton().click();
        driver.switchTo().window(hId);

        getCreateContactBtn().click();
    }
    
}
