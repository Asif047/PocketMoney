package com.asif047.pocketmoney.PieChart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

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

public class PiExpenseActivity extends AppCompatActivity {

    private PocketDBHelper dbHelper;

    private List<Pocket> pockets;

    private Toolbar toolbar;

    private PieChart pieChart, pieChartFeb, pieChartMar, pieChartApr, pieChartMay,
            pieChartJune, pieChartJuly, pieChartAug, pieChartSep,
            pieChartOct, pieChartNov, pieChartDec;

    private double expense_jan_home = 0.0, expense_jan_bills = 0.0, expense_jan_food = 0.0,
            expense_jan_shopping = 0.0, expense_jan_others = 0.0;

    private double expense_feb_home = 0.0, expense_feb_bills = 0.0, expense_feb_food = 0.0,
            expense_feb_shopping = 0.0, expense_feb_others = 0.0;

    private double expense_mar_home = 0.0, expense_mar_bills = 0.0, expense_mar_food = 0.0,
            expense_mar_shopping = 0.0, expense_mar_others = 0.0;

    private double expense_apr_home = 0.0, expense_apr_bills = 0.0, expense_apr_food = 0.0,
            expense_apr_shopping = 0.0, expense_apr_others = 0.0;

    private double expense_may_home = 0.0, expense_may_bills = 0.0, expense_may_food = 0.0,
            expense_may_shopping = 0.0, expense_may_others = 0.0;

    private double expense_june_home = 0.0, expense_june_bills = 0.0, expense_june_food = 0.0,
            expense_june_shopping = 0.0, expense_june_others = 0.0;

    private double expense_july_home = 0.0, expense_july_bills = 0.0, expense_july_food = 0.0,
            expense_july_shopping = 0.0, expense_july_others = 0.0;

    private double expense_aug_home = 0.0, expense_aug_bills = 0.0, expense_aug_food = 0.0,
            expense_aug_shopping = 0.0, expense_aug_others = 0.0;

    private double expense_sep_home = 0.0, expense_sep_bills = 0.0, expense_sep_food = 0.0,
            expense_sep_shopping = 0.0, expense_sep_others = 0.0;

    private double expense_oct_home = 0.0, expense_oct_bills = 0.0, expense_oct_food = 0.0,
            expense_oct_shopping = 0.0, expense_oct_others = 0.0;

    private double expense_nov_home = 0.0, expense_nov_bills = 0.0, expense_nov_food = 0.0,
            expense_nov_shopping = 0.0, expense_nov_others = 0.0;

    private double expense_dec_home = 0.0, expense_dec_bills = 0.0, expense_dec_food = 0.0,
            expense_dec_shopping = 0.0, expense_dec_others = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pi_expense);



        dbHelper = new PocketDBHelper(this);
        pockets = dbHelper.pocketList();


        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("1") || pockets.get(i).getMonth().equals("01") )
                    && pockets.get(i).getCategory().equals("Home Rent") ){
                expense_jan_home = expense_jan_home + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("1") || pockets.get(i).getMonth().equals("01") )
                    && pockets.get(i).getCategory().equals("Bills") ){
                expense_jan_bills = expense_jan_bills + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("1") || pockets.get(i).getMonth().equals("01") )
                    && pockets.get(i).getCategory().equals("Food") ){
                expense_jan_food = expense_jan_food + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("1") || pockets.get(i).getMonth().equals("01") )
                    && pockets.get(i).getCategory().equals("Shopping") ){
                expense_jan_shopping = expense_jan_shopping + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("1") || pockets.get(i).getMonth().equals("01") )
                    && pockets.get(i).getCategory().equals("Others Expense") ){
                expense_jan_others = expense_jan_others + pockets.get(i).getAmount();
            }

        }




        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("2") || pockets.get(i).getMonth().equals("02") )
                    && pockets.get(i).getCategory().equals("Home Rent") ){
                expense_feb_home = expense_feb_home + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("2") || pockets.get(i).getMonth().equals("02") )
                    && pockets.get(i).getCategory().equals("Bills") ){
                expense_feb_bills = expense_feb_bills + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("2") || pockets.get(i).getMonth().equals("02") )
                    && pockets.get(i).getCategory().equals("Food") ){
                expense_feb_food = expense_feb_food + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("2") || pockets.get(i).getMonth().equals("02") )
                    && pockets.get(i).getCategory().equals("Shopping") ){
                expense_feb_shopping = expense_feb_shopping + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("2") || pockets.get(i).getMonth().equals("02") )
                    && pockets.get(i).getCategory().equals("Others Expense") ){
                expense_feb_others = expense_feb_others + pockets.get(i).getAmount();
            }

        }



        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("3") || pockets.get(i).getMonth().equals("03") )
                    && pockets.get(i).getCategory().equals("Home Rent") ){
                expense_mar_home = expense_mar_home + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("3") || pockets.get(i).getMonth().equals("03") )
                    && pockets.get(i).getCategory().equals("Bills") ){
                expense_mar_bills = expense_mar_bills + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("3") || pockets.get(i).getMonth().equals("03") )
                    && pockets.get(i).getCategory().equals("Food") ){
                expense_mar_food = expense_mar_food + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("3") || pockets.get(i).getMonth().equals("03") )
                    && pockets.get(i).getCategory().equals("Shopping") ){
                expense_mar_shopping = expense_mar_shopping + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("3") || pockets.get(i).getMonth().equals("03") )
                    && pockets.get(i).getCategory().equals("Others Expense") ){
                expense_mar_others = expense_mar_others + pockets.get(i).getAmount();
            }

        }


        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("4") || pockets.get(i).getMonth().equals("04") )
                    && pockets.get(i).getCategory().equals("Home Rent") ){
                expense_apr_home = expense_apr_home + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("4") || pockets.get(i).getMonth().equals("04") )
                    && pockets.get(i).getCategory().equals("Bills") ){
                expense_apr_bills = expense_apr_bills + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("4") || pockets.get(i).getMonth().equals("04") )
                    && pockets.get(i).getCategory().equals("Food") ){
                expense_apr_food = expense_apr_food + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("4") || pockets.get(i).getMonth().equals("04") )
                    && pockets.get(i).getCategory().equals("Shopping") ){
                expense_apr_shopping = expense_apr_shopping + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("4") || pockets.get(i).getMonth().equals("04") )
                    && pockets.get(i).getCategory().equals("Others Expense") ){
                expense_apr_others = expense_apr_others + pockets.get(i).getAmount();
            }

        }


        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("5") || pockets.get(i).getMonth().equals("05") )
                    && pockets.get(i).getCategory().equals("Home Rent") ){
                expense_may_home = expense_may_home + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("5") || pockets.get(i).getMonth().equals("05") )
                    && pockets.get(i).getCategory().equals("Bills") ){
                expense_may_bills = expense_may_bills + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("5") || pockets.get(i).getMonth().equals("05") )
                    && pockets.get(i).getCategory().equals("Food") ){
                expense_may_food = expense_may_food + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("5") || pockets.get(i).getMonth().equals("05") )
                    && pockets.get(i).getCategory().equals("Shopping") ){
                expense_may_shopping = expense_may_shopping + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("5") || pockets.get(i).getMonth().equals("05") )
                    && pockets.get(i).getCategory().equals("Others Expense") ){
                expense_may_others = expense_may_others + pockets.get(i).getAmount();
            }

        }


        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("6") || pockets.get(i).getMonth().equals("06") )
                    && pockets.get(i).getCategory().equals("Home Rent") ){
                expense_june_home = expense_june_home + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("6") || pockets.get(i).getMonth().equals("06") )
                    && pockets.get(i).getCategory().equals("Bills") ){
                expense_june_bills = expense_june_bills + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("6") || pockets.get(i).getMonth().equals("06") )
                    && pockets.get(i).getCategory().equals("Food") ){
                expense_june_food = expense_june_food + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("6") || pockets.get(i).getMonth().equals("06") )
                    && pockets.get(i).getCategory().equals("Shopping") ){
                expense_june_shopping = expense_june_shopping + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("6") || pockets.get(i).getMonth().equals("06") )
                    && pockets.get(i).getCategory().equals("Others Expense") ){
                expense_june_others = expense_june_others + pockets.get(i).getAmount();
            }

        }



        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("7") || pockets.get(i).getMonth().equals("07") )
                    && pockets.get(i).getCategory().equals("Home Rent") ){
                expense_july_home = expense_july_home + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("7") || pockets.get(i).getMonth().equals("07") )
                    && pockets.get(i).getCategory().equals("Bills") ){
                expense_july_bills = expense_july_bills + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("7") || pockets.get(i).getMonth().equals("07") )
                    && pockets.get(i).getCategory().equals("Food") ){
                expense_july_food = expense_july_food + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("7") || pockets.get(i).getMonth().equals("07") )
                    && pockets.get(i).getCategory().equals("Shopping") ){
                expense_july_shopping = expense_july_shopping + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("7") || pockets.get(i).getMonth().equals("07") )
                    && pockets.get(i).getCategory().equals("Others Expense") ){
                expense_july_others = expense_july_others + pockets.get(i).getAmount();
            }

        }



        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("8") || pockets.get(i).getMonth().equals("08") )
                    && pockets.get(i).getCategory().equals("Home Rent") ){
                expense_aug_home = expense_aug_home + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("8") || pockets.get(i).getMonth().equals("08") )
                    && pockets.get(i).getCategory().equals("Bills") ){
                expense_aug_bills = expense_aug_bills + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("8") || pockets.get(i).getMonth().equals("08") )
                    && pockets.get(i).getCategory().equals("Food") ){
                expense_aug_food = expense_aug_food + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("8") || pockets.get(i).getMonth().equals("08") )
                    && pockets.get(i).getCategory().equals("Shopping") ){
                expense_aug_shopping = expense_aug_shopping + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("8") || pockets.get(i).getMonth().equals("08") )
                    && pockets.get(i).getCategory().equals("Others Expense") ){
                expense_aug_others = expense_aug_others + pockets.get(i).getAmount();
            }

        }




        for( int i = 0; i< pockets.size(); i++) {
            if ( (pockets.get(i).getMonth().equals("9") || pockets.get(i).getMonth().equals("09") )
                    && pockets.get(i).getCategory().equals("Home Rent") ){
                expense_sep_home = expense_sep_home + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("9") || pockets.get(i).getMonth().equals("09") )
                    && pockets.get(i).getCategory().equals("Bills") ){
                expense_sep_bills = expense_sep_bills + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("9") || pockets.get(i).getMonth().equals("09") )
                    && pockets.get(i).getCategory().equals("Food") ){
                expense_sep_food = expense_sep_food + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("9") || pockets.get(i).getMonth().equals("09") )
                    && pockets.get(i).getCategory().equals("Shopping") ){
                expense_sep_shopping = expense_sep_shopping + pockets.get(i).getAmount();
            }

            if ( (pockets.get(i).getMonth().equals("9") || pockets.get(i).getMonth().equals("09") )
                    && pockets.get(i).getCategory().equals("Others Expense") ){
                expense_sep_others = expense_sep_others + pockets.get(i).getAmount();
            }

        }


        for( int i = 0; i< pockets.size(); i++) {
            if ( pockets.get(i).getMonth().equals("10")
                    && pockets.get(i).getCategory().equals("Home Rent") ){
                expense_oct_home = expense_oct_home + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("10")
                    && pockets.get(i).getCategory().equals("Bills") ){
                expense_oct_bills = expense_oct_bills + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("10")
                    && pockets.get(i).getCategory().equals("Food") ){
                expense_oct_food = expense_oct_food + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("10")
                    && pockets.get(i).getCategory().equals("Shopping") ){
                expense_oct_shopping = expense_oct_shopping + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("10")
                    && pockets.get(i).getCategory().equals("Others Expense") ){
                expense_oct_others = expense_oct_others + pockets.get(i).getAmount();
            }

        }



        for( int i = 0; i< pockets.size(); i++) {
            if ( pockets.get(i).getMonth().equals("11")
                    && pockets.get(i).getCategory().equals("Home Rent") ){
                expense_nov_home = expense_nov_home + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("11")
                    && pockets.get(i).getCategory().equals("Bills") ){
                expense_nov_bills = expense_nov_bills + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("11")
                    && pockets.get(i).getCategory().equals("Food") ){
                expense_nov_food = expense_nov_food + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("11")
                    && pockets.get(i).getCategory().equals("Shopping") ){
                expense_nov_shopping = expense_nov_shopping + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("11")
                    && pockets.get(i).getCategory().equals("Others Expense") ){
                expense_nov_others = expense_nov_others + pockets.get(i).getAmount();
            }

        }



        for( int i = 0; i< pockets.size(); i++) {
            if ( pockets.get(i).getMonth().equals("12")
                    && pockets.get(i).getCategory().equals("Home Rent") ){
                expense_dec_home = expense_dec_home + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("12")
                    && pockets.get(i).getCategory().equals("Bills") ){
                expense_dec_bills = expense_dec_bills + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("12")
                    && pockets.get(i).getCategory().equals("Food") ){
                expense_dec_food = expense_dec_food + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("12")
                    && pockets.get(i).getCategory().equals("Shopping") ){
                expense_dec_shopping = expense_dec_shopping + pockets.get(i).getAmount();
            }

            if ( pockets.get(i).getMonth().equals("12")
                    && pockets.get(i).getCategory().equals("Others Expense") ){
                expense_dec_others = expense_dec_others + pockets.get(i).getAmount();
            }

        }



        //pie chart starts
        pieChart = findViewById(R.id.piechart_jan_expense);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(0.99f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValues = new ArrayList<>();

        if(expense_jan_home != 0.0){
            yValues.add(new PieEntry((float) expense_jan_home, "Home Rent"));
        }
        if(expense_jan_bills != 0.0){
            yValues.add(new PieEntry((float) expense_jan_bills, "Bills"));
        }
        if(expense_jan_food != 0.0){
            yValues.add(new PieEntry((float) expense_jan_food, "Food"));
        }
        if(expense_jan_shopping != 0.0){
            yValues.add(new PieEntry((float) expense_jan_shopping, "Shopping"));
        }
        if(expense_jan_others != 0.0){
            yValues.add(new PieEntry((float) expense_jan_others, "Others"));
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
        pieChartFeb = findViewById(R.id.piechart_feb_expense);
        pieChartFeb.getDescription().setEnabled(false);
        pieChartFeb.setExtraOffsets(5, 10, 5, 5);
        pieChartFeb.setDragDecelerationFrictionCoef(0.99f);
        pieChartFeb.setDrawHoleEnabled(true);
        pieChartFeb.setHoleColor(Color.WHITE);
        pieChartFeb.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesFeb = new ArrayList<>();

        if(expense_feb_home != 0.0){
            yValuesFeb.add(new PieEntry((float) expense_feb_home, "Home Rent"));
        }
        if(expense_feb_bills != 0.0){
            yValuesFeb.add(new PieEntry((float) expense_feb_bills, "Bills"));
        }
        if(expense_feb_food != 0.0){
            yValuesFeb.add(new PieEntry((float) expense_feb_food, "Food"));
        }
        if(expense_feb_shopping != 0.0){
            yValuesFeb.add(new PieEntry((float) expense_feb_shopping, "Shopping"));
        }
        if(expense_feb_others != 0.0){
            yValuesFeb.add(new PieEntry((float) expense_feb_others, "Others"));
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
        pieChartMar = findViewById(R.id.piechart_march_expense);
        pieChartMar.getDescription().setEnabled(false);
        pieChartMar.setExtraOffsets(5, 10, 5, 5);
        pieChartMar.setDragDecelerationFrictionCoef(0.99f);
        pieChartMar.setDrawHoleEnabled(true);
        pieChartMar.setHoleColor(Color.WHITE);
        pieChartMar.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesMar = new ArrayList<>();

        if(expense_mar_home != 0.0){
            yValuesMar.add(new PieEntry((float) expense_mar_home, "Home Rent"));
        }
        if(expense_mar_bills != 0.0){
            yValuesMar.add(new PieEntry((float) expense_mar_bills, "Bills"));
        }
        if(expense_mar_food != 0.0){
            yValuesMar.add(new PieEntry((float) expense_mar_food, "Food"));
        }
        if(expense_mar_shopping != 0.0){
            yValuesMar.add(new PieEntry((float) expense_mar_shopping, "Shopping"));
        }
        if(expense_mar_others != 0.0){
            yValuesMar.add(new PieEntry((float) expense_mar_others, "Others"));
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
        pieChartApr = findViewById(R.id.piechart_april_expense);
        pieChartApr.getDescription().setEnabled(false);
        pieChartApr.setExtraOffsets(5, 10, 5, 5);
        pieChartApr.setDragDecelerationFrictionCoef(0.99f);
        pieChartApr.setDrawHoleEnabled(true);
        pieChartApr.setHoleColor(Color.WHITE);
        pieChartApr.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesApr = new ArrayList<>();

        if(expense_apr_home != 0.0){
            yValuesApr.add(new PieEntry((float) expense_apr_home, "Home Rent"));
        }
        if(expense_apr_bills != 0.0){
            yValuesApr.add(new PieEntry((float) expense_apr_bills, "Bills"));
        }
        if(expense_apr_food != 0.0){
            yValuesApr.add(new PieEntry((float) expense_apr_food, "Food"));
        }
        if(expense_apr_shopping != 0.0){
            yValuesApr.add(new PieEntry((float) expense_apr_shopping, "Shopping"));
        }
        if(expense_apr_others != 0.0){
            yValuesApr.add(new PieEntry((float) expense_apr_others, "Others"));
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
        pieChartMay = findViewById(R.id.piechart_may_expense);
        pieChartMay.getDescription().setEnabled(false);
        pieChartMay.setExtraOffsets(5, 10, 5, 5);
        pieChartMay.setDragDecelerationFrictionCoef(0.99f);
        pieChartMay.setDrawHoleEnabled(true);
        pieChartMay.setHoleColor(Color.WHITE);
        pieChartMay.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesMay = new ArrayList<>();

        if(expense_may_home != 0.0){
            yValuesMay.add(new PieEntry((float) expense_may_home, "Home Rent"));
        }
        if(expense_may_bills != 0.0){
            yValuesMay.add(new PieEntry((float) expense_may_bills, "Bills"));
        }
        if(expense_may_food != 0.0){
            yValuesMay.add(new PieEntry((float) expense_may_food, "Food"));
        }
        if(expense_may_shopping != 0.0){
            yValuesMay.add(new PieEntry((float) expense_may_shopping, "Shopping"));
        }
        if(expense_may_others != 0.0){
            yValuesMay.add(new PieEntry((float) expense_may_others, "Others"));
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
        pieChartJune = findViewById(R.id.piechart_june_expense);
        pieChartJune.getDescription().setEnabled(false);
        pieChartJune.setExtraOffsets(5, 10, 5, 5);
        pieChartJune.setDragDecelerationFrictionCoef(0.99f);
        pieChartJune.setDrawHoleEnabled(true);
        pieChartJune.setHoleColor(Color.WHITE);
        pieChartJune.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesJune = new ArrayList<>();

        if(expense_june_home != 0.0){
            yValuesJune.add(new PieEntry((float) expense_june_home, "Home Rent"));
        }
        if(expense_june_bills != 0.0){
            yValuesJune.add(new PieEntry((float) expense_june_bills, "Bills"));
        }
        if(expense_june_food != 0.0){
            yValuesJune.add(new PieEntry((float) expense_june_food, "Food"));
        }
        if(expense_june_shopping != 0.0){
            yValuesJune.add(new PieEntry((float) expense_june_shopping, "Shopping"));
        }
        if(expense_june_others != 0.0){
            yValuesJune.add(new PieEntry((float) expense_june_others, "Others"));
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
        pieChartJuly = findViewById(R.id.piechart_july_expense);
        pieChartJuly.getDescription().setEnabled(false);
        pieChartJuly.setExtraOffsets(5, 10, 5, 5);
        pieChartJuly.setDragDecelerationFrictionCoef(0.99f);
        pieChartJuly.setDrawHoleEnabled(true);
        pieChartJuly.setHoleColor(Color.WHITE);
        pieChartJuly.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesJuly = new ArrayList<>();

        if(expense_july_home != 0.0){
            yValuesJuly.add(new PieEntry((float) expense_july_home, "Home Rent"));
        }
        if(expense_july_bills != 0.0){
            yValuesJuly.add(new PieEntry((float) expense_july_bills, "Bills"));
        }
        if(expense_july_food != 0.0){
            yValuesJuly.add(new PieEntry((float) expense_july_food, "Food"));
        }
        if(expense_july_shopping != 0.0){
            yValuesJuly.add(new PieEntry((float) expense_july_shopping, "Shopping"));
        }
        if(expense_july_others != 0.0){
            yValuesJuly.add(new PieEntry((float) expense_july_others, "Others"));
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
        pieChartAug = findViewById(R.id.piechart_aug_expense);
        pieChartAug.getDescription().setEnabled(false);
        pieChartAug.setExtraOffsets(5, 10, 5, 5);
        pieChartAug.setDragDecelerationFrictionCoef(0.99f);
        pieChartAug.setDrawHoleEnabled(true);
        pieChartAug.setHoleColor(Color.WHITE);
        pieChartAug.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesAug = new ArrayList<>();

        if(expense_aug_home != 0.0){
            yValuesAug.add(new PieEntry((float) expense_aug_home, "Home Rent"));
        }
        if(expense_aug_bills != 0.0){
            yValuesAug.add(new PieEntry((float) expense_aug_bills, "Bills"));
        }
        if(expense_aug_food != 0.0){
            yValuesAug.add(new PieEntry((float) expense_aug_food, "Food"));
        }
        if(expense_aug_shopping != 0.0){
            yValuesAug.add(new PieEntry((float) expense_aug_shopping, "Shopping"));
        }
        if(expense_aug_others != 0.0){
            yValuesAug.add(new PieEntry((float) expense_aug_others, "Others"));
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
        pieChartSep = findViewById(R.id.piechart_sep_expense);
        pieChartSep.getDescription().setEnabled(false);
        pieChartSep.setExtraOffsets(5, 10, 5, 5);
        pieChartSep.setDragDecelerationFrictionCoef(0.99f);
        pieChartSep.setDrawHoleEnabled(true);
        pieChartSep.setHoleColor(Color.WHITE);
        pieChartSep.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesSep = new ArrayList<>();

        if(expense_sep_home != 0.0){
            yValuesSep.add(new PieEntry((float) expense_sep_home, "Home Rent"));
        }
        if(expense_sep_bills != 0.0){
            yValuesSep.add(new PieEntry((float) expense_sep_bills, "Bills"));
        }
        if(expense_sep_food != 0.0){
            yValuesSep.add(new PieEntry((float) expense_sep_food, "Food"));
        }
        if(expense_sep_shopping != 0.0){
            yValuesSep.add(new PieEntry((float) expense_sep_shopping, "Shopping"));
        }
        if(expense_sep_others != 0.0){
            yValuesSep.add(new PieEntry((float) expense_sep_others, "Others"));
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
        pieChartOct = findViewById(R.id.piechart_oct_expense);
        pieChartOct.getDescription().setEnabled(false);
        pieChartOct.setExtraOffsets(5, 10, 5, 5);
        pieChartOct.setDragDecelerationFrictionCoef(0.99f);
        pieChartOct.setDrawHoleEnabled(true);
        pieChartOct.setHoleColor(Color.WHITE);
        pieChartOct.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesOct = new ArrayList<>();

        if(expense_oct_home != 0.0){
            yValuesOct.add(new PieEntry((float) expense_oct_home, "Home Rent"));
        }
        if(expense_oct_bills != 0.0){
            yValuesOct.add(new PieEntry((float) expense_oct_bills, "Bills"));
        }
        if(expense_oct_food != 0.0){
            yValuesOct.add(new PieEntry((float) expense_oct_food, "Food"));
        }
        if(expense_oct_shopping != 0.0){
            yValuesOct.add(new PieEntry((float) expense_oct_shopping, "Shopping"));
        }
        if(expense_oct_others != 0.0){
            yValuesOct.add(new PieEntry((float) expense_oct_others, "Others"));
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
        pieChartNov = findViewById(R.id.piechart_nov_expense);
        pieChartNov.getDescription().setEnabled(false);
        pieChartNov.setExtraOffsets(5, 10, 5, 5);
        pieChartNov.setDragDecelerationFrictionCoef(0.99f);
        pieChartNov.setDrawHoleEnabled(true);
        pieChartNov.setHoleColor(Color.WHITE);
        pieChartNov.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesNov = new ArrayList<>();

        if(expense_nov_home != 0.0){
            yValuesNov.add(new PieEntry((float) expense_nov_home, "Home Rent"));
        }
        if(expense_nov_bills != 0.0){
            yValuesNov.add(new PieEntry((float) expense_nov_bills, "Bills"));
        }
        if(expense_nov_food != 0.0){
            yValuesNov.add(new PieEntry((float) expense_nov_food, "Food"));
        }
        if(expense_nov_shopping != 0.0){
            yValuesNov.add(new PieEntry((float) expense_nov_shopping, "Shopping"));
        }
        if(expense_nov_others != 0.0){
            yValuesNov.add(new PieEntry((float) expense_nov_others, "Others"));
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
        pieChartDec = findViewById(R.id.piechart_dec_expense);
        pieChartDec.getDescription().setEnabled(false);
        pieChartDec.setExtraOffsets(5, 10, 5, 5);
        pieChartDec.setDragDecelerationFrictionCoef(0.99f);
        pieChartDec.setDrawHoleEnabled(true);
        pieChartDec.setHoleColor(Color.WHITE);
        pieChartDec.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValuesDec = new ArrayList<>();

        if(expense_dec_home != 0.0){
            yValuesDec.add(new PieEntry((float) expense_dec_home, "Home Rent"));
        }
        if(expense_dec_bills != 0.0){
            yValuesDec.add(new PieEntry((float) expense_dec_bills, "Bills"));
        }
        if(expense_dec_food != 0.0){
            yValuesDec.add(new PieEntry((float) expense_dec_food, "Food"));
        }
        if(expense_dec_shopping != 0.0){
            yValuesDec.add(new PieEntry((float) expense_dec_shopping, "Shopping"));
        }
        if(expense_dec_others != 0.0){
            yValuesDec.add(new PieEntry((float) expense_dec_others, "Others"));
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
