package Modules;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import object_repository.Campaigns;
import object_repository.Contacts;
import object_repository.CreateContact;

public class ContactsTest extends BaseClass{
    @Test
    public void createContactTest() throws IOException { 
        // CampaignsTest campTest = new CampaignsTest();
        // campTest.createCampaignTest();

        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        
        Campaigns cp = new Campaigns(driver);
        cp.getContactsLink().click();

        Contacts ct = new Contacts(driver);
        ct.getCreateContactBtn().click();

        CreateContact cc = new CreateContact(driver);
        cc.createContact();

        WebElement alert = cp.getAlert();
        // alert = cp.getAlert();
        mwdu.waitForElementToBeVisible(alert);
        if(cp.getAlert().getText().contains("Successfully Added")) {
            System.out.println("Contact created successfully");
        }else if(cp.getAlert().getText().contains("already exists")) {
            System.err.println("Contact already exists");
        } else {
            Assert.fail("Failed to create contact");
        }
        alert.click();
    }
}
