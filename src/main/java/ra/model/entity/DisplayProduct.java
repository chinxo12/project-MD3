package ra.model.entity;

public class DisplayProduct {
    private Product product;
    private float maxPrice;
    private float minPrice;

    public DisplayProduct() {
    }

    public DisplayProduct(Product product, float maxPrice, float minPrice) {
        this.product = product;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
    }
}
