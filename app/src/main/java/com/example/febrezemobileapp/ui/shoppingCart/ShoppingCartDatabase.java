package com.example.febrezemobileapp.ui.shoppingCart;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.febrezemobileapp.ui.market.Product;
import com.example.febrezemobileapp.ui.market.ProductDao;
import com.example.febrezemobileapp.ui.market.ProductDatabase;

@Database(entities = ShoppingCart.class, version = 3)
public abstract class ShoppingCartDatabase extends RoomDatabase {

    private static ShoppingCartDatabase instance;

    public abstract ShoppingCartDao shoppingCartDao();

    public static synchronized ShoppingCartDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),ShoppingCartDatabase.class, "shopping_cart_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };


    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void> {
        private ShoppingCartDao shoppingCartDao;

        private PopulateDbAsyncTask(ShoppingCartDatabase db){
            shoppingCartDao = db.shoppingCartDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }
}
