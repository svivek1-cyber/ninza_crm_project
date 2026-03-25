package Modules;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import object_repository.Campaigns;
import object_repository.CreatePurchaseOrder;
import object_repository.PurchaseOrders;

public class PurchaseOrdersTest extends BaseClass {
    @Test
    public void createPurchaseOrderTest() throws IOException {
        
//        ContactsTest contTest = new ContactsTest();
//        contTest.createContactTest();
//        ProductsTest prodTest = new ProductsTest();
//        prodTest.createProductTest();

        Campaigns cp = new Campaigns(driver);
        cp.getPurchaseOrderLink().click();

        PurchaseOrders po = new PurchaseOrders(driver);
        po.getCreatePurchaseOrderBtn().click();

        CreatePurchaseOrder cpo = new CreatePurchaseOrder(driver);
        cpo.createPurchaseOrder(driver);
        

        WebElement alert = cp.getAlert();
        mwdu.waitForElementToBeVisible(alert);
        if (cp.getAlert().getText().contains("Successfully Added")) {
            System.out.println("Purchase Order created successfully");
        } else if (cp.getAlert().getText().contains("Purchase Order is Not Added")) {
            System.err.println("Purchase Order already exists");
        } else {
            Assert.fail("Failed to create Purchase Order");
        }
        alert.click();
    }
}
