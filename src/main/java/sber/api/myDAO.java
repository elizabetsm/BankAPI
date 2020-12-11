package sber.api;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface myDAO<T> {
    List<T> getAll();

    T get(int id) throws SQLException;

    boolean add(User user);

    void delete(int id);

}
