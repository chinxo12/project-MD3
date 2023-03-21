package ra.model.sevices;

import ra.model.entity.Cart;
import ra.model.entity.User;

import java.util.List;

public interface CartSevices<T, E> extends Sevices<T, E>{
    List<Cart> getAllCart(User user);
    boolean insertOrDer(List<Cart> list);
}
