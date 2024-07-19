package automation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class autoSignUp {

    WebDriver driver = new EdgeDriver();
    Actions actions = new Actions(driver);
    String file = "src\\test\\BuiTuanMinh\\AutoSignUpUserTestCase.csv";
    BufferedReader reader = null;
    String line, expected = "", actual = "";

    public String runningSignUpPage(String accountId, String email, String name, String password, String confirmPassword, String url) throws InterruptedException {
        driver.navigate().to(url);
        actions.scrollByAmount(0, 450).build().perform();
        Thread.sleep(200);
        WebElement accountIdField = driver.findElement(By.name("id")); // Adjust if necessary
        accountIdField.sendKeys(accountId);
        Thread.sleep(200);
        WebElement emailField = driver.findElement(By.name("email")); // Adjust if necessary
        emailField.sendKeys(email);
        Thread.sleep(200);
        WebElement nameField = driver.findElement(By.name("fullname")); // Adjust if necessary
        nameField.sendKeys(name);
        Thread.sleep(200);
        WebElement passwordField = driver.findElement(By.name("Npass")); // Adjust if necessary
        passwordField.sendKeys(password);
        Thread.sleep(200);
        WebElement confirmPasswordField = driver.findElement(By.name("Cpass")); // Adjust if necessary
        confirmPasswordField.sendKeys(confirmPassword);
        Thread.sleep(200);
        WebElement button = driver.findElement(By.className("site-btn"));
        button.click();
        actions.scrollByAmount(0, 450).build().perform();
        WebElement actualResult = driver.findElement(By.id("result")); // Adjust if necessary
        String result = actualResult.getText();
        Thread.sleep(1000);
        driver.quit();
        return result;
    }

    public void SignUpUserTest(String input) throws InterruptedException, IOException {
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals(input)) {
                    actual = runningSignUpPage(row[1], row[2], row[3], row[4], row[5], "http://localhost:8080/AnimeWeb_HE181309_SWT/register");
                    expected = row[6].trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testSignUpUserValid() throws InterruptedException, IOException {
        SignUpUserTest("SignUp-1");
    }

    @Test
    public void testSignUpUserEmptyAccountId() throws InterruptedException, IOException {
        SignUpUserTest("SignUp-2");
    }

    @Test
    public void testSignUpUserSpecialIDChar() throws InterruptedException, IOException {
        SignUpUserTest("SignUp-3");
    }

    @Test
    public void testSignUpUserIDMoreThan255() throws InterruptedException, IOException {
        SignUpUserTest("SignUp-4");
    }

    @Test
    public void testSignUpUserPasswordBlank() throws InterruptedException, IOException {
        SignUpUserTest("SignUp-5");
    }

    @Test
    public void testSignUpUserLongPassword() throws InterruptedException, IOException {
        SignUpUserTest("SignUp-6");
    }

    @Test
    public void testSignUpUserEmptyName() throws InterruptedException, IOException {
        SignUpUserTest("SignUp-7");
    }

    @Test
    public void testSignUpUserSpecialCharsName() throws InterruptedException, IOException {
        SignUpUserTest("SignUp-8");
    }

    @Test
    public void testSignUpUserLongName() throws InterruptedException, IOException {
        SignUpUserTest("SignUp-9");
    }

    @Test
    public void testSignUpUserEmptyCPassword() throws InterruptedException, IOException {
        SignUpUserTest("SignUp-10");
    }

    @Test
    public void testSignUpUserMismatchedPasswords() throws InterruptedException, IOException {
        SignUpUserTest("SignUp-11");
    }

    @Test
    public void testSignUpUserEmptyEmail() throws InterruptedException, IOException {
        SignUpUserTest("SignUp-12");
    }

    @Test
    public void testSignUpUserInvalidEmailFormat() throws InterruptedException, IOException {
        SignUpUserTest("SignUp-13");
    }

    @Test
    public void testSignUpUserLongEmail() throws InterruptedException, IOException {
        SignUpUserTest("SignUp-14");
    }
    @Test
    public void testSignUpUserExistedAcc() throws InterruptedException, IOException {
        SignUpUserTest("SignUp-15");
    }
}
