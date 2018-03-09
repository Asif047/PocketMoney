package com.asif047.pocketmoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.asif047.pocketmoney.Model.Pocket;
import com.asif047.pocketmoney.Utils.PocketDBHelper;

import java.util.List;

public class StatusActivity extends AppCompatActivity {

    private PocketDBHelper dbHelper;
    private List<Pocket> pockets;
    private TextView tvPocketStatus, tvIncome, tvExpense;
    private Double income = 0.0, expense=0.0, total_amount = 0.0;

    private double jan_income=0.0, feb_income = 0.0, mar_income = 0.0, apr_income = 0.0,
            may_income = 0.0, june_income =0.0, july_income = 0.0, aug_income =0.0,
            sep_income = 0.0, oct_income = 0.0, nov_income = 0.0, dec_income =0.0;


    private double jan_expense=0.0, feb_expense = 0.0, mar_expense = 0.0, apr_expense = 0.0,
            may_expense = 0.0, june_expense =0.0, july_expense = 0.0, aug_expense =0.0,
            sep_expense = 0.0, oct_expense = 0.0, nov_expense = 0.0, dec_expense =0.0;

    private TextView tvJanIncome, tvFebIncome, tvMarIncome, tvAprIncome, tvMayIncome,
            tvJuneIncome, tvJulyIncome, tvAugIncome, tvSepIncome, tvOctIncome,
            tvNovIncome, tvDecIncome;


    private TextView tvJanExpense, tvFebExpense, tvMarExpense, tvAprExpense, tvMayExpense,
            tvJuneExpense, tvJulyExpense, tvAugExpense, tvSepExpense, tvOctExpense,
            tvNovExpense, tvDecExpense;

    private Button btnGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        dbHelper = new PocketDBHelper(this);
        pockets = dbHelper.pocketList();

        tvPocketStatus = findViewById(R.id.textview_pocket_status);
        tvIncome = findViewById(R.id.textview_income_status);
        tvExpense = findViewById(R.id.textview_expense_status);

        tvJanIncome = findViewById(R.id.textview_jan_income);
        tvFebIncome = findViewById(R.id.textview_feb_income);
        tvMarIncome = findViewById(R.id.textview_march_income);
        tvAprIncome = findViewById(R.id.textview_april_income);
        tvMayIncome = findViewById(R.id.textview_may_income);
        tvJuneIncome = findViewById(R.id.textview_june_income);
        tvJulyIncome = findViewById(R.id.textview_july_income);
        tvAugIncome = findViewById(R.id.textview_august_income);
        tvSepIncome = findViewById(R.id.textview_september_income);
        tvOctIncome = findViewById(R.id.textview_october_income);
        tvNovIncome = findViewById(R.id.textview_november_income);
        tvDecIncome = findViewById(R.id.textview_december_income);


        tvJanExpense = findViewById(R.id.textview_jan_expense);
        tvFebExpense = findViewById(R.id.textview_feb_expense);
        tvMarExpense = findViewById(R.id.textview_march_expense);
        tvAprExpense = findViewById(R.id.textview_april_expense);
        tvMayExpense = findViewById(R.id.textview_may_expense);
        tvJuneExpense = findViewById(R.id.textview_june_expense);
        tvJulyExpense = findViewById(R.id.textview_july_expense);
        tvAugExpense = findViewById(R.id.textview_august_expense);
        tvSepExpense = findViewById(R.id.textview_september_expense);
        tvOctExpense = findViewById(R.id.textview_october_expense);
        tvNovExpense = findViewById(R.id.textview_november_expense);
        tvDecExpense = findViewById(R.id.textview_december_expense);

        btnGraph = findViewById(R.id.button_graph);


        btnGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatusActivity.this, GraphActivity.class);
                startActivity(intent);
            }
        });


        for( int i = 0; i< pockets.size(); i++)
        {
            if(pockets.get(i).getType().equals("Income"))
            {
                total_amount = total_amount + pockets.get(i).getAmount() ;
                income = income + pockets.get(i).getAmount();
            }

            if(pockets.get(i).getType().equals("Expense"))
            {
                total_amount = total_amount - pockets.get(i).getAmount() ;
                expense = expense + pockets.get(i).getAmount();
            }

        }

        tvPocketStatus.setText(String.format("%.5f",Double.valueOf(total_amount)));
        tvIncome.setText(String.format("%.5f",Double.valueOf(income)));
        tvExpense.setText(String.format("%.5f",Double.valueOf(expense)));

        //Toast.makeText(this, String.format("%.5f",Double.valueOf(income)),Toast.LENGTH_LONG).show();

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




        tvJanIncome.setText(String.format("%.3f",jan_income));
        tvFebIncome.setText(String.format("%.3f",feb_income));
        tvMarIncome.setText(String.format("%.3f",mar_income));
        tvAprIncome.setText(String.format("%.3f",apr_income));
        tvMayIncome.setText(String.format("%.3f",may_income));
        tvJuneIncome.setText(String.format("%.3f",june_income));
        tvJulyIncome.setText(String.format("%.3f",july_income));
        tvAugIncome.setText(String.format("%.3f",aug_income));
        tvSepIncome.setText(String.format("%.3f",sep_income));
        tvOctIncome.setText(String.format("%.3f",oct_income));
        tvNovIncome.setText(String.format("%.3f",nov_income));
        tvDecIncome.setText(String.format("%.3f",dec_income));



        tvJanExpense.setText(String.format("%.3f",jan_expense));
        tvFebExpense.setText(String.format("%.3f",feb_expense));
        tvMarExpense.setText(String.format("%.3f",mar_expense));
        tvAprExpense.setText(String.format("%.3f",apr_expense));
        tvMayExpense.setText(String.format("%.3f",may_expense));
        tvJuneExpense.setText(String.format("%.3f",june_expense));
        tvJulyExpense.setText(String.format("%.3f",july_expense));
        tvAugExpense.setText(String.format("%.3f",aug_expense));
        tvSepExpense.setText(String.format("%.3f",sep_expense));
        tvOctExpense.setText(String.format("%.3f",oct_expense));
        tvNovExpense.setText(String.format("%.3f",nov_expense));
        tvDecExpense.setText(String.format("%.3f",dec_expense));


    }


    //back button operation starts

    @Override
    public void onBackPressed() {

        finish();
    }


    //back button operation ends


}
