package object_repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import generic_utility.FileUtility;
import generic_utility.MyWebDriverUtility;

public class CreateOpportunity {
    WebDriver driver;
    MyWebDriverUtility mwdu;

    public CreateOpportunity(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, CreateOpportunity.this);
    }

    @FindBy(name="opportunityName")
    private WebElement opportunityNameTF;
    public WebElement getOpportunityNameTF(){
        return opportunityNameTF;
    }

    @FindBy(name="businessType")
    private WebElement businessTypeTF;
    public WebElement getBusinessTypeTF(){
        return businessTypeTF;
    }

    @FindBy(name="amount")
    private WebElement amountTF;
    public WebElement getAmountTF(){
        return amountTF;
    }

    @FindBy(name="assignedTo")
    private WebElement assignedToTF;
    public WebElement getAssignedToTF(){
        return assignedToTF;
    }

    @FindBy(name="expectedCloseDate")
    private WebElement expectedCloseDateTF;
    public WebElement getExpectedCloseDateTF(){
        return expectedCloseDateTF;
    }

    @FindBy(name="nextStep")
    private WebElement nextStepTF;
    public WebElement getNextStepTF(){
        return nextStepTF;
    }

    @FindBy(name="salesStage")
    private WebElement salesStageTF;
    public WebElement getSalesStageTF(){
        return salesStageTF;
    }

    @FindBy(name="probability")
    private WebElement probabilityTF;
    public WebElement getProbabilityTF(){
        return probabilityTF;
    }

    @FindBy(xpath="//input[@type='text']/..//button")
    private WebElement addLeadBtn;
    public WebElement getAddLeadBtn(){
        return addLeadBtn;
    }

    @FindBy(xpath="//button[@type='submit']")
    private WebElement createOpportunityBtn;
    public WebElement getCreateOpportunityBtn() {
        return createOpportunityBtn;
    }

    public void createOpportunity() throws IOException{
        FileUtility fu = new FileUtility();
        mwdu = new MyWebDriverUtility(driver);

        String opportunityName = fu.getDataFromExcelFile("CreateOpportunity", 1, 0);
        String amount = fu.getDataFromExcelFile("CreateOpportunity", 1, 1);
        String businessType = fu.getDataFromExcelFile("CreateOpportunity", 1, 2);
        String assignedTo = fu.getDataFromExcelFile("CreateOpportunity", 1, 3);
        String expectedCloseDate = fu.getDataFromExcelFile("CreateOpportunity", 1, 4);
        String nextStep = fu.getDataFromExcelFile("CreateOpportunity", 1, 5);
        String salesStage = fu.getDataFromExcelFile("CreateOpportunity", 1, 6);
        String probability = fu.getDataFromExcelFile("CreateOpportunity", 1, 7);

        getOpportunityNameTF().sendKeys(opportunityName);
        getAmountTF().sendKeys(amount);
        getBusinessTypeTF().sendKeys(businessType);
        getAssignedToTF().sendKeys(assignedTo);
        getExpectedCloseDateTF().sendKeys(expectedCloseDate);
        getNextStepTF().sendKeys(nextStep);
        getSalesStageTF().sendKeys(salesStage);
        getProbabilityTF().sendKeys(probability);

        String hId = driver.getWindowHandle();
        getAddLeadBtn().click();
        mwdu.switchWindowById(hId);

        SelectLead sc = new SelectLead(driver);
        WebElement searchCriteriaDD = sc.getSearchCriteriaDD();
        mwdu.waitForElementToBeVisible(searchCriteriaDD);
        Select s = new Select(searchCriteriaDD);
        s.selectByVisibleText("Lead Name");
        sc.getSearchInput().sendKeys(fu.getDataFromExcelFile("CreateLead", 1, 0));
        sc.getSelectButton().click();
        mwdu.switchToParent(hId);

        getCreateOpportunityBtn().click();
    }
    
}
