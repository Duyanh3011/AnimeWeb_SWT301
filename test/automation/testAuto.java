package automation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class testAuto {

    WebDriver driver = new EdgeDriver();
    Actions actions = new Actions(driver);
    String file = "src\\test\\LeAnhDuc\\AutoInsertVideoTestCase.csv";
    BufferedReader reader = null;
    String line, expected = "", actual = "";

    public String runningAddPage(String id, String title, String poster, String views, String desc, String link, String year, String url) throws InterruptedException {
        driver.navigate().to(url);
        actions.scrollByAmount(0, 450).build().perform();
        Thread.sleep(200);
        WebElement videoID = driver.findElement(By.name("id"));
        videoID.sendKeys(id);
        Thread.sleep(200);
        WebElement videoTitle = driver.findElement(By.name("title"));
        videoTitle.sendKeys(title);
        Thread.sleep(200);
        WebElement videoPoster = driver.findElement(By.name("poster"));
        videoPoster.sendKeys(poster);
        Thread.sleep(200);
        WebElement videoView = driver.findElement(By.name("views"));
        videoView.sendKeys(views);
        Thread.sleep(200);
        WebElement videoDescription = driver.findElement(By.name("desc"));
        videoDescription.click();
        videoDescription.sendKeys(desc);
        Thread.sleep(200);
        WebElement videoLink = driver.findElement(By.name("link"));
        videoLink.sendKeys(link);
        Thread.sleep(200);
        WebElement videoYear = driver.findElement(By.name("year"));
        videoYear.sendKeys(year);
        Thread.sleep(200);
        WebElement button = driver.findElement(By.className("site-btn"));
        button.click();
        actions.scrollByAmount(0, 450).build().perform();
        WebElement actualResult = driver.findElement(By.id("result"));
        String result = actualResult.getText();
        Thread.sleep(1000);
        driver.quit();
        return result;
    }

    public void AddVideoTest(String input) throws InterruptedException, IOException {
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals(input)) {
                    actual = runningAddPage(row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8]);
                    expected = row[9].trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
            assertEquals(expected, actual);
        }
    }

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
    public void testAddVideoValid() throws InterruptedException, IOException {
        AddVideoTest("AddVid-1");
    }

    @Test
    public void testAddVideoIDEmpty() throws InterruptedException, IOException {
        AddVideoTest("AddVid-2");
    }

    @Test
    public void testAddVideoIDExisted() throws InterruptedException, IOException {
        AddVideoTest("AddVid-3");
    }

    @Test
    public void testAddVideoIDLetters() throws InterruptedException, IOException {
        AddVideoTest("AddVid-4");
    }

    @Test
    public void testAddVideoTitleEmpty() throws InterruptedException, IOException {
        AddVideoTest("AddVid-5");
    }

    @Test
    public void testAddVideoTitleSpecial() throws InterruptedException, IOException {
        AddVideoTest("AddVid-6");
    }

    @Test
    public void testAddVideoTitleBoundary() throws InterruptedException, IOException {
        AddVideoTest("AddVid-7");
    }

    @Test
    public void testAddVideoPosterEmpty() throws InterruptedException, IOException {
        AddVideoTest("AddVid-8");
    }

    @Test
    public void testAddVideoInvalidPosterFormat() throws InterruptedException, IOException {
        AddVideoTest("AddVid-9");
    }

    @Test
    public void testAddVideoPosterBoundary() throws InterruptedException, IOException {
        AddVideoTest("AddVid-10");
    }

    @Test
    public void testAddVideoViewsEmpty() throws InterruptedException, IOException {
        AddVideoTest("AddVid-11");
    }

    @Test
    public void testAddVideoViewsValueZero() throws InterruptedException, IOException {
        AddVideoTest("AddVid-12");
    }

    @Test
    public void testAddVideoViewsBoundary() throws InterruptedException, IOException {
        AddVideoTest("AddVid-13");
    }

    @Test
    public void testAddVideoViewsLetter() throws InterruptedException, IOException {
        AddVideoTest("AddVid-14");
    }

    @Test
    public void testAddVideoDescriptionEmpty() throws InterruptedException, IOException {
        AddVideoTest("AddVid-15");
    }

    @Test
    public void testAddVideoDescriptionSpecial() throws InterruptedException, IOException {
        AddVideoTest("AddVid-16");
    }

    @Test
    public void testAddVideoLinkEmpty() throws InterruptedException, IOException {
        AddVideoTest("AddVid-17");
    }

    @Test
    public void testAddVideoLinkInvalidFormat() throws InterruptedException, IOException {
        AddVideoTest("AddVid-18");
    }

    @Test
    public void testAddVideoLinkBoundary() throws InterruptedException, IOException {
        AddVideoTest("AddVid-19");
    }

    @Test
    public void testAddVideoYearEmpty() throws InterruptedException, IOException {
        AddVideoTest("AddVid-20");
    }

    @Test
    public void testAddVideoYearValueZero() throws InterruptedException, IOException {
        AddVideoTest("AddVid-21");
    }

    @Test
    public void testAddVideoYearBoundary() throws InterruptedException, IOException {
        AddVideoTest("AddVid-22");
    }

    @Test
    public void testAddVideoYearLetter() throws InterruptedException, IOException {
        AddVideoTest("AddVid-23");
    }

    @Test
    public void testAddVideoGenreInvalid() throws InterruptedException, IOException {
        AddVideoTest("AddVid-24");
    }

    @Test
    public void testAddVideoStudioInvalid() throws InterruptedException, IOException {
        AddVideoTest("AddVid-25");
    }

}
