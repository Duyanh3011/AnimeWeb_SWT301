package automation;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class testChangePass {

    WebDriver driver;

    @Before
    public void Setup() {
        System.setProperty("webdriver.edge.driver", "C:\\Desktopmini\\edgedriver\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.navigate().to("http://localhost:9999/AnimeWeb_HE181309_SWT/login");
        WebElement account = driver.findElement(By.name("user"));
        account.sendKeys("user1");
        WebElement password = driver.findElement(By.name("pass"));
        password.sendKeys("123");
        WebElement button = driver.findElement(By.className("site-btn"));
        button.click();
    }

    @Test
    public void testValidPassword() throws InterruptedException {
        changePassword("123", "1234", "1234");
        WebElement errorMessage = driver.findElement(By.id("done")); 
        assertEquals("Change password successful!!!", errorMessage.getText());
        revertPassword("1234", "123");
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:9999/AnimeWeb_HE181309_SWT/password", currentUrl);
    }

    @Test
    public void testSamePassword() throws InterruptedException {
        changePassword("123", "123", "123");
        WebElement errorMessage = driver.findElement(By.id("done")); 
        assertEquals("Change password successful!!!", errorMessage.getText());
        revertPassword("123", "123");
         String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:9999/AnimeWeb_HE181309_SWT/password", currentUrl);
    }

    @Test
    public void testOneCharacterPassword() throws InterruptedException {
        changePassword("123", "a", "a");
        WebElement errorMessage = driver.findElement(By.id("done")); 
        assertEquals("Change password successful!!!", errorMessage.getText());
        revertPassword("a", "123");
         String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:9999/AnimeWeb_HE181309_SWT/password", currentUrl);
    }

    @Test
    public void testVeryLongPassword() throws InterruptedException {
        String longPassword = "a".repeat(100);
        changePassword("123", longPassword, longPassword);
        WebElement errorMessage = driver.findElement(By.id("done")); 
        assertEquals("Change password successful!!!", errorMessage.getText());
        revertPassword(longPassword, "123");
         String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:9999/AnimeWeb_HE181309_SWT/password", currentUrl);
    }

    @Test
    public void testPasswordWithSpecialCharacters() throws InterruptedException {
        changePassword("123", "Passw0rd!@#", "Passw0rd!@#");
        WebElement errorMessage = driver.findElement(By.id("done")); 
        assertEquals("Change password successful!!!", errorMessage.getText());
        revertPassword("Passw0rd!@#", "123");
         String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:9999/AnimeWeb_HE181309_SWT/password", currentUrl);
    }

    @Test
    public void testNoOldPassword() throws InterruptedException {
        changePassword("", "1234", "1234");
        
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:9999/AnimeWeb_HE181309_SWT/profile", currentUrl);
    }

    @Test
    public void testNoNewPassword() throws InterruptedException {
        changePassword("123", "", "1234");
        
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:9999/AnimeWeb_HE181309_SWT/profile", currentUrl);
    }

    @Test
    public void testNoConfirmPassword() throws InterruptedException {
        changePassword("123", "1234", "");
        
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:9999/AnimeWeb_HE181309_SWT/profile", currentUrl);
    }

    @Test
    public void testNoInformation() throws InterruptedException {
        changePassword("", "", "");
        
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:9999/AnimeWeb_HE181309_SWT/profile", currentUrl);
    }

    @Test
    public void testIncorrectOldPassword() throws InterruptedException {
        changePassword("132", "1234", "1234");
        WebElement errorMessage = driver.findElement(By.id("fail1")); 
        assertEquals("Password is incorrect", errorMessage.getText());
         String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:9999/AnimeWeb_HE181309_SWT/password", currentUrl);
    }
    
        @Test
    public void testIncorrectNewPassword() throws InterruptedException {
        changePassword("123", "1243", "1234");
        WebElement errorMessage = driver.findElement(By.id("fail2")); 
        assertEquals("Password is not matching", errorMessage.getText());
         String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:9999/AnimeWeb_HE181309_SWT/password", currentUrl);
    }
    
        @Test
    public void testIncorrectConfirmPassword() throws InterruptedException {
        changePassword("123", "1234", "1243");
        WebElement errorMessage = driver.findElement(By.id("fail2")); 
        assertEquals("Password is not matching", errorMessage.getText());
         String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:9999/AnimeWeb_HE181309_SWT/password", currentUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void changePassword(String oldPassword, String newPassword, String confirmPassword) throws InterruptedException {
        driver.navigate().to("http://localhost:9999/AnimeWeb_HE181309_SWT/profile");
        Thread.sleep(2000);

        WebElement oldPasswordField = driver.findElement(By.name("Opass"));
        WebElement newPasswordField = driver.findElement(By.name("Npass"));
        WebElement confirmPasswordField = driver.findElement(By.name("Cpass"));
        WebElement changePasswordButton = driver.findElement(By.className("site-btn"));

        if (!oldPassword.isEmpty()) {
            oldPasswordField.sendKeys(oldPassword);
        }
        if (!newPassword.isEmpty()) {
            newPasswordField.sendKeys(newPassword);
        }
        if (!confirmPassword.isEmpty()) {
            confirmPasswordField.sendKeys(confirmPassword);
        }
        changePasswordButton.click();
    }

    private void revertPassword(String oldPassword, String newPassword) throws InterruptedException {
        changePassword(oldPassword, newPassword, newPassword);
    }
}
