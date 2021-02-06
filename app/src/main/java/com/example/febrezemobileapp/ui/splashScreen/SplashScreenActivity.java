package com.example.febrezemobileapp.ui.splashScreen;

import android.content.Intent;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.febrezemobileapp.MainActivity;
import com.example.febrezemobileapp.R;
import org.w3c.dom.Text;

public class SplashScreenActivity extends AppCompatActivity {

    private final int SPLASH_DELAY = 3000;

    ImageView _imLogo;
    TextView _tvTarih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        _imLogo = (ImageView)findViewById(R.id.imLogo);
        _tvTarih = (TextView)findViewById(R.id.tvTarih);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash_screen_anim);
        _imLogo.startAnimation(animation);
        _tvTarih.startAnimation(animation);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreenActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_DELAY);

    }
}