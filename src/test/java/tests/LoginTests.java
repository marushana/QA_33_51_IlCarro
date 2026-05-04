package tests;

import model.User;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginRegistrationForm("marushana@yandex.ru", "Pokrov13041986!");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        app.getHelperUser().clickOkButton();
    }

    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginRegistrationForm("marushana@yandex.ru", "Pokrov13041986!");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        app.getHelperUser().clickOkButton();
    }

    @Test
    public void loginWrongEmail(){
        User user = new User().setEmail("marushanayandex.ru").setPassword("Pokrov13041986!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
    }
    @Test
    public void loginWrongPassword(){
        User user = new User().setEmail("marushana@yandex.ru").setPassword("Pokrov1304198!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        app.getHelperUser().clickOkButton();
    }
    @Test
    public void loginUnregisteredUser(){
        User user = new User().setEmail("mgled@yandex.ru").setPassword("Pokrov13041986!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        app.getHelperUser().clickOkButton();
    }

//    @AfterMethod
//    public void postCondition(){
//        app.getHelperUser().clickOkButton();
//    }
}
