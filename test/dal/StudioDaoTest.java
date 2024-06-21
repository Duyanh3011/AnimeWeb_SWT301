package dal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author manht
 */
public class StudioDaoTest {

    public StudioDaoTest() {
    }

    @Test
    public void testGetAll() {
    }

    @Test
    public void testGetStudioByID() {
    }

    @Test
    public void testInsert() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testDeleteValid() throws IOException {
        var studioDao = new StudioDao();
        String file = "src\\test\\NguyenManhTung\\deleteTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 1")) {
                    String resultForDelete = studioDao.delete(row[1]);
                    System.out.println("Actual result: '" + resultForDelete + "'");
                    String expectedResult = row[2].trim(); // Trimming in case of extra spaces

                    assertEquals(expectedResult, resultForDelete);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    @Test
    public void testDeleteInvalid() throws IOException {
        var studioDao = new StudioDao();
        String file = "src\\test\\NguyenManhTung\\deleteTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 2")) {
                    String resultForDelete = studioDao.delete(row[1]);
                    System.out.println(row[1]);
                    System.out.println(resultForDelete);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

    }

    @Test
    public void testDeletefalse() throws IOException {
        var studioDao = new StudioDao();
        String file = "src\\test\\NguyenManhTung\\deleteTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 3")) {
                    String resultForDelete = studioDao.delete(row[1]);
                    boolean actualResult = Boolean.parseBoolean(resultForDelete);
                    boolean expected = Boolean.parseBoolean(row[2]);
                    assertEquals(expected, actualResult, "Deleted Successfully");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

    }

    @Test
    public void testMostStudio() {
    }

    @Test
    public void testMostStudioName() {
    }

    @Test
    public void testMain() {
    }

}
