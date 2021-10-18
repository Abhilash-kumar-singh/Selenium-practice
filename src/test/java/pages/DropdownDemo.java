package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utility.PageObject;

public class DropdownDemo extends PageObject {
    public DropdownDemo(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//*[@id=\"post-289\"]/div/div[3]/select")
    WebElement flamingoList;

    public void selectFlamingoChoice(){
        Select list= new Select(flamingoList);
        list.selectByVisibleText("Greater flamingo");
    }

}
