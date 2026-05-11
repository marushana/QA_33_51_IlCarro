package tests;

import model.User;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        System.out.println(i);
        System.out.println("+++++++++");
        System.out.println(System.currentTimeMillis());
        int z = (int)((System.currentTimeMillis()/1000)%3600);
        System.out.println(z);

        User user = new User().setName("Touyyyy").setLastName("TOYTOY").setEmail("touy"+z+"@gmail.com").setPassword("Toy46213&");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");
        app.getHelperUser().clickOkButton();
        app.getHelperUser().pause(5000);
    }

    @Test
    public void registrationNameBlank(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        User user = new User().setName("").setLastName("Toyyy").setEmail("toy"+i+"@gmail.com").setPassword("Toy46213&");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Name is required");
    }

    @Test
    public void registrationLastNameBlank(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        User user = new User().setName("Toy").setLastName("").setEmail("toy"+i+"@gmail.com").setPassword("Toy46213&");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().pause(5000);
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");
    }

    @Test
    public void registrationEmailWrong(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        User user = new User().setName("Toy").setLastName("Toyoyoy").setEmail("toy"+i+"gmail.com").setPassword("Toy46213&");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Wrong email format\n" +
                "Wrong email format");
        app.getHelperUser().pause(5000);

    }

    @Test
    public void registrationEmailBlank(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        User user = new User().setName("tot").setLastName("touuu").setEmail("").setPassword("Toy46213&");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");

    }

    @Test
    public void registrationPasswordWrongSpecialSymbol(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        User user = new User().setName("You").setLastName("Are").setEmail("learning"+i+"@gmail.com").setPassword("Toy46215");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");

    }

    @Test
    public void registrationPasswordWrongLessSymbols(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        User user = new User().setName("You").setLastName("Are").setEmail("learning"+i+"@gmail.com").setPassword("Toy462&");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password must contain minimum 8 symbols\n" +
                "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");

    }

    @Test
    public void registrationPasswordBlank(){
        Random random = new Random();
        int i = random.nextInt();
        User user = new User().setName("I").setLastName("need").setEmail("atableofsets"+i+"@gmail.com").setPassword("");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");

    }

//    @AfterMethod
//    public void postCondition(){
//        app.getHelperUser().clickOkButton();
//    }
}
