package ra.model.daoIml;

import com.sun.org.apache.regexp.internal.RE;
import ra.model.dao.ProductDao;
import ra.model.entity.*;
import ra.model.util.ConnectionDB;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImp implements ProductDao<Product, Integer> {
    @Override
    public List<Product> getAll() {
        List<Product> listProduct = null;
        Connection conn = null;
        CallableStatement calst = null;
        try {
            conn = ConnectionDB.openConnection();
            listProduct = new ArrayList<>();
            calst = conn.prepareCall("{Call proc_getProductWeb()}");
            ResultSet rs = calst.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductStatus(rs.getBoolean("productStatus"));
                product.setProductImage(rs.getString("productImage"));
                product.setDiscription(rs.getString("discription"));
                Catalog catalog = new Catalog();
                catalog.setCatalogId(rs.getInt("catalogId"));
                catalog.setCatalogName(rs.getString("catalogName"));
                catalog.setParentId(rs.getInt("parentId"));
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                product.setUser(user);
                product.setCatalog(catalog);
                CallableStatement calSt2 = conn.prepareCall("{call proc_getImageByProductId(?)}");
                calSt2.setInt(1, product.getProductId());
                ResultSet rs2 = calSt2.executeQuery();
                while (rs2.next()) {
                    product.getImageList().add(rs2.getString("imageLink"));
                }
                CallableStatement calSt3 = conn.prepareCall("{call proc_getProductDetailForAdmin(?)}");
                calSt3.setInt(1, product.getProductId());
                ResultSet rs3 = calSt3.executeQuery();
                while (rs3.next()) {
                    ProductDetail productDetail = new ProductDetail();
                    Size size = new Size();
                    size.setSizeId(rs3.getInt("sizeId"));
                    size.setSizeName(rs3.getString("sizeName"));
                    Color color = new Color();
                    color.setColorId(rs3.getInt("colorId"));
                    color.setColorName(rs3.getString("colorName"));
                    productDetail.setSize(size);
                    productDetail.setColor(color);
                    productDetail.setPrice(rs3.getFloat("price"));
                    productDetail.setQuantity(rs3.getInt("quantity"));
                    productDetail.setSellQuantity(rs3.getInt("sellQuantity"));
                    product.getListProductDetail().add(productDetail);
                }
                listProduct.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calst);
        }
        return listProduct;
    }

    @Override
    public boolean insert(Product product) {
        Connection conn = null;
        CallableStatement calst = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            calst = conn.prepareCall("{call proc_insertProduct(?,?,?,?,?,?)}");
            calst.setString(1, product.getProductName());
            calst.setString(2, product.getProductImage());
            calst.setString(3, product.getDiscription());
            calst.setInt(4, product.getUser().getUserId());
            calst.setInt(5, product.getCatalog().getCatalogId());
            calst.registerOutParameter(6, Types.INTEGER);
            calst.execute();
            int id = calst.getInt(6);
            for (String str : product.getImageList()) {
                CallableStatement calst2 = conn.prepareCall("{call proc_insertImage(?,?)}");
                calst2.setInt(1, id);
                calst2.setString(2, str);
                calst2.executeUpdate();
                calst2.close();
            }

        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calst);
        }
        return result;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public Product searchByName(String name) {
        return null;
    }

    @Override
    public Product getById(Integer integer) {
        Product product = null;
        Connection conn = null;
        CallableStatement calst = null;
        try {
            conn = ConnectionDB.openConnection();
            product = new Product();
            calst = conn.prepareCall("{call proc_getAllProductByProductId(?)}");
            calst.setInt(1, integer);
            ResultSet rs = calst.executeQuery();
            if (rs.next()) {
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setDiscription(rs.getString("discription"));
                product.setProductStatus(rs.getBoolean("productStatus"));
                int catId = rs.getInt("catalogId");
                Catalog catalog = new Catalog();
                CallableStatement calSt2 = conn.prepareCall("{call proc_getCatalogById(?)}");
                calSt2.setInt(1, catId);
                ResultSet rs2 = calSt2.executeQuery();
                if (rs2.next()) {
                    catalog.setCatalogId(rs2.getInt("catalogId"));
                    catalog.setCatalogName(rs2.getString("catalogName"));
                    catalog.setParentId(rs2.getInt("parentId"));
                    catalog.setCatalogStatus(true);
                }
                product.setCatalog(catalog);
                product.getListProductDetail().addAll(getProductDetailForAdmin(product.getProductId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calst);
        }

        return product;
    }

    @Override
    public List<Color> getAllColor() {
        List<Color> list = null;
        Connection conn = null;
        CallableStatement calSt = null;
        try {
            list = new ArrayList<>();
            conn = ConnectionDB.openConnection();
            calSt = conn.prepareCall("{call proc_getAllColor()}");
            ResultSet rs = calSt.executeQuery();
            while (rs.next()) {
                Color color = new Color();
                color.setColorId(rs.getInt("colorId"));
                color.setColorName(rs.getString("colorName"));
                list.add(color);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calSt);
        }
        return list;
    }

    @Override
    public Product getNewProduct(Integer id) {
        Connection conn = null;
        CallableStatement calst = null;
        Product product = null;
        try {
            conn = ConnectionDB.openConnection();
            product = new Product();
            calst = conn.prepareCall("{call proc_getNewProduct(?)}");
            calst.setInt(1, id);
            ResultSet rs = calst.executeQuery();
            if (rs.next()) {
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductImage(rs.getString("productImage"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calst);
        }
        return product;
    }

    @Override
    public boolean insertProductDetail(int proId, List<ProductDetail> list) {
        boolean result = true;
        Connection conn = null;
        CallableStatement calst = null;
        try {
            conn = ConnectionDB.openConnection();
            for (ProductDetail proDetail : list) {
                calst = conn.prepareCall("{call proc_insertProductDetail(?,?,?,?,?)}");
                calst.setInt(1, proId);
                calst.setInt(2, proDetail.getSize().getSizeId());
                calst.setInt(3, proDetail.getColor().getColorId());
                calst.setFloat(4, proDetail.getPrice());
                calst.setInt(5, proDetail.getQuantity());
                calst.executeUpdate();
            }


        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calst);
        }
        return result;
    }

    @Override
    public List<Product> getProductForAdminTable(int id) {
        Connection conn = null;
        CallableStatement calSt = null;
        List<Product> listProduct = null;
        try {
            conn = ConnectionDB.openConnection();
            calSt = conn.prepareCall("{call proc_getProductForAdminTable(?)}");
            calSt.setInt(1, id);
            listProduct = new ArrayList<>();
            ResultSet rs = calSt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductStatus(rs.getBoolean("productStatus"));
                Catalog catalog = new Catalog();
                catalog.setCatalogId(rs.getInt("catalogId"));
                catalog.setCatalogName(rs.getString("catalogName"));
                product.setCatalog(catalog);
                CallableStatement calst1 = conn.prepareCall("{call proc_getProductDetailForAdmin(?)}");
                calst1.setInt(1, product.getProductId());
                ResultSet rs2 = calst1.executeQuery();
                while (rs2.next()) {
                    Size size = new Size();
                    size.setSizeId(rs2.getInt("sizeId"));
                    size.setSizeName(rs2.getString("sizeName"));
                    Color color = new Color();
                    color.setColorId(rs2.getInt("colorId"));
                    color.setColorName(rs2.getString("colorName"));
                    ProductDetail productDetail = new ProductDetail();
                    productDetail.setSize(size);
                    productDetail.setColor(color);
                    productDetail.setProductDetailId(rs2.getInt("productDetailId"));
                    productDetail.setPrice(rs2.getFloat("price"));
                    productDetail.setQuantity(rs2.getInt("quantity"));
                    productDetail.setSellQuantity(rs2.getInt("sellQuantity"));
                    product.getListProductDetail().add(productDetail);
                }
                listProduct.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calSt);
        }
        return listProduct;
    }

    @Override
    public List<ProductDetail> getProductDetailForAdmin(int id) {
        List<ProductDetail> listProduct = null;
        Connection conn = null;
        CallableStatement calst = null;
        try {
            conn = ConnectionDB.openConnection();
            listProduct = new ArrayList<>();
            CallableStatement calst1 = conn.prepareCall("{call proc_getProductDetailForAdmin(?)}");
            calst1.setInt(1, id);
            ResultSet rs2 = calst1.executeQuery();
            while (rs2.next()) {
                Size size1 = new Size();
                size1.setSizeId(rs2.getInt("sizeId"));
                size1.setSizeName(rs2.getString("sizeName"));
                Color color = new Color();
                color.setColorId(rs2.getInt("colorId"));
                color.setColorName(rs2.getString("colorName"));
                ProductDetail productDetail = new ProductDetail();
                productDetail.setSize(size1);
                productDetail.setColor(color);
                productDetail.setProductDetailId(rs2.getInt("productDetailId"));
                productDetail.setPrice(rs2.getFloat("price"));
                productDetail.setQuantity(rs2.getInt("quantity"));
                productDetail.setSellQuantity(rs2.getInt("sellQuantity"));
                listProduct.add(productDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calst);
        }
        return listProduct;
    }

    @Override
    public boolean updatePrice(List<Float> listF, List<Integer> list) {
        boolean result = true;
        Connection conn = null;
        CallableStatement calst = null;
        try {
            conn = ConnectionDB.openConnection();
            for (int i = 0; i < list.size(); i++) {
                calst = conn.prepareCall("{call proc_updatePrice(?,?)}");
                calst.setFloat(1, listF.get(i));
                calst.setInt(2, list.get(i));
                calst.executeUpdate();

            }
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calst);
        }
        return result;
    }

    @Override
    public boolean updateQuantity(List<Integer> listQ, List<Integer> list) {
        boolean result = true;
        Connection conn = null;
        CallableStatement calst = null;
        try {
            conn = ConnectionDB.openConnection();
            for (int i = 0; i < list.size(); i++) {
                calst = conn.prepareCall("{call proc_updateQuantity(?,?)}");
                calst.setInt(1, listQ.get(i));
                calst.setInt(2, list.get(i));
                calst.executeUpdate();

            }
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calst);
        }
        return result;
    }

    @Override
    public boolean deleteProductDetail(int id) {
        Connection conn = null;
        CallableStatement calSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            calSt = conn.prepareCall("{call proc_deleteProductDetail(?)}");
            calSt.setInt(1, id);
            calSt.executeUpdate();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calSt);
        }
        return result;
    }

    @Override
    public List<Product> getProductForWeb() {
        return null;
    }

    @Override
    public List<DisplayProduct> displayWebProduct() {
        List<DisplayProduct> list = null;
        Connection conn = null;
        CallableStatement calSt = null;
        try {
            list = new ArrayList<>();
            conn = ConnectionDB.openConnection();
            calSt = conn.prepareCall("{call proc_displayProductWeb()}");
            ResultSet rs = calSt.executeQuery();
            while (rs.next()) {
                DisplayProduct displayProduct = new DisplayProduct();
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductImage(rs.getString("productImage"));
                displayProduct.setProduct(product);
                displayProduct.setMinPrice(rs.getFloat("minPrice"));
                displayProduct.setMaxPrice(rs.getFloat("maxPrice"));
                list.add(displayProduct);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calSt);
        }
        return list;
    }

    @Override
    public List<DisplayProduct> displayNewProducts() {
        List<DisplayProduct> list = null;
        Connection conn = null;
        CallableStatement calSt = null;
        try {
            list = new ArrayList<>();
            conn = ConnectionDB.openConnection();
            calSt = conn.prepareCall("{call proc_newDisplayProductWeb()}");
            ResultSet rs = calSt.executeQuery();
            while (rs.next()) {
                DisplayProduct displayProduct = new DisplayProduct();
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductImage(rs.getString("productImage"));
                displayProduct.setProduct(product);
                displayProduct.setMinPrice(rs.getFloat("minPrice"));
                displayProduct.setMaxPrice(rs.getFloat("maxPrice"));
                list.add(displayProduct);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calSt);
        }
        return list;
    }

    @Override
    public List<Color> getAllColorOfProduct(Integer id) {
        List<Color> list = null;
        CallableStatement calSt = null;
        Connection conn = null;
        try {
            list = new ArrayList<>();
            conn = ConnectionDB.openConnection();
            calSt = conn.prepareCall("{call proc_getAllColorOfProduct(?)}");
            calSt.setInt(1, id);
            ResultSet rs = calSt.executeQuery();
            while (rs.next()) {
                Color color = new Color();
                color.setColorId(rs.getInt("colorId"));
                CallableStatement calSt2 = conn.prepareCall("{call proc_getColorById(?)}");
                calSt2.setInt(1, color.getColorId());
                ResultSet rs2 = calSt2.executeQuery();
                if (rs2.next()) {
                    color.setColorName(rs2.getString("colorName"));
                }
                list.add(color);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calSt);
        }
        return list;
    }

    @Override
    public DisplayProduct displaySingerProduct(int id) {
        DisplayProduct displayProduct = null;
        Connection conn = null;
        CallableStatement calst = null;
        try {
            displayProduct = new DisplayProduct();
            conn = ConnectionDB.openConnection();
            calst = conn.prepareCall("{Call proc_getProductWebById(?)}");
            calst.setInt(1,id);
            ResultSet rs = calst.executeQuery();
            if (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductStatus(rs.getBoolean("productStatus"));
                product.setProductImage(rs.getString("productImage"));
                product.setDiscription(rs.getString("discription"));
                Catalog catalog = new Catalog();
                catalog.setCatalogId(rs.getInt("catalogId"));
                catalog.setCatalogName(rs.getString("catalogName"));
                catalog.setParentId(rs.getInt("parentId"));
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                product.setUser(user);
                product.setCatalog(catalog);
                CallableStatement calSt2 = conn.prepareCall("{call proc_getImageByProductId(?)}");
                calSt2.setInt(1, product.getProductId());
                ResultSet rs2 = calSt2.executeQuery();
                while (rs2.next()) {
                    product.getImageList().add(rs2.getString("imageLink"));
                }
                CallableStatement calSt3 = conn.prepareCall("{call proc_getProductDetailForAdmin(?)}");
                calSt3.setInt(1, product.getProductId());
                ResultSet rs3 = calSt3.executeQuery();
                while (rs3.next()) {
                    ProductDetail productDetail = new ProductDetail();
                    Size size = new Size();
                    size.setSizeId(rs3.getInt("sizeId"));
                    size.setSizeName(rs3.getString("sizeName"));
                    Color color = new Color();
                    color.setColorId(rs3.getInt("colorId"));
                    color.setColorName(rs3.getString("colorName"));
                    productDetail.setSize(size);
                    productDetail.setColor(color);
                    productDetail.setPrice(rs3.getFloat("price"));
                    productDetail.setQuantity(rs3.getInt("quantity"));
                    productDetail.setSellQuantity(rs3.getInt("sellQuantity"));
                    product.getListProductDetail().add(productDetail);
                }
                displayProduct.setProduct(product);
                CallableStatement calSt4 = conn.prepareCall("{call proc_getDisplayProductById(?)}");
                calSt4.setInt(1, product.getProductId());
                ResultSet rs4 = calSt4.executeQuery();
                if (rs4.next()) {
                    displayProduct.setMaxPrice(rs4.getFloat("maxPrice"));
                    displayProduct.setMinPrice(rs4.getFloat("minPrice"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calst);
        }
        return displayProduct;
    }

    @Override
    public ProductDetail getProductDetailById(int id) {
        ProductDetail productDetail =null;
        Connection conn = null;
        CallableStatement calst = null;
        try {
            conn = ConnectionDB.openConnection();
            productDetail = new ProductDetail();
            CallableStatement calst1 = conn.prepareCall("{call proc_getProductDetailById(?)}");
            calst1.setInt(1, id);
            ResultSet rs2 = calst1.executeQuery();
            while (rs2.next()) {
                Size size1 = new Size();
                size1.setSizeId(rs2.getInt("sizeId"));
                size1.setSizeName(rs2.getString("sizeName"));
                Color color = new Color();
                color.setColorId(rs2.getInt("colorId"));
                color.setColorName(rs2.getString("colorName"));
                productDetail.setSize(size1);
                productDetail.setColor(color);
                productDetail.setProductDetailId(rs2.getInt("productDetailId"));
                productDetail.setPrice(rs2.getFloat("price"));
                productDetail.setQuantity(rs2.getInt("quantity"));
                productDetail.setSellQuantity(rs2.getInt("sellQuantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, calst);
        }
        return productDetail;
    }

    @Override
    public List<DisplayProduct> getByCatalogId(int id) {
        List<DisplayProduct> list = null;
       Connection conn = null;
       CallableStatement  calSt = null;
       try {
           list = new ArrayList<>();
           conn = ConnectionDB.openConnection();
           calSt = conn.prepareCall("{call proc_findProductByCatId(?)}");
           calSt.setInt(1,id);
           ResultSet rs = calSt.executeQuery();
           while (rs.next()){
               DisplayProduct displayProduct = new DisplayProduct();
               Product product = new Product();
               product.setProductId(rs.getInt("productId"));
               product.setProductName(rs.getString("productName"));
               product.setProductImage(rs.getString("productImage"));
               displayProduct.setProduct(product);
               displayProduct.setMinPrice(rs.getFloat("minPrice"));
               displayProduct.setMaxPrice(rs.getFloat("maxPrice"));
               list.add(displayProduct);
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           ConnectionDB.closeConnection(conn,calSt);
       }
        return list;
    }
}
