package test;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.auth;
import page.lang;

public class test extends base
{

    private auth page;
    private lang langSelect;
    private SoftAssert softAssert = new SoftAssert();;

    @BeforeClass
    public void setUpPages() {
        page = new auth(driver);
        langSelect = new lang(driver);
    }



    @Test(description = "enter invalid credentials during authorization", dataProvider = "assertionProvider", dataProviderClass = DataProvide.class)
    @Feature("User authorization")
    public void testAuth(String header,String usrField, String passField, String submit, String error,String language)
    {
        selectLanguage(language);
        checkAuthPage(header,usrField,passField,submit);
        enterCredentials();
        submitLogin();
        checkErrorMessage(error);


    }

    @Step("Select language")
    public void selectLanguage(String language)
    {
        switch (language)
        {
            case "Georgian":
                langSelect.selectGeo();
                break;
            case "Svanuri":
                langSelect.selectSvan();
                break;
            case "Megruli":
                langSelect.selectMar();
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    @Step("Enter credentials")
    public void enterCredentials()
    {
        page.enterCredentials();
    }

    @Step("Submit login form")
    public void submitLogin()
    {
        page.pressSubmit();
    }


    @Step("Check auth page")
    public void checkAuthPage(String header,String usrField, String passField, String submit)
    {
        softAssert.assertEquals(page.getHeaderText(),header);
        softAssert.assertEquals(page.getUserPlaceHolderText(),usrField);
        softAssert.assertEquals(page.getPassPlaceHolderText(),passField);
        softAssert.assertEquals(page.getSubmitButtonText(),submit);
    }
    @Step("Check error message")
    public void checkErrorMessage(String error)
    {
        softAssert.assertEquals( page.getErrorMessage() ,error);
    }




}