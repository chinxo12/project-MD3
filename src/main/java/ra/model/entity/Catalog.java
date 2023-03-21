package ra.model.entity;

public class Catalog {
    private int catalogId;
    private String catalogName;
    private int parentId;
    private boolean catalogStatus = true;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int parentId, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.parentId = parentId;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
}
