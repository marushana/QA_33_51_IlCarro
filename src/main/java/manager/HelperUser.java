package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void openRegistrationForm() {
//        WebElement loginTab = wd.findElement(By.xpath("//a[text() = 'LOGIN']"));
//        loginTab.click();
        click(By.xpath("//a[text() = ' Sign up ']"));
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

    public void submitLogin(){
        click(By.xpath("//*[text() = 'Y’alla!']"));
    }

    public String getMessage(){
        WebElement element = wd.findElement(By.xpath("//h2[@class = 'message']"));
        return element.getText();
    }


}
