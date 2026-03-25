package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, LoginPage.this);
    }

    @FindBy(id="username")
    private WebElement unTF;
    public WebElement getUserNameTF(){
        return unTF;
    }

    @FindBy(id="inputPassword")
    private WebElement pwdTF;
    public WebElement getPasswordTF(){
        return pwdTF;
    }

    @FindBy(xpath="//button[text()='Sign In']")
    private WebElement signInBtn;
    public WebElement getSignInButton(){
        return signInBtn;
    }

}
