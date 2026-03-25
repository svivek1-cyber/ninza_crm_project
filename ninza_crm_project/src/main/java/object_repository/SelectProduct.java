package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectProduct {
    public SelectProduct(WebDriver driver){
        PageFactory.initElements(driver, SelectProduct.this);
    }

    @FindBy(id="search-criteria")
    private WebElement searchCriteriaDD;
    public WebElement getSearchCriteriaDD(){
        return searchCriteriaDD;
    }

    @FindBy(id="search-input")
    private WebElement searchInput;
    public WebElement getSearchInput(){
        return searchInput;
    }
    
    @FindBy(xpath="//button[@class='select-btn']")
    private WebElement selectButton;
    public WebElement getSelectButton(){
        return selectButton;
    } 
}
