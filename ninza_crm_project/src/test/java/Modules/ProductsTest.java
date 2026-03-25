package Modules;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import object_repository.Campaigns;
import object_repository.CreateProduct;
import object_repository.Products;

public class ProductsTest extends BaseClass{
    
    @Test
    public void createProductTest() throws IOException{
    	
        Campaigns cp = new Campaigns(driver);
        cp.getProductsLink().click();

        Products p = new Products(driver);
        p.getCreateProductBtn().click();

        CreateProduct cpdt = new CreateProduct(driver);
        cpdt.createProduct();

        WebElement alert = cp.getAlert();
        mwdu.waitForElementToBeVisible(alert);
        if(cp.getAlert().getText().contains("Successfully Added")) {
            System.out.println("Product created successfully");
        }else if(cp.getAlert().getText().contains("Already Exists")) {
            System.err.println("Product already exists");
        } else {
            Assert.fail("Failed to create Product");
        }
        alert.click();
    }
}
