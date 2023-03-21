package ra.model.entity;

public class ProductDetail {
    private int productDetailId;
    private Size size;
    private Color color;
    private float price;
    private int quantity;
    private int sellQuantity;
    private int permisson;

    public ProductDetail() {
    }

    public ProductDetail(int productDetailId, Size size, Color color, float price, int quantity, int sellQuantity, int permisson) {
        this.productDetailId = productDetailId;
        this.size = size;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
        this.sellQuantity = sellQuantity;
        this.permisson = permisson;
    }

    public int getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(int productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

    public int getSellQuantity() {
        return sellQuantity;
    }

    public void setSellQuantity(int sellQuantity) {
        this.sellQuantity = sellQuantity;
    }

    public int getPermisson() {
        return permisson;
    }

    public void setPermisson(int permisson) {
        this.permisson = permisson;
    }
}
