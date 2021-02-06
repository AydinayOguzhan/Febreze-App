package com.example.febrezemobileapp.ui.market;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void Insert(Product product);

    @Update
    void Update(Product product);

    @Delete
    void Delete(Product product);

    @Query("DELETE FROM products_table")
    void DeleteAllProducts();

    @Query("SELECT * FROM products_table ORDER BY productId DESC")
    LiveData<List<Product>> GetAllProducts();
}
