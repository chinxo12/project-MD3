package ra.model.entity;

public class Cart {
    private int cartId;
    private User user;
    private CartProduct cartProduct;
    private boolean cartStatus = false;
    private int quantity;
    public Cart() {
    }

    public Cart(int cartId, User user, CartProduct cartProduct, boolean cartStatus, int quantity) {
        this.cartId = cartId;
        this.user = user;
        this.cartProduct = cartProduct;
        this.cartStatus = cartStatus;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CartProduct getCartProduct() {
        return cartProduct;
    }

    public void setCartProduct(CartProduct cartProduct) {
        this.cartProduct = cartProduct;
    }


    public boolean isCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(boolean cartStatus) {
        this.cartStatus = cartStatus;
    }
}
