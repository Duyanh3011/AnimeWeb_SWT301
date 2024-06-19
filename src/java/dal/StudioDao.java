package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Studio;

public class StudioDao extends DBContext {

    public List<Studio> getAll() {
        List<Studio> list = new ArrayList<>();
        String sql = "select * from [Studio]";
        //chay lenhj truy van
        try (PreparedStatement st = connection.prepareStatement(sql);) {
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Studio ad = new Studio(rs.getInt("id"), rs.getString("name"));
                    list.add(ad);
                }
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
    public void insert(Studio s){
        String sql = "INSERT INTO Studio (id, name) \n" +
                    "VALUES(?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, s.getId());
            st.setString(2, s.getName());

            st.executeUpdate();

        } catch (Exception e) {
        }
    }
    public void update(String id, String name) {
        String sql = "UPDATE [Studio]\n"
                + "SET [name] = ?\n"
                + "WHERE id = ?;";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(2, name);
            st.setString(1, id);

            st.executeUpdate();

        } catch (Exception e) {
        }
    }

    public String delete(String studioID) {
        String sql = "Delete from [Studio]\n"
                + "	where id =?";
        String res = "";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, studioID);
            st.setString(2, studioID);

            int rowaff = st.executeUpdate();
            if( rowaff > 0)
                res = res + "Delete successful";
            else
                res = res + "Delete unsuccessful";
        } catch (Exception e) {
            res = res + e.getMessage();
        }
        return res;
    }

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
        List<Studio> li = sd.getAll();
        System.out.println(li.get(0).getName());

        Studio ge = sd.getStudioByID(1);
        System.out.println(ge.getName());

    }
}
