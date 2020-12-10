import sber.api.User;
import sber.api.myDAOUser;

import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        myDAOUser dao = new myDAOUser();

        List<User> lst = new LinkedList<>();
        User userr = new User(5,12234567, "kjyf");

        System.out.println(dao.add(userr));
        lst = dao.getAll();
        for (User user : lst)
            System.out.println(user);
    }
}
