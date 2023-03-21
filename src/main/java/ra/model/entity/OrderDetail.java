package ra.model.entity;

public class OrderDetail {
    private int orderDetailId;

    private int quantity;
    private float price;
    private float totalMoney;
    private Cart cart;

    public OrderDetail() {
    }

    public OrderDetail(int orderDetailId, int quantity, float price, float totalMoney, Cart cart) {
        this.orderDetailId = orderDetailId;
        this.quantity = quantity;
        this.price = price;
        this.totalMoney = totalMoney;
        this.cart = cart;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
