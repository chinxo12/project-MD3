package ra.model.sevicesImp;

import ra.model.dao.UserDao;
import ra.model.daoIml.UserDaoImpl;
import ra.model.entity.User;
import ra.model.sevices.UserSevices;

import java.util.List;

public class UserSevicesImp implements UserSevices<User, Integer> {
    UserDao userDao = new UserDaoImpl();


    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean changePasswood(User user) {
        return false;
    }

    @Override
    public User login(String userName, String pass) {
        return (User) userDao.login(userName,pass);
    }


}
