package DTO;

public class Product {
    private int productNo;
    private String productName;
    private String imageName;
    private String imagePath;
    private String description;
    private int price;

    // 기본 생성자
    public Product() {}

    // 생성자 (필요하면 추가)

    // Getter & Setter
    public int getProductNo() {
        return productNo;
    }
    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getImageName() {
        return imageName;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
