package com.example.pharmacy;

public class HorizontalProductScrollModel {

    private int productImage;
    private String ProductTitle;
    private String ProductDescription;
    private String ProductPrice;

    public HorizontalProductScrollModel(int productImage, String productTitle, String productDescription, String productPrice) {
        this.productImage = productImage;
        ProductTitle = productTitle;
        ProductDescription = productDescription;
        ProductPrice = productPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return ProductTitle;
    }

    public void setProductTitle(String productTitle) {
        ProductTitle = productTitle;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }
}
