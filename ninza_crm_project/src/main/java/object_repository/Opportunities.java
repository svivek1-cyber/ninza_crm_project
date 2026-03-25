package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Opportunities {
    public Opportunities(WebDriver driver){
        PageFactory.initElements(driver, Opportunities.this);
    }

    @FindBy(xpath="//span[text()='Create Opportunity']")
    private WebElement createOpportunityBtn;
    public WebElement getCreateOpportunityBtn(){
        return createOpportunityBtn;
    } 
}
