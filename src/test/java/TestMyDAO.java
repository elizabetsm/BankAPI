import org.junit.Test;
import sber.api.User;
import sber.api.myDAOUser;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class TestMyDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    myDAOUser test = new myDAOUser();

    @Test
    public void test1() {
        List<User> lst = new LinkedList<>();
        User user = test.get(2);
        test.add(user);
        lst = test.getAll();
        for (User usser : lst)
            System.out.println(user);
        test.delete(1);

        lst.clear();
        lst = test.getAll();
        for (User usser : lst)
            System.out.println(user);

    }
}
