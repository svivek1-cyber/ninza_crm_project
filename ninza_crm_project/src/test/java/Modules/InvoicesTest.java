package Modules;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import object_repository.Campaigns;
import object_repository.CreateInvoice;
import object_repository.Invoices;

public class InvoicesTest extends BaseClass {
    @Test
    public void createInvoiceTest() throws IOException{
        
//        ContactsTest contTest = new ContactsTest();
//        contTest.createContactTest();
//        SalesOrdersTest soTest = new SalesOrdersTest();
//        soTest.createSalesOrderTest();
//        ProductsTest prodTest = new ProductsTest();
//        prodTest.createProductTest();

        Campaigns cp = new Campaigns(driver);
        cp.getInvoiceLink().click();

        Invoices inv = new Invoices(driver);
        inv.getCreateInvoiceBtn().click();

        CreateInvoice ci = new CreateInvoice(driver);
        ci.createInvoice();        

        WebElement alert = cp.getAlert();
        mwdu.waitForElementToBeVisible(alert);
        if(cp.getAlert().getText().contains("Successfully Added")) {
            System.out.println("Invoice created successfully");
        }else if(cp.getAlert().getText().contains("Invoice is Not Added")) {
            System.err.println("Invoice already exists");
        } else {
            Assert.fail("Failed to create Invoice");
        }
        alert.click();
    }
}
