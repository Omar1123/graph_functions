package tv.tvquetzachapin.graphfunctions.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;

import tv.tvquetzachapin.graphfunctions.R;

public class MainActivity extends AppCompatActivity {

    //Primeros campos de la primera ecuación

    private MaterialEditText inputEq1_first;
    private MaterialEditText inputEq1_second;

    //Primeros campos de la segunda ecuación

    private MaterialEditText inputEq2_first;
    private MaterialEditText inputEq2_second;

    //Strings primer campo

    private String primerCampo;
    private String primerCampo_2;
    private String resultado;

    //Strings segundo campo

    private String segundoCampo;
    private String segundoCampo_2;

    //LLenar lista 1

    private String[] arraySpinner;
    private String itemSpiner;
    private Spinner s;

    //Llenar lista 2

    private String[] arraySpinner2;
    private String itemSpiner2;
    private Spinner s2;

    //Limite del primer campo

    private MaterialEditText main_activity_first_rule;
    private String valueOfFirstRule;

    //Limite del segundo campo

    private MaterialEditText main_activity_second_rule;
    private String valueOfSecondRule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //Primera Operacion

        inputEq1_first = (MaterialEditText) findViewById(R.id.main_activity_input_operation_first);
        inputEq1_second = (MaterialEditText) findViewById(R.id.Second_operation_1eq_input_main);

        //Segunda Operacion

        inputEq2_first = (MaterialEditText) findViewById(R.id.Second_operation_input_main);
        inputEq2_second = (MaterialEditText) findViewById(R.id.Second_operation_1_input_main);

        //Primer limite

        main_activity_first_rule = (MaterialEditText) findViewById(R.id.main_activity_first_rule);

        //Segundo Limite

        main_activity_second_rule = (MaterialEditText)findViewById(R.id.main_activity_second_rule);

        //Llenar listas

        this.arraySpinner = new String[] {
                "X >=", "X <=", "X >", "X <"
        };

        s = (Spinner) findViewById(R.id.textView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);

        this.arraySpinner2 = new String[] {
                "X >=", "X <=", "X >", "X <"
        };

        s2 = (Spinner) findViewById(R.id.textSecondRule);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner2);
        s2.setAdapter(adapter2);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                itemSpiner = s.getSelectedItem().toString();

                primerCampo = inputEq1_first.getText().toString();
                primerCampo_2 = inputEq1_second.getText().toString();
                resultado = primerCampo + primerCampo_2;

                operateEQ(resultado);

                Toast.makeText(MainActivity.this, "Valor:" + resultado, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "TEXT:" + itemSpiner, Toast.LENGTH_SHORT).show();
                Intent graphSomething = new Intent(MainActivity.this, GraphActivity.class);
                startActivity(graphSomething);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void operateEQ(String eqn) {
        Argument x = new Argument("x = 5");
        //Expression e = new Expression("3*(x)^2",x);
        Expression e = new Expression(eqn,x);
        Toast.makeText(MainActivity.this, "OP: " + e.calculate(), Toast.LENGTH_SHORT).show();
    }

    public void getLimit(String secondParameter, String caseLimit) {
        int limit = Integer.parseInt(secondParameter);

        switch (caseLimit) {
            case "X >=":

                break;
            case "X <=":

                break;
            case "<=":

                break;
            case "X >":

                break;
            case "X <":

                break;
            case "==":

                break;
        }
    }

    private void operateFirstEQ() {

    }
}
