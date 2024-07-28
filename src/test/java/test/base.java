package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.awt.*;


public class base
{
    WebDriver driver;

    @BeforeTest
    public void beforetest()
    {
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Dimension maximizedScreenSize = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
        driver.manage().window().setSize(maximizedScreenSize);
        driver.get("https://mycredo.ge/landing/main/auth");
    }
    @AfterTest
    public void tearDown() throws InterruptedException
    {
        if (driver != null) {
            driver.quit();
        }

    }
    @AfterMethod
    public void delay() throws InterruptedException
    {
        Thread.sleep(5000);
        driver.navigate().refresh();
    }


}
