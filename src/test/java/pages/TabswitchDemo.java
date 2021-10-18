package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.PageObject;

public class TabswitchDemo extends PageObject {
    @FindBy(css = "a[href='tryit.asp?filename=tryhtml_iframe']")
    WebElement tryButton;



    public TabswitchDemo(WebDriver driver){
        super(driver);
    }

    public void clickTry(){
        tryButton.click();
    }

    public void switchTab(){
        String base= driver.getWindowHandle();
        driver.getWindowHandles().forEach(tab-> driver.switchTo().window(tab));
        driver.findElement(By.xpath("/html/body/div[3]/div/a[5]")).click();

    }


}
