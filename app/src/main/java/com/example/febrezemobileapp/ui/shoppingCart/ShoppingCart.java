package com.example.febrezemobileapp.ui.shoppingCart;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "shopping_cart_table")
public class ShoppingCart {

    @PrimaryKey(autoGenerate = true)
    private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productImage;


    public ShoppingCart(String productName, String productDescription, double productPrice, String productImage) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productImage = productImage;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductImage() {
        return productImage;
    }
}
