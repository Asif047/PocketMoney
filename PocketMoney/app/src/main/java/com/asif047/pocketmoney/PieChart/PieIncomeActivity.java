package com.asif047.pocketmoney.PieChart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.asif047.pocketmoney.Model.Pocket;
import com.asif047.pocketmoney.R;
import com.asif047.pocketmoney.Utils.PocketDBHelper;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class PieIncomeActivity extends AppCompatActivity {

    private PocketDBHelper dbHelper;

    private List<Pocket> pockets;

    private Toolbar toolbar;

    private PieChart pieChart, pieChartFeb, pieChartMar, pieChartApr, pieChartMay,
            pieChartJune, pieChartJuly, pieChartAug, pieChartSep,
            pieChartOct, pieChartNov, pieChartDec;

    private double income_jan_sal = 0.0, income_jan_bonus = 0.0, income_jan_fund = 0.0,
            income_jan_gift = 0.0, income_jan_others = 0.0;

    private double income_feb_sal = 0.0, income_feb_bonus = 0.0, income_feb_fund = 0.0,
            income_feb_gift = 0.0, income_feb_others = 0.0;

    private double income_mar_sal = 0.0, income_mar_bonus = 0.0, income_mar_fund = 0.0,
            income_mar_gift = 0.0, income_mar_others = 0.0;

    private double income_apr_sal = 0.0, income_apr_bonus = 0.0, income_apr_fund = 0.0,
            income_apr_gift = 0.0, income_apr_others = 0.0;

    private double income_may_sal = 0.0, income_may_bonus = 0.0, income_may_fund = 0.0,
            income_may_gift = 0.0, income_may_others = 0.0;

    private double income_june_sal = 0.0, income_june_bonus = 0.0, income_june_fund = 0.0,
            income_june_gift = 0.0, income_june_others = 0.0;

    private double income_july_sal = 0.0, income_july_bonus = 0.0, income_july_fund = 0.0,
            income_july_gift = 0.0, income_july_others = 0.0;

    private double income_aug_sal = 0.0, income_aug_bonus = 0.0, income_aug_fund = 0.0,
            income_aug_gift = 0.0, income_aug_others = 0.0;

    private double income_sep_sal = 0.0, income_sep_bonus = 0.0, income_sep_fund = 0.0,
            income_sep_gift = 0.0, income_sep_others = 0.0;

    private double income_oct_sal = 0.0, income_oct_bonus = 0.0, income_oct_fund = 0.0,
            income_oct_gift = 0.0, income_oct_others = 0.0;

    private double income_nov_sal = 0.0, income_nov_bonus = 0.0, income_nov_fund = 0.0,
            income_nov_gift = 0.0, income_nov_others = 0.0;

    private double income_dec_sal = 0.0, income_dec_bonus = 0.0, income_dec_fund = 0.0,
            income_dec_gift = 0.0, income_dec_others = 0.0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_income);




        dbHelper = new PocketDBHelper(this);
        pockets = dbHelper.pocketList();


        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("1") || pockets.get(i).getMonth().equals("01") )
                    && pockets.get(i).getCategory().equals("Salary") ){
                income_jan_sal = income_jan_sal + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("1") || pockets.get(i).getMonth().equals("01") )
                    && pockets.get(i).getCategory().equals("Bonus") ){
                income_jan_bonus = income_jan_bonus + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("1") || pockets.get(i).getMonth().equals("01") )
                    && pockets.get(i).getCategory().equals("Fund") ){
                income_jan_fund = income_jan_fund + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("1") || pockets.get(i).getMonth().equals("01") )
                    && pockets.get(i).getCategory().equals("Gifts") ){
                income_jan_gift = income_jan_gift + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("1") || pockets.get(i).getMonth().equals("01") )
                    && pockets.get(i).getCategory().equals("Others") ){
                income_jan_others = income_jan_others + pockets.get(i).getAmount();
            }

        }



        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("2") || pockets.get(i).getMonth().equals("02") )
                    && pockets.get(i).getCategory().equals("Salary") ){
                income_feb_sal = income_feb_sal + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("2") || pockets.get(i).getMonth().equals("02") )
                    && pockets.get(i).getCategory().equals("Bonus") ){
                income_feb_bonus = income_feb_bonus + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("2") || pockets.get(i).getMonth().equals("02") )
                    && pockets.get(i).getCategory().equals("Fund") ){
                income_feb_fund = income_feb_fund + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("2") || pockets.get(i).getMonth().equals("02") )
                    && pockets.get(i).getCategory().equals("Gifts") ){
                income_feb_gift = income_feb_gift + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("2") || pockets.get(i).getMonth().equals("02") )
                    && pockets.get(i).getCategory().equals("Others") ){
                income_feb_others = income_feb_others + pockets.get(i).getAmount();
            }

        }


        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("3") || pockets.get(i).getMonth().equals("03") )
                    && pockets.get(i).getCategory().equals("Salary") ){
                income_mar_sal = income_mar_sal + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("3") || pockets.get(i).getMonth().equals("03") )
                    && pockets.get(i).getCategory().equals("Bonus") ){
                income_mar_bonus = income_mar_bonus + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("3") || pockets.get(i).getMonth().equals("03") )
                    && pockets.get(i).getCategory().equals("Fund") ){
                income_mar_fund = income_mar_fund + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("3") || pockets.get(i).getMonth().equals("03") )
                    && pockets.get(i).getCategory().equals("Gifts") ){
                income_mar_gift = income_mar_gift + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("3") || pockets.get(i).getMonth().equals("03") )
                    && pockets.get(i).getCategory().equals("Others") ){
                income_mar_others = income_mar_others + pockets.get(i).getAmount();
            }

        }



        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("4") || pockets.get(i).getMonth().equals("04") )
                    && pockets.get(i).getCategory().equals("Salary") ){
                income_apr_sal = income_apr_sal + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("4") || pockets.get(i).getMonth().equals("04") )
                    && pockets.get(i).getCategory().equals("Bonus") ){
                income_apr_bonus = income_apr_bonus + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("4") || pockets.get(i).getMonth().equals("04") )
                    && pockets.get(i).getCategory().equals("Fund") ){
                income_apr_fund = income_apr_fund + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("4") || pockets.get(i).getMonth().equals("04") )
                    && pockets.get(i).getCategory().equals("Gifts") ){
                income_apr_gift = income_apr_gift + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("4") || pockets.get(i).getMonth().equals("04") )
                    && pockets.get(i).getCategory().equals("Others") ){
                income_apr_others = income_apr_others + pockets.get(i).getAmount();
            }

        }



        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("5") || pockets.get(i).getMonth().equals("05") )
                    && pockets.get(i).getCategory().equals("Salary") ){
                income_may_sal = income_may_sal + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("5") || pockets.get(i).getMonth().equals("05") )
                    && pockets.get(i).getCategory().equals("Bonus") ){
                income_may_bonus = income_may_bonus + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("5") || pockets.get(i).getMonth().equals("05") )
                    && pockets.get(i).getCategory().equals("Fund") ){
                income_may_fund = income_may_fund + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("5") || pockets.get(i).getMonth().equals("05") )
                    && pockets.get(i).getCategory().equals("Gifts") ){
                income_may_gift = income_may_gift + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("5") || pockets.get(i).getMonth().equals("05") )
                    && pockets.get(i).getCategory().equals("Others") ){
                income_may_others = income_may_others + pockets.get(i).getAmount();
            }

        }


        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("6") || pockets.get(i).getMonth().equals("06") )
                    && pockets.get(i).getCategory().equals("Salary") ){
                income_june_sal = income_june_sal + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("6") || pockets.get(i).getMonth().equals("06") )
                    && pockets.get(i).getCategory().equals("Bonus") ){
                income_june_bonus = income_june_bonus + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("6") || pockets.get(i).getMonth().equals("06") )
                    && pockets.get(i).getCategory().equals("Fund") ){
                income_june_fund = income_june_fund + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("6") || pockets.get(i).getMonth().equals("06") )
                    && pockets.get(i).getCategory().equals("Gifts") ){
                income_june_gift = income_june_gift + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("6") || pockets.get(i).getMonth().equals("06") )
                    && pockets.get(i).getCategory().equals("Others") ){
                income_june_others = income_june_others + pockets.get(i).getAmount();
            }

        }



        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("7") || pockets.get(i).getMonth().equals("07") )
                    && pockets.get(i).getCategory().equals("Salary") ){
                income_july_sal = income_july_sal + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("7") || pockets.get(i).getMonth().equals("07") )
                    && pockets.get(i).getCategory().equals("Bonus") ){
                income_july_bonus = income_july_bonus + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("7") || pockets.get(i).getMonth().equals("07") )
                    && pockets.get(i).getCategory().equals("Fund") ){
                income_july_fund = income_july_fund + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("7") || pockets.get(i).getMonth().equals("07") )
                    && pockets.get(i).getCategory().equals("Gifts") ){
                income_july_gift = income_july_gift + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("7") || pockets.get(i).getMonth().equals("07") )
                    && pockets.get(i).getCategory().equals("Others") ){
                income_july_others = income_july_others + pockets.get(i).getAmount();
            }

        }


        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("8") || pockets.get(i).getMonth().equals("08") )
                    && pockets.get(i).getCategory().equals("Salary") ){
                income_aug_sal = income_aug_sal + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("8") || pockets.get(i).getMonth().equals("08") )
                    && pockets.get(i).getCategory().equals("Bonus") ){
                income_aug_bonus = income_aug_bonus + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("8") || pockets.get(i).getMonth().equals("08") )
                    && pockets.get(i).getCategory().equals("Fund") ){
                income_aug_fund = income_aug_fund + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("8") || pockets.get(i).getMonth().equals("08") )
                    && pockets.get(i).getCategory().equals("Gifts") ){
                income_aug_gift = income_aug_gift + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("8") || pockets.get(i).getMonth().equals("08") )
                    && pockets.get(i).getCategory().equals("Others") ){
                income_aug_others = income_aug_others + pockets.get(i).getAmount();
            }

        }



        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("9") || pockets.get(i).getMonth().equals("09") )
                    && pockets.get(i).getCategory().equals("Salary") ){
                income_sep_sal = income_sep_sal + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("9") || pockets.get(i).getMonth().equals("09") )
                    && pockets.get(i).getCategory().equals("Bonus") ){
                income_sep_bonus = income_sep_bonus + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("9") || pockets.get(i).getMonth().equals("09") )
                    && pockets.get(i).getCategory().equals("Fund") ){
                income_sep_fund = income_sep_fund + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("9") || pockets.get(i).getMonth().equals("09") )
                    && pockets.get(i).getCategory().equals("Gifts") ){
                income_sep_gift = income_sep_gift + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("9") || pockets.get(i).getMonth().equals("09") )
                    && pockets.get(i).getCategory().equals("Others") ){
                income_sep_others = income_sep_others + pockets.get(i).getAmount();
            }

        }




        for( int i = 0; i< pockets.size(); i++) {
            if ( pockets.get(i).getMonth().equals("10")
                    && pockets.get(i).getCategory().equals("Salary") ){
                income_oct_sal = income_oct_sal + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("10")
                    && pockets.get(i).getCategory().equals("Bonus") ){
                income_oct_bonus = income_oct_bonus + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("10")
                    && pockets.get(i).getCategory().equals("Fund") ){
                income_oct_fund = income_oct_fund + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("10")
                    && pockets.get(i).getCategory().equals("Gifts") ){
                income_oct_gift = income_oct_gift + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("10")
                    && pockets.get(i).getCategory().equals("Others") ){
                income_oct_others = income_oct_others + pockets.get(i).getAmount();
            }

        }




        for( int i = 0; i< pockets.size(); i++) {
            if ( pockets.get(i).getMonth().equals("11")
                    && pockets.get(i).getCategory().equals("Salary") ){
                income_nov_sal = income_nov_sal + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("11")
                    && pockets.get(i).getCategory().equals("Bonus") ){
                income_nov_bonus = income_nov_bonus + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("11")
                    && pockets.get(i).getCategory().equals("Fund") ){
                income_nov_fund = income_nov_fund + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("11")
                    && pockets.get(i).getCategory().equals("Gifts") ){
                income_nov_gift = income_nov_gift + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("11")
                    && pockets.get(i).getCategory().equals("Others") ){
                income_nov_others = income_nov_others + pockets.get(i).getAmount();
            }

        }




        for( int i = 0; i< pockets.size(); i++) {
            if ( pockets.get(i).getMonth().equals("12")
                    && pockets.get(i).getCategory().equals("Salary") ){
                income_dec_sal = income_dec_sal + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("12")
                    && pockets.get(i).getCategory().equals("Bonus") ){
                income_dec_bonus = income_dec_bonus + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("12")
                    && pockets.get(i).getCategory().equals("Fund") ){
                income_dec_fund = income_dec_fund + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("12")
                    && pockets.get(i).getCategory().equals("Gifts") ){
                income_dec_gift = income_dec_gift + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("12")
                    && pockets.get(i).getCategory().equals("Others") ){
                income_dec_others = income_dec_others + pockets.get(i).getAmount();
            }

        }


        //Toast.makeText(PieIncomeActivity.this, ""+income_jan_sal, Toast.LENGTH_LONG).show();


        //pie chart starts
        pieChart = findViewById(R.id.piechart_jan);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(0.99f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValues = new ArrayList<>();


        if(income_jan_sal != 0.0){
            yValues.add(new PieEntry((float) income_jan_sal, "Salary"));
        }
        if(income_jan_bonus != 0.0){
            yValues.add(new PieEntry((float) income_jan_bonus, "Bonus"));
        }
        if(income_jan_fund != 0.0){
            yValues.add(new PieEntry((float) income_jan_fund, "Fund"));
        }
        if(income_jan_gift != 0.0){
            yValues.add(new PieEntry((float) income_jan_gift, "Gifts"));
        }
        if(income_jan_others != 0.0){
            yValues.add(new PieEntry((float) income_jan_others, "Others"));
        }


//        Description description = new Description();
//        description.setText("This is Description");
//        description.setTextSize(15);
//        pieChart.setDescription(description);

        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSet = new PieDataSet(yValues, "");

        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLUE);


        //to set the label color
        int colorBlack = Color.parseColor("#000000");
        pieChart.setEntryLabelColor(colorBlack);
        //to set the label color ends

        pieChart.setData(data);
        //pie chart ends




        //pie chart starts feb
        pieChartFeb = findViewById(R.id.piechart_feb);
        pieChartFeb.getDescription().setEnabled(false);
        pieChartFeb.setExtraOffsets(5, 10, 5, 5);
        pieChartFeb.setDragDecelerationFrictionCoef(0.99f);
        pieChartFeb.setDrawHoleEnabled(true);
        pieChartFeb.setHoleColor(Color.WHITE);
        pieChartFeb.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesFeb = new ArrayList<>();

        if(income_feb_sal != 0.0){
            yValuesFeb.add(new PieEntry((float) income_feb_sal, "Salary"));
        }
        if(income_feb_bonus != 0.0){
            yValuesFeb.add(new PieEntry((float) income_feb_bonus, "Bonus"));
        }
        if(income_feb_fund != 0.0){
            yValuesFeb.add(new PieEntry((float) income_feb_fund, "Fund"));
        }
        if(income_feb_gift != 0.0){
            yValuesFeb.add(new PieEntry((float) income_feb_gift, "Gifts"));
        }
        if(income_feb_others != 0.0){
            yValuesFeb.add(new PieEntry((float) income_feb_others, "Others"));
        }


        pieChartFeb.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSetFeb = new PieDataSet(yValuesFeb, "");

        dataSetFeb.setSliceSpace(3f);
        dataSetFeb.setSelectionShift(5f);
        dataSetFeb.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData dataFeb = new PieData(dataSetFeb);
        dataFeb.setValueTextSize(10f);
        dataFeb.setValueTextColor(Color.BLUE);

        //to set the label color
        pieChartFeb.setEntryLabelColor(colorBlack);
        //to set the label color ends

        pieChartFeb.setData(dataFeb);
        //pie chart ends feb



        //pie chart starts mar
        pieChartMar = findViewById(R.id.piechart_march);
        pieChartMar.getDescription().setEnabled(false);
        pieChartMar.setExtraOffsets(5, 10, 5, 5);
        pieChartMar.setDragDecelerationFrictionCoef(0.99f);
        pieChartMar.setDrawHoleEnabled(true);
        pieChartMar.setHoleColor(Color.WHITE);
        pieChartMar.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesMar = new ArrayList<>();

        if(income_mar_sal != 0.0){
            yValuesMar.add(new PieEntry((float) income_mar_sal, "Salary"));
        }
        if(income_mar_bonus != 0.0){
            yValuesMar.add(new PieEntry((float) income_mar_bonus, "Bonus"));
        }
        if(income_mar_fund != 0.0){
            yValuesMar.add(new PieEntry((float) income_mar_fund, "Fund"));
        }
        if(income_mar_gift != 0.0){
            yValuesMar.add(new PieEntry((float) income_mar_gift, "Gifts"));
        }
        if(income_mar_others != 0.0){
            yValuesMar.add(new PieEntry((float) income_mar_others, "Others"));
        }

        pieChartMar.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSetMar = new PieDataSet(yValuesMar, "");

        dataSetMar.setSliceSpace(3f);
        dataSetMar.setSelectionShift(5f);
        dataSetMar.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData dataMar = new PieData(dataSetMar);
        dataMar.setValueTextSize(10f);
        dataMar.setValueTextColor(Color.BLUE);

        //to set the label color
        pieChartMar.setEntryLabelColor(colorBlack);
        //to set the label color ends

        pieChartMar.setData(dataMar);
        //pie chart ends mar




        //pie chart starts apr
        pieChartApr = findViewById(R.id.piechart_april);
        pieChartApr.getDescription().setEnabled(false);
        pieChartApr.setExtraOffsets(5, 10, 5, 5);
        pieChartApr.setDragDecelerationFrictionCoef(0.99f);
        pieChartApr.setDrawHoleEnabled(true);
        pieChartApr.setHoleColor(Color.WHITE);
        pieChartApr.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesApr = new ArrayList<>();

        if(income_apr_sal != 0.0){
            yValuesApr.add(new PieEntry((float) income_apr_sal, "Salary"));
        }
        if(income_apr_bonus != 0.0){
            yValuesApr.add(new PieEntry((float) income_apr_bonus, "Bonus"));
        }
        if(income_apr_fund != 0.0){
            yValuesApr.add(new PieEntry((float) income_apr_fund, "Fund"));
        }
        if(income_apr_gift != 0.0){
            yValuesApr.add(new PieEntry((float) income_apr_gift, "Gifts"));
        }
        if(income_apr_others != 0.0){
            yValuesApr.add(new PieEntry((float) income_apr_others, "Others"));
        }

        pieChartApr.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSetApr = new PieDataSet(yValuesApr, "");

        dataSetApr.setSliceSpace(3f);
        dataSetApr.setSelectionShift(5f);
        dataSetApr.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData dataApr = new PieData(dataSetApr);
        dataApr.setValueTextSize(10f);
        dataApr.setValueTextColor(Color.BLUE);

        //to set the label color
        pieChartApr.setEntryLabelColor(colorBlack);
        //to set the label color ends

        pieChartApr.setData(dataApr);
        //pie chart ends apr




        //pie chart starts may
        pieChartMay = findViewById(R.id.piechart_may);
        pieChartMay.getDescription().setEnabled(false);
        pieChartMay.setExtraOffsets(5, 10, 5, 5);
        pieChartMay.setDragDecelerationFrictionCoef(0.99f);
        pieChartMay.setDrawHoleEnabled(true);
        pieChartMay.setHoleColor(Color.WHITE);
        pieChartMay.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesMay = new ArrayList<>();

        if(income_may_sal != 0.0){
            yValuesMay.add(new PieEntry((float) income_may_sal, "Salary"));
        }
        if(income_may_bonus != 0.0){
            yValuesMay.add(new PieEntry((float) income_may_bonus, "Bonus"));
        }
        if(income_may_fund != 0.0){
            yValuesMay.add(new PieEntry((float) income_may_fund, "Fund"));
        }
        if(income_may_gift != 0.0){
            yValuesMay.add(new PieEntry((float) income_may_gift, "Gifts"));
        }
        if(income_may_others !=0.0){
            yValuesMay.add(new PieEntry((float) income_may_others, "Others"));
        }

        pieChartMay.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSetMay = new PieDataSet(yValuesMay, "");

        dataSetMay.setSliceSpace(3f);
        dataSetMay.setSelectionShift(5f);
        dataSetMay.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData dataMay = new PieData(dataSetMay);
        dataMay.setValueTextSize(10f);
        dataMay.setValueTextColor(Color.BLUE);

        //to set the label color
        pieChartMay.setEntryLabelColor(colorBlack);
        //to set the label color ends

        pieChartMay.setData(dataMay);
        //pie chart ends may




        //pie chart starts june
        pieChartJune = findViewById(R.id.piechart_june);
        pieChartJune.getDescription().setEnabled(false);
        pieChartJune.setExtraOffsets(5, 10, 5, 5);
        pieChartJune.setDragDecelerationFrictionCoef(0.99f);
        pieChartJune.setDrawHoleEnabled(true);
        pieChartJune.setHoleColor(Color.WHITE);
        pieChartJune.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesJune = new ArrayList<>();

        if(income_june_sal != 0.0){
            yValuesJune.add(new PieEntry((float) income_june_sal, "Salary"));
        }
        if(income_june_bonus !=0.0){
            yValuesJune.add(new PieEntry((float) income_june_bonus, "Bonus"));
        }
        if(income_june_fund != 0.0){
            yValuesJune.add(new PieEntry((float) income_june_fund, "Fund"));
        }
        if(income_june_gift != 0.0){
            yValuesJune.add(new PieEntry((float) income_june_gift, "Gifts"));
        }
        if(income_june_others != 0.0){
            yValuesJune.add(new PieEntry((float) income_june_others, "Others"));
        }


        pieChartJune.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSetJune = new PieDataSet(yValuesJune, "");

        dataSetJune.setSliceSpace(3f);
        dataSetJune.setSelectionShift(5f);
        dataSetJune.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData dataJune = new PieData(dataSetJune);
        dataJune.setValueTextSize(10f);
        dataJune.setValueTextColor(Color.BLUE);

        //to set the label color
        pieChartJune.setEntryLabelColor(colorBlack);
        //to set the label color ends

        pieChartJune.setData(dataJune);
        //pie chart ends june




        //pie chart starts july
        pieChartJuly = findViewById(R.id.piechart_july);
        pieChartJuly.getDescription().setEnabled(false);
        pieChartJuly.setExtraOffsets(5, 10, 5, 5);
        pieChartJuly.setDragDecelerationFrictionCoef(0.99f);
        pieChartJuly.setDrawHoleEnabled(true);
        pieChartJuly.setHoleColor(Color.WHITE);
        pieChartJuly.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesJuly = new ArrayList<>();

        if(income_july_sal != 0.0){
            yValuesJuly.add(new PieEntry((float) income_july_sal, "Salary"));
        }
        if(income_july_bonus != 0.0){
            yValuesJuly.add(new PieEntry((float) income_july_bonus, "Bonus"));
        }
        if(income_july_fund != 0.0){
            yValuesJuly.add(new PieEntry((float) income_july_fund, "Fund"));
        }
        if(income_july_gift != 0.0){
            yValuesJuly.add(new PieEntry((float) income_july_gift, "Gifts"));
        }
        if(income_july_others != 0.0){
            yValuesJuly.add(new PieEntry((float) income_july_others, "Others"));
        }

        pieChartJuly.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSetJuly = new PieDataSet(yValuesJuly, "");

        dataSetJuly.setSliceSpace(3f);
        dataSetJuly.setSelectionShift(5f);
        dataSetJuly.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData dataJuly = new PieData(dataSetJuly);
        dataJuly.setValueTextSize(10f);
        dataJuly.setValueTextColor(Color.BLUE);

        //to set the label color
        pieChartJuly.setEntryLabelColor(colorBlack);
        //to set the label color ends

        pieChartJuly.setData(dataJuly);
        //pie chart ends july



        //pie chart starts aug
        pieChartAug = findViewById(R.id.piechart_aug);
        pieChartAug.getDescription().setEnabled(false);
        pieChartAug.setExtraOffsets(5, 10, 5, 5);
        pieChartAug.setDragDecelerationFrictionCoef(0.99f);
        pieChartAug.setDrawHoleEnabled(true);
        pieChartAug.setHoleColor(Color.WHITE);
        pieChartAug.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesAug = new ArrayList<>();

        if(income_aug_sal != 0.0){
            yValuesAug.add(new PieEntry((float) income_aug_sal, "Salary"));
        }
        if(income_aug_bonus != 0.0){
            yValuesAug.add(new PieEntry((float) income_aug_bonus, "Bonus"));
        }
        if(income_aug_fund != 0.0){
            yValuesAug.add(new PieEntry((float) income_aug_fund, "Fund"));
        }
        if(income_aug_gift != 0.0){
            yValuesAug.add(new PieEntry((float) income_aug_gift, "Gifts"));
        }
        if(income_aug_others != 0.0){
            yValuesAug.add(new PieEntry((float) income_aug_others, "Others"));
        }

        pieChartAug.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSetAug = new PieDataSet(yValuesAug, "");

        dataSetAug.setSliceSpace(3f);
        dataSetAug.setSelectionShift(5f);
        dataSetAug.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData dataAug = new PieData(dataSetAug);
        dataAug.setValueTextSize(10f);
        dataAug.setValueTextColor(Color.BLUE);

        //to set the label color
        pieChartAug.setEntryLabelColor(colorBlack);
        //to set the label color ends

        pieChartAug.setData(dataAug);
        //pie chart ends aug



        //pie chart starts sep
        pieChartSep = findViewById(R.id.piechart_sep);
        pieChartSep.getDescription().setEnabled(false);
        pieChartSep.setExtraOffsets(5, 10, 5, 5);
        pieChartSep.setDragDecelerationFrictionCoef(0.99f);
        pieChartSep.setDrawHoleEnabled(true);
        pieChartSep.setHoleColor(Color.WHITE);
        pieChartSep.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesSep = new ArrayList<>();

        if(income_sep_sal != 0.0){
            yValuesSep.add(new PieEntry((float) income_sep_sal, "Salary"));
        }
        if(income_sep_bonus != 0.0){
            yValuesSep.add(new PieEntry((float) income_sep_bonus, "Bonus"));
        }
        if(income_sep_fund != 0.0){
            yValuesSep.add(new PieEntry((float) income_sep_fund, "Fund"));
        }
        if(income_sep_gift != 0.0){
            yValuesSep.add(new PieEntry((float) income_sep_gift, "Gifts"));
        }
        if(income_sep_others !=0.0){
            yValuesSep.add(new PieEntry((float) income_sep_others, "Others"));
        }

        pieChartSep.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSetSep = new PieDataSet(yValuesSep, "");

        dataSetSep.setSliceSpace(3f);
        dataSetSep.setSelectionShift(5f);
        dataSetSep.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData dataSep = new PieData(dataSetSep);
        dataSep.setValueTextSize(10f);
        dataSep.setValueTextColor(Color.BLUE);

        //to set the label color
        pieChartSep.setEntryLabelColor(colorBlack);
        //to set the label color ends

        pieChartSep.setData(dataSep);
        //pie chart ends sep


        //pie chart starts oct
        pieChartOct = findViewById(R.id.piechart_oct);
        pieChartOct.getDescription().setEnabled(false);
        pieChartOct.setExtraOffsets(5, 10, 5, 5);
        pieChartOct.setDragDecelerationFrictionCoef(0.99f);
        pieChartOct.setDrawHoleEnabled(true);
        pieChartOct.setHoleColor(Color.WHITE);
        pieChartOct.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesOct = new ArrayList<>();

        if(income_oct_sal != 0.0){
            yValuesOct.add(new PieEntry((float) income_oct_sal, "Salary"));
        }
        if(income_oct_bonus != 0.0){
            yValuesOct.add(new PieEntry((float) income_oct_bonus, "Bonus"));
        }
        if(income_oct_fund != 0.0){
            yValuesOct.add(new PieEntry((float) income_oct_fund, "Fund"));
        }
        if(income_oct_gift != 0.0){
            yValuesOct.add(new PieEntry((float) income_oct_gift, "Gifts"));
        }
        if(income_oct_others != 0.0){
            yValuesOct.add(new PieEntry((float) income_oct_others, "Others"));
        }

        pieChartOct.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSetOct = new PieDataSet(yValuesOct, "");

        dataSetOct.setSliceSpace(3f);
        dataSetOct.setSelectionShift(5f);
        dataSetOct.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData dataOct = new PieData(dataSetOct);
        dataOct.setValueTextSize(10f);
        dataOct.setValueTextColor(Color.BLUE);

        //to set the label color
        pieChartOct.setEntryLabelColor(colorBlack);
        //to set the label color ends

        pieChartOct.setData(dataOct);
        //pie chart ends oct


        //pie chart starts nov
        pieChartNov = findViewById(R.id.piechart_nov);
        pieChartNov.getDescription().setEnabled(false);
        pieChartNov.setExtraOffsets(5, 10, 5, 5);
        pieChartNov.setDragDecelerationFrictionCoef(0.99f);
        pieChartNov.setDrawHoleEnabled(true);
        pieChartNov.setHoleColor(Color.WHITE);
        pieChartNov.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesNov = new ArrayList<>();

        if(income_nov_sal != 0.0){
            yValuesNov.add(new PieEntry((float) income_nov_sal, "Salary"));
        }
        if(income_nov_bonus != 0.0){
            yValuesNov.add(new PieEntry((float) income_nov_bonus, "Bonus"));
        }
        if(income_nov_fund != 0.0){
            yValuesNov.add(new PieEntry((float) income_nov_fund, "Fund"));
        }
        if(income_nov_gift != 0.0){
            yValuesNov.add(new PieEntry((float) income_nov_gift, "Gifts"));
        }
        if(income_nov_others != 0.0){
            yValuesNov.add(new PieEntry((float) income_nov_others, "Others"));
        }

        pieChartNov.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSetNov = new PieDataSet(yValuesNov, "");

        dataSetNov.setSliceSpace(3f);
        dataSetNov.setSelectionShift(5f);
        dataSetNov.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData dataNov = new PieData(dataSetNov);
        dataNov.setValueTextSize(10f);
        dataNov.setValueTextColor(Color.BLUE);

        //to set the label color
        pieChartNov.setEntryLabelColor(colorBlack);
        //to set the label color ends

        pieChartNov.setData(dataNov);
        //pie chart ends nov



        //pie chart starts dec
        pieChartDec = findViewById(R.id.piechart_dec);
        pieChartDec.getDescription().setEnabled(false);
        pieChartDec.setExtraOffsets(5, 10, 5, 5);
        pieChartDec.setDragDecelerationFrictionCoef(0.99f);
        pieChartDec.setDrawHoleEnabled(true);
        pieChartDec.setHoleColor(Color.WHITE);
        pieChartDec.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesDec = new ArrayList<>();

        if(income_dec_sal != 0.0){
            yValuesDec.add(new PieEntry((float) income_dec_sal, "Salary"));
        }
        if(income_dec_bonus != 0.0){
            yValuesDec.add(new PieEntry((float) income_dec_bonus, "Bonus"));
        }
        if(income_dec_fund != 0.0){
            yValuesDec.add(new PieEntry((float) income_dec_fund, "Fund"));
        }
        if(income_dec_gift != 0.0){
            yValuesDec.add(new PieEntry((float) income_dec_gift, "Gifts"));
        }
        if(income_dec_others != 0.0){
            yValuesDec.add(new PieEntry((float) income_dec_others, "Others"));
        }

        pieChartDec.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSetDec = new PieDataSet(yValuesDec, "");

        dataSetDec.setSliceSpace(3f);
        dataSetDec.setSelectionShift(5f);
        dataSetDec.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData dataDec = new PieData(dataSetDec);
        dataDec.setValueTextSize(10f);
        dataDec.setValueTextColor(Color.BLUE);

        //to set the label color
        pieChartDec.setEntryLabelColor(colorBlack);
        //to set the label color ends

        pieChartDec.setData(dataDec);
        //pie chart ends dec


    }
}
