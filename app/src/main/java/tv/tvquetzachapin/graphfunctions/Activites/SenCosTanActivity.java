package tv.tvquetzachapin.graphfunctions.Activites;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import org.w3c.dom.Text;

import tv.tvquetzachapin.graphfunctions.R;

public class SenCosTanActivity extends AppCompatActivity {

    private String[] arraySpinnerMethod;
    private String itemSpinerMethod;
    private Spinner sMethod;

    private String[] arraySpinnerLad;
    private String itemSpinerLad;
    private Spinner sLad;

    private EditText txtAngle, txtCateto;
    private TextView textView16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sen_cos_tan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.arraySpinnerMethod = new String[] {
                "sen", "Cos", "Tan"
        };

        sMethod = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnerMethod);
        sMethod.setAdapter(adapter);

        this.arraySpinnerLad = new String[] {
                "Hipostenusa", "Adyacente", "Opuesto"
        };

        sLad = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnerLad);
        sLad.setAdapter(adapter2);

        txtAngle = (EditText)findViewById(R.id.angle);
        txtCateto = (EditText)findViewById(R.id.cat);
        textView16 = (TextView)findViewById(R.id.textView16);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                itemSpinerMethod = sMethod.getSelectedItem().toString();
                itemSpinerLad = sLad.getSelectedItem().toString();
                String angle = txtAngle.getText().toString();
                String cat = txtCateto.getText().toString();

                switch (itemSpinerMethod) {
                    case "sen":
                        if(itemSpinerLad.equals("Hipostenusa")) {

                            Argument a = new Argument("a = " + angle);
                            Argument lad = new Argument("c = " + cat);
                            Expression e = new Expression("c/sin(a)", a, lad);
                            Double Hip = e.calculate();

                            textView16.setText(Hip.toString());
                        } else {

                            Argument a = new Argument("a = " + angle);
                            Argument lad = new Argument("c = " + cat);
                            Expression e = new Expression("sin(a)/c", a, lad);
                            Double Hip = e.calculate();

                            textView16.setText(Hip.toString());
                        }
                    break;
                    case "Cos":
                        if(itemSpinerLad.equals("Hipostenusa")) {

                            Argument a = new Argument("a = " + angle);
                            Argument lad = new Argument("c = " + cat);
                            Expression e = new Expression("c/cos(a)", a, lad);
                            Double Hip = e.calculate();

                            textView16.setText(Hip.toString());
                        } else {

                            Argument a = new Argument("a = " + angle);
                            Argument lad = new Argument("c = " + cat);
                            Expression e = new Expression("cos(a)/c", a, lad);
                            Double Hip = e.calculate();

                            textView16.setText(Hip.toString());
                        }
                        break;
                    case "Tan":
                        if(itemSpinerLad.equals("Adyacente")) {

                            Argument a = new Argument("a = " + angle);
                            Argument lad = new Argument("c = " + cat);
                            Expression e = new Expression("c/tan(a)", a, lad);
                            Double Hip = e.calculate();

                            textView16.setText(Hip.toString());
                        } else {

                            Argument a = new Argument("a = " + angle);
                            Argument lad = new Argument("c = " + cat);
                            Expression e = new Expression("tan(a)/c", a, lad);
                            Double Hip = e.calculate();

                            textView16.setText(Hip.toString());
                        }
                        break;
                }
            }
        });
    }

}
