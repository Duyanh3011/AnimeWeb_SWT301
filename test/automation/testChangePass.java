package automation;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

    public String runChangePasswordTest(String oldPassword, String newPassword, String confirmPassword, String expectedOutcome) throws InterruptedException {
        driver.navigate().to("http://localhost:9999/AnimeWeb_HE181309_SWT/profile");
        Thread.sleep(2000);

        WebElement oldPasswordField = driver.findElement(By.name("Opass"));
        WebElement newPasswordField = driver.findElement(By.name("Npass"));
        WebElement confirmPasswordField = driver.findElement(By.name("Cpass"));
        WebElement changePasswordButton = driver.findElement(By.className("site-btn"));

        oldPasswordField.clear();
        newPasswordField.clear();
        confirmPasswordField.clear();

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
        Thread.sleep(1000);

        System.out.println(expectedOutcome);
        if (expectedOutcome.startsWith("URL: ")) {
                    System.out.println("xxxx");

            return "URL: " + driver.getCurrentUrl();
        } else {
                                System.out.println("yyyyy");

            WebElement messageElement;
            if (expectedOutcome.equals("Password is incorrect")) {
                messageElement = driver.findElement(By.id("fail1"));
            } else if (expectedOutcome.equals("Password is not matching")) {
                messageElement = driver.findElement(By.id("fail2"));
            } else {
                messageElement = driver.findElement(By.id("done"));
            }
            return messageElement.getText();
        }
    }

    public void revertPassword(String newPassword, String oldPassword) throws InterruptedException {
        runChangePasswordTest(newPassword, oldPassword, oldPassword, "Change password successful!!!");
    }

    public void ChangePasswordTest(String testCaseId) throws InterruptedException, IOException {
        String file = "src\\test\\NguyenManhTung\\changePasswordTestCase.csv";
        BufferedReader reader = null;
        String line, expected = "", actual = "";
        String oldPassword = "", newPassword = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals(testCaseId)) {
                    oldPassword = row[2];
                    newPassword = row[3];
                    expected = row[5].trim();
                    actual = runChangePasswordTest(oldPassword, newPassword, row[4], expected);

                    if (expected.equals("Change password successful!!!")) {
                        revertPassword(newPassword, oldPassword);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }

            if (expected.startsWith("URL: ")) {
                System.out.println(actual);
                System.out.println(expected);
                assertEquals(expected, actual);
                
            } else {
                assertEquals(expected, actual);
            }
            driver.quit();
        }
    }

    @Test
    public void testValidPasswordChange() throws InterruptedException, IOException {
        ChangePasswordTest("1");
    }

    @Test
    public void testSamePasswordChange() throws InterruptedException, IOException {
        ChangePasswordTest("2");
    }

    @Test
    public void testOneCharacterPasswordChange() throws InterruptedException, IOException {
        ChangePasswordTest("3");
    }

    @Test
    public void testVeryLongPasswordChange() throws InterruptedException, IOException {
        ChangePasswordTest("4");
    }

    @Test
    public void testSpecialCharacterPasswordChange() throws InterruptedException, IOException {
        ChangePasswordTest("5");
    }

    @Test
    public void testNoOldPassword() throws InterruptedException, IOException {
        ChangePasswordTest("6");
    }

    @Test
    public void testNoNewPassword() throws InterruptedException, IOException {
        ChangePasswordTest("7");
    }

    @Test
    public void testNoConfirmPassword() throws InterruptedException, IOException {
        ChangePasswordTest("8");
    }

    @Test
    public void testNoInformation() throws InterruptedException, IOException {
        ChangePasswordTest("9");
        
    }

    @Test
    public void testIncorrectOldPassword() throws InterruptedException, IOException {
        ChangePasswordTest("10");
    }

    @Test
    public void testIncorrectNewPassword() throws InterruptedException, IOException {
        ChangePasswordTest("11");
    }

    @Test
    public void testIncorrectConfirmPassword() throws InterruptedException, IOException {
        ChangePasswordTest("12");
    }
}
