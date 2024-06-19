package dal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DuyAnhComputer
 */
public class UserDAOTest {
    
    public UserDAOTest() {
    }

    @Test
    public void testGetAll() {
    }

    @Test
    public void testCheckUserPass() {
    }

    @Test
    public void testCheckUser() {
    }

    @Test
    public void testInsert() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testDeleteUserValid() throws IOException {
        var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\deleteTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 1")) {
                    String resultForDelete = userDao.delete(row[1]);
                        
                    assertTrue(resultForDelete.equals(row[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
    @Test
    public void testDeleteUserInvalidNotFound() throws IOException {
        var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\deleteTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 2")) {
                    String resultForDelete = userDao.delete(row[1]);
                    System.out.println(row[1]);
                        System.out.println(resultForDelete);
//                    assertTrue(resultForDelete.equals(row[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testUpdateInfo() {
    }

    @Test
    public void testTotalUsers() {
    }

    @Test
    public void testMain() {
    }
    
}
