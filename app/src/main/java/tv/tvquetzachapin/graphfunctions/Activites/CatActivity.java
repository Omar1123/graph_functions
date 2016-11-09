package tv.tvquetzachapin.graphfunctions.Activites;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;

import tv.tvquetzachapin.graphfunctions.R;

public class CatActivity extends AppCompatActivity {

    private EditText cat3, cat4;
    private TextView txtR1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cat3 = (EditText) findViewById(R.id.ct4);
        cat4 = (EditText) findViewById(R.id.ct5);
        txtR1 = (TextView) findViewById(R.id.txtCat);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String firstValue = cat3.getText().toString();
                String secondValue = cat4.getText().toString();

                Argument x = new Argument("x = " + firstValue);
                Argument y = new Argument("y = " + secondValue);
                Expression e = new Expression("(y)^2-(x)^2", x,y);

                Double rst = e.calculate();

                Argument rz = new Argument("r = " + rst);
                Expression raiz = new Expression("sqrt(r)",rz);

                String rzm = Double.toString(raiz.calculate());

                txtR1.setText(rzm.substring(0, 2));

                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
            }
        });
    }

}
