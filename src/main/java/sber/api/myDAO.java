package sber.api;

import java.util.List;
import java.util.Optional;

public interface myDAO<T> {
    List<T> getAll();

//    T get(long id);

    boolean add(Object o);

    void delete(Object o);

}
