package com.asif047.pocketmoney;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphActivity extends AppCompatActivity {

    BarChart barChart;

    private double jan_income=0.0, feb_income = 0.0, mar_income = 0.0, apr_income = 0.0,
            may_income = 0.0, june_income =0.0, july_income = 0.0, aug_income =0.0,
            sep_income = 0.0, oct_income = 0.0, nov_income = 0.0, dec_income =0.0;


    private double jan_expense=0.0, feb_expense = 0.0, mar_expense = 0.0, apr_expense = 0.0,
            may_expense = 0.0, june_expense =0.0, july_expense = 0.0, aug_expense =0.0,
            sep_expense = 0.0, oct_expense = 0.0, nov_expense = 0.0, dec_expense =0.0;

    private float mIncome[];
    private float max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        barChart = findViewById(R.id.barchart);

        barChart.setDrawBarShadow(true);
        barChart.setDrawValueAboveBar(true);

        barChart.setMaxVisibleValueCount(50);
        barChart.setPinchZoom(true);
        barChart.setDrawGridBackground(false);

        barChart.getDescription().setEnabled(false);
        barChart.getAxisRight().setDrawLabels(false);

        ArrayList<BarEntry> barentries = new ArrayList<>();
        ArrayList<BarEntry> barentries1 = new ArrayList<>();



        jan_income = Double.parseDouble(getSharedPreferences("PREFERENCE", MODE_PRIVATE).getString("jan_income", "0.0"));
        feb_income = Double.parseDouble(getSharedPreferences("PREFERENCE2", MODE_PRIVATE).getString("feb_income", "0.0"));
        mar_income = Double.parseDouble(getSharedPreferences("PREFERENCE3", MODE_PRIVATE).getString("mar_income", "0.0"));
        apr_income = Double.parseDouble(getSharedPreferences("PREFERENCE4", MODE_PRIVATE).getString("apr_income", "0.0"));
        may_income = Double.parseDouble(getSharedPreferences("PREFERENCE5", MODE_PRIVATE).getString("may_income", "0.0"));
        june_income = Double.parseDouble(getSharedPreferences("PREFERENCE6", MODE_PRIVATE).getString("june_income", "0.0"));
        july_income = Double.parseDouble(getSharedPreferences("PREFERENCE7", MODE_PRIVATE).getString("july_income", "0.0"));
        aug_income = Double.parseDouble(getSharedPreferences("PREFERENCE8", MODE_PRIVATE).getString("aug_income", "0.0"));
        sep_income = Double.parseDouble(getSharedPreferences("PREFERENCE9", MODE_PRIVATE).getString("sep_income", "0.0"));
        oct_income = Double.parseDouble(getSharedPreferences("PREFERENCE10", MODE_PRIVATE).getString("oct_income", "0.0"));
        nov_income = Double.parseDouble(getSharedPreferences("PREFERENCE11", MODE_PRIVATE).getString("nov_income", "0.0"));
        dec_income = Double.parseDouble(getSharedPreferences("PREFERENCE12", MODE_PRIVATE).getString("dec_income", "0.0"));


        jan_expense = Double.parseDouble(getSharedPreferences("PREFERENCE", MODE_PRIVATE).getString("jan_expense", "0.0"));
        feb_expense = Double.parseDouble(getSharedPreferences("PREFERENCE2", MODE_PRIVATE).getString("feb_expense", "0.0"));
        mar_expense = Double.parseDouble(getSharedPreferences("PREFERENCE3", MODE_PRIVATE).getString("mar_expense", "0.0"));
        apr_expense = Double.parseDouble(getSharedPreferences("PREFERENCE4", MODE_PRIVATE).getString("apr_expense", "0.0"));
        may_expense = Double.parseDouble(getSharedPreferences("PREFERENCE5", MODE_PRIVATE).getString("may_expense", "0.0"));
        june_expense = Double.parseDouble(getSharedPreferences("PREFERENCE6", MODE_PRIVATE).getString("june_expense", "0.0"));
        july_expense = Double.parseDouble(getSharedPreferences("PREFERENCE7", MODE_PRIVATE).getString("july_expense", "0.0"));
        aug_expense = Double.parseDouble(getSharedPreferences("PREFERENCE8", MODE_PRIVATE).getString("aug_expense", "0.0"));
        sep_expense = Double.parseDouble(getSharedPreferences("PREFERENCE9", MODE_PRIVATE).getString("sep_expense", "0.0"));
        oct_expense = Double.parseDouble(getSharedPreferences("PREFERENCE10", MODE_PRIVATE).getString("oct_expense", "0.0"));
        nov_expense = Double.parseDouble(getSharedPreferences("PREFERENCE11", MODE_PRIVATE).getString("nov_expense", "0.0"));
        dec_expense = Double.parseDouble(getSharedPreferences("PREFERENCE12", MODE_PRIVATE).getString("dec_expense", "0.0"));



//        barentries.add(new BarEntry(0, Float.valueOf(jan_income+"")));
//        barentries.add(new BarEntry(1, Float.valueOf(feb_income+"")));
//        barentries.add(new BarEntry(2, Float.valueOf(mar_income+"")));
//        barentries.add(new BarEntry(3, Float.valueOf(apr_income+"")));
//        barentries.add(new BarEntry(4, Float.valueOf(may_income+"")));
//        barentries.add(new BarEntry(5, Float.valueOf(june_income+"")));
//        barentries.add(new BarEntry(6, Float.valueOf(july_income+"")));
//        barentries.add(new BarEntry(7, Float.valueOf(aug_income+"")));
//        barentries.add(new BarEntry(8, Float.valueOf(sep_income+"")));
//        barentries.add(new BarEntry(9, Float.valueOf(oct_income+"")));
//        barentries.add(new BarEntry(10, Float.valueOf(nov_income+"")));
//        barentries.add(new BarEntry(11, Float.valueOf(dec_income+"")));



        //new starts
        mIncome = new float[12];
        mIncome[0]= Float.valueOf(String.format("%.5f", jan_income));
        mIncome[1]= Float.valueOf(String.format("%.5f", feb_income));
        mIncome[2]= Float.valueOf(String.format("%.5f", mar_income));
        mIncome[3]= Float.valueOf(String.format("%.5f", apr_income));
        mIncome[4]= Float.valueOf(String.format("%.5f", may_income));
        mIncome[5]= Float.valueOf(String.format("%.5f", june_income));
        mIncome[6]= Float.valueOf(String.format("%.5f", july_income));
        mIncome[7]= Float.valueOf(String.format("%.5f", aug_income));
        mIncome[8]= Float.valueOf(String.format("%.5f", sep_income));
        mIncome[9]= Float.valueOf(String.format("%.5f", oct_income));
        mIncome[10]= Float.valueOf(String.format("%.5f", nov_income));
        mIncome[11]= Float.valueOf(String.format("%.5f", dec_income));

        max = maxValue(mIncome);
        //new ends

        barentries.add(new BarEntry(1, Float.valueOf(String.format("%.5f", jan_income))));
        barentries.add(new BarEntry(2, Float.valueOf(String.format("%.5f", feb_income))));
        barentries.add(new BarEntry(3, Float.valueOf(String.format("%.5f", mar_income))));
        barentries.add(new BarEntry(4, Float.valueOf(String.format("%.5f", apr_income))));
        barentries.add(new BarEntry(5, Float.valueOf(String.format("%.5f", may_income))));
        barentries.add(new BarEntry(6, Float.valueOf(String.format("%.5f", june_income))));
        barentries.add(new BarEntry(7, Float.valueOf(String.format("%.5f", july_income))));
        barentries.add(new BarEntry(8, Float.valueOf(String.format("%.5f", aug_income))));
        barentries.add(new BarEntry(9, Float.valueOf(String.format("%.5f", sep_income))));
        barentries.add(new BarEntry(10, Float.valueOf(String.format("%.5f", oct_income))));
        barentries.add(new BarEntry(11, Float.valueOf(String.format("%.5f", nov_income))));
        barentries.add(new BarEntry(12, Float.valueOf(String.format("%.5f", dec_income))));


        barentries1.add(new BarEntry(1, Float.valueOf(String.format("%.5f", jan_expense))));
        barentries1.add(new BarEntry(2, Float.valueOf(String.format("%.5f", feb_expense))));
        barentries1.add(new BarEntry(3, Float.valueOf(String.format("%.5f", mar_expense))));
        barentries1.add(new BarEntry(4, Float.valueOf(String.format("%.5f", apr_expense))));
        barentries1.add(new BarEntry(5, Float.valueOf(String.format("%.5f", may_expense))));
        barentries1.add(new BarEntry(6, Float.valueOf(String.format("%.5f", june_expense))));
        barentries1.add(new BarEntry(7, Float.valueOf(String.format("%.5f", july_expense))));
        barentries1.add(new BarEntry(8, Float.valueOf(String.format("%.5f", aug_expense))));
        barentries1.add(new BarEntry(9, Float.valueOf(String.format("%.5f", sep_expense))));
        barentries1.add(new BarEntry(10, Float.valueOf(String.format("%.5f", oct_expense))));
        barentries1.add(new BarEntry(11, Float.valueOf(String.format("%.5f", nov_expense))));
        barentries1.add(new BarEntry(12, Float.valueOf(String.format("%.5f", dec_expense))));


        BarDataSet barDataSet = new BarDataSet(barentries, "Income");
        BarDataSet barDataSet1 = new BarDataSet(barentries1, "Expense");

        barDataSet.setColors(getApplicationContext().getResources().getColor(android.R.color.holo_green_dark));
        barDataSet1.setColors(getApplicationContext().getResources().getColor(android.R.color.holo_red_dark));

        BarData data = new BarData(barDataSet, barDataSet1);

        float groupSpace = 0.55f;
        float barSpace = 0.01f;
        float barWidth = 0.25f;

        data.setBarWidth(barWidth);



        barChart.setData(data);
        barChart.groupBars(0,groupSpace,barSpace);

        data.setDrawValues(true);

        String[] months = new String[]{"","Jan","Feb","Mar","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};

        XAxis xAxis = barChart.getXAxis();

        xAxis.setValueFormatter(new MyXAxisValueFormatter(months));

        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);

        xAxis.setGranularity(1);
        xAxis.setCenterAxisLabels(false);
        xAxis.setAxisMinimum(0);



        YAxis y = barChart.getAxisLeft();
        y.setLabelCount(15);
        y.setAxisMaxValue(max);
        y.setAxisMinValue(1);

    }



    public class  MyXAxisValueFormatter implements IAxisValueFormatter
    {
        private String[] mValues;

        public MyXAxisValueFormatter(String[] values)
        {
            this.mValues = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int) value];
        }
    }

    public float maxValue(float array[]){
        List<Float> list = new ArrayList<Float>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return Collections.max(list);
    }


    //back button operation starts

    @Override
    public void onBackPressed() {

        finish();
    }


    //back button operation ends


}
