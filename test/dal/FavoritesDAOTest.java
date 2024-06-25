/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import model.Favorites;
import model.Video;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author minhb
 */
public class FavoritesDAOTest {
    
    public FavoritesDAOTest() {
    }

    @Test
    public void testUpdate() throws IOException {
        var favoritesDao = new FavoritesDAO();
        String file = "src/test/BuiTuanMinh/updateTestCase.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 1")) {
                    Favorites favorites = new Favorites(Integer.parseInt(row[1]), row[2], row[3]);
                    boolean result = favoritesDao.update(favorites);
                    boolean expected = Boolean.parseBoolean(row[4]);
                    assertEquals(expected, result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindByUser() throws IOException {
        var favoritesDao = new FavoritesDAO();
        String file = "src/test/BuiTuanMinh/findByUserTestCase.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 3")) {
                    List<Video> videos = favoritesDao.findByUser(row[1]);
                    assertEquals(Integer.parseInt(row[2]), videos.size());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() throws IOException {
        var favoritesDao = new FavoritesDAO();
        String file = "src\\test\\BuiTuanMinh\\insertTestCase.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 2")) {
                    Favorites favorites = new Favorites(row[1], row[2]);
                    favoritesDao.insert(favorites);
                    // Optionally, assert the result if needed
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runDeleteTest(String caseType) throws IOException {
        var favoritesDao = new FavoritesDAO();
        String file = "src\\test\\BuiTuanMinh\\deleteTestCase.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals(caseType)) {
                    boolean resultForDelete = false;
                    try {
                        resultForDelete = favoritesDao.delete(Integer.parseInt(row[1]));
                    } catch (NumberFormatException e) {
                        // Handle case where ID is not a valid integer
                        System.out.println("Invalid ID format: " + row[1]);
                    }
                    boolean expected = Boolean.parseBoolean(row[2]);
                    assertTrue(resultForDelete == expected, "Test failed for " + caseType + ": " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteValid() throws IOException {
        runDeleteTest("Case 1");
    }

    @Test
    public void testDeleteInvalid() throws IOException {
        runDeleteTest("Case 2");
    }
    
    @Test
    public void testDeleteInvalidFormat() throws IOException {
        runDeleteTest("Case 3");
    }

    
}
