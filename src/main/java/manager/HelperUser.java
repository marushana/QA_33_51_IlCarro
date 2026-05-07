package manager;

import model.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
//        WebElement loginTab = wd.findElement(By.xpath("//a[text() = 'LOGIN']"));
//        loginTab.click();
        click(By.xpath("//a[text() = ' Log in ']"));
    }


    public void fillLoginRegistrationForm(User user) {
        type(By.xpath("//input[@id = 'email']"), user.getEmail());
        type(By.xpath("//input[@id = 'password']"), user.getPassword());
    }

    public void fillLoginRegistrationForm(String email, String password){
//        WebElement emailInput = wd.findElement(By.xpath("//*[text() = 'Email ']"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
        type(By.xpath("//input[@id = 'email']"), email);
//        WebElement passwordInput = wd.findElement(By.xpath("//*[text() = 'Password ']"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
        type(By.xpath("//input[@id = 'password']"), password);
    }

    public void submit(){
        click(By.xpath("//*[text() = 'Y’alla!']"));
    }

    public String getMessage(){
        WebElement element = wd.findElement(By.xpath("//h2[@class = 'message']"));
        //pause(2000);
        return element.getText();
    }


    public void clickOkButton() {
        click(By.xpath("//button[text() = 'Ok']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text() =' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//*[text() =' Logout ']"));
    }

    public String getErrorText() {
        return wd.findElement(By.xpath("//div[@class = 'error']")).getText();
    }

    /// =============registration

    public void openRegistrationForm() {
//        WebElement loginTab = wd.findElement(By.xpath("//a[text() = 'LOGIN']"));
//        loginTab.click();
        click(By.xpath("//a[text() = ' Sign up ']"));
    }



    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public void checkPolicy() {
        //click(By.id("terms-of-use"));

        //click(By.cssSelector("label[for = 'terms-of-use']"));

        //

        //JavaScript option when nothing works
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click()");

    }

    public void checkPolicyXY(){
        WebElement lable = wd.findElement(By.cssSelector("label[for = 'terms-of-use']"));
        Rectangle rectangle = lable.getRect();
        int w = rectangle.getWidth();
        int xOfSet = -w/2;
//        Dimension size = wd.manage().window().getSize();
//        size.getWidth();
        Actions actions = new Actions(wd);
        actions.moveToElement(lable, xOfSet, 0).click().release().perform();
    }

}
