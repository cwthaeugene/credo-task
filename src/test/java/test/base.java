package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.auth;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class base
{
    WebDriver driver;

    @BeforeTest
    public void beforetest()
    {
        FirefoxBinary firefoxBinary = new FirefoxBinary(new File("/usr/bin/firefox"));

        // Set Firefox options
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);

        // Setup WebDriver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options);



        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("https://mycredo.ge/landing/main/auth");
    }
    @Test
    public void test()
    {
        auth page = new auth(driver);
        page.InputUsername();
    }
}
