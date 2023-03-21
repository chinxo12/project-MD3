package ra.model.sevicesImp;

import ra.model.dao.ProductDao;
import ra.model.daoIml.ProductDaoImp;
import ra.model.entity.Color;
import ra.model.entity.DisplayProduct;
import ra.model.entity.Product;
import ra.model.entity.ProductDetail;
import ra.model.sevices.ProductSevices;

import java.util.List;

public class ProductSevicesImp implements ProductSevices<ra.model.entity.Product, Integer> {
    ProductDao productDao = new ProductDaoImp();
    @Override
    public Product searchByName(String name) {
        return null;
    }

    @Override
    public Product getById(Integer integer) {
        return (Product) productDao.getById(integer);
    }

    @Override
    public List<Color> getAllColor() {
        return productDao.getAllColor();
    }

    @Override
    public Product getNewProduct(Integer id) {
        return (Product) productDao.getNewProduct(id);
    }

    @Override
    public boolean insertProductDetail(int proId, List<ProductDetail> list) {
        return productDao.insertProductDetail(proId,list);
    }

    @Override
    public List<Product> getProductForAdminTable(int id) {
        return productDao.getProductForAdminTable(id);
    }

    @Override
    public List<ProductDetail> getProductDetailForAdmin(int id) {
        return productDao.getProductDetailForAdmin(id);
    }

    @Override
    public boolean updatePrice(List<Float> listF, List<Integer> list) {
        return productDao.updatePrice(listF,list);
    }

    @Override
    public boolean updateQuantity(List<Integer> listQ, List<Integer> list) {
        return productDao.updateQuantity(listQ,list);
    }

    @Override
    public boolean deleteProductDetail(int id) {
        return productDao.deleteProductDetail(id);
    }

    @Override
    public List<Product> getProductForWeb() {
        return productDao.getProductForWeb();
    }

    @Override
    public List<DisplayProduct> displayWebProduct() {
        return productDao.displayWebProduct();
    }

    @Override
    public List<Color> getAllColorOfProduct(Integer id) {
        return productDao.getAllColorOfProduct(id);
    }

    @Override
    public List<DisplayProduct> displayNewProducts() {
        return productDao.displayNewProducts();
    }

    @Override
    public DisplayProduct displaySingerProduct(int id) {
        return productDao.displaySingerProduct(id);
    }

    @Override
    public ProductDetail getProductDetailById(int id) {
        return productDao.getProductDetailById(id);
    }

    @Override
    public List<DisplayProduct> getByCatalogId(int id) {
        return productDao.getByCatalogId(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public boolean insert(Product product) {
        return productDao.insert(product);
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }
}
