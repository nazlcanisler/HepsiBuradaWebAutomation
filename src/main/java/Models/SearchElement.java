package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Models.HomePageElement.driver;

public class SearchElement {

    public WebElement searchBox() {
        return driver.findElement(By.className("desktopOldAutosuggestTheme-input"));
    }

    public WebElement searchButton() {
        return driver.findElement(By.name("SearchBoxOld-buttonContainer\""));
    }

    public WebElement chooseProduct() {
        return driver.findElement(By.xpath("//*[@id=\"64af58fc-ea8a-4944-aec0-764cc1322fef\"]/div/div/ul/li/div/a/div[1]/figure/div[1]/div/div[1]/div"));
    }
}
