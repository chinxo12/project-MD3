package ra.model.entity;

public class BillDetail {
    private ProductDetail productDetail;
    private float price;
    private int quantity;
    private float totalMoney;

    public BillDetail() {
    }

    public BillDetail(ProductDetail productDetail, float price, int quantity, float totalMoney) {
        this.productDetail = productDetail;
        this.price = price;
        this.quantity = quantity;
        this.totalMoney = totalMoney;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }
}
