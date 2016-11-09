package tv.tvquetzachapin.graphfunctions.Activites;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import tv.tvquetzachapin.graphfunctions.R;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = null;
                SharedPreferences preferenciasUsuario = SplashActivity.this.getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
                Boolean isRemembered = preferenciasUsuario.getBoolean("Recordarme", false);

                if (isRemembered) {
                    intent = new Intent(SplashActivity.this, NavigationActivity.class);
                }
                else {
                    intent = new Intent(SplashActivity.this, NavigationActivity.class);
                }
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

}
