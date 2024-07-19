package automation;

import dal.VideoDAO;
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
import org.openqa.selenium.support.ui.Select;


public class UpdateVideoAutotest {

    WebDriver driver = new EdgeDriver();
    Actions actions = new Actions(driver);
    String file = "src\\test\\DuyAnh\\AutoUpdateVideoTestCase.csv";
    BufferedReader reader = null;
    String line, expected = "", actual = "";

    public void runningAddPage(String title, String poster, String views, String desc, String link, String year, String genre, String studio, String url) throws InterruptedException {
        driver.navigate().to(url);

        try {
            actions.scrollByAmount(0, 450).build().perform();
            Thread.sleep(200);

    //Title -> Year
            Thread.sleep(200);
            WebElement videoTitle = driver.findElement(By.name("title"));
            videoTitle.clear();
            videoTitle.sendKeys(title);
            Thread.sleep(200);
            WebElement videoPoster = driver.findElement(By.name("poster"));
            videoPoster.clear();
            videoPoster.sendKeys(poster);
            Thread.sleep(200);
            WebElement videoView = driver.findElement(By.name("views"));
            videoView.clear();
            videoView.sendKeys(views);
            Thread.sleep(200);
            WebElement videoDescription = driver.findElement(By.id("desc"));

    System.out.println("Found description field WebElement: " + videoDescription.getAccessibleName());
            videoDescription.clear();
            videoDescription.sendKeys(desc);
            Thread.sleep(200);
            WebElement videoLink = driver.findElement(By.name("link"));
            videoLink.clear();
            videoLink.sendKeys(link);
            Thread.sleep(200);
            WebElement videoYear = driver.findElement(By.name("year"));
            videoYear.clear();
            videoYear.sendKeys(year);
            Thread.sleep(200);
            
    //Select Genre - Studio
            
            Select selectGenre = new Select(driver.findElement(By.name("seleGenre")));
            selectGenre.selectByVisibleText(genre);
            Thread.sleep(200);

           Select selectStudio = new Select(driver.findElement(By.name("seleStudio")));
           selectStudio.selectByVisibleText(studio);
//           System.out.println("Selected Studio: " + selectStudio.getFirstSelectedOption().getText());
            Thread.sleep(200);

            WebElement button = driver.findElement(By.className("site-btn"));
            button.click();
            actions.scrollByAmount(0, 450).build().perform();
        } finally {
            Thread.sleep(1000);
            driver.quit();
        }

    }

    public void UpdateVideoTest(String input) throws InterruptedException, IOException {
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals(input)) {
                    System.out.println("row" + row[1]);
                    runningAddPage(row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9]);
                    expected = row[11].trim();
                    VideoDAO v = new VideoDAO();
                    actual = v.findByID(row[10]).toString();
                    System.out.println(actual);
                    System.out.println(expected);
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
        System.setProperty("webdriver.edge.driver", "\"D:\\1_Study\\A_Semester\\Summer2024\\SWT301\\Lab\\lab1\\msedgedriver.exe\"");
        driver.navigate().to("http://localhost:8080/AnimeWeb_HE181309_SWT/login");
        WebElement account = driver.findElement(By.name("user"));
        account.sendKeys("sa");
        WebElement password = driver.findElement(By.name("pass"));
        password.sendKeys("123");
        WebElement button = driver.findElement(By.className("site-btn"));
        button.click();
    }

//    @Test
//    public void testSelectAtuto() throws InterruptedException {
//        driver.navigate().to("http://localhost:8080/AnimeWeb_HE181309_SWT/categories");
//        Thread.sleep(2000);
////        assertEquals("Check", "Anime | Admin", driver.getTitle());
//            Select selectGenre = new Select(driver.findElement(By.id("g")));
//            System.out.println(   selectGenre.getFirstSelectedOption().getText());
//            selectGenre.selectByIndex(2);
//        driver.quit();
//    }
//
//    @Test
//    public void testAuto() throws InterruptedException {
//        driver.navigate().to("http://localhost:8080/AnimeWeb_HE181309_SWT/update?id=11 ");
//        Thread.sleep(2000);
//        assertEquals("Check", "Anime | Admin", driver.getTitle());
//        System.out.println(new VideoDAO().findByID("12").toString());
//        driver.quit();
//    }

    @Test
    public void testUV2() throws InterruptedException, IOException {
        UpdateVideoTest("UpdVid-2");
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
    public void testUV22() throws InterruptedException, IOException {
        UpdateVideoTest("UpdVid-22");
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
    public void testInputAllFieldValid() throws InterruptedException, IOException {
        UpdateVideoTest("UpdVid-1");
    }
    
 @Test
    public void testUV3() throws InterruptedException, IOException {
        UpdateVideoTest("UpdVid-3");
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
    public void testUV20() throws InterruptedException, IOException {
        UpdateVideoTest("UpdVid-20");
    }

    @Test
    public void testUV21() throws InterruptedException, IOException {
        UpdateVideoTest("UpdVid-21");
    }
}
