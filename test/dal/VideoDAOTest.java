package dal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author acer
 */
public class VideoDAOTest {

    public VideoDAOTest() {
    }

    @Test
    public void testDeleteValid() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\deleteTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 1")) {
                    boolean resultForDelete = videoDao.delete(row[1]);
                    boolean expected = Boolean.parseBoolean(row[2]);
                    assertTrue(resultForDelete == expected, "Deleted Successfully");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testDeleteInvalid() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\deleteTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 2")) {
                    boolean resultForDelete = videoDao.delete(row[1]);
                    boolean expected = Boolean.parseBoolean(row[2]);
                    assertTrue(resultForDelete == expected, "Deleted Successfully");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testDeleteInvalidNumber() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\deleteTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 3")) {
                    boolean resultForDelete = videoDao.delete(row[1]);
                    boolean expected = Boolean.parseBoolean(row[2]);
                    assertTrue(resultForDelete == expected, "Deleted Successfully");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

}
