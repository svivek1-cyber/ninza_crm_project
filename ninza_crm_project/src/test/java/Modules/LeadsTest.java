package Modules;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import object_repository.Campaigns;
import object_repository.CreateLead;
import object_repository.Lead;

public class LeadsTest extends BaseClass {
    @Test
    public void createLeadTest() throws IOException {
    	
//        CampaignsTest campTest = new CampaignsTest();
//        campTest.createCampaignTest();

        Campaigns cp = new Campaigns(driver);
        cp.getLeadsLink().click();

        Lead ld = new Lead(driver);
        ld.getCreateLeadBtn().click();

        CreateLead cl = new CreateLead(driver);
        cl.createLead();

        WebElement alert = cp.getAlert();
        mwdu.waitForElementToBeVisible(alert);
        if(cp.getAlert().getText().contains("Successfully Added")) {
            System.out.println("Lead created successfully");
        }else if(cp.getAlert().getText().contains("Lead is Not Added")) {
            System.err.println("Lead already exists");
        } else {
            Assert.fail("Failed to create Lead");
        }
        alert.click();
    }
}
