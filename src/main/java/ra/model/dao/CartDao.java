package ra.model.dao;

import ra.model.entity.Cart;
import ra.model.entity.User;

import java.util.List;

public interface CartDao<T, E> extends Dao<T, E>{
    List<Cart> getAllCart(User user);
    boolean insertOrDer(List<Cart> list);
}
