package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.PageObject;



public class iframeDemo extends PageObject {
    public iframeDemo(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "launcher")
    WebElement laucherFrame;

    @FindBy(xpath = "/html/body/div/div/div/div/div/button")
    WebElement supportButton;

    @FindBy(id="webWidget")
    WebElement iframeWindow;

    @FindBy(xpath="//*[@id=\"widgetHeaderTitle\"]")
    WebElement frameWindowTitle;

    public void switchToSupportIframe(){
        //switch to frame which has button to open chatbot
        driver.switchTo().frame(laucherFrame);
    }

    public void openChatBot(){
        //click the button to open chatBot
        supportButton.click();
    }

    public void switchToParent(){
        driver.switchTo().defaultContent();
    }

    public void switchToChatBotFrame(){
        //switch to window which has chatbot
        driver.switchTo().frame(iframeWindow);
    }

    public String fetchFrametitle(){
        //click on the official website link present on chatbot iframe
        return frameWindowTitle.getText();
    }

}
