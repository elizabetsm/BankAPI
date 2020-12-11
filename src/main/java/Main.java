import com.sun.net.httpserver.HttpServer;
import sber.api.Handler;
import sber.api.User;
import sber.api.myDAOUser;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        myDAOUser dao = new myDAOUser();
        User user = null;
        user = dao.get(2);


        System.out.println(user);
//        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
//        server.createContext("/", new Handler());
//        server.setExecutor(null);
//        server.start();

//        List<User> lst = new LinkedList<>();
//        User userr = new User(5,12234567, "kjyf");
//
//        System.out.println(dao.add(userr));
//        lst = dao.getAll();
//        for (User user : lst)
//            System.out.println(user);
    }
}
