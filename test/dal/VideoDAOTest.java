package dal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import model.Video;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author acer
 */
public class VideoDAOTest {

    public VideoDAOTest() {
    }

    @Test
    public void testFindVideoValid() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\findVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 1")) {
                    Video actual = videoDao.findByID(row[1]);
                    String expected = row[2];
                    assertTrue(expected.equals(actual.toString()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testFindVideoInvalidID() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\findVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 2")) {
                    Video actual = videoDao.findByID(row[1]);
                    assertNull(actual);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testFindVideoSQLException() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\findVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 3")) {
                    Video actual = videoDao.findByID(row[1]);
                    assertNull(actual);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testFindVideoIDEmpty() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\findVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 4")) {
                    Video actual = videoDao.findByID(row[1]);
                    assertNull(actual);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testInsertVideoValid() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\insertVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 1")) {
                    var video = new Video(row[1], row[2], row[3], Integer.parseInt(row[4]), row[5], row[6], Integer.parseInt(row[7]), Integer.parseInt(row[8]), Integer.parseInt(row[9]));
                    String actual = videoDao.insert(video);
                    String expected = row[10];
                    assertTrue(actual.equals(expected));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testInsertVideoInvalidID() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\insertVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 2")) {
                    var video = new Video(row[1], row[2], row[3], Integer.parseInt(row[4]), row[5], row[6], Integer.parseInt(row[7]), Integer.parseInt(row[8]), Integer.parseInt(row[9]));
                    String actual = videoDao.insert(video);
                    String expected = row[10];
                    assertTrue(actual.equals(expected));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testInsertVideoSQLException() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\insertVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 3")) {
                    var video = new Video(row[1], row[2], row[3], Integer.parseInt(row[4]), row[5], row[6], Integer.parseInt(row[7]), Integer.parseInt(row[8]), Integer.parseInt(row[9]));
                    String actual = videoDao.insert(video);
                    String expected = row[10];
                    assertTrue(actual.equals(expected));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testInsertVideoNumberFormatException() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\insertVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 4")) {
                    var video = new Video(row[1], row[2], row[3], Integer.parseInt(row[4]), row[5], row[6], Integer.parseInt(row[7]), Integer.parseInt(row[8]), Integer.parseInt(row[9]));
                    String actual = videoDao.insert(video);
                    String expected = row[10];
                    assertTrue(actual.equals(expected));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testInsertVideoIDEmpty() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\insertVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 5")) {
                    var video = new Video(row[1], row[2], row[3], Integer.parseInt(row[4]), row[5], row[6], Integer.parseInt(row[7]), Integer.parseInt(row[8]), Integer.parseInt(row[9]));
                    String actual = videoDao.insert(video);
                    String expected = row[10];
                    assertTrue(actual.equals(expected));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testUpdateVideoValid() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\updateVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 1")) {
                    var video = new Video(row[1], row[2], row[3], Integer.parseInt(row[4]), row[5], row[6], Integer.parseInt(row[7]), Integer.parseInt(row[8]), Integer.parseInt(row[9]));
                    String actual = videoDao.update(video);
                    String expected = row[10];
                    assertTrue(actual.equals(expected));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testUpdateVideoInvalidID() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\updateVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 2")) {
                    var video = new Video(row[1], row[2], row[3], Integer.parseInt(row[4]), row[5], row[6], Integer.parseInt(row[7]), Integer.parseInt(row[8]), Integer.parseInt(row[9]));
                    String actual = videoDao.update(video);
                    String expected = row[10];
                    assertTrue(actual.equals(expected));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testUpdateVideoSQLException() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\updateVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 3")) {
                    var video = new Video(row[1], row[2], row[3], Integer.parseInt(row[4]), row[5], row[6], Integer.parseInt(row[7]), Integer.parseInt(row[8]), Integer.parseInt(row[9]));
                    String actual = videoDao.update(video);
                    String expected = row[10];
                    assertTrue(actual.equals(expected));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testUpdateVideoNumberFormatException() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\updateVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 4")) {
                    var video = new Video(row[1], row[2], row[3], Integer.parseInt(row[4]), row[5], row[6], Integer.parseInt(row[7]), Integer.parseInt(row[8]), Integer.parseInt(row[9]));
                    assertThrows(NumberFormatException.class,
                            () -> {
                                videoDao.update(video);
                            });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testUpdateVideoIDEmpty() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\updateVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 5")) {
                    var video = new Video(row[1], row[2], row[3], Integer.parseInt(row[4]), row[5], row[6], Integer.parseInt(row[7]), Integer.parseInt(row[8]), Integer.parseInt(row[9]));
                    String actual = videoDao.update(video);
                    String expected = row[10];
                    assertTrue(actual.equals(expected));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testDeleteVideoValid() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\deleteVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 1")) {
                    String actual = videoDao.delete(row[1]);
                    String expected = row[2];
                    assertTrue(actual.equals(expected));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testDeleteVideoInvalidID() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\deleteVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 2")) {
                    String actual = videoDao.delete(row[1]);
                    String expected = row[2];
                    assertTrue(actual.equals(expected));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testDeleteVideoInvalidNumber() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\deleteVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 3")) {
                    String actual = videoDao.delete(row[1]);
                    String expected = row[2];
                    assertTrue(actual.equals(expected));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testDeleteVideoInvalidIDEmpty() throws IOException {
        var videoDao = new VideoDAO();
        String file = "src\\test\\LeAnhDuc\\deleteVideoTestCase.csv";
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals("Case 4")) {
                    String actual = videoDao.delete(row[1]);
                    String expected = row[2];
                    assertTrue(actual.equals(expected));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

}
