package Modules;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import object_repository.Campaigns;
import object_repository.CreateCampaign;

public class CampaignsTest extends BaseClass {
    
    @Test
    public void createCampaignTest() throws IOException {
        Campaigns cp = new Campaigns(driver);
        cp.getCreateCampaignBtn().click();

        CreateCampaign ccp = new CreateCampaign(driver);
        ccp.createCampaign();
        
        WebElement alert = cp.getAlert();
        mwdu.waitForElementToBeVisible(alert);
        if(cp.getAlert().getText().contains("Successfully Added")) {
            System.out.println("Campaign created successfully");
        }else if(cp.getAlert().getText().contains("Campaign is Not Added")) {
            System.err.println("Campaign already exists");
        } else {
            Assert.fail("Failed to create campaign");
        }
        alert.click();
    }

    // @Test
    // public void deleteCampaignTest() throws IOException {

    //     Campaigns cp = new Campaigns(driver);
    //     String campaignName = fu.getDataFromExcelFile("CreateCampaign", 1, 0);
    //     mwdu.selectFromDDusingVisibleText(cp.getSearchInDD(), "Search by Campaign Name");
    //     cp.getSearchTF().sendKeys(campaignName);
        
    //     if (!cp.getDeleteIcons().isEmpty()) {
    //     	cp.getDeleteIcons().get(0).click();
    //     	WebElement alert = cp.getAlert();
    //         mwdu.waitForElementToBeVisible(alert);
    //         if(cp.getAlert().getText().contains("Campaign Successfully Deleted")) {
    //             System.out.println("Campaign deleted successfully");
    //         } else {
    //             Assert.fail("Failed to delete campaign");
    //         }
    //         alert.click();
    //     } else {
    //         System.err.println("Campaign not found for deletion");
    //     }
        
    // }
}
