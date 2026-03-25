package object_repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.FileUtility;

public class CreateCampaign {
    public CreateCampaign(WebDriver driver){
        PageFactory.initElements(driver, CreateCampaign.this);
    }

    @FindBy(name="campaignName")
    private WebElement campaignNameTF;
    public WebElement getCampaignNameTF(){
        return campaignNameTF;
    }

    @FindBy(name="campaignStatus")
    private WebElement campaignStatusTF;
    public WebElement getCampaignStatusTF(){
        return campaignStatusTF;
    }

    @FindBy(name="targetSize")
    private WebElement targetSizeTF;
    public WebElement getTargetSizeTF(){
        return targetSizeTF;
    }

    @FindBy(name="expectedCloseDate")
    private WebElement expectedCloseDateTF;
    public WebElement getExpectedCloseDateTF(){
        return expectedCloseDateTF;
    }

    @FindBy(name="targetAudience")
    private WebElement targetAudienceTF;
    public WebElement getTargetAudienceTF(){
        return targetAudienceTF;
    }

    @FindBy(xpath="//textarea[@name='description']")
    private WebElement descriptionTA;
    public WebElement getDescriptionTA(){
        return descriptionTA;
    }

    @FindBy(xpath="//button[text()='Create Campaign']")
    private WebElement createCampaignBtn;
    public WebElement getCreateCampaignBtn(){
        return createCampaignBtn;
    }

    public void createCampaign() throws IOException{
        FileUtility fu = new FileUtility();
        String campaignName = fu.getDataFromExcelFile("CreateCampaign", 1, 0);
        String campaignStatus = fu.getDataFromExcelFile("CreateCampaign", 1, 1);
        String targetSize = fu.getDataFromExcelFile("CreateCampaign", 1, 2);
        String expectedCloseDate = fu.getDataFromExcelFile("CreateCampaign", 1, 3);
        String targetAudience = fu.getDataFromExcelFile("CreateCampaign", 1, 4);
        String description = fu.getDataFromExcelFile("CreateCampaign", 1, 5);

        getCampaignNameTF().sendKeys(campaignName);
        getCampaignStatusTF().sendKeys(campaignStatus);
        getTargetSizeTF().sendKeys(targetSize);
        getExpectedCloseDateTF().sendKeys(expectedCloseDate);
        getTargetAudienceTF().sendKeys(targetAudience);
        getDescriptionTA().sendKeys(description);
        getCreateCampaignBtn().click();
    }




}
