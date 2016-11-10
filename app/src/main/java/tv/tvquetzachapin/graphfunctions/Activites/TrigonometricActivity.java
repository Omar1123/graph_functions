package tv.tvquetzachapin.graphfunctions.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tv.tvquetzachapin.graphfunctions.R;

public class TrigonometricActivity extends AppCompatActivity {

    Button btnHip, btnCat, btnTrig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trigonometric);

        btnHip = (Button)findViewById(R.id.btnHipotenusa);
        btnCat = (Button)findViewById(R.id.btnCat);
        btnTrig = (Button)findViewById(R.id.btnTrig);

        btnHip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intHip = new Intent(TrigonometricActivity.this, HipActivity.class);
                startActivity(intHip);
            }
        });

        btnCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intCat = new Intent(TrigonometricActivity.this, CatActivity.class);
                startActivity(intCat);
            }
        });

        btnTrig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intAng = new Intent(TrigonometricActivity.this, SenCosTanActivity.class);
                startActivity(intAng);
            }
        });
    }
}
