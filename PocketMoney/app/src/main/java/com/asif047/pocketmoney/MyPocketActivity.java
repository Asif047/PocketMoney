package com.asif047.pocketmoney;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.asif047.pocketmoney.Model.Pocket;
import com.asif047.pocketmoney.Utils.PocketAdapter;
import com.asif047.pocketmoney.Utils.PocketDBHelper;

import java.util.List;

public class MyPocketActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private PocketDBHelper dbHelper;
    private PocketAdapter adapter;

    private List<Pocket> pockets;

    private Double income = 0.0, expense=0.0, total_amount = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pocket);

        mRecyclerView = findViewById(R.id.recyclerview_mypocket);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        dbHelper = new PocketDBHelper(this);
        pockets = dbHelper.pocketList();


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


       // Toast.makeText(this, String.format("%.5f",Double.valueOf(income)),Toast.LENGTH_LONG).show();

        adapter = new PocketAdapter(dbHelper.pocketList(),this,mRecyclerView);
        mRecyclerView.setAdapter(adapter);

    }

    //back button operation starts

    @Override
    public void onBackPressed() {

        finish();
    }


    //back button operation ends

}
