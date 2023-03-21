package ra.model.daoIml;

import ra.model.dao.CartDao;
import ra.model.entity.*;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImp implements CartDao<Cart,Integer> {


    @Override
    public List<Cart> getAll() {
        List<Cart> listCart = null;
        Connection conn = null;
        CallableStatement calSt = null;
        try {
            conn = ConnectionDB.openConnection();
            listCart = new ArrayList<>();
//            calSt = conn.prepareCall("")

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,calSt);
        }

        return listCart;
    }

    @Override
    public boolean insert(Cart cart) {
        boolean result = true;
        Connection conn = null;
        CallableStatement calSt = null;
        try {
            conn= ConnectionDB.openConnection();
            calSt = conn.prepareCall("{call proc_getCartByUserIdProductDetailId(?,?)}");
            calSt.setInt(1,cart.getCartProduct().getProductDetail().getProductDetailId());
            calSt.setInt(2,cart.getUser().getUserId());
            ResultSet rs =  calSt.executeQuery();
            if (rs.next()){
                CallableStatement calSt2 = conn.prepareCall("{call proc_plusQuantity(?,?)}");
                calSt2.setInt(1,cart.getCartProduct().getProductDetail().getProductDetailId());
                calSt2.setInt(2,cart.getUser().getUserId());
                calSt2.executeUpdate();
            }else{
                CallableStatement calSt3 = conn.prepareCall("{call proc_insertCart(?,?,?)}");
                calSt3.setInt(1,cart.getCartProduct().getProductDetail().getProductDetailId());
                calSt3.setInt(2,cart.getUser().getUserId());
                calSt3.setInt(3,cart.getQuantity());
                calSt3.executeUpdate();
            }
        }catch (Exception e){
            result= false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,calSt);
        }
        return result;
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
        List<Cart> list = null;
        Connection conn = null;
        CallableStatement calSt = null;
        try {
            list = new ArrayList<>();
            conn = ConnectionDB.openConnection();
            calSt = conn.prepareCall("{call proc_getAllCartByUserId(?)}");
            calSt.setInt(1,user.getUserId());
            ResultSet rs= calSt.executeQuery();
            while (rs.next()){
                Cart cart = new Cart();
                cart.setUser(user);
                cart.setQuantity(rs.getInt("quantity"));
                ProductDetail productDetail = new ProductDetail();
                productDetail.setProductDetailId(rs.getInt("productDetailId"));
                productDetail.setPrice(rs.getFloat("price"));
                Size size = new Size();
                size.setSizeId(rs.getInt("sizeId"));
                size.setSizeName(rs.getString("sizeName"));
                Color color = new Color();
                color.setColorId(rs.getInt("colorId"));
                color.setColorName(rs.getString("colorName"));
                productDetail.setSize(size);
                productDetail.setColor(color);
                CartProduct cartProduct = new CartProduct();
                cartProduct.setProductDetail(productDetail);
                cartProduct.setProductName(rs.getString("productName"));
                cartProduct.setProductId(rs.getInt("productId"));
                cartProduct.setProductImage(rs.getString("productImage"));
                cart.setCartProduct(cartProduct);

                list.add(cart);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,calSt);
        }
        return list;
    }

    @Override
    public boolean insertOrDer(List<Cart> list) {
        boolean result = true;
        Connection conn = null;
        CallableStatement calSt = null;
        try {
            conn = ConnectionDB.openConnection();



        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,calSt);
        }



        return result;
    }
}
