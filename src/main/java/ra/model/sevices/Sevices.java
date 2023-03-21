package ra.model.sevices;

import java.util.List;

public interface Sevices <T, E> {
    List<T> getAll();
    boolean insert(T t);
    boolean delete(E e);
    boolean update(T t);

}
