package automation;

import dal.VideoDAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import model.Video;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UpdateVideoAutotest {

    WebDriver driver = new EdgeDriver();
    Actions actions = new Actions(driver);
    String file = "src\\test\\DuyAnh\\AutoUpdateVideoTestCase.csv";

    BufferedReader reader = null;
    String line, expected = "", actual = "";
    Video vidOld;

    public void runningAddPage(String title, String poster, String views, String desc, String link, String year, String genre, String studio, String url) throws InterruptedException {
        driver.navigate().to(url);

        try {
            actions.scrollByAmount(0, 450).build().perform();

            //Title -> Year
            WebElement videoTitle = driver.findElement(By.name("title"));
            videoTitle.clear();
            videoTitle.sendKeys(title);

            WebElement videoPoster = driver.findElement(By.name("poster"));
            videoPoster.clear();
            videoPoster.sendKeys(poster);

            WebElement videoView = driver.findElement(By.name("views"));
            videoView.clear();
            videoView.sendKeys(views);

            WebElement videoDescription = driver.findElement(By.id("desc"));

//    System.out.println("Found description field WebElement: " + videoDescription.getAccessibleName());
            videoDescription.clear();
            videoDescription.sendKeys(desc);

            WebElement videoLink = driver.findElement(By.name("link"));
            videoLink.clear();
            videoLink.sendKeys(link);

            WebElement videoYear = driver.findElement(By.name("year"));
            videoYear.clear();
            videoYear.sendKeys(year);

            //Select Genre - Studio
            Select selectGenre = new Select(driver.findElement(By.name("seleGenre")));
            selectGenre.selectByVisibleText(genre);

            Select selectStudio = new Select(driver.findElement(By.name("seleStudio")));
            selectStudio.selectByVisibleText(studio);
//           System.out.println("Selected Studio: " + selectStudio.getFirstSelectedOption().getText());

            WebElement button = driver.findElement(By.className("site-btn"));
            button.click();
            actions.scrollByAmount(0, 450).build().perform();
        } finally {
            driver.quit();
        }

    }

    public void UpdateVideoTest(String input) throws InterruptedException, IOException {
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals(input)) {
//                    System.out.println("row" + row[1]);
                    runningAddPage(row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9]);
                    expected = row[11].trim();
                    VideoDAO v = new VideoDAO();
                    actual = v.findByID(row[10]).toString();
//                    System.out.println(actual);
//                    System.out.println(expected);
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            assertEquals(expected, actual);
        }
    }

    private Video SetOldData(String input) {
        Video v = new Video();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals(input)) {
                    VideoDAO vd = new VideoDAO();
                    v = vd.findByID(row[10]);
                    vidOld = v;
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            assertEquals(expected, actual);
        }
        return v;
    }

    private void revertData() throws InterruptedException {
        VideoDAO v = new VideoDAO();
        v.update(vidOld);
        System.out.println("VIdold Revert: " + vidOld.toString());

    }

    @Before
    public void Setup() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "D:\\1_Study\\A_Semester\\Summer2024\\SWT301\\Lab\\lab1\\msedgedriver.exe");
        driver.navigate().to("http://localhost:8080/AnimeWeb_HE181309_SWT/login");
        WebElement account = driver.findElement(By.name("user"));
        account.sendKeys("sa");
        WebElement password = driver.findElement(By.name("pass"));
        password.sendKeys("123");
        WebElement button = driver.findElement(By.className("site-btn"));
        button.click();
        SetOldData("UpdVid-1");
        System.out.println("Before: " + SetOldData("UpdVid-1").toString());
    }

    @After
    public void tearDown() throws InterruptedException {
        System.out.println("2");
        revertData();
        driver.quit();
    }

    @Test
    public void testInputAllFieldValid() throws InterruptedException, IOException {
        System.out.println("11111111111");
        UpdateVideoTest("UpdVid-1");
    }

    @Test
    public void testUV2() throws InterruptedException, IOException {
        System.out.println("22222");
        UpdateVideoTest("UpdVid-2");

    }

    @Test
    public void testUV3() throws InterruptedException, IOException {
        System.out.println("3333333");
        UpdateVideoTest("UpdVid-3");
    }

    @Test
    public void testUV4() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-4");

    }

    @Test
    public void testUV5() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-5");

    }

    @Test
    public void testUV6() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-6");

    }

    @Test
    public void testUV7() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-7");

    }

    @Test
    public void testUV8() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-8");

    }

    @Test
    public void testUV11() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-11");

    }

    @Test
    public void testUV12() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-12");

    }

    @Test
    public void testUV13() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-13");

    }

    @Test
    public void testUV14() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-14");

    }

    @Test
    public void testUV16() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-16");

    }

    @Test
    public void testUV17() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-17");

    }

    @Test
    public void testUV18() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-18");

    }

    @Test
    public void testUV19() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-19");

    }

    @Test
    public void testUV20() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-20");

    }

    @Test
    public void testUV23() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-23");

    }

    @Test
    public void testUV24() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-24");

    }

    @Test
    public void testUV25() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-25");

    }

    @Test
    public void testUV26() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-26");

    }

    @Test
    public void testUV27() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-27");

    }

    @Test
    public void testUV9() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-9");

    }

    @Test
    public void testUV10() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-10");

    }

    @Test
    public void testUV15() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-15");

    }

    @Test
    public void testUV21() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-21");

    }

    @Test
    public void testUV22() throws InterruptedException, IOException {

        UpdateVideoTest("UpdVid-22");

    }

}
