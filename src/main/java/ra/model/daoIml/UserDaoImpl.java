package ra.model.daoIml;

import ra.model.dao.UserDao;
import ra.model.entity.User;
import ra.model.util.ConnectionDB;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao<User, Integer> {
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean insert(User user) {
        boolean resuilt = true;
        Connection conn = null;
        CallableStatement calst = null;
        try {
            conn = ConnectionDB.openConnection();
            calst = conn.prepareCall("{call proc_insertUser(?,?,?,?,?,?,?)}");
            calst.setString(1,user.getUserName());
            calst.setString(2,user.getPasswood());
            calst.setString(3,user.getFullName());
            calst.setDate(4,new Date(user.getBirthOfDate().getTime()));
            calst.setString(5,user.getEmail());
            calst.setString(6,user.getPhoneNumber());
            calst.setString(7,user.getAddress());
            calst.executeUpdate();
        } catch (SQLException e) {
            resuilt = false;
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,calst);
        }
        return resuilt;
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
        User user = null;
        Connection conn = null;
        CallableStatement calst = null;
        try {
            conn = ConnectionDB.openConnection();
            calst = conn.prepareCall("{call proc_login(?,?)}");
            calst.setString(1,userName);
            calst.setString(2,pass);
            ResultSet rs = calst.executeQuery() ;
            user = new User();
            if (rs.next()){
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPasswood(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPermisson(rs.getInt("permisson"));
                user.setCreateDate(rs.getDate("createDate"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setUserStatus(rs.getBoolean("userStatus"));
                user.setBirthOfDate(rs.getDate("dateOfBirth"));
                user.setAddress(rs.getString("address"));
                user.setFullName(rs.getString("fullname"));
                user.setSex(rs.getInt("sex"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,calst);
        }
        return user;
    }


}
