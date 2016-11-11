package tv.tvquetzachapin.graphfunctions.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import tv.tvquetzachapin.graphfunctions.R;

public class Trigonometry2Activity extends AppCompatActivity {

    Button btnHip, btnCat, btnTrig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trigonometry2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnHip = (Button)findViewById(R.id.btnHipotenusa);
        btnCat = (Button)findViewById(R.id.btnCat);
        btnTrig = (Button)findViewById(R.id.btnTrig);

        btnHip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intHip = new Intent(Trigonometry2Activity.this, HipActivity.class);
                startActivity(intHip);
            }
        });

        btnCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intCat = new Intent(Trigonometry2Activity.this, CatActivity.class);
                startActivity(intCat);
            }
        });

        btnTrig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intAng = new Intent(Trigonometry2Activity.this, SenCosTanActivity.class);
                startActivity(intAng);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
