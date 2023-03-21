package ra.model.dao;

import java.util.List;

public interface Dao <T, E>{
     List<T> getAll();
     boolean insert(T t);
     boolean delete(E e);
     boolean update(T t);

}
