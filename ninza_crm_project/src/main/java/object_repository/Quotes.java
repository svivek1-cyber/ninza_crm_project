package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quotes {
    public Quotes(WebDriver driver){
        PageFactory.initElements(driver, Quotes.this);
    }

    @FindBy(xpath="//span[text()='Create Quote']")
    private WebElement createQuoteBtn;
    public WebElement getCreateQuoteBtn(){
        return createQuoteBtn;
    }
}
