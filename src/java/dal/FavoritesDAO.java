package dal;

import model.Favorites;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Video;

public class FavoritesDAO extends DBContext {

    public int findByUserAndVideo(String userId, String videoId) {
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
    }
    
    public List<Video> findByUser(String userId) {
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
    }
    
    public void insert(Favorites s){
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
    }
    
    public void delete(int Favorite) {
        String sql = "DELETE FROM [dbo].[Favorite]\n"
                + "WHERE [id] = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Favorite);
            st.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        FavoritesDAO fd= new FavoritesDAO();
//        fd.delete(11);
        Favorites f = new Favorites("user1", "2");
        System.out.println(f);
        fd.insert(f);
        System.out.println(fd.findByUserAndVideo("user1", "1"));
        System.out.println(fd.findByUser("user1").get(0).getTitle());
    }
}
