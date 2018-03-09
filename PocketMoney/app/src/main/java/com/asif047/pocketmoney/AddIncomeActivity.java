package com.asif047.pocketmoney;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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

public class AddIncomeActivity extends AppCompatActivity
        implements
        TimePickerDialog.OnTimeSetListener,
        DatePickerDialog.OnDateSetListener{


    private EditText etDescription;
    private EditText etAmount;
    private Button btnSave;
    private Button btnShow;

    private TextView mDateText;

    private PocketDBHelper dbHelper;
    Double amount;
    private String date_time="",month, year;

    private int mYear, mMonth, mDay;
    private String mDate;

    private double jan_income, feb_income , mar_income , apr_income ,
            may_income , june_income , july_income , aug_income ,
            sep_income , oct_income , nov_income , dec_income ;

    private Spinner sp;
    String category[] = {"Salary", "Bonus", "Fund", "Gift", "Others"};
    private String record_category="";
    ArrayAdapter<String> adapter;

    private ShowAlert showAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

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


//        etDate.setText(date_time);
//        etDate.setEnabled(false);
        mDateText.setText(mDate);





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
                    Toast.makeText(AddIncomeActivity.this, "Please enter the Amount", Toast.LENGTH_LONG).show();
                } else{


                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("1")) || (String.format("%d",mMonth).equals("01")) ))
                    {
                        jan_income = jan_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("2")) || (String.format("%d",mMonth).equals("02")) ))
                    {
                        feb_income = feb_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("3")) || (String.format("%d",mMonth).equals("03")) ))
                    {
                        mar_income = mar_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("4")) || (String.format("%d",mMonth).equals("04")) ))
                    {
                        apr_income = apr_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("5")) || (String.format("%d",mMonth).equals("05")) ))
                    {
                        may_income = may_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("6")) || (String.format("%d",mMonth).equals("06")) ))
                    {
                        june_income = june_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("7")) || (String.format("%d",mMonth).equals("07")) ))
                    {
                        july_income = july_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("8")) || (String.format("%d",mMonth).equals("08")) ))
                    {
                        aug_income = aug_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("9")) || (String.format("%d",mMonth).equals("09")) ))
                    {
                        sep_income = sep_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("10")) || (String.format("%d",mMonth).equals("10")) ))
                    {
                        oct_income = oct_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("11")) || (String.format("%d",mMonth).equals("11")) ))
                    {
                        nov_income = nov_income + Double.parseDouble(etAmount.getText().toString());
                    }

                    if(String.format("%d",mYear).equals(year)&& ( (String.format("%d",mMonth).equals("12")) || (String.format("%d",mMonth).equals("12")) ))
                    {
                        dec_income = dec_income + Double.parseDouble(etAmount.getText().toString());
                    }



                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putString("jan_income", ""+jan_income).commit();
                    getSharedPreferences("PREFERENCE2", MODE_PRIVATE).edit().putString("feb_income", ""+feb_income).commit();
                    getSharedPreferences("PREFERENCE3", MODE_PRIVATE).edit().putString("mar_income", ""+mar_income).commit();
                    getSharedPreferences("PREFERENCE4", MODE_PRIVATE).edit().putString("apr_income", ""+apr_income).commit();
                    getSharedPreferences("PREFERENCE5", MODE_PRIVATE).edit().putString("may_income", ""+may_income).commit();
                    getSharedPreferences("PREFERENCE6", MODE_PRIVATE).edit().putString("june_income", ""+june_income).commit();
                    getSharedPreferences("PREFERENCE7", MODE_PRIVATE).edit().putString("july_income", ""+july_income).commit();
                    getSharedPreferences("PREFERENCE8", MODE_PRIVATE).edit().putString("aug_income", ""+aug_income).commit();
                    getSharedPreferences("PREFERENCE9", MODE_PRIVATE).edit().putString("sep_income", ""+sep_income).commit();
                    getSharedPreferences("PREFERENCE10", MODE_PRIVATE).edit().putString("oct_income", ""+oct_income).commit();
                    getSharedPreferences("PREFERENCE11", MODE_PRIVATE).edit().putString("nov_income", ""+nov_income).commit();
                    getSharedPreferences("PREFERENCE12", MODE_PRIVATE).edit().putString("dec_income", ""+dec_income).commit();

                    savePerson();


                }




            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddIncomeActivity.this, MyPocketActivity.class);
                startActivity(intent);
            }
        });

    }


    // String.format("%.5f",Double.valueOf(c.getString(c.getColumnIndex(TAB_AMOUT+""))));

    private void savePerson(){
        String type = "Income";
        String date = mDate;
        String description = etDescription.getText().toString().trim();
        amount = Double.parseDouble(etAmount.getText().toString());
        dbHelper = new PocketDBHelper(this);


        //create new person
        Pocket pocket = new Pocket(type, date, description, amount,month, record_category);
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
