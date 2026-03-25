package generic_utility;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import object_repository.Campaigns;
import object_repository.LoginPage;

public class BaseClass {
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public FileUtility fu = null;
    public MyWebDriverUtility mwdu = null;

    @BeforeClass
    public void configBeforeClass() throws IOException{
        this.fu = new FileUtility();
		String BROWSER = fu.getDataFromPropertiesFile("brow");
        this.driver = MyWebDriverUtility.browserDriver(BROWSER);
        sdriver = this.driver;
        System.out.println("Browser opened");
    }

    @BeforeMethod
    public void login() throws IOException {
		String URL = fu.getDataFromPropertiesFile("url");
        String USERNAME = fu.getDataFromPropertiesFile("un");
		String PASSWORD = fu.getDataFromPropertiesFile("pwd");
        this.mwdu = new MyWebDriverUtility(driver);
        mwdu.getMaximize();
		mwdu.globalWait();

		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.getUserNameTF().sendKeys(USERNAME + Keys.TAB + PASSWORD + Keys.ENTER);

        System.out.println("Login is successful");
    }

    @AfterMethod
    public void logout() {
        Campaigns cp = new Campaigns(driver);
        WebElement userIcon = cp.getUserIcon();
        mwdu.waitForElementToBeVisible(userIcon).click();
        cp.getLogoutbtn().click();
        System.out.println("Logout is successful");
    }
    
    @AfterClass
    public void closeBrowser() {
        driver.quit();
        System.out.println("Browser closed");
    }
}
