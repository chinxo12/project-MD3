package ra.model.dao;

import ra.model.entity.Color;
import ra.model.entity.DisplayProduct;
import ra.model.entity.Product;
import ra.model.entity.ProductDetail;

import java.util.List;

public interface ProductDao<T, E> extends Dao<T, E> {
    T searchByName(String name);
    T getById(E e);
    List<Color> getAllColor();
    T getNewProduct (E id);
    boolean insertProductDetail(int proId, List<ProductDetail> list);
    List<Product> getProductForAdminTable(int id);
    List<ProductDetail> getProductDetailForAdmin(int id);
    boolean updatePrice(List<Float> listF,List<Integer> list);
    boolean updateQuantity(List<Integer> listQ,List<Integer> list);
    boolean deleteProductDetail(int id);
    List<Product> getProductForWeb();
    List<DisplayProduct> displayWebProduct();
    List<DisplayProduct> displayNewProducts();
    List<Color> getAllColorOfProduct(Integer id);
    DisplayProduct displaySingerProduct(int id);
    ProductDetail getProductDetailById(int id);
    List<DisplayProduct> getByCatalogId(int id);

}
