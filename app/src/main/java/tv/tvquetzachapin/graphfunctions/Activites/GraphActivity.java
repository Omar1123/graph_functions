package tv.tvquetzachapin.graphfunctions.Activites;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import tv.tvquetzachapin.graphfunctions.R;

public class GraphActivity extends AppCompatActivity {

    //Primera Grafica

    private int yvalueGraph1 = 0;
    private int yvalueGraph2 = 0;
    private int yvalueGraph3 = 0;
    private int yvalueGraph4 = 0;
    private int yvalueGraph5 = 0;

    //Segunda Grafica

    private int yvalue2Graph1 = 0;
    private int yvalue2Graph2 = 0;
    private int yvalue2Graph3 = 0;
    private int yvalue2Graph4 = 0;
    private int yvalue2Graph5 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backHome = new Intent(GraphActivity.this, MainActivity.class);
                startActivity(backHome);
            }
        });

        //Se reciven los valores de la grafica

        Intent mIntent = getIntent();

        //Valores Grafica 1

        yvalueGraph1 = mIntent.getIntExtra("xValue0", 0);
        yvalueGraph2 = mIntent.getIntExtra("xValue1", 0);
        yvalueGraph3 = mIntent.getIntExtra("xValue2", 0);
        yvalueGraph4 = mIntent.getIntExtra("xValue3", 0);
        yvalueGraph5 = mIntent.getIntExtra("xValue4", 0);

        //Valores Grafica 2

        yvalue2Graph1 = mIntent.getIntExtra("xValue20", 0);
        yvalue2Graph2 = mIntent.getIntExtra("xValue21", 0);
        yvalue2Graph3 = mIntent.getIntExtra("xValue22", 0);
        yvalue2Graph4 = mIntent.getIntExtra("xValue23", 0);
        yvalue2Graph5 = mIntent.getIntExtra("xValue24", 0);

        GraphView graph = (GraphView) findViewById(R.id.graph);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
            new DataPoint(0, yvalueGraph1),
            new DataPoint(1, yvalueGraph2),
            new DataPoint(2, yvalueGraph3),
            new DataPoint(3, yvalueGraph4),
            new DataPoint(4, yvalueGraph5)
        });

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(new DataPoint[] {
            new DataPoint(0, yvalue2Graph1),
            new DataPoint(1, yvalue2Graph2),
            new DataPoint(2, yvalue2Graph3),
            new DataPoint(3, yvalue2Graph4),
            new DataPoint(4, yvalue2Graph5)
        });

        series.setDrawDataPoints(true);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-10);
        graph.getViewport().setMaxY(20);

        graph.getViewport().setScrollable(true);

        // set second scale
        graph.getSecondScale().addSeries(series2);
        // the y bounds are always manual for second scale
        graph.getSecondScale().setMinY(-10);
        graph.getSecondScale().setMaxY(20);
        graph.addSeries(series);
        series2.setColor(Color.RED);
        graph.getGridLabelRenderer().setVerticalLabelsSecondScaleColor(Color.RED);

    }

    /*LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
            new DataPoint(0, yvalueGraph1),
            new DataPoint(1, yvalueGraph2),
            new DataPoint(2, yvalueGraph3),
            new DataPoint(3, yvalueGraph4),
            new DataPoint(4, yvalueGraph5)
    });
    graph.addSeries(series);

    LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(new DataPoint[] {
            new DataPoint(0, yvalue2Graph1),
            new DataPoint(1, yvalue2Graph2),
            new DataPoint(2, yvalue2Graph3),
            new DataPoint(3, yvalue2Graph4),
            new DataPoint(4, yvalue2Graph5)
    });*/
}
