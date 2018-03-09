package com.asif047.pocketmoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

public class AddExpenseActivity extends AppCompatActivity
        implements
        TimePickerDialog.OnTimeSetListener,
        DatePickerDialog.OnDateSetListener{

    private EditText etType;
    private EditText etDate;
    private EditText etDescription;
    private EditText etAmount;
    private Button btnSave;
    private Button btnShow;

    private Spinner sp;
    String category[] = {"Home Rent", "Bills", "Food", "Shopping", "Others"};
    private String record_category="";
    ArrayAdapter<String> adapter;

    private TextView mDateText;

    private PocketDBHelper dbHelper;
    Double amount;
    private String date_time="",month,year;

    private int mYear, mMonth, mDay;
    private String mDate;


    private double jan_expense, feb_expense , mar_expense , apr_expense ,
            may_expense , june_expense , july_expense , aug_expense ,
            sep_expense , oct_expense , nov_expense , dec_expense ;

    private ShowAlert showAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        showAlert = new ShowAlert(this);

        //init


        //to get time starts
        java.util.Calendar c = java.util.Calendar.getInstance();
        java.text.SimpleDateFormat sd = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.text.SimpleDateFormat sd1 = new java.text.SimpleDateFormat("MM");
        java.text.SimpleDateFormat sd2 = new java.text.SimpleDateFormat("yyyy");
        month = sd1.format(c.getTime());
        mMonth = Integer.parseInt(sd1.format(c.getTime()));
        year = sd2.format(c.getTime());
        mYear = Integer.parseInt(sd2.format(c.getTime()));
        date_time = sd.format(c.getTime());
        mDate = sd.format(c.getTime());
        //to get time ends


        etDescription = (EditText)findViewById(R.id.edittext_description);
        etAmount = (EditText)findViewById(R.id.edittext_amount);
        mDateText = findViewById(R.id.set_date);
        btnSave = (Button)findViewById(R.id.button_save);
        btnShow = (Button) findViewById(R.id.button_show);

        sp = findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, category);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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


//        etDate.setText(date_time);
//        etDate.setEnabled(false);
        mDateText.setText(mDate);



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





        //listen to add button click
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the save person method


                if(etDescription.getText().toString().isEmpty()){
                    etDescription.setError("PLease enter the description");
                }

                if(etAmount.getText().toString().isEmpty()){
                    etAmount.setError("PLease enter the amount");
                    Toast.makeText(AddExpenseActivity.this, "Please enter the Amount", Toast.LENGTH_LONG).show();
                }else{



                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("1")) || (String.format("%d",mMonth).equals("01")) ))
                    {
                        jan_expense = jan_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("2")) || (String.format("%d",mMonth).equals("02")) ))
                    {
                        feb_expense = feb_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("3")) || (String.format("%d",mMonth).equals("03")) ))
                    {
                        mar_expense = mar_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("4")) || (String.format("%d",mMonth).equals("04")) ))
                    {
                        apr_expense = apr_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("5")) || (String.format("%d",mMonth).equals("05")) ))
                    {
                        may_expense = may_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("6")) || (String.format("%d",mMonth).equals("06")) ))
                    {
                        june_expense = june_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("7")) || (String.format("%d",mMonth).equals("07")) ))
                    {
                        july_expense = july_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("8")) || (String.format("%d",mMonth).equals("08")) ))
                    {
                        aug_expense = aug_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("9")) || (String.format("%d",mMonth).equals("09")) ))
                    {
                        sep_expense = sep_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("10")) || (String.format("%d",mMonth).equals("10")) ))
                    {
                        oct_expense = oct_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("11")) || (String.format("%d",mMonth).equals("11")) ))
                    {
                        nov_expense = nov_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("12")) || (String.format("%d",mMonth).equals("12")) ))
                    {
                        dec_expense = dec_expense + Double.parseDouble(etAmount.getText().toString());
                    }

                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putString("jan_expense", ""+jan_expense).commit();
                    getSharedPreferences("PREFERENCE2", MODE_PRIVATE).edit().putString("feb_expense", ""+feb_expense).commit();
                    getSharedPreferences("PREFERENCE3", MODE_PRIVATE).edit().putString("mar_expense", ""+mar_expense).commit();
                    getSharedPreferences("PREFERENCE4", MODE_PRIVATE).edit().putString("apr_expense", ""+apr_expense).commit();
                    getSharedPreferences("PREFERENCE5", MODE_PRIVATE).edit().putString("may_expense", ""+may_expense).commit();
                    getSharedPreferences("PREFERENCE6", MODE_PRIVATE).edit().putString("june_expense", ""+june_expense).commit();
                    getSharedPreferences("PREFERENCE7", MODE_PRIVATE).edit().putString("july_expense", ""+july_expense).commit();
                    getSharedPreferences("PREFERENCE8", MODE_PRIVATE).edit().putString("aug_expense", ""+aug_expense).commit();
                    getSharedPreferences("PREFERENCE9", MODE_PRIVATE).edit().putString("sep_expense", ""+sep_expense).commit();
                    getSharedPreferences("PREFERENCE10", MODE_PRIVATE).edit().putString("oct_expense", ""+oct_expense).commit();
                    getSharedPreferences("PREFERENCE11", MODE_PRIVATE).edit().putString("nov_expense", ""+nov_expense).commit();
                    getSharedPreferences("PREFERENCE12", MODE_PRIVATE).edit().putString("dec_expense", ""+dec_expense).commit();


                    savePerson();


                }


            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddExpenseActivity.this, StatusActivity.class);
                startActivity(intent);
            }
        });

    }


    // String.format("%.5f",Double.valueOf(c.getString(c.getColumnIndex(TAB_AMOUT+""))));

    private void savePerson(){
        String type = "Expense";
        String date = mDate;
        String description = etDescription.getText().toString().trim();
        amount = Double.parseDouble(etAmount.getText().toString());
        dbHelper = new PocketDBHelper(this);



        //create new person
        Pocket pocket = new Pocket(type, date, description, amount,month,record_category);
        dbHelper.saveNewPocket(pocket);

        showAlert.showIncomeExpenseSaved();

        //finally redirect back home
        // NOTE you can implement an sqlite callback then redirect on success delete


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

        monthOfYear ++;
        mDay = dayOfMonth;
        mMonth = monthOfYear;
        month= ""+mMonth;
        mYear = year;
        mDate = year + "-" + monthOfYear + "-" + dayOfMonth;
        mDateText.setText(year + "-" + monthOfYear + "-" + dayOfMonth);


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
