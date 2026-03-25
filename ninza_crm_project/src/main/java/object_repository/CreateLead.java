package object_repository;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import generic_utility.FileUtility;

public class CreateLead {
    WebDriver driver;

    public CreateLead(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, CreateLead.this);
    }

    @FindBy(name="name")
    private WebElement leadNameTF;
    public WebElement getLeadNameTF(){
        return leadNameTF;
    }

    @FindBy(name="company")
    private WebElement companyNameTF;
    public WebElement getCompanyNameTF(){
        return companyNameTF;
    }   

    @FindBy(name="leadSource")
    private WebElement leadSourceTF;
    public WebElement getLeadSourceTF(){
        return leadSourceTF;
    }

    @FindBy(name="industry")
    private WebElement industryTF;
    public WebElement getIndustryTF(){
        return industryTF;
    }

    @FindBy(name="annualRevenue")
    private WebElement annualRevenueTF;
    public WebElement getAnnualRevenueTF(){
        return annualRevenueTF;
    }

    @FindBy(name="noOfEmployees")
    private WebElement noOfEmployeesTF;
    public WebElement getNoOfEmployeesTF(){
        return noOfEmployeesTF;
    }

    @FindBy(name="phone")
    private WebElement phoneTF;
    public WebElement getPhoneTF(){
        return phoneTF;
    }

    @FindBy(name="email")
    private WebElement emailTF;
    public WebElement getEmailTF(){
        return emailTF;
    }

    @FindBy(name="leadStatus")
    private WebElement leadStatusTF;
    public WebElement getLeadStatusTF(){
        return leadStatusTF;
    }

    @FindBy(name="rating")
    private WebElement ratingTF;
    public WebElement getRatingTF(){
        return ratingTF;
    }

    @FindBy(name="assignedTo")
    private WebElement assignedToTF;
    public WebElement getAssignedToTF(){
        return assignedToTF;
    }

    @FindBy(xpath="//input[@type='text']/..//button")
    private WebElement addCompaignButton;
    public WebElement getAddCompaignButton(){
        return addCompaignButton;
    }
    
    @FindBy(xpath="//button[@type='submit']")
    private WebElement createLeadBtn;
    public WebElement getCreateLeadBtn() {
        return createLeadBtn;
    }


    public void createLead() throws IOException{
        FileUtility fu = new FileUtility();

        String leadName = fu.getDataFromExcelFile("CreateLead", 1, 0);
        String companyName = fu.getDataFromExcelFile("CreateLead", 1, 1);
        String leadSource = fu.getDataFromExcelFile("CreateLead", 1, 2);
        String industry = fu.getDataFromExcelFile("CreateLead", 1, 3);
        String annualRevenue = fu.getDataFromExcelFile("CreateLead", 1, 4);
        String noOfEmployees = fu.getDataFromExcelFile("CreateLead", 1, 5);
        String phone = fu.getDataFromExcelFile("CreateLead", 1, 6);
        String email = fu.getDataFromExcelFile("CreateLead", 1, 7);
        String leadStatus = fu.getDataFromExcelFile("CreateLead", 1, 8);
        String rating = fu.getDataFromExcelFile("CreateLead", 1, 9);
        String assignedTo = fu.getDataFromExcelFile("CreateLead", 1, 10);

        getLeadNameTF().sendKeys(leadName);
        getCompanyNameTF().sendKeys(companyName);
        getLeadSourceTF().sendKeys(leadSource);
        getIndustryTF().sendKeys(industry);
        getAnnualRevenueTF().sendKeys(annualRevenue);
        getNoOfEmployeesTF().sendKeys(noOfEmployees);
        getPhoneTF().sendKeys(phone);
        getEmailTF().sendKeys(email);
        getLeadStatusTF().sendKeys(leadStatus);
        getRatingTF().sendKeys(rating);
        getAssignedToTF().sendKeys(assignedTo);

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

        getCreateLeadBtn().click();
    }
}
