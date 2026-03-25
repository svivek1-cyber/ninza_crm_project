package Modules;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import object_repository.Campaigns;
import object_repository.CreateQuote;
import object_repository.Quotes;


public class QuotesTest extends BaseClass{
    @Test
    public void createQuoteTest() throws IOException{
    	
//        ContactsTest contTest = new ContactsTest();
//        contTest.createContactTest();
//        OpportunitiesTest oppTest = new OpportunitiesTest();
//        oppTest.createOpportunityTest();
//        ProductsTest prodTest = new ProductsTest();
//        prodTest.createProductTest();


        Campaigns cp = new Campaigns(driver); 
        cp.getQuotesLink().click();

        Quotes q = new Quotes(driver);
        q.getCreateQuoteBtn().click();

        CreateQuote cq = new CreateQuote(driver);
        cq.fillQuoteCredentials(driver);
        

        WebElement alert = cp.getAlert();
        mwdu.waitForElementToBeVisible(alert);
        if(cp.getAlert().getText().contains("Successfully Added")) {
            System.out.println("Quote created successfully");
        }else if(cp.getAlert().getText().contains("Quote is Not Added")) {
            System.err.println("Quote already exists");
        } else {
            Assert.fail("Failed to create Quote");
        }
        alert.click();
    }
}
