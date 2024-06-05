package dal;

import java.util.List;

import model.Genre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GenreDao extends DBContext{
	
	public List<Genre> getAll() {
        List<Genre> list = new ArrayList<>();
        String sql = "select * from [Genre]";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Genre ad = new Genre(rs.getInt("id"), rs.getString("name"));
                list.add(ad);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
	
	
        public Genre getGenreByID(int id) {
        String sql = "select * from Genre where id= ?";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Genre ad = new Genre(rs.getInt("id"), rs.getString("name"));
                return ad;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
//	public void insert(Genre s){
//        String sql = "INSERT INTO [User](id, password, email, fullname, admin)\n" + "VALUES (?, ?, ?, N'"+s.getFullname()+"', '0');";
//        
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, s.getId());
//            st.setString(2, s.getPassword());
//            st.setString(3, s.getEmail());
//            
//            st.executeUpdate();
//            
//        } catch (Exception e) {
//        }
//    }
        public int mostGenre() {
        String sql = "SELECT top 1 g.id, g.name, COUNT(v.id) AS num_videos\n"
                    + "	FROM Genre g\n"
                    + "	LEFT JOIN Video v ON g.id = v.GenreId\n"
                    + "	GROUP BY g.id, g.name\n"
                    + "	ORDER BY num_videos DESC";
            //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("num_videos");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return -1;
    }
    public String mostGenreName() {
        String sql = "SELECT top 1 g.id, g.name, COUNT(v.id) AS num_videos\n"
                + "	FROM Genre g\n"
                + "	LEFT JOIN Video v ON g.id = v.GenreId\n"
                + "	GROUP BY g.id, g.name\n"
                + "	ORDER BY num_videos DESC";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

        
        public static void main(String[] args) {
        GenreDao sd = new GenreDao();
        List<Genre> li = sd. getAll();
        System.out.println(li.get(0).getName());
        
        Genre ge = sd.getGenreByID(1);
            System.out.println(ge.getName());

    }
}
