package Modules;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import object_repository.Campaigns;
import object_repository.CreateOpportunity;
import object_repository.Opportunities;

public class OpportunitiesTest extends BaseClass {

    @Test
    public void createOpportunityTest() throws IOException {
    	
//        LeadsTest leadTest = new LeadsTest();
//        leadTest.createLeadTest();

        Campaigns cp = new Campaigns(driver);
        cp.getOpportunitiesLink().click();

        Opportunities op = new Opportunities(driver);
        op.getCreateOpportunityBtn().click();

        CreateOpportunity cop = new CreateOpportunity(driver);
        cop.createOpportunity();

        WebElement alert = cp.getAlert();
        mwdu.waitForElementToBeVisible(alert);
        if (cp.getAlert().getText().contains("Successfully Added")) {
            System.out.println("Opportunity created successfully");
        } else if (cp.getAlert().getText().contains("Opportunity is Not Added")) {
            System.err.println("Opportunity already exists");
        } else {
            Assert.fail("Failed to create Opportunity");
        }
        alert.click();
    }

}
