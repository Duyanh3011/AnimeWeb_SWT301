package dal;

import java.util.List;

import model.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends DBContext {

    public List<Users> getAll() {
        List<Users> list = new ArrayList<>();
        String sql = "select * from [User]";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                boolean adm;
                if (rs.getString("admin").equals("1")) {
                    adm = true;
                } else {
                    adm = false;
                }
                Users ad = new Users(rs.getString("id"), 
                        rs.getString("password"), 
                        rs.getString("email"), 
                        rs.getString("fullname"), adm);
                list.add(ad);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public Users checkUserPass(String username, String password) {
        String sql = "select * from [User] where id= ? and password = ?";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                boolean adm;
                if (rs.getString("admin").equals("1")) {
                    adm = true;
                } else {
                    adm = false;
                }
                Users ad = new Users(rs.getString("id"), rs.getString("password"), rs.getString("email"), rs.getString("fullname"), adm);
                return ad;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public Users checkUser(String username) {
        String sql = "select * from [User] where id= ? ";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                boolean adm;
                if (rs.getString("admin").equals("1")) {
                    adm = true;
                } else {
                    adm = false;
                }
                Users ad = new Users(rs.getString("id"), rs.getString("password"), rs.getString("email"), rs.getString("fullname"), adm);
                System.out.println("User found");
                return ad;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("User not found");
        return null;
    }

    public int insert(Users s) {
        String sql = "INSERT INTO [User](id, password, email, fullname, admin)\n" + "VALUES (?, ?, ?, N'" + s.getFullname() + "', '0');";

        int rowaff = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getId());
            st.setString(2, s.getPassword());
            st.setString(3, s.getEmail());

         rowaff = st.executeUpdate();

            if(rowaff == 0)
                System.out.println("Insert unsuccessful");
            else
                System.out.println("Insert successful");

        } catch (Exception e) {
            rowaff = -1;
            System.out.println(e);

        }
        return rowaff;
    }

    public void update(String userid, String npass) {
        String sql = "UPDATE [User]\n"
                + "SET [password] = ?\n"
                + "WHERE id = ?;";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(2, userid);
            st.setString(1, npass);

            st.executeUpdate();

        } catch (Exception e) {
        }
    }

    public int delete(String userID) {
        String sql = "Delete from Favorite\n"
                + "	where [UserId] = ?\n"
                + "	delete from [User]\n"
                + "	where id =?";
        int rowaff = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, userID);
            st.setString(2, userID);

            rowaff = st.executeUpdate();
        
            if(rowaff == 0)
                System.out.println("User not found or null");
        } catch (Exception e) {
            rowaff = -1;
        }
        return rowaff;
    }

    public int updateInfo(String user, String name, String email) {
        String sql = "UPDATE [User]\n"
                + "SET fullname = ?, email = ?\n"
                + "WHERE id = ?";
        int rowaff = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, email);
            st.setString(3, user);

            rowaff = st.executeUpdate();

            if(rowaff == 0)
                System.out.println("Update unsuccessful");
            else
                System.out.println("Update successful");

        } catch (Exception e) {
            rowaff = -1;
            System.out.println(e);
        }
        return rowaff;
    }
//	public Users getPassword(String email) {
//		EntityManager em = JpaUtils.getEntityManager();
//		Query q = em.createQuery("select u from Users u where u.email like :email");
//		q.setParameter("email", email);
//		List<Users> list = q.getResultList();
//		try {
//			Users user = list.get(0);
//			return user;
//		} catch (Exception e) {
//			return null;
//		}
//	}

    public int totalUsers() {
        String sql = "SELECT COUNT(id) AS total_users\n"
                + "FROM [User];";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("total_users");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return -1;
    }

    public static void main(String[] args) {
        UserDAO sd = new UserDAO();
        List<Users> li = sd.getAll();
        System.out.println(li.get(0).getAdmin());

        System.out.println(sd.checkUserPass("123", "123").getFullname());

        sd.updateInfo("user1", "Minh Trang", "user1@example.com");
//        sd.insert(new Users("123", "123", "email@gmail.com", "fullname", false));
    }
}
