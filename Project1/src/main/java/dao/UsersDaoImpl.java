package dao;

import models.User;

import java.sql.*;

//singleton
public class UsersDaoImpl implements UsersDao {

    private static UsersDao usersDao;

    public UsersDaoImpl() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static UsersDao getInstance() {
        if (usersDao == null) {
            usersDao = new UsersDaoImpl();
        }

        return usersDao;
    }

    String url = "jdbc:postgresql://revaturedatabase.caqhkgq4ux3z.us-east-1.rds.amazonaws.com/Project1";
    String username = "postgres";
    String password = "p4ssw0rd";

    @Override
    public User insertUser(User user) {
        try(Connection con = DriverManager.getConnection(url, username, password);){

            String sql = "INSERT INTO ers_users VALUES (DEFAULT, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getErsUsername());
            ps.setString(2, user.getErsPassword());
            ps.setString(3, user.getUserFirstname());
            ps.setString(4, user.getUserLastName());
            ps.setString(5, user.getUserEmail());
            ps.setInt(6, user.getUserRoleId());

            if (ps.executeUpdate() != 0)
                return user;

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUser(String user) {
        try(Connection conn = DriverManager.getConnection(url,username,password)){

            String sql = "SELECT * FROM ers_users WHERE ers_username = '" + user + "';";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getPassword(Integer userId) {
        try(Connection conn = DriverManager.getConnection(url,username,password)){

            String sql = "SELECT * FROM ers_users WHERE ers_users_id = '" + userId + "';";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                return rs.getString(3);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
