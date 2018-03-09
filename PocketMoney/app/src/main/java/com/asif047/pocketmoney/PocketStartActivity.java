package com.asif047.pocketmoney;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.asif047.pocketmoney.PieChart.PiExpenseActivity;
import com.asif047.pocketmoney.PieChart.PieIncomeActivity;

public class PocketStartActivity extends AppCompatActivity {

    private CardView cardAddIncome, cardAddExpense, cardAllTransaction, cardMonthlyTransaction,
            cardMonthlyIncome, cardMonthlyExpense, cardCurrentStatus, cardTransactionGraph;

    private TextView tvCurrentStatus, tvAllTransaction, tvAddIncome, tvAddExpense, tvMonthlyincome,
                        tvMonthlyExpense, tvMonthlyTransaction, tvTransactionGraph;

    private Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocket_start);

        cardAddIncome = findViewById(R.id.card_add_income);
        cardAddExpense = findViewById(R.id.card_add_expense);
        cardAllTransaction = findViewById(R.id.card_all_transaction);
        cardMonthlyTransaction = findViewById(R.id.card_monthly_transaction);
        cardMonthlyIncome = findViewById(R.id.card_monthly_income);
        cardMonthlyExpense = findViewById(R.id.card_monthly_expense);
        cardCurrentStatus = findViewById(R.id.card_current_status);
        cardTransactionGraph = findViewById(R.id.card_transaction_graph);

        tvCurrentStatus = findViewById(R.id.current_status);
        tvAllTransaction = findViewById(R.id.all_transaction);
        tvAddIncome = findViewById(R.id.add_income);
        tvAddExpense = findViewById(R.id.add_expense);
        tvMonthlyincome = findViewById(R.id.monthly_income);
        tvMonthlyExpense = findViewById(R.id.monthly_expense);
        tvMonthlyTransaction = findViewById(R.id.monthly_transaction);
        tvTransactionGraph = findViewById(R.id.transaction_graph);

        cardAddIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PocketStartActivity.this, AddIncomeActivity.class);
                startActivity(intent);
            }
        });

        cardAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PocketStartActivity.this, AddExpenseActivity.class);
                startActivity(intent);
            }
        });

        cardAllTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PocketStartActivity.this, MyPocketActivity.class);
                startActivity(intent);
            }
        });

        cardMonthlyTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PocketStartActivity.this, MonthlyTransactionActivity.class);
                startActivity(intent);
            }
        });

        cardMonthlyIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PocketStartActivity.this, PieIncomeActivity.class);
                startActivity(intent);
            }
        });


        cardMonthlyExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PocketStartActivity.this, PiExpenseActivity.class);
                startActivity(intent);
            }
        });


        cardCurrentStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PocketStartActivity.this, StatusActivity.class);
                startActivity(intent);
            }
        });


        cardTransactionGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PocketStartActivity.this, GraphActivity.class);
                startActivity(intent);
            }
        });


        typeface = Typeface.createFromAsset(getAssets(), "font_amaranth/Amaranth-Bold.ttf");
        tvCurrentStatus.setTypeface(typeface);
        tvAllTransaction.setTypeface(typeface);
        tvAddIncome.setTypeface(typeface);
        tvAddExpense.setTypeface(typeface);
        tvMonthlyincome.setTypeface(typeface);
        tvMonthlyExpense.setTypeface(typeface);
        tvMonthlyTransaction.setTypeface(typeface);
        tvTransactionGraph.setTypeface(typeface);


    }


    //back button operation starts

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        //finish();
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);

                    }
                })
                .setNegativeButton("No", null)
                .show();
    }


    //back button operation ends


}
