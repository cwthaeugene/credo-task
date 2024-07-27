package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class auth
{
    WebDriver driver;
    public auth(WebDriver driver)
    {
        this.driver = driver;
    }

    private By userNameField = By.id("userName");
    //private By passwordField = By.id("newPass");

    public void InputUsername()
    {
        driver.findElement(userNameField).sendKeys("hello");
    }

}
