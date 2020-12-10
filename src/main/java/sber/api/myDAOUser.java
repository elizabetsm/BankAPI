package sber.api;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class myDAOUser implements myDAO<User>{

    private String url = "jdbc:postgresql://localhost:5432/elizaveta?user=elizaveta&password=secret&ssl=false";
    public static final String SELECT_ALL_USERS = "SELECT * FROM Users";
    public static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id=?;";
    public static final String INSERT_NEW_USER = "INSERT INTO Users (id, card, Client) VALUES (?, ?, ?)";
    public static final String DELETE_USER = "DELETE FROM * WHERE id=?";

    @Override
    public List<User> getAll() {
        List<User> lst = new LinkedList<>();
        try (java.sql.Connection conn = DriverManager.getConnection(url)){
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_USERS);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    User user = new User(rs.getInt(1),
                            rs.getInt(2), rs.getString(3));
                    lst.add(user);
                }
            }
        } catch (Throwable e){
            e.printStackTrace();
        }
        return lst;
    }

//    @Override
//    public User get(long id) {
//        User user = null;
//        try (java.sql.Connection conn = DriverManager.getConnection(url)){
//            PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID);
//            ps.setLong(1, id);
//            ResultSet rs = ps.executeQuery();
//            user = new User(rs.getLong(1),
//                    rs.getLong(2), rs.getString(3));
//        } catch(Throwable e) {
//        e.printStackTrace();
//        }
//        return user;
//    }

    @Override
    public boolean add(Object o) {
        User user = (User)o;
        boolean succes = false;
        try (Connection conn = DriverManager.getConnection(url)) {
            PreparedStatement ps = conn.prepareStatement(INSERT_NEW_USER);
            ps.setInt(1, user.getUser_id());
            ps.setInt(2, user.getCards());
            ps.setString(3, user.getClient());
            try (ResultSet rs = ps.executeQuery()){
                    succes = true;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }catch(Throwable e) {
            e.printStackTrace();
        }
        return succes;
    }

    @Override
    public void delete(Object o) {
        try (java.sql.Connection conn = DriverManager.getConnection(url)) {
            PreparedStatement ps = conn.prepareStatement(DELETE_USER);
            ps.setLong(1, 1);
        }catch(Throwable e) {
            e.printStackTrace();
        }
    }
}
