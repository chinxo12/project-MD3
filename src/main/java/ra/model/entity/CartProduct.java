package ra.model.entity;

public class CartProduct {
    private ProductDetail productDetail;
    private String productName;
    private String productImage;
    private int productId;

    public CartProduct() {
    }

    public CartProduct(ProductDetail productDetail, String productName, String productImage, int productId) {
        this.productDetail = productDetail;
        this.productName = productName;
        this.productImage = productImage;
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
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
}
