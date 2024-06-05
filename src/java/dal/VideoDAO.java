package dal;
import java.util.List;

import model.Users;
import model.Video;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VideoDAO extends DBContext {
    static String check;
//Find list vide 
    public List<Video> findPage(int n) {
        List<Video> list = new ArrayList<>();
        String sql = "select * from Video \n"
                + "order by id, [year] desc\n"
                + "OFFSET ? ROWS\n"
                + "FETCH FIRST 6 ROWS ONLY";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, n);
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
    public List<Video> findPage8(int n) {
        List<Video> list = new ArrayList<>();
        String sql = "select * from Video \n"
                + "order by id, [year] desc\n"
                + "OFFSET ? ROWS\n"
                + "FETCH FIRST 8 ROWS ONLY";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, n);
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
    
    public List<Video> getAll() {
        List<Video> list = new ArrayList<>();
        String sql = "select * from video";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
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
    
    public List<Video> getByTitle(String title) {
        List<Video> list = new ArrayList<>();
        String sql = "select * from Video\n"
                + "	where title like '%" + title + "%'";        
    //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
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
    
    public List<Video> getTop3Year() {
        List<Video> list = new ArrayList<>();
        String sql = "select top 3 * from Video \n"
                + "order by [year] desc, id";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
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
    public List<Video> mostViewVideo() {
        List<Video> list = new ArrayList<>();
        String sql = "SELECT top 5 * FROM video \n"
                + "order by views desc";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
//                st.setString(1, n);
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

    public List<Video> categoriesVideo(String gid, String sid, String order) {
        List<Video> list = new ArrayList<>();
        String sql = "";
        if(gid.equals("0") && sid.equals("0")){
            sql = "select * from Video\n ";
        }else if(sid.equals("0")){
            sql = "select * from Video\n" +
                "where GenreId = "+gid+" \n ";
        }
        else if(gid.equals("0")){
            sql = "select * from Video\n" +
                "where StudioId = "+sid+" \n ";
        }else{
            sql = "select * from Video\n" +
                "where StudioId = "+sid+" and GenreId = "+gid+" \n ";
        }   
        
        String sql2 = "";
        if(order.equals("1-10")){
            sql2 = "ORDER BY id;";
        }
        else if(order.equals("A-Z")){
            sql2 = "ORDER BY title;";
        }
        else if(order.equals("Years")){
            sql2 = "ORDER BY [year] DESC;";
        }
        else if(order.equals("Views")){
            sql2 = "ORDER BY [views] DESC;";
        }
        check = sql + sql2;
        try {
            PreparedStatement st = connection.prepareStatement(sql + sql2);
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
    
    public List<Video> findByGenre(int id) {
        List<Video> list = new ArrayList<>();
        String sql = "select * from Video\n"
                + "	where GenreId = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, id);
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
//	
    public List<Video> findByStudio(int id) {
        List<Video> list = new ArrayList<>();
        String sql = "select * from Video\n"
                + "	where StudioId = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, id);
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

//Find Video
    public Video findByID(String id) {
        List<Video> list = new ArrayList<>();
        String sql = "select * from Video\n"
                + "	where id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Video ad = new Video(rs.getString("id"), rs.getString("title"), rs.getString("poster"), rs.getInt("views"), rs.getString("description"), rs.getString("link"), rs.getInt("year"), rs.getInt("genreId"), rs.getInt("studioID"));
                return ad;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }


//CRUD
    public void insert(Video s) {
        String sql ="INSERT INTO Video (id,title, poster, views, description, link, year, GenreId, StudioId)\n" +
                    "VALUES"
                + "(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getId());
            st.setString(2, s.getTitle());
            st.setString(3, s.getPoster());
            st.setInt(4, s.getViews());
            st.setString(5, s.getDescription());
            st.setString(6, s.getLink());
            st.setInt(7, s.getYear());
            st.setInt(8, s.getGenreId());
            st.setInt(9, s.getStudioId());
            
            st.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void update(Video s) {
        String sql = "UPDATE Video\n"
                + "SET title = ?,\n"
                + "    poster = ? ,\n"
                + "    views = ?,\n"
                + "    description = ?,\n"
                + "    link = ?,\n"
                + "    year = ?,\n"
                + "    GenreId = ?,\n"
                + "    StudioId = ?\n"
                + "WHERE id = ?;";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(9, s.getId());
            st.setString(1, s.getTitle());
            st.setString(2, s.getPoster());
            st.setInt(3, s.getViews());
            st.setString(4, s.getDescription());
            st.setString(5, s.getLink());
            st.setInt(6, s.getYear());
            st.setInt(7, s.getGenreId());
            st.setInt(8, s.getStudioId());

            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void delete(String user) {
        String sql = "Delete from Favorite\n"
                + "	where [videoId] = ?\n"
                + "     Delete from Video\n"
                + "	where [id] = ?";


        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, user);

            st.executeUpdate();

        } catch (Exception e) {
        }
    }

//	public List<Object[]> mostLikeVideo(){
//		EntityManager em = JpaUtils.getEntityManager();
//		List<Object[]> list = em.createNamedStoredProcedureQuery("Video.mostLikeVideo").getResultList();
//		return list;
//	}
//	
//	public List<Object[]> mostShareVideo(){
//		EntityManager em = JpaUtils.getEntityManager();
//		List<Object[]> list = em.createNamedStoredProcedureQuery("Video.mostShareVideo").getResultList();
//		return list;
//	}
//	
    public int totalView() {
        List<Video> list = new ArrayList<>();
        String sql = "SELECT SUM(views) AS total_views\n"
                + "	FROM Video";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("total_views");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return -1;
    }
    public int avgView() {
        List<Video> list = new ArrayList<>();
        String sql = "SELECT AVG(views) AS average_views\n"
                + "FROM Video";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("average_views");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return -1;
    }
    public int mostFavorite() {
        List<Video> list = new ArrayList<>();
        String sql = "SELECT top 1 v.id, v.title, COUNT(f.id) AS num_favorites\n"
                + "FROM Video v\n"
                + "LEFT JOIN Favorite f ON v.id = f.videoId\n"
                + "GROUP BY v.id, v.title\n"
                + "ORDER BY num_favorites DESC";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("num_favorites");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return -1;
    }
    public String mostFavoriteTitle() {
        List<Video> list = new ArrayList<>();
        String sql = "SELECT top 1 v.id, v.title, COUNT(f.id) AS num_favorites\n"
                + "FROM Video v\n"
                + "LEFT JOIN Favorite f ON v.id = f.videoId\n"
                + "GROUP BY v.id, v.title\n"
                + "ORDER BY num_favorites DESC";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getString("title");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }


    public static void main(String[] args) {
        VideoDAO video = new VideoDAO();
//        List<Video> videos = video.findPage(0);
//        System.out.println(videos.get(0).getTitle());

        List<Video> videoFind = video.findByStudio(1);
        for (Video videos1 : videoFind) {
            System.out.println(videos1.getTitle());
        }
        
        Video vid = new Video("10","Shironeko Project ZERO CHRONICLE", "https://cdn.myanimelist.net/images/anime/1072/111360l.jpg", 800, "The world is divided into two kingdoms: the Kingdom of White, which floats in the heavens and is ruled by their queen Iris, and the Kingdom of Black, which stands upon desolate land below and houses the King of Darkness as its ruler. As of late, forces of evil have amassed great power, posing a threat to the entire world. Being the main representative of the Light, it is Iris duty to maintain the balance of the world and fight off the darkness in her kingdom.", "https://www.youtube.com/embed/G4_ACGXNRBU?si=Ts1cKRh_Kju8clnU", 2020, 3,1);
        video.update(vid);
        System.out.println(vid.getViews());
        System.out.println(check);

//        System.out.println(video.findByID("1").getTitle());
    
    }
}
