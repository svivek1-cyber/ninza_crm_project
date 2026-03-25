package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {
    public Contacts(WebDriver driver){
        PageFactory.initElements(driver, Contacts.this);
    }

    
    @FindBy(xpath="//span[text()='Create Contact']")
    private WebElement createContactBtn;
    public WebElement getCreateContactBtn(){
        return createContactBtn;
    }
}
