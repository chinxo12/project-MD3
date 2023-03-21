package ra.model.entity;

public class Size {
    private int sizeId;
    private String sizeName;
    private int catalogId;

    public Size() {
    }


    public Size(int sizeId, String sizeName, int catalogId) {
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.catalogId = catalogId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }
}
