package ra.model.dao;

public interface UserDao <T, E> extends Dao<T,E>{
    boolean changePasswood(T t);
    T login (String userName, String pass);
}
