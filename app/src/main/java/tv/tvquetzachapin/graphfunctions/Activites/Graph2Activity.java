package tv.tvquetzachapin.graphfunctions.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tv.tvquetzachapin.graphfunctions.R;
import android.app.*;
import android.graphics.*;
import android.os.*;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.androidplot.util.*;
import com.androidplot.xy.*;

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;

import java.text.*;
import java.util.*;


public class Graph2Activity extends AppCompatActivity {

    private XYPlot plot;
    private String eqn1, eqn2, eqn3 = null;

    /**
     * Custom line label renderer that highlights origin labels
     */
    class MyLineLabelRenderer extends XYGraphWidget.LineLabelRenderer {

        @Override
        protected void drawLabel(Canvas canvas, String text, Paint paint,
                                 float x, float y, boolean isOrigin) {
            if(isOrigin) {
                // make the origin labels red:
                final Paint originPaint = new Paint(paint);
                originPaint.setColor(Color.RED);
                super.drawLabel(canvas, text, originPaint, x, y , isOrigin);
            } else {
                super.drawLabel(canvas, text, paint, x, y , isOrigin);
            }
        }
    }

    /**
     * Draws every other tick label and renders text in gray instead of white.
     */
    class MySecondaryLabelRenderer extends MyLineLabelRenderer {


        @Override
        public void drawLabel(Canvas canvas, XYGraphWidget.LineLabelStyle style,
                              Number val, float x, float y, boolean isOrigin) {
            if(val.doubleValue() % 6 == 0) {
                final Paint paint = style.getPaint();
                if(!isOrigin) {
                    paint.setColor(Color.GRAY);
                }
                super.drawLabel(canvas, style, val, x, y, isOrigin);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph2);

        // initialize our XYPlot reference:
        plot = (XYPlot) findViewById(R.id.plot);

        plot.setDomainStep(StepMode.INCREMENT_BY_VAL, 1);
        plot.setRangeStep(StepMode.INCREMENT_BY_VAL, 1);

        plot.centerOnDomainOrigin(0);
        plot.centerOnRangeOrigin(0);

        // create formatters to use for drawing a series using LineAndPointRenderer
        // and configure them from xml:
        LineAndPointFormatter series1Format = new LineAndPointFormatter();
        series1Format.configure(getApplicationContext(),
                R.xml.line_point_formatter);

        // use our custom renderer to make origin labels red
        plot.getGraph().setLineLabelRenderer(XYGraphWidget.Edge.BOTTOM, new MyLineLabelRenderer());
        plot.getGraph().setLineLabelRenderer(XYGraphWidget.Edge.LEFT, new MyLineLabelRenderer());

        // skip every other line for top and right edge labels
        plot.getGraph().setLineLabelRenderer(XYGraphWidget.Edge.RIGHT, new MySecondaryLabelRenderer());
        plot.getGraph().setLineLabelRenderer(XYGraphWidget.Edge.TOP, new MySecondaryLabelRenderer());

        // don't show decimal places for top and right edge labels
        plot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.TOP).setFormat(new DecimalFormat("0"));
        plot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.RIGHT).setFormat(new DecimalFormat("0"));

        // create a dash effect for domain and range grid lines:
        DashPathEffect dashFx = new DashPathEffect(
                new float[] {PixelUtils.dpToPix(3), PixelUtils.dpToPix(3)}, 0);
        plot.getGraph().getDomainGridLinePaint().setPathEffect(dashFx);
        plot.getGraph().getRangeGridLinePaint().setPathEffect(dashFx);

        // add a new series' to the xyplot:
        //plot.addSeries(generateSeries(-5, 3, 10), series1Format);

        //Se reciven los valores de la grafica

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            eqn1 = extras.getString("eqn1");
            eqn2 = extras.getString("eqn2");
            eqn3 = extras.getString("eqn3");
        }

        plot.addSeries(generateEquation1(-5, 3, 10, eqn1), series1Format);
        plot.addSeries(generateEquation2(-5, 3, 10, eqn2), series1Format);
        plot.addSeries(generateEquation3(-5, 3, 10, eqn3), series1Format);
    }

    //1 Grafica

    protected XYSeries generateEquation1(double minX, double maxX, double resolution, String equation1) {
        final double range = maxX - minX;
        final double step = range / resolution;
        List<Number> xVals = new ArrayList<>();
        List<Number> yVals = new ArrayList<>();

        double x = minX;
        while (x <= maxX) {
            xVals.add(x);
            yVals.add(operateEquation1(equation1,x));
            x +=step;
        }

        return new SimpleXYSeries(xVals, yVals,"");
    }

    protected double operateEquation1(String eqn1, double x) {

        Argument x1 = new Argument("x = " + x);
        Expression e = new Expression(eqn1,x1);
        Double saveValuePositionY = e.calculate();
        int i = saveValuePositionY.intValue();

        return saveValuePositionY;

    }

    //2 Grafica

    protected XYSeries generateEquation2(double minX, double maxX, double resolution, String equation2) {
        final double range = maxX - minX;
        final double step = range / resolution;
        List<Number> xVals = new ArrayList<>();
        List<Number> yVals = new ArrayList<>();

        double x = minX;
        while (x <= maxX) {
            xVals.add(x);
            yVals.add(operateEquation2(equation2,x));
            x +=step;
        }

        return new SimpleXYSeries(xVals, yVals, "");
    }

    protected double operateEquation2(String eqn2, double x) {

        Argument x1 = new Argument("x = " + x);
        Expression e = new Expression(eqn2,x1);
        Double saveValuePositionY = e.calculate();
        int i = saveValuePositionY.intValue();

        return saveValuePositionY;
    }

    //3 Grafica

    protected XYSeries generateEquation3(double minX, double maxX, double resolution, String equation3) {
        final double range = maxX - minX;
        final double step = range / resolution;
        List<Number> xVals = new ArrayList<>();
        List<Number> yVals = new ArrayList<>();

        double x = minX;
        while (x <= maxX) {
            xVals.add(x);
            yVals.add(operateEquation2(equation3,x));
            x +=step;
        }

        return new SimpleXYSeries(xVals, yVals, "");
    }

    protected double operateEquation3(String eqn3, double x) {

        Argument x1 = new Argument("x = " + x);
        Expression e = new Expression(eqn3,x1);
        Double saveValuePositionY = e.calculate();
        int i = saveValuePositionY.intValue();

        return saveValuePositionY;
    }
}
