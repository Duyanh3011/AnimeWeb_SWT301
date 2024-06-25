package dal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import model.Users;
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
    public void testCheckUserValid() throws IOException {
        var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\viewTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 1")) {
                    Users u = userDao.checkUser(row[1]);
//                    System.out.println(row[1]);
//                    System.out.println(u.toString());
  
                    assertTrue(u.toString().equals(row[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
    @Test
    public void testCheckUserInvalidNotFound() throws IOException {
       var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\viewTestCase.csv";
        BufferedReader reader = null;
        String line;
        Users test = new Users("", "", "", "", null);

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 2")) {
                    Users u = userDao.checkUser(row[1]);
//                    System.out.println(te);
//                    System.out.println(u.toString());

                    if (row[2].equals("null")) 
                    {
                        test = null;
                    }
                    assertEquals(u, test);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

      @Test
    public void testCheckUserInvalidBlank() throws IOException {
       var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\viewTestCase.csv";
        BufferedReader reader = null;
        String line;
        Users test = new Users("", "", "", "", null);

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 3")) {
                    Users u = userDao.checkUser(row[1]);
//                    System.out.println(te);
//                    System.out.println(u.toString());

                    if (row[2].equals("null")) 
                    {
                        test = null;
                    }
                    assertEquals(u, test);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
    
      @Test
    public void testCheckUserInvalidNull() throws IOException {
       var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\viewTestCase.csv";
        BufferedReader reader = null;
        String line;
        Users test = new Users("", "", "", "", null);

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 2")) {
                    Users u = userDao.checkUser(row[1]);
//                    System.out.println(te);
//                    System.out.println(u.toString());

                    if (row[2].equals("null")) 
                    {
                        test = null;
                    }
                    assertEquals(u, test);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
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
                    int result = userDao.delete(row[1]);
//                    System.out.println(row[1]);
//                    System.out.println(result);
                    assertTrue(result >= Integer.parseInt(row[2]));
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
                    int result = userDao.delete(row[1]);
//                    System.out.println(row[1]);
//                        System.out.println(result);
                    assertTrue(result == Integer.parseInt(row[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

      @Test
    public void testDeleteUserInvalidBlank() throws IOException {
        var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\deleteTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 3")) {
                    int result = userDao.delete(row[1]);
//                    System.out.println(row[2]);
//                        System.out.println(result);
                    assertTrue(result == Integer.parseInt(row[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
    
      @Test
    public void testDeleteUserInvalidNull() throws IOException {
        var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\deleteTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 4")) {
                    int result = userDao.delete((row[1].equals("null"))?null:row[1]);
    //                    System.out.println(row[2]);
    //                        System.out.println(result);
                    assertTrue(result == Integer.parseInt(row[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
    
  
    
    @Test
    public void testUpdateInfoValid() throws IOException{
        var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\updateTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 1" )) {
                    int u = userDao.updateInfo(row[1],row[2],row[3]);
//                    System.out.println(Arrays.toString(row));
//                    System.out.println(u);
  
                    assertTrue(u == Integer.parseInt(row[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
  
    public void testUpdateInfoInvalid(int cas) throws IOException {
        var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\updateTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case " + cas)) {
                    int u = userDao.updateInfo(row[1],row[2],row[3]);
//                    System.out.println(row[3]);
//                    System.out.println(u);
  
                    assertTrue(u == Integer.parseInt(row[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
    
    @Test
    public void testUpdateInfoEmailErr() throws IOException{
        testUpdateInfoInvalid(2);
    }
    @Test
    public void testUpdateInfoInvalidInfoNull() throws IOException{
        testUpdateInfoInvalid(3);
    }
    @Test
    public void testUpdateInfoInvalidInfoBlank() throws IOException{
        testUpdateInfoInvalid(4);
    }
    @Test
    public void testUpdateInfoInvalIDNotFound() throws IOException{
        testUpdateInfoInvalid(5);
    }
    @Test
    public void testUpdateInfoInvalIDBlank() throws IOException{
        testUpdateInfoInvalid(7);
    } 
    @Test
    public void testUpdateInfoInvalIDNull() throws IOException  {
       var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\viewTestCase.csv";
        BufferedReader reader = null;
        String line;

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 5")) {
                    if (row[2].equals("null")) {
                        row[2] = null;
                    }
                    if (row[3].equals("null")) {
                        row[3] = null;
                    }

                    int u = userDao.updateInfo(row[1], row[2], row[3]);
                    System.out.println(Arrays.toString(row));
//                    System.out.println(u.toString());

                    assertTrue(u == Integer.parseInt(row[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testInsert() {
    }
    
    public void testInsertInvalid(int cas) throws IOException {
        var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\updateTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case " + cas)) {
                    int u = userDao.updateInfo(row[1],row[2],row[3]);
//                    System.out.println(row[3]);
//                    System.out.println(u);
  
                    assertTrue(u == Integer.parseInt(row[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
    
}
