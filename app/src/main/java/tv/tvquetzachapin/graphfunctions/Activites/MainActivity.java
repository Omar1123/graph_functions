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

import java.util.ArrayList;
import java.util.List;

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
    private String resultado2;

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

                //Primer resultado

                itemSpiner = s.getSelectedItem().toString(); //Obtiene el parametro para el limite

                primerCampo = inputEq1_first.getText().toString(); //Obtiene el valor del primer campo(x)
                primerCampo_2 = inputEq1_second.getText().toString(); //Obtiene el valor del segundo campo(y)

                segundoCampo = inputEq2_first.getText().toString();
                segundoCampo_2 = inputEq2_second.getText().toString();


                resultado = primerCampo + primerCampo_2; //Une la ecuacion para poder resolverla
                resultado2 = segundoCampo + segundoCampo_2; //Une la segunda ecuacion para resolverla

                operateEQ(resultado,resultado2); //Despeja la ecuacion y retorna los valores a operar
                //Segundo Resultado

                //valueOfSecondRule = main_activity_first_rule.getText().toString(); //Obtiene el parametro del limite

                //getLimit(valueOfSecondRule,itemSpiner); //Obtiene el limite, si es vacio o lleno
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

    public void operateEQ(String eqn1, String eqn2) {

        Intent graphSomething = new Intent(MainActivity.this, GraphActivity.class);
        String listNumbers;

        for(int i=0; i<=5; i++) {
            Argument x = new Argument("x = " + i);
            Expression e = new Expression(eqn1,x);
            Double saveValuePositionY = e.calculate();
            int positionY = saveValuePositionY.intValue();

            graphSomething.putExtra("xValue" + i, positionY);
        }

        for(int i=0; i<=5; i++) {
            Argument x1 = new Argument("x = " + i);
            Expression e = new Expression(eqn2,x1);
            Double saveValuePositionY1 = e.calculate();
            int positionY1 = saveValuePositionY1.intValue();

            graphSomething.putExtra("xValue2" + i, positionY1);
        }

        startActivity(graphSomething);
    }

    public void getLimit(String secondParameter, String caseLimit) {

        int limit = Integer.parseInt(secondParameter);

        switch (caseLimit) {
            case "X >=":
                Toast.makeText(MainActivity.this, "Si Incluye:" + resultado, Toast.LENGTH_SHORT).show();
                break;
            case "X <=":
                Toast.makeText(MainActivity.this, "No Incluye:" + resultado, Toast.LENGTH_SHORT).show();
                break;
            case "X >":
                Toast.makeText(MainActivity.this, "Si Incluye:" + resultado, Toast.LENGTH_SHORT).show();
                break;
            case "X <":
                Toast.makeText(MainActivity.this, "No Incluye:" + resultado, Toast.LENGTH_SHORT).show();
                break;
            case "==":
                Toast.makeText(MainActivity.this, "NPI" + resultado, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
