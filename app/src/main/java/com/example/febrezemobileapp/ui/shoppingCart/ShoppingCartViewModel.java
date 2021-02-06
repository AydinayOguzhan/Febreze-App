package com.example.febrezemobileapp.ui.shoppingCart;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.febrezemobileapp.ui.market.Product;
import com.example.febrezemobileapp.ui.market.ProductRepository;

import java.util.List;

public class ShoppingCartViewModel extends AndroidViewModel {

    private ShoppingCartRepository repository;
    private LiveData<List<ShoppingCart>> allShoppingCart;


    public ShoppingCartViewModel(@NonNull Application application) {
        super(application);
        repository = new ShoppingCartRepository(application);
        allShoppingCart = repository.getAllShoppingCart();
    }

    public void insert(ShoppingCart shoppingCart){
        repository.insert(shoppingCart);
    }

    public void update(ShoppingCart shoppingCart){
        repository.update(shoppingCart);
    }

    public void delete(ShoppingCart shoppingCart){
        repository.delete(shoppingCart);
    }

    public void deleteAllShoppingCart(){ repository.deleteAllShoppingCart(); }

    public LiveData<List<ShoppingCart>> getAllShoppingCart(){
        return allShoppingCart;
    }

}