package tv.tvquetzachapin.graphfunctions.Activites;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;

import tv.tvquetzachapin.graphfunctions.R;

public class HipActivity extends AppCompatActivity {

    private EditText cat1, cat2;
    private TextView txtR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hip);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cat1 = (EditText) findViewById(R.id.ct1);
        cat2 = (EditText) findViewById(R.id.ct2);
        txtR = (TextView) findViewById(R.id.txtHip);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String firstValue = cat1.getText().toString();
                String secondValue = cat2.getText().toString();

                Argument x = new Argument("x = " + firstValue);
                Argument y = new Argument("y = " + secondValue);
                Expression e = new Expression("(x)^2+(y)^2", x,y);

                Double rst = e.calculate();

                Argument rz = new Argument("r = " + rst);
                Expression raiz = new Expression("sqrt(r)",rz);

                String rzm = Double.toString(raiz.calculate());

                txtR.setText(rzm.substring(0, 2));

                //Snackbar.make(view, "The value is: " + rzm, Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
            }
        });
    }

}
