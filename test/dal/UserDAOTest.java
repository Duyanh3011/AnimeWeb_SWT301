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

                    if (row[2].equals("null")) {
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

                    if (row[2].equals("null")) {
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

                    if (row[2].equals("null")) {
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
                    int result = userDao.delete((row[1].equals("null")) ? null : row[1]);
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
    public void testUpdateInfoValid() throws IOException {
        var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\updateTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 1")) {
                    int u = userDao.updateInfo(row[1], row[2], row[3]);
                    System.out.println(Arrays.toString(row));
                    System.out.println(u);

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
                    int u = userDao.updateInfo(row[1], row[2], row[3]);
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

    public void testUpdateInfoInvalNull(int cas) throws IOException {
        var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\updateTestCase.csv";
        BufferedReader reader = null;
        String line;

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case " + cas)) {
//                    System.out.println(cas);

                    for (int i = 1; i <= 3; i++) {
                        if (row[i].equals("null")) {
                            row[i] = null;
                        }
                    }

                    int u = userDao.updateInfo(row[1], row[2], row[3]);
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

    @Test
    public void testUpdateInfoEmailFormat() throws IOException {
        testUpdateInfoInvalid(2);
    }

    @Test
    public void testUpdateInfoEmailNull() throws IOException {
        testUpdateInfoInvalNull(3);
    }

    @Test
    public void testUpdateInfoEmailBlank() throws IOException {
        testUpdateInfoInvalid(4);
    }

    @Test
    public void testUpdateInfoNameNull() throws IOException {
        testUpdateInfoInvalNull(5);
    }

    @Test
    public void testUpdateInfoNameBlank() throws IOException {
        testUpdateInfoInvalid(6);
    }

    @Test
    public void testUpdateInfoEmailExceed() throws IOException {
        testUpdateInfoInvalid(7);
    }

    @Test
    public void testUpdateInfoNameExceed() throws IOException {
        testUpdateInfoInvalid(8);
    }

    @Test
    public void testUpdateInfoInvalIDNotFound() throws IOException {
        testUpdateInfoInvalid(9);

    }

    @Test
    public void testUpdateInfoInvalIDNull() throws IOException {
        testUpdateInfoInvalNull(10);
    }

    @Test
    public void testUpdateInfoInvalIDBlank() throws IOException {
        testUpdateInfoInvalid(11);
    }

    @Test
    public void testInsert() {
    }

    @Test
    public void testInsertValid() throws IOException {
        var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\insertTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 1")) {
                    Users u = new Users(row[1], row[4], row[3], row[2], row[5].equals("True"));
                    int res = userDao.insert(u);
//                    System.out.println(Arrays.toString(row));
                    System.out.println(u.toString());
                    System.out.println(res);

                    assertTrue(res == Integer.parseInt(row[6]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    public void testInsertInvalid(int cas) throws IOException {
        var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\insertTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case " + cas) ) {
                    Users u = new Users(row[1], row[4], row[3], row[2], row[5].equals("True"));
                    int res = userDao.insert(u);
                    System.out.println(Arrays.toString(row));
                    System.out.println(u.toString());
                    System.out.println(res);

                    assertTrue(res == Integer.parseInt(row[6]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
    public void testInsertInvalNull(int cas) throws IOException {
        var userDao = new UserDAO();
        String file = "src\\test\\DuyAnh\\insertTestCase.csv";
        BufferedReader reader = null;
        String line;

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case " + cas)) {
//                    System.out.println(cas);

                    for (int i = 1; i <= 4; i++) {
                        if (row[i].equals("null")) {
                            row[i] = null;
                        }
                    }

                    Users u = new Users(row[1], row[4], row[3], row[2], row[5]==null?null:(row[5].equals("True")));
                    int res = userDao.insert(u);
//                    System.out.println(Arrays.toString(row));
                    System.out.println(u.toString());
                    System.out.println(res);

                    assertTrue(res == Integer.parseInt(row[6]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testInsertIdNull() throws IOException {
        testInsertInvalNull(2);
    }
    @Test
    public void testInsertIdBlank() throws IOException {
        testInsertInvalid(3);
    }
    @Test
    public void testInsertIdExceed() throws IOException {
        testInsertInvalid(4);
    }
    
    @Test
    public void testInsertEmailFormat() throws IOException {
        testInsertInvalid(5);
    }
    @Test
    public void testInsertEmailNull() throws IOException {
        testInsertInvalNull(6);
    }
    @Test
    public void testInsertEmailBlank() throws IOException {
        testInsertInvalid(7);
    }
    @Test
    public void testInsertEmailExceed() throws IOException {
        testInsertInvalid(8);
    }
    
    @Test
    public void testInsertNameNull() throws IOException {
        testInsertInvalNull(9);
    }
    @Test
    public void testInsertNameBlank() throws IOException {
        testInsertInvalid(10);
    }
    @Test
    public void testInsertNameExceed() throws IOException {
        testInsertInvalid(11);
    }
    
    @Test
    public void testInsertPasswordNull() throws IOException {
        testInsertInvalNull(12);
    }
    @Test
    public void testInsertPasswordBlank() throws IOException {
        testInsertInvalid(13);
    }
    @Test
    public void testInsertPasswordExceed() throws IOException {
        testInsertInvalid(14);
    }
    
    @Test
    public void testInsertAdminNull() throws IOException {
        testInsertInvalNull(15);
    }
    
    @Test
    public void testInsertIdExisted() throws IOException {
        testInsertInvalNull(16);
    }
}
