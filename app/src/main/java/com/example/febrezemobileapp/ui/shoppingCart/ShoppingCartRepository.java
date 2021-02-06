package com.example.febrezemobileapp.ui.shoppingCart;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.example.febrezemobileapp.ui.market.Product;
import com.example.febrezemobileapp.ui.market.ProductDao;
import com.example.febrezemobileapp.ui.market.ProductRepository;

import java.util.List;

public class ShoppingCartRepository {

    private ShoppingCartDao shoppingCartDao;
    private LiveData<List<ShoppingCart>> allShoppingCart;

    public ShoppingCartRepository(Application application){
        ShoppingCartDatabase database = ShoppingCartDatabase.getInstance(application);
        shoppingCartDao = database.shoppingCartDao();
        allShoppingCart = shoppingCartDao.GetAllShoppingCart();
    }

    public void insert(ShoppingCart shoppingCart){
        new ShoppingCartRepository.InsertShoppingCartAsyncTask(shoppingCartDao).execute(shoppingCart);
    }

    public void update(ShoppingCart shoppingCart){
        new ShoppingCartRepository.UpdateShoppingCartAsyncTask(shoppingCartDao).execute(shoppingCart);
    }

    public void delete(ShoppingCart shoppingCart){
        new ShoppingCartRepository.DeleteShoppingCartAsyncTask(shoppingCartDao).execute(shoppingCart);
    }

    public void deleteAllShoppingCart(){
        new ShoppingCartRepository.DeleteAllShoppingCartAsyncTask(shoppingCartDao).execute();
    }

    public LiveData<List<ShoppingCart>> getAllShoppingCart(){
        return allShoppingCart;
    }



    private static class InsertShoppingCartAsyncTask extends AsyncTask<ShoppingCart,Void,Void> {
        private ShoppingCartDao shoppingCartDao;

        private InsertShoppingCartAsyncTask(ShoppingCartDao shoppingCartDao){
            this.shoppingCartDao = shoppingCartDao;
        }

        @Override
        protected Void doInBackground(ShoppingCart... shoppingCarts) {
            shoppingCartDao.Insert(shoppingCarts[0]);
            return null;
        }
    }

    private static class UpdateShoppingCartAsyncTask extends AsyncTask<ShoppingCart,Void,Void>{
        private ShoppingCartDao shoppingCartDao;

        private UpdateShoppingCartAsyncTask(ShoppingCartDao shoppingCartDao){
            this.shoppingCartDao = shoppingCartDao;
        }

        @Override
        protected Void doInBackground(ShoppingCart... shoppingCart) {
            shoppingCartDao.Update(shoppingCart[0]);
            return null;
        }
    }

    private static class DeleteShoppingCartAsyncTask extends AsyncTask<ShoppingCart,Void,Void>{
        private ShoppingCartDao shoppingCartDao;

        private DeleteShoppingCartAsyncTask(ShoppingCartDao shoppingCartDao){
            this.shoppingCartDao = shoppingCartDao;
        }

        @Override
        protected Void doInBackground(ShoppingCart... shoppingCart) {
            shoppingCartDao.Delete(shoppingCart[0]);
            return null;
        }

        public void execute(int id) {
        }
    }

    private static class DeleteAllShoppingCartAsyncTask extends AsyncTask<Void,Void,Void>{
        private ShoppingCartDao shoppingCartDao;

        private DeleteAllShoppingCartAsyncTask(ShoppingCartDao shoppingCartDao){
            this.shoppingCartDao = shoppingCartDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            shoppingCartDao.DeleteAllProducts();
            return null;
        }
    }
}
