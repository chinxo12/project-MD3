package ra.model.entity;

public class Image {
    private int image;
    private String imageLink;
    private boolean imageStatus;

    public Image() {
    }

    public Image(int image, String imageLink, boolean imageStatus) {
        this.image = image;
        this.imageLink = imageLink;
        this.imageStatus = imageStatus;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public boolean isImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(boolean imageStatus) {
        this.imageStatus = imageStatus;
    }
}
