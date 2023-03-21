package ra.model.sevicesImp;

import ra.model.dao.CartDao;
import ra.model.daoIml.CartDaoImp;
import ra.model.entity.Cart;
import ra.model.entity.User;
import ra.model.sevices.CartSevices;

import java.util.List;

public class CartServicesImp implements CartSevices<Cart,Integer> {
    private static CartDao cartDao = new CartDaoImp();

    @Override
    public List<Cart> getAll() {
        return cartDao.getAll();
    }

    @Override
    public boolean insert(Cart cart) {
        return cartDao.insert(cart);
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public boolean update(Cart cart) {
        return false;
    }

    @Override
    public List<Cart> getAllCart(User user) {
        return cartDao.getAllCart(user);
    }

    @Override
    public boolean insertOrDer(List<Cart> list) {
        return cartDao.insertOrDer(list);
    }
}
