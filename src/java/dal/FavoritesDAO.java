package dal;

import model.Favorites;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Video;

public class FavoritesDAO extends DBContext {

    /*public int findByUserAndVideo(String userId, String videoId) {
    List<Favorites> list = new ArrayList<>();
    String sql = "select DISTINCT id from Favorite f\n" +
    "where f.UserId like ? and f.videoId like ?";
    
    try {
    PreparedStatement st = connection.prepareStatement(sql);
    st.setString(1, userId);
    st.setString(2, videoId);
    ResultSet rs = st.executeQuery();
    if (rs.next()) {
    return rs.getInt("id");
    }
    
    } catch (SQLException e) {
    System.out.println(e);
    }
    return -1;
    }*/
    public int findByUserAndVideo(String userId, String videoId) {
    String sql = "select DISTINCT id from Favorite f\n" +
                "where f.UserId like ? and f.videoId like ?";

    try (PreparedStatement st = connection.prepareStatement(sql)) {
        st.setString(1, userId);
        st.setString(2, videoId);
        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
    } catch (SQLException e) {
        System.out.println(e);
    }
    return -1;
}

    /*public List<Video> findByUser(String userId) {
    List<Video> list = new ArrayList<>();
    String sql = "select * from Video\n"
    + "	where id in \n"
    + "	(select DISTINCT videoId from Favorite f where f.UserId like ?)";
    
    try {
    PreparedStatement st = connection.prepareStatement(sql);
    st.setString(1, userId);
    ResultSet rs = st.executeQuery();
    while (rs.next()) {
    Video ad = new Video(rs.getString("id"), rs.getString("title"), rs.getString("poster"), rs.getInt("views"), rs.getString("description"), rs.getString("link"), rs.getInt("year"), rs.getInt("genreId"), rs.getInt("studioID"));
    list.add(ad);
    }
    
    } catch (SQLException e) {
    System.out.println(e);
    }
    return list;
    }*/
    public List<Video> findByUser(String userId) {
    List<Video> list = new ArrayList<>();
    String sql = "select * from Video\n"
            + "    where id in \n"
            + "    (select DISTINCT videoId from Favorite f where f.UserId like ?)";

    try (PreparedStatement st = connection.prepareStatement(sql)) {
        st.setString(1, userId);
        try (ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Video ad = new Video(rs.getString("id"), rs.getString("title"), rs.getString("poster"), rs.getInt("views"), rs.getString("description"), rs.getString("link"), rs.getInt("year"), rs.getInt("genreId"), rs.getInt("studioID"));
                list.add(ad);
            }
        }
    } catch (SQLException e) {
        System.out.println(e);
    }
    return list;
}

    /*public void insert(Favorites s){
    String sql = "INSERT INTO Favorite (videoId, UserId) \n"
    + "VALUES \n"
    + "(?, ?)";
    
    try {
    PreparedStatement st = connection.prepareStatement(sql);
    st.setString(2, s.getUserId());
    st.setInt(1, Integer.parseInt(s.getVideoId()));
    
    st.executeUpdate();
    
    } catch (Exception e) {
    }
    }*/
    public void insert(Favorites s)throws SQLException {
    String sql = "INSERT INTO Favorite (videoId, UserId) \n"
            + "VALUES \n"
            + "(?, ?)";

    try (PreparedStatement st = connection.prepareStatement(sql)) {
        st.setString(2, s.getUserId());
        st.setInt(1, Integer.parseInt(s.getVideoId()));
        st.executeUpdate();
    } catch (RuntimeException e) {
        throw e;
    } catch (Exception e) {
        System.out.println(e);
    }
}

    /* public void delete(int Favorite) {
    String sql = "DELETE FROM [dbo].[Favorite]\n"
    + "WHERE [id] = ?";
    
    try {
    PreparedStatement st = connection.prepareStatement(sql);
    st.setInt(1, Favorite);
    st.executeUpdate();
    
    } catch (Exception e) {
    }
    }*/
    public boolean delete(int favoriteId) {
    String sql = "DELETE FROM [dbo].[Favorite]\n"
            + "WHERE [id] = ?";

    try (PreparedStatement st = connection.prepareStatement(sql)) {
        st.setInt(1, favoriteId);
        st.executeUpdate();
    } catch (Exception e) {
        System.out.println(e);
    }
    return false;
}
    public boolean update(Favorites favorites) {
        String sql = "UPDATE Favorite SET videoId = ?, UserId = ? WHERE id = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, favorites.getVideoId());
            st.setString(2, favorites.getUserId());
            st.setInt(3, favorites.getId());

            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    public static void main(String[] args) {
        FavoritesDAO fd= new FavoritesDAO();
//        fd.delete(11);
        Favorites f = new Favorites("user1", "2");
        System.out.println(f);
       
        System.out.println(fd.findByUserAndVideo("user1", "1"));
        System.out.println(fd.findByUser("user1").get(0).getTitle());
    }
}
