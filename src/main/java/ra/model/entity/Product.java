package ra.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int productId;
    private String productName;
    private String productImage;
    private List<String> imageList = new ArrayList<>();
    private Catalog catalog;
    private String discription;
    private List<ProductDetail> listProductDetail =new ArrayList<>();
    private float star;
    private List<FeedBack> listFeedBack;
    private boolean productStatus;
    private User user;

    public Product() {
    }

    public Product(int productId, String productName, String productImage, List<String> imageList, Catalog catalog,
                   String discription, List<ProductDetail> listProductDetail, float star, List<FeedBack> listFeedBack, boolean productStatus, User user) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.imageList = imageList;
        this.catalog = catalog;
        this.discription = discription;
        this.listProductDetail = listProductDetail;
        this.star = star;
        this.listFeedBack = listFeedBack;
        this.productStatus = productStatus;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public List<ProductDetail> getListProductDetail() {
        return listProductDetail;
    }

    public void setListProductDetail(List<ProductDetail> listProductDetail) {
        this.listProductDetail = listProductDetail;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public List<FeedBack> getListFeedBack() {
        return listFeedBack;
    }

    public void setListFeedBack(List<FeedBack> listFeedBack) {
        this.listFeedBack = listFeedBack;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
}
