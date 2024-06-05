package dal;

import java.util.List;

import model.Studio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudioDao extends DBContext{
	
	public List<Studio> getAll() {
        List<Studio> list = new ArrayList<>();
        String sql = "select * from [Studio]";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Studio ad = new Studio(rs.getInt("id"), rs.getString("name"));
                list.add(ad);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
	
	
        public Studio getStudioByID(int id) {
        String sql = "select * from Studio where id= ?";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Studio ad = new Studio(rs.getInt("id"), rs.getString("name"));
                return ad;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
//	public void insert(Studio s){
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

        public int mostStudio() {
        String sql = "SELECT top 1 s.id, s.name, COUNT(v.id) AS num_videos\n"
                    + "	FROM Studio s\n"
                    + "	LEFT JOIN Video v ON s.id = v.StudioId\n"
                    + "	GROUP BY s.id, s.name\n"
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
    public String mostStudioName() {
        String sql = "SELECT top 1 s.id, s.name, COUNT(v.id) AS num_videos\n"
                + "	FROM Studio s\n"
                + "	LEFT JOIN Video v ON s.id = v.StudioId\n"
                + "	GROUP BY s.id, s.name\n"
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
        StudioDao sd = new StudioDao();
        List<Studio> li = sd. getAll();
        System.out.println(li.get(0).getName());
        
        Studio ge = sd.getStudioByID(1);
            System.out.println(ge.getName());

    }
}
