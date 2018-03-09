package com.asif047.pocketmoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.asif047.pocketmoney.AlertBox.ShowAlert;
import com.asif047.pocketmoney.Model.Pocket;
import com.asif047.pocketmoney.Utils.PocketDBHelper;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

public class UpdatePocketActivity extends AppCompatActivity
        implements
        TimePickerDialog.OnTimeSetListener,
        DatePickerDialog.OnDateSetListener {

    private EditText etDescription, etAmount;
    private TextView tvSetDate;
    private Button btnSave, btnShow;
    private PocketDBHelper pocketDBHelper;
    private long receivedPocketId;
    private String receivedPocketDate, receivedPocketType, receivedPocketMonth, receivedPocketCategory;

    private String date_time = "", month, year;

    private int mYear, mMonth, mDay;
    private String mDate;

    private double previous_amount = 0.0;

    private double jan_income, feb_income, mar_income, apr_income,
            may_income, june_income, july_income, aug_income,
            sep_income, oct_income, nov_income, dec_income;

    private double jan_expense, feb_expense, mar_expense, apr_expense,
            may_expense, june_expense, july_expense, aug_expense,
            sep_expense, oct_expense, nov_expense, dec_expense;

    private Spinner sp, spExpense;
    String category[] = {"Salary", "Bonus", "Fund", "Gift", "Others"};
    String categoryExpense[] = {"Home Rent", "Bills", "Food", "Shopping", "Others"};
    private String record_category="";
    ArrayAdapter<String> adapter, adapterExpense;

    private RadioGroup rg;
    private int radioId;
    private String previous_type;

    private ShowAlert showAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pocket);

        showAlert = new ShowAlert(this);

        etDescription = findViewById(R.id.edittext_description_update);
        etAmount = findViewById(R.id.edittext_amount_update);
        tvSetDate = findViewById(R.id.set_date_update);
        btnSave = findViewById(R.id.button_save_update);
        btnShow = findViewById(R.id.button_show_update);

        rg = findViewById(R.id.rgroup);

        final RadioButton radioIncome = findViewById(R.id.radio_income);
        final RadioButton radioExpense = findViewById(R.id.radio_expense);

        sp = findViewById(R.id.spinner);
        spExpense = findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, category);
        adapterExpense = new ArrayAdapter<String>(this, R.layout.spinner_item, categoryExpense);

        adapter.setDropDownViewResource(R.layout.spinner_item);
        adapterExpense.setDropDownViewResource(R.layout.spinner_item);



        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(radioIncome.isChecked()){
                    receivedPocketType = "Income";


                    sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                            switch (position)
                            {
                                case 0:
                                    record_category = "Salary";
                                    break;
                                case 1:
                                    record_category = "Bonus";
                                    break;
                                case 2:
                                    record_category = "Fund";
                                    break;
                                case 3:
                                    record_category = "Gifts";
                                    break;
                                case 4:
                                    record_category = "Others";
                                    break;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });


                    sp.setAdapter(adapter);
                }
                else{
                    receivedPocketType = "Expense";

                    spExpense.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                            switch (position)
                            {
                                case 0:
                                    record_category = "Home Rent";
                                    break;
                                case 1:
                                    record_category = "Bills";
                                    break;
                                case 2:
                                    record_category = "Food";
                                    break;
                                case 3:
                                    record_category = "Shopping";
                                    break;
                                case 4:
                                    record_category = "Others Expense";
                                    break;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                    spExpense.setAdapter(adapterExpense);
                }

            }
        });


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


        //to get time starts
        java.util.Calendar c = java.util.Calendar.getInstance();
        java.text.SimpleDateFormat sd = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.text.SimpleDateFormat sd1 = new java.text.SimpleDateFormat("MM");
        java.text.SimpleDateFormat sd2 = new java.text.SimpleDateFormat("yyyy");
        mMonth = Integer.parseInt(sd1.format(c.getTime()));
        year = sd2.format(c.getTime());
        mYear = Integer.parseInt(sd2.format(c.getTime()));
        date_time = sd.format(c.getTime());

        //to get time ends


        tvSetDate.setText("" + mDate);

        pocketDBHelper = new PocketDBHelper(this);

        try {
            receivedPocketId = getIntent().getLongExtra("POCKET_ID", 1);
            receivedPocketDate = getIntent().getStringExtra("POCKET_DATE");
            receivedPocketMonth = getIntent().getStringExtra("POCKET_MONTH");
            receivedPocketType = getIntent().getStringExtra("POCKET_TYPE");
            receivedPocketCategory = getIntent().getStringExtra("POCKET_CATEGORY");

            previous_type = receivedPocketType;

            if(receivedPocketType.equals("Income")){
                radioId = radioIncome.getId();
            }else{
                radioId = radioExpense.getId();
            }

            rg.check(radioId);

            mDate = receivedPocketDate;
            month = receivedPocketMonth;

            record_category =receivedPocketCategory;

            int spinnerPosition = adapter.getPosition(record_category);

//set the default according to value
            sp.setSelection(spinnerPosition);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Pocket queiredPocket = pocketDBHelper.getPocket(receivedPocketId);

        etDescription.setText(queiredPocket.getDescription());
//        etAmount.setText(""+queiredPocket.getAmount());
        etAmount.setText(String.format("%.5f", Double.valueOf(queiredPocket.getAmount())));
        tvSetDate.setText(queiredPocket.getDate());

        previous_amount = Double.valueOf(queiredPocket.getAmount());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(etDescription.getText().toString().isEmpty()){
                    etDescription.setError("PLease enter the description");
                }

                if(etAmount.getText().toString().isEmpty()){
                    etAmount.setError("PLease enter the amount");
                    Toast.makeText(UpdatePocketActivity.this, "Please enter the Amount", Toast.LENGTH_LONG).show();
                }else{

                    // checking income update starts
                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("1")) || (String.format("%d", mMonth).equals("01")))) {
                        jan_income = jan_income - previous_amount;
                        jan_income = jan_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("2")) || (String.format("%d", mMonth).equals("02")))) {
                        feb_income = feb_income - previous_amount;
                        feb_income = feb_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("3")) || (String.format("%d", mMonth).equals("03")))) {
                        mar_income = mar_income - previous_amount;
                        mar_income = mar_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("4")) || (String.format("%d", mMonth).equals("04")))) {
                        apr_income = apr_income - previous_amount;
                        apr_income = apr_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("5")) || (String.format("%d", mMonth).equals("05")))) {
                        may_income = may_income - previous_amount;
                        may_income = may_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("6")) || (String.format("%d", mMonth).equals("06")))) {
                        june_income = june_income - previous_amount;
                        june_income = june_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("7")) || (String.format("%d", mMonth).equals("07")))) {
                        july_income = july_income - previous_amount;
                        july_income = july_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("8")) || (String.format("%d", mMonth).equals("08")))) {
                        aug_income = aug_income - previous_amount;
                        aug_income = aug_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("9")) || (String.format("%d", mMonth).equals("09")))) {
                        sep_income = sep_income - previous_amount;
                        sep_income = sep_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("10")) || (String.format("%d", mMonth).equals("10")))) {
                        oct_income = oct_income - previous_amount;
                        oct_income = oct_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("11")) || (String.format("%d", mMonth).equals("11")))) {
                        nov_income = nov_income - previous_amount;
                        nov_income = nov_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("12")) || (String.format("%d", mMonth).equals("12")))) {
                        dec_income = dec_income - previous_amount;
                        dec_income = dec_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    // checking income update ends


                    //checking expense update starts
                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("1")) || (String.format("%d", mMonth).equals("01")))) {
                        jan_expense = jan_expense - previous_amount;
                        jan_expense = jan_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("2")) || (String.format("%d", mMonth).equals("02")))) {
                        feb_expense = feb_expense - previous_amount;
                        feb_expense = feb_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("3")) || (String.format("%d", mMonth).equals("03")))) {
                        mar_expense = mar_expense - previous_amount;
                        mar_expense = mar_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("4")) || (String.format("%d", mMonth).equals("04")))) {
                        apr_expense = apr_expense - previous_amount;
                        apr_expense = apr_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("5")) || (String.format("%d", mMonth).equals("05")))) {
                        may_expense = may_expense - previous_amount;
                        may_expense = may_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("6")) || (String.format("%d", mMonth).equals("06")))) {
                        june_expense = june_expense - previous_amount;
                        june_expense = june_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("7")) || (String.format("%d", mMonth).equals("07")))) {
                        july_expense = july_expense - previous_amount;
                        july_expense = july_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("8")) || (String.format("%d", mMonth).equals("08")))) {
                        aug_expense = aug_expense - previous_amount;
                        aug_expense = aug_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("9")) || (String.format("%d", mMonth).equals("09")))) {
                        sep_expense = sep_expense - previous_amount;
                        sep_expense = sep_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("10")) || (String.format("%d", mMonth).equals("10")))) {
                        oct_expense = oct_expense - previous_amount;
                        oct_expense = oct_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("11")) || (String.format("%d", mMonth).equals("11")))) {
                        nov_expense = nov_expense - previous_amount;
                        nov_expense = nov_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("12")) || (String.format("%d", mMonth).equals("12")))) {
                        dec_expense = dec_expense - previous_amount;
                        dec_expense = dec_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    //checking expense update ends



                    // previous income and current expense starts

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("1")) || (String.format("%d", mMonth).equals("01")))) {
                        jan_income = jan_income - previous_amount;
                        jan_expense = jan_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("2")) || (String.format("%d", mMonth).equals("02")))) {
                        feb_income = feb_income - previous_amount;
                        feb_expense = feb_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("3")) || (String.format("%d", mMonth).equals("03")))) {
                        mar_income = mar_income - previous_amount;
                        mar_expense = mar_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("4")) || (String.format("%d", mMonth).equals("04")))) {
                        apr_income = apr_income - previous_amount;
                        apr_expense = apr_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("5")) || (String.format("%d", mMonth).equals("05")))) {
                        may_income = may_income - previous_amount;
                        may_expense = may_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("6")) || (String.format("%d", mMonth).equals("06")))) {
                        june_income = june_income - previous_amount;
                        june_expense = june_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("7")) || (String.format("%d", mMonth).equals("07")))) {
                        july_income = july_income - previous_amount;
                        july_expense = july_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("8")) || (String.format("%d", mMonth).equals("08")))) {
                        aug_income = aug_income - previous_amount;
                        aug_expense = aug_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("9")) || (String.format("%d", mMonth).equals("09")))) {
                        sep_income = sep_income - previous_amount;
                        sep_expense = sep_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("10")) || (String.format("%d", mMonth).equals("10")))) {
                        oct_income = oct_income - previous_amount;
                        oct_expense = oct_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("11")) || (String.format("%d", mMonth).equals("11")))) {
                        nov_income = nov_income - previous_amount;
                        nov_expense = nov_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Expense"))
                            && previous_type.equals("Income") && ((String.format("%d", mMonth).equals("12")) || (String.format("%d", mMonth).equals("12")))) {
                        dec_income = dec_income - previous_amount;
                        dec_expense = dec_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    // previous income and current expense ends



                    //previous expense current income starts

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("1")) || (String.format("%d", mMonth).equals("01")))) {
                        jan_expense = jan_expense - previous_amount;
                        jan_income = jan_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("2")) || (String.format("%d", mMonth).equals("02")))) {
                        feb_expense = feb_expense - previous_amount;
                        feb_income = feb_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("3")) || (String.format("%d", mMonth).equals("03")))) {
                        mar_expense = mar_expense - previous_amount;
                        mar_income = mar_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("4")) || (String.format("%d", mMonth).equals("04")))) {
                        apr_expense = apr_expense - previous_amount;
                        apr_income = apr_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("5")) || (String.format("%d", mMonth).equals("05")))) {
                        may_expense = may_expense - previous_amount;
                        may_income = may_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("6")) || (String.format("%d", mMonth).equals("06")))) {
                        june_expense = june_expense - previous_amount;
                        june_income = june_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("7")) || (String.format("%d", mMonth).equals("07")))) {
                        july_expense = july_expense - previous_amount;
                        july_income = july_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("8")) || (String.format("%d", mMonth).equals("08")))) {
                        aug_expense = aug_expense - previous_amount;
                        aug_income = aug_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("9")) || (String.format("%d", mMonth).equals("09")))) {
                        sep_expense = sep_expense - previous_amount;
                        sep_income = sep_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("10")) || (String.format("%d", mMonth).equals("10")))) {
                        oct_expense = oct_expense - previous_amount;
                        oct_income = oct_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("11")) || (String.format("%d", mMonth).equals("11")))) {
                        nov_expense = nov_expense - previous_amount;
                        nov_income = nov_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if (String.format("%d", mYear).equals(year) && (receivedPocketType.equals("Income"))
                            && previous_type.equals("Expense") && ((String.format("%d", mMonth).equals("12")) || (String.format("%d", mMonth).equals("12")))) {
                        dec_expense = dec_expense - previous_amount;
                        dec_income = dec_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    //previous expense current income starts


                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putString("jan_income", "" + jan_income).commit();
                    getSharedPreferences("PREFERENCE2", MODE_PRIVATE).edit().putString("feb_income", "" + feb_income).commit();
                    getSharedPreferences("PREFERENCE3", MODE_PRIVATE).edit().putString("mar_income", "" + mar_income).commit();
                    getSharedPreferences("PREFERENCE4", MODE_PRIVATE).edit().putString("apr_income", "" + apr_income).commit();
                    getSharedPreferences("PREFERENCE5", MODE_PRIVATE).edit().putString("may_income", "" + may_income).commit();
                    getSharedPreferences("PREFERENCE6", MODE_PRIVATE).edit().putString("june_income", "" + june_income).commit();
                    getSharedPreferences("PREFERENCE7", MODE_PRIVATE).edit().putString("july_income", "" + july_income).commit();
                    getSharedPreferences("PREFERENCE8", MODE_PRIVATE).edit().putString("aug_income", "" + aug_income).commit();
                    getSharedPreferences("PREFERENCE9", MODE_PRIVATE).edit().putString("sep_income", "" + sep_income).commit();
                    getSharedPreferences("PREFERENCE10", MODE_PRIVATE).edit().putString("oct_income", "" + oct_income).commit();
                    getSharedPreferences("PREFERENCE11", MODE_PRIVATE).edit().putString("nov_income", "" + nov_income).commit();
                    getSharedPreferences("PREFERENCE12", MODE_PRIVATE).edit().putString("dec_income", "" + dec_income).commit();


                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putString("jan_expense", "" + jan_expense).commit();
                    getSharedPreferences("PREFERENCE2", MODE_PRIVATE).edit().putString("feb_expense", "" + feb_expense).commit();
                    getSharedPreferences("PREFERENCE3", MODE_PRIVATE).edit().putString("mar_expense", "" + mar_expense).commit();
                    getSharedPreferences("PREFERENCE4", MODE_PRIVATE).edit().putString("apr_expense", "" + apr_expense).commit();
                    getSharedPreferences("PREFERENCE5", MODE_PRIVATE).edit().putString("may_expense", "" + may_expense).commit();
                    getSharedPreferences("PREFERENCE6", MODE_PRIVATE).edit().putString("june_expense", "" + june_expense).commit();
                    getSharedPreferences("PREFERENCE7", MODE_PRIVATE).edit().putString("july_expense", "" + july_expense).commit();
                    getSharedPreferences("PREFERENCE8", MODE_PRIVATE).edit().putString("aug_expense", "" + aug_expense).commit();
                    getSharedPreferences("PREFERENCE9", MODE_PRIVATE).edit().putString("sep_expense", "" + sep_expense).commit();
                    getSharedPreferences("PREFERENCE10", MODE_PRIVATE).edit().putString("oct_expense", "" + oct_expense).commit();
                    getSharedPreferences("PREFERENCE11", MODE_PRIVATE).edit().putString("nov_expense", "" + nov_expense).commit();
                    getSharedPreferences("PREFERENCE12", MODE_PRIVATE).edit().putString("dec_expense", "" + dec_expense).commit();


                    updatePocket();



                }



            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdatePocketActivity.this, MyPocketActivity.class);
                startActivity(intent);
            }
        });

    }


    private void updatePocket() {
        String type = receivedPocketType;
        String date = mDate;

        String description = etDescription.getText().toString().trim();
        double amount = Double.parseDouble(etAmount.getText().toString());

        Pocket updatedPocket = new Pocket(type, date, description, amount,month,record_category);
        pocketDBHelper.updatePocketRecord(receivedPocketId, this, updatedPocket);


        showAlert.showIncomeExpenseSaved();

    }


    public void setDate(View view) {

        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                (DatePickerDialog.OnDateSetListener) this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");

    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        monthOfYear++;
        mDay = dayOfMonth;
        mMonth = monthOfYear;
        month = "" + mMonth;
        mYear = year;
        mDate = year + "-" + monthOfYear + "-" + dayOfMonth;
        tvSetDate.setText(year + "-" + monthOfYear + "-" + dayOfMonth);

    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {

    }


    //back button operation starts

    @Override
    public void onBackPressed() {

        finish();
    }


    //back button operation ends


}
