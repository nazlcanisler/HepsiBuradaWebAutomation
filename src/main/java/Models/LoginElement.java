package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Models.HomePageElement.driver;

public class LoginElement {
    public WebElement login() { return driver.findElement(By.xpath("//*[@id=\"myAccount\"]")); }

    public WebElement loginLink() {
        return driver.findElement(By.id("login"));
    }

    public  WebElement userName() {
        return driver.findElement(By.name("username"));
    }

    public WebElement password() {
        return driver.findElement(By.name("password"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.id("btnLogin"));
    }
}

