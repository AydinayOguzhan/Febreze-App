package com.example.febrezemobileapp.ui.market;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Product.class, version = 5)
public abstract class ProductDatabase extends RoomDatabase {

    private static ProductDatabase instance;

    public abstract ProductDao productDao();

    public static synchronized ProductDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),ProductDatabase.class, "product_database")
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


    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private ProductDao productDao;

        private PopulateDbAsyncTask(ProductDatabase db){
            productDao = db.productDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            productDao.Insert(new Product("Japon Kiraz Çiçekleri","Oda Spreyi", 23.02,"https://res.cloudinary.com/pxty/image/upload/c_scale,f_auto,q_60/v1/joltc2/~/media/growing-families-version1/gf-tr/product/new-product/febreze/febreze-hava-ferahlatc-sprey-oda-kokusu-japon-kiraz-iekleri-300-ml.jpg?la=tr-tr&v=1-201903290840&hash=092384B95B2B197B2F5D17E4B3C065C87DF58E1C"));
            productDao.Insert(new Product("Lavanta Konforu","Oda Spreyi", 26.50,"https://productimages.hepsiburada.net/s/41/550/10701270024242.jpg/format:webp"));
            productDao.Insert(new Product("Evcil Hayvan","Oda Spreyi", 22.00,"https://productimages.hepsiburada.net/s/31/550/10341982535730.jpg/format:webp"));
            productDao.Insert(new Product("Kumaş Ferahlatıcı","Kumaş Spreyi", 24.96,"https://productimages.hepsiburada.net/s/37/550/10554821771314.jpg/format:webp"));
            productDao.Insert(new Product("Efsanevi Himalaya","Oda Spreyi", 21.76,"https://cdn.dsmcdn.com/ty16/product/media/images/20201009/20/14621628/91956141/0/0_org.jpg"));
            productDao.Insert(new Product("Bahar Çiçekleri","Araba Kokusu", 19.50,"https://productimages.hepsiburada.net/s/37/550/10572385714226.jpg/format:webp"));
            productDao.Insert(new Product("Okyanus Esintisi","Araba Kokusu",22.99,"https://productimages.hepsiburada.net/s/38/550/10613361737778.jpg/format:webp"));
            productDao.Insert(new Product("Sigara Kokusu Giderici","Araba Kokusu",20.40,"https://productimages.hepsiburada.net/s/38/550/10613362524210.jpg/format:webp"));
            productDao.Insert(new Product("Felight Kedi Kumu","Kedi Kumu", 39.90,"https://productimages.hepsiburada.net/s/35/550/10488854577202.jpg/format:webp"));
            return null;
        }
    }
}


