package dal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
        String file = "src\\deleteTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                boolean resultForDelete = videoDao.delete(row[0]);
                assertTrue(resultForDelete);
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
        String file = "src\\deleteTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                boolean resultForDelete = videoDao.delete(row[1]);
                assertFalse(resultForDelete);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

}
