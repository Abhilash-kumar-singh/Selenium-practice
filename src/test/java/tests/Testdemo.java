package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;
import pages.DropdownDemo;
import pages.TabswitchDemo;
import pages.iframeDemo;
import java.util.concurrent.TimeUnit;

class TestDemo {
    WebDriver driver=null;
    @BeforeMethod
    protected void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    protected void tabSwitchTest(){
        driver.get("https://www.w3schools.com/tags/tag_iframe.ASP");
        TabswitchDemo test1=new TabswitchDemo(driver);
        test1.clickTry();
        test1.switchTab();
        Assert.assertEquals(driver.getTitle(),"Tryit Editor v3.7");
    }
    @Test
    protected void iframeTest(){
        driver.get("https://profile.w3schools.com/log-in?redirect_url=https%3A%2F%2Fmy-learning.w3schools.com");
        iframeDemo test2=new iframeDemo(driver);
        test2.switchToSupportIframe();
        test2.openChatBot();
        test2.switchToParent();
        test2.switchToChatBotFrame();

        Assert.assertEquals(test2.fetchFrametitle(),"W3Schools.com");
    }
    @Test
    protected void selectTest(){
        driver.get("https://html.com/tags/select/");
        DropdownDemo test3=new DropdownDemo(driver);
        test3.selectFlamingoChoice();
    }
    @AfterMethod
    protected void breakDown(){
        driver.quit();
    }
}
