package com.example.febrezemobileapp.ui.market;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductRepository {
    private ProductDao productDao;
    private LiveData<List<Product>> allProducts;

    public ProductRepository(Application application){
        ProductDatabase database = ProductDatabase.getInstance(application);
        productDao = database.productDao();
        allProducts = productDao.GetAllProducts();
    }

    public void insert(Product product){
        new InsertProductAsyncTask(productDao).execute(product);
    }

    public void update(Product product){
        new UpdateProductAsyncTask(productDao).execute(product);
    }

    public void delete(Product product){
        new DeleteProductAsyncTask(productDao).execute(product);
    }

    public void deleteAllProducts(){
        new DeleteAllPRoductsProductAsyncTask(productDao).execute();
    }

    public LiveData<List<Product>> getAllProducts(){
        return allProducts;
    }



    private static class InsertProductAsyncTask extends AsyncTask<Product,Void,Void>{
        private ProductDao productDao;

        private InsertProductAsyncTask(ProductDao productDao){
            this.productDao = productDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.Insert(products[0]);
            return null;
        }
    }

    private static class UpdateProductAsyncTask extends AsyncTask<Product,Void,Void>{
        private ProductDao productDao;

        private UpdateProductAsyncTask(ProductDao productDao){
            this.productDao = productDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.Update(products[0]);
            return null;
        }
    }

    private static class DeleteProductAsyncTask extends AsyncTask<Product,Void,Void>{
        private ProductDao productDao;

        private DeleteProductAsyncTask(ProductDao productDao){
            this.productDao = productDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.Delete(products[0]);
            return null;
        }
    }

    private static class DeleteAllPRoductsProductAsyncTask extends AsyncTask<Void,Void,Void>{
        private ProductDao productDao;

        private DeleteAllPRoductsProductAsyncTask(ProductDao productDao){
            this.productDao = productDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            productDao.DeleteAllProducts();
            return null;
        }
    }

}
