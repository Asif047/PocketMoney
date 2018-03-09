package com.asif047.pocketmoney;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.asif047.pocketmoney.Model.Pocket;
import com.asif047.pocketmoney.Utils.PocketAdapterApr;
import com.asif047.pocketmoney.Utils.PocketAdapterAug;
import com.asif047.pocketmoney.Utils.PocketAdapterFeb;
import com.asif047.pocketmoney.Utils.PocketAdapterJan;
import com.asif047.pocketmoney.Utils.PocketAdapterJuly;
import com.asif047.pocketmoney.Utils.PocketAdapterJune;
import com.asif047.pocketmoney.Utils.PocketAdapterMar;
import com.asif047.pocketmoney.Utils.PocketAdapterMay;
import com.asif047.pocketmoney.Utils.PocketAdapterNov;
import com.asif047.pocketmoney.Utils.PocketAdapterOct;
import com.asif047.pocketmoney.Utils.PocketAdapterSep;
import com.asif047.pocketmoney.Utils.PocketDBHelper;
import com.asif047.pocketmoney.Utils.PocketadapterDec;

import java.util.List;

public class MonthlyTransactionActivity extends AppCompatActivity {



    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.LayoutManager mLayoutManagerFeb;
    private RecyclerView.LayoutManager mLayoutManagerMar;
    private RecyclerView.LayoutManager mLayoutManagerApr;
    private RecyclerView.LayoutManager mLayoutManagerMay;
    private RecyclerView.LayoutManager mLayoutManagerJune;
    private RecyclerView.LayoutManager mLayoutManagerJuly;
    private RecyclerView.LayoutManager mLayoutManagerAug;
    private RecyclerView.LayoutManager mLayoutManagerSep;
    private RecyclerView.LayoutManager mLayoutManagerOct;
    private RecyclerView.LayoutManager mLayoutManagerNov;
    private RecyclerView.LayoutManager mLayoutManagerDec;

    private PocketDBHelper dbHelper;
    private RecyclerView mRecyclerView;
    private PocketAdapterJan adapter;

    private RecyclerView mRecyclerViewFeb;
    private PocketAdapterFeb adapterFeb;

    private RecyclerView mRecyclerViewMar;
    private PocketAdapterMar adapterMar;

    private RecyclerView mRecyclerViewApr;
    private PocketAdapterApr adapterApr;

    private RecyclerView mRecyclerViewMay;
    private PocketAdapterMay adapterMay;

    private RecyclerView mRecyclerViewJune;
    private PocketAdapterJune adapterJune;

    private RecyclerView mRecyclerViewJuly;
    private PocketAdapterJuly adapterJuly;

    private RecyclerView mRecyclerViewAug;
    private PocketAdapterAug adapterAug;

    private RecyclerView mRecyclerViewSep;
    private PocketAdapterSep adapterSep;

    private RecyclerView mRecyclerViewOct;
    private PocketAdapterOct adapterOct;

    private RecyclerView mRecyclerViewNov;
    private PocketAdapterNov adapterNov;

    private RecyclerView mRecyclerViewDec;
    private PocketadapterDec adapterDec;

    private List<Pocket> pockets;

    private Double income = 0.0, expense=0.0, total_amount = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_transaction);

        mRecyclerView = findViewById(R.id.recycler_january);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManagerFeb = new LinearLayoutManager(this);
        mLayoutManagerMar = new LinearLayoutManager(this);
        mLayoutManagerApr = new LinearLayoutManager(this);
        mLayoutManagerMay = new LinearLayoutManager(this);
        mLayoutManagerJune = new LinearLayoutManager(this);
        mLayoutManagerJuly = new LinearLayoutManager(this);
        mLayoutManagerAug = new LinearLayoutManager(this);
        mLayoutManagerSep = new LinearLayoutManager(this);
        mLayoutManagerOct = new LinearLayoutManager(this);
        mLayoutManagerNov = new LinearLayoutManager(this);
        mLayoutManagerDec = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mRecyclerViewFeb = findViewById(R.id.recyclerview_february);
        mRecyclerViewFeb.setHasFixedSize(true);
        mRecyclerViewFeb.setLayoutManager(mLayoutManagerFeb);

        mRecyclerViewMar = findViewById(R.id.recylerview_march);
        mRecyclerViewMar.setHasFixedSize(true);
        mRecyclerViewMar.setLayoutManager(mLayoutManagerMar);

        mRecyclerViewApr = findViewById(R.id.recyclerview_april);
        mRecyclerViewApr.setHasFixedSize(true);
        mRecyclerViewApr.setLayoutManager(mLayoutManagerApr);

        mRecyclerViewMay = findViewById(R.id.recyclerview_may);
        mRecyclerViewMay.setHasFixedSize(true);
        mRecyclerViewMay.setLayoutManager(mLayoutManagerMay);

        mRecyclerViewJune = findViewById(R.id.recyclerview_june);
        mRecyclerViewJune.setHasFixedSize(true);
        mRecyclerViewJune.setLayoutManager(mLayoutManagerJune);

        mRecyclerViewJuly = findViewById(R.id.recyclerview_july);
        mRecyclerViewJuly.setHasFixedSize(true);
        mRecyclerViewJuly.setLayoutManager(mLayoutManagerJuly);

        mRecyclerViewAug = findViewById(R.id.recyclerview_august);
        mRecyclerViewAug.setHasFixedSize(true);
        mRecyclerViewAug.setLayoutManager(mLayoutManagerAug);

        mRecyclerViewSep = findViewById(R.id.recyclerview_september);
        mRecyclerViewSep.setHasFixedSize(true);
        mRecyclerViewSep.setLayoutManager(mLayoutManagerSep);

        mRecyclerViewOct = findViewById(R.id.recyclerview_october);
        mRecyclerViewOct.setHasFixedSize(true);
        mRecyclerViewOct.setLayoutManager(mLayoutManagerOct);

        mRecyclerViewNov = findViewById(R.id.recyclerview_november);
        mRecyclerViewNov.setHasFixedSize(true);
        mRecyclerViewNov.setLayoutManager(mLayoutManagerNov);

        mRecyclerViewDec = findViewById(R.id.recyclerview_december);
        mRecyclerViewDec.setHasFixedSize(true);
        mRecyclerViewDec.setLayoutManager(mLayoutManagerDec);

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


        //Toast.makeText(this, String.format("%.5f",Double.valueOf(income)),Toast.LENGTH_LONG).show();

        adapter = new PocketAdapterJan(dbHelper.pocketListJan(),this,mRecyclerView);
        mRecyclerView.setAdapter(adapter);

        adapterFeb = new PocketAdapterFeb(dbHelper.pocketListFeb(),this,mRecyclerViewFeb);
        mRecyclerViewFeb.setAdapter(adapterFeb);

        adapterMar = new PocketAdapterMar(dbHelper.pocketListMar(),this,mRecyclerViewMar);
        mRecyclerViewMar.setAdapter(adapterMar);

        adapterApr= new PocketAdapterApr(dbHelper.pocketListApr(),this,mRecyclerViewApr);
        mRecyclerViewApr.setAdapter(adapterApr);

        adapterMay= new PocketAdapterMay(dbHelper.pocketListMay(),this,mRecyclerViewMay);
        mRecyclerViewMay.setAdapter(adapterMay);

        adapterJune= new PocketAdapterJune(dbHelper.pocketListJune(),this,mRecyclerViewJune);
        mRecyclerViewJune.setAdapter(adapterJune);

        adapterJuly= new PocketAdapterJuly(dbHelper.pocketListJuly(),this,mRecyclerViewJuly);
        mRecyclerViewJuly.setAdapter(adapterJuly);

        adapterAug= new PocketAdapterAug(dbHelper.pocketListAug(),this,mRecyclerViewAug);
        mRecyclerViewAug.setAdapter(adapterAug);

        adapterSep= new PocketAdapterSep(dbHelper.pocketListSep(),this,mRecyclerViewSep);
        mRecyclerViewSep.setAdapter(adapterSep);

        adapterOct= new PocketAdapterOct(dbHelper.pocketListOct(),this,mRecyclerViewOct);
        mRecyclerViewOct.setAdapter(adapterOct);

        adapterNov= new PocketAdapterNov(dbHelper.pocketListNov(),this,mRecyclerViewNov);
        mRecyclerViewNov.setAdapter(adapterNov);

        adapterDec= new PocketadapterDec(dbHelper.pocketListDec(),this,mRecyclerViewDec);
        mRecyclerViewDec.setAdapter(adapterDec);

    }


    //back button operation starts

    @Override
    public void onBackPressed() {

        finish();
    }


    //back button operation ends

}
