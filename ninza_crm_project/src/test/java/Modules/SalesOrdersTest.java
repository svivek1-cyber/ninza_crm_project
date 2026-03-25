package Modules;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import object_repository.Campaigns;
import object_repository.CreateSalesOrder;
import object_repository.SalesOrders;

public class SalesOrdersTest extends BaseClass {
    @Test
    public void createSalesOrderTest() throws IOException {

//        ContactsTest contTest = new ContactsTest();
//        contTest.createContactTest();
//        OpportunitiesTest oppTest = new OpportunitiesTest();
//        oppTest.createOpportunityTest();
//        ProductsTest prodTest = new ProductsTest();
//        prodTest.createProductTest();
//        QuotesTest quoteTest = new QuotesTest();
//        quoteTest.createQuoteTest();

        Campaigns cp = new Campaigns(driver);
        cp.getSalesOrderLink().click();

        SalesOrders so = new SalesOrders(driver);
        so.getCreateProductBtn().click();

        CreateSalesOrder cso = new CreateSalesOrder(driver);
        cso.createSalesOrder();
        

        WebElement alert = cp.getAlert();
        mwdu.waitForElementToBeVisible(alert);
        if (cp.getAlert().getText().contains("Successfully Added")) {
            System.out.println("Sales Order created successfully");
        } else if (cp.getAlert().getText().contains("Sales Order is Not Added")) {
            System.err.println("Sales Order already exists");
        } else {
            Assert.fail("Failed to create Sales Order");
        }
        alert.click();
    }
}
