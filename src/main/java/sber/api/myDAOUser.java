package sber.api;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class myDAOUser implements myDAO<User>{
    // private String url = "jdbc:postgresql://localhost:5432/elizaveta?user=elizaveta&password=secret&ssl=false"
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    public static final String SELECT_ALL_USERS = "SELECT * FROM Users, cards";
    public static final String SELECT_USER_BY_ID = "SELECT * FROM users, cards WHERE user_id=?;";
    public static final String INSERT_NEW_USER = "INSERT INTO Users (user_name) VALUES ( ?)";
    public static final String DELETE_USER = "DELETE FROM * WHERE user_id=?";

    @Override
    public List<User> getAll() {
        List<User> lst = new LinkedList<>();
        try (java.sql.Connection conn = DriverManager.getConnection(URL)){
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_USERS);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    User user = new User(rs.getString(2), rs.getInt(3),
                            rs.getInt(4));
                    lst.add(user);
                }
            }
        } catch (Throwable e){
            e.printStackTrace();
        }
        return lst;
    }

    @Override
    public User get(int id) {
        User user = null;
        try (java.sql.Connection conn = DriverManager.getConnection(URL)){
            PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
                user = new User(rs.getString(2), rs.getInt(3),
                        rs.getInt(4));
        } catch(Throwable e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean add(User user) {
//        User user = (User)o;
        boolean succes = false;
        try (Connection conn = DriverManager.getConnection(URL)) {
            PreparedStatement ps = conn.prepareStatement(INSERT_NEW_USER);
//            ps.setInt(1, user.getUser_id());
            ps.setString(1, user.getUser_name());
//            ps.setInt(1, user.getCard_id());
//            ps.setInt(4, user.getCustomer_id());
           int rs = ps.executeUpdate();
            if (rs == 0 ){
                succes = true;
            }
        }catch(Throwable e) {
            e.printStackTrace();
        }
        return succes;
    }

    @Override
    public void delete(int id) {
        try (java.sql.Connection conn = DriverManager.getConnection(URL)) {
            PreparedStatement ps = conn.prepareStatement(DELETE_USER);
            ps.setInt(1, id);
        }catch(Throwable e) {
            e.printStackTrace();
        }
    }
}
