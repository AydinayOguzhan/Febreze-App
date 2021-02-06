package com.example.febrezemobileapp.ui.shoppingCart;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface ShoppingCartDao {

    @Insert
    void Insert(ShoppingCart shoppingCart);

    @Update
    void Update(ShoppingCart shoppingCart);

    @Delete
    void Delete(ShoppingCart shoppingCart);

    @Query("DELETE FROM shopping_cart_table")
    void DeleteAllProducts();

    @Query("SELECT * FROM shopping_cart_table ORDER BY productId DESC")
    LiveData<List<ShoppingCart>> GetAllShoppingCart();
}
