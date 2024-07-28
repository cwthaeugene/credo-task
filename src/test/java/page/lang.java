package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class lang
{

    private WebDriver driver;
    private WebDriverWait wait;
    public lang(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
    }

    private By languageSwitchBtn = By.xpath("//*[@id=\"languageSwitcherBtn\"]");
    private By georgianLang = By.xpath("/html/body/app-root/app-language-switcher-dialog/app-popup-container/div/div/div[2]/ul/li[1]/div[2]/div[1]/p");
    private By margalLang = By.xpath("/html/body/app-root/app-language-switcher-dialog/app-popup-container/div/div/div[2]/ul/li[1]/div[2]/div[2]/p");
    private By svanLang = By.xpath("/html/body/app-root/app-language-switcher-dialog/app-popup-container/div/div/div[2]/ul/li[1]/div[2]/div[3]/p");





    public void selectGeo()
    {
        wait.until(ExpectedConditions.elementToBeClickable(languageSwitchBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(georgianLang)).click();
    }

    public void selectMar()
    {
        wait.until(ExpectedConditions.elementToBeClickable(languageSwitchBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(margalLang)).click();
    }

    public void selectSvan()
    {
        wait.until(ExpectedConditions.elementToBeClickable(languageSwitchBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(svanLang)).click();
    }
}
