package page;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class auth
{

    private WebDriver driver;
    private WebDriverWait wait;


    private By userNameField = By.id("userName");
    private By userNamePlaceHolder = By.id("placeHolderAuth");
    private By passwordField = By.id("newPass");
    private By passwordPlaceHolder = By.id("placeholderPass");
    private By submitButton = By.id("submitAuth");
    private By errorText = By.id("growlText");
    private By header = By.xpath("//*[@id='authloading']/p");


    public auth(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set timeout as needed
    }


    public String randomParams(int size)
    {
        return RandomStringUtils.randomAlphanumeric(size);
    }


    public void inputUsername(String username)
    {
        WebElement usernameFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        usernameFieldElement.sendKeys(username);
    }


    public void inputPassword(String password)
    {
        WebElement passwordFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordFieldElement.sendKeys(password);
    }


    public void pressSubmit()
    {
        WebElement submitButtonElement = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButtonElement.click();
    }
    public String getSubmitButtonText()
    {
        WebElement submitButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        return submitButtonElement.getText();
    }


    public String getErrorMessage()
    {
        WebElement errorTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorText));
        return errorTextElement.getText();
    }


    public String getHeaderText()
    {
        WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        return headerElement.getText();
    }


    public String getUserPlaceHolderText()
    {
        WebElement userNamePlaceHolderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userNamePlaceHolder));
        return userNamePlaceHolderElement.getText();
    }


    public String getPassPlaceHolderText()
    {
        WebElement passwordPlaceHolderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordPlaceHolder));
        return passwordPlaceHolderElement.getText();
    }


    public void enterCredentials()
    {
        inputUsername(randomParams(8));
        inputPassword(randomParams(8));
    }
}
