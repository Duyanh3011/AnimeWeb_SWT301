package automation;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class testAuto {

    WebDriver driver = new EdgeDriver();

    @Before
    public void Setup() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\acer\\Desktop\\msedgedriver.exe");
        driver.navigate().to("http://localhost:4444/AnimeWeb_HE181309_SWT/login");
        WebElement account = driver.findElement(By.name("user"));
        account.sendKeys("sa");
        WebElement password = driver.findElement(By.name("pass"));
        password.sendKeys("123");
        WebElement button = driver.findElement(By.className("site-btn"));
        button.click();
    }

    @Test
    public void testAuto() throws InterruptedException {
        driver.navigate().to("http://localhost:4444/AnimeWeb_HE181309_SWT/add");
        Thread.sleep(2000);
        assertEquals("Check", "Anime | Admin", driver.getTitle());
        driver.quit();
    }
}
