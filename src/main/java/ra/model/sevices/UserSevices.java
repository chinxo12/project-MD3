package ra.model.sevices;

import ra.model.entity.User;

public interface UserSevices<T , E> extends Sevices<T, E>{
    boolean changePasswood(T t);
    User login (String userName, String pass);
}
