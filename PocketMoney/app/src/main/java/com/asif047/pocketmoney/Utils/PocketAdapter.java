package com.asif047.pocketmoney.Utils;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asif047.pocketmoney.Model.Pocket;
import com.asif047.pocketmoney.R;
import com.asif047.pocketmoney.UpdatePocketActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class PocketAdapter extends RecyclerView.Adapter<PocketAdapter.ViewHolder> {


    private List<Pocket> mPocketList;
    private Context mContext;
    private RecyclerView mRecyclerV;

    private double jan_income, feb_income, mar_income, apr_income,
            may_income, june_income, july_income, aug_income,
            sep_income, oct_income, nov_income, dec_income;

    private double jan_expense, feb_expense, mar_expense, apr_expense,
            may_expense, june_expense, july_expense, aug_expense,
            sep_expense, oct_expense, nov_expense, dec_expense;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvId;
        public TextView tvType;
        public TextView tvDate;
        public TextView tvDescription;
        public TextView tvAmount;
        public TextView tvMonth;
        public TextView tvCategory;

        public ImageView ivType;


        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            tvId = (TextView) v.findViewById(R.id.textview_id);
            tvType = (TextView) v.findViewById(R.id.textview_type);
            tvDate = (TextView) v.findViewById(R.id.textview_date);
            tvDescription = (TextView) v.findViewById(R.id.textview_description);
            tvAmount = (TextView) v.findViewById(R.id.textview_amount);
            tvMonth = v.findViewById(R.id.textview_month);
            tvCategory = v.findViewById(R.id.textview_category);

            ivType = v.findViewById(R.id.image_type);

        }
    }

    public void add(int position, Pocket pocket) {
        mPocketList.add(position, pocket);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        mPocketList.remove(position);
        notifyItemRemoved(position);
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public PocketAdapter(List<Pocket> myDataset, Context context, RecyclerView recyclerView) {
        mPocketList = myDataset;
        mContext = context;
        mRecyclerV = recyclerView;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PocketAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_item_pocket, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final Pocket pocket = mPocketList.get(position);
        holder.tvId.setText("No. : " + pocket.getId());
        holder.tvType.setText("Type: " + pocket.getType());
        holder.tvDate.setText("Date: " + pocket.getDate());
        holder.tvDescription.setText("Description: " + pocket.getDescription());
        holder.tvAmount.setText("Amount: " + String.format("%.5f", Double.valueOf(pocket.getAmount())));
        holder.tvMonth.setText("Month: "+pocket.getMonth());
        holder.tvCategory.setText("Category: "+pocket.getCategory());

        if (pocket.getType().toString().equals("Income")) {
            Picasso.with(mContext).load(R.drawable.ic_plus_white).into(holder.ivType);
        }
        if (pocket.getType().toString().equals("Expense")) {
            Picasso.with(mContext).load(R.drawable.ic_minus_white).into(holder.ivType);
        }


        //listen to single view layout click
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Choose option");
                builder.setMessage("Update or delete user?");
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //go to update activity
                        goToUpdateActivity(pocket.getId(), pocket.getDate(), pocket.getType(), pocket.getMonth(), pocket.getCategory());

                    }
                });
                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PocketDBHelper dbHelper = new PocketDBHelper(mContext);
                        dbHelper.deletePocketRecord(pocket.getId(), mContext);




                        jan_income = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE", MODE_PRIVATE).getString("jan_income", "0.0"));
                        feb_income = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE2", MODE_PRIVATE).getString("feb_income", "0.0"));
                        mar_income = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE3", MODE_PRIVATE).getString("mar_income", "0.0"));
                        apr_income = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE4", MODE_PRIVATE).getString("apr_income", "0.0"));
                        may_income = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE5", MODE_PRIVATE).getString("may_income", "0.0"));
                        june_income = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE6", MODE_PRIVATE).getString("june_income", "0.0"));
                        july_income = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE7", MODE_PRIVATE).getString("july_income", "0.0"));
                        aug_income = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE8", MODE_PRIVATE).getString("aug_income", "0.0"));
                        sep_income = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE9", MODE_PRIVATE).getString("sep_income", "0.0"));
                        oct_income = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE10", MODE_PRIVATE).getString("oct_income", "0.0"));
                        nov_income = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE11", MODE_PRIVATE).getString("nov_income", "0.0"));
                        dec_income = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE12", MODE_PRIVATE).getString("dec_income", "0.0"));


                        jan_expense = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE", MODE_PRIVATE).getString("jan_expense", "0.0"));
                        feb_expense = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE2", MODE_PRIVATE).getString("feb_expense", "0.0"));
                        mar_expense = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE3", MODE_PRIVATE).getString("mar_expense", "0.0"));
                        apr_expense = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE4", MODE_PRIVATE).getString("apr_expense", "0.0"));
                        may_expense = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE5", MODE_PRIVATE).getString("may_expense", "0.0"));
                        june_expense = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE6", MODE_PRIVATE).getString("june_expense", "0.0"));
                        july_expense = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE7", MODE_PRIVATE).getString("july_expense", "0.0"));
                        aug_expense = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE8", MODE_PRIVATE).getString("aug_expense", "0.0"));
                        sep_expense = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE9", MODE_PRIVATE).getString("sep_expense", "0.0"));
                        oct_expense = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE10", MODE_PRIVATE).getString("oct_expense", "0.0"));
                        nov_expense = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE11", MODE_PRIVATE).getString("nov_expense", "0.0"));
                        dec_expense = Double.parseDouble(mContext.getSharedPreferences("PREFERENCE12", MODE_PRIVATE).getString("dec_expense", "0.0"));


                        if(pocket.getType().equals("Income") && (pocket.getMonth().equals("1")
                                || pocket.getMonth().equals("01"))){
                            jan_income = jan_income - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Income") && (pocket.getMonth().equals("2")
                                || pocket.getMonth().equals("02"))){
                            feb_income = feb_income - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Income") && (pocket.getMonth().equals("3")
                                || pocket.getMonth().equals("03"))){
                            mar_income = mar_income - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Income") && (pocket.getMonth().equals("4")
                                || pocket.getMonth().equals("04"))){
                            apr_income = apr_income - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Income") && (pocket.getMonth().equals("5")
                                || pocket.getMonth().equals("05"))){
                            may_income = may_income - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Income") && (pocket.getMonth().equals("6")
                                || pocket.getMonth().equals("06"))){
                            june_income = june_income - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Income") && (pocket.getMonth().equals("7")
                                || pocket.getMonth().equals("07"))){
                            july_income = july_income - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Income") && (pocket.getMonth().equals("8")
                                || pocket.getMonth().equals("08"))){
                            aug_income = aug_income - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Income") && (pocket.getMonth().equals("9")
                                || pocket.getMonth().equals("09"))){
                            sep_income = sep_income - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Income") && (pocket.getMonth().equals("10")) ){
                            oct_income = oct_income - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Income") && (pocket.getMonth().equals("11"))){
                            nov_income = nov_income - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Income") && (pocket.getMonth().equals("12") )){
                            dec_income = dec_income - pocket.getAmount();
                        }




                        // expense part starts

                        if(pocket.getType().equals("Expense") && (pocket.getMonth().equals("1")
                                || pocket.getMonth().equals("01"))){
                            jan_expense = jan_expense - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Expense") && (pocket.getMonth().equals("2")
                                || pocket.getMonth().equals("02"))){
                            feb_expense = feb_expense - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Expense") && (pocket.getMonth().equals("3")
                                || pocket.getMonth().equals("03"))){
                            mar_expense = mar_expense - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Expense") && (pocket.getMonth().equals("4")
                                || pocket.getMonth().equals("04"))){
                            apr_expense = apr_expense - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Expense") && (pocket.getMonth().equals("5")
                                || pocket.getMonth().equals("05"))){
                            may_expense = may_expense - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Expense") && (pocket.getMonth().equals("6")
                                || pocket.getMonth().equals("06"))){
                            june_expense = june_expense - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Expense") && (pocket.getMonth().equals("7")
                                || pocket.getMonth().equals("07"))){
                            july_expense = july_expense - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Expense") && (pocket.getMonth().equals("8")
                                || pocket.getMonth().equals("08"))){
                            aug_expense = aug_expense - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Expense") && (pocket.getMonth().equals("9")
                                || pocket.getMonth().equals("09"))){
                            sep_expense = sep_expense - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Expense") && (pocket.getMonth().equals("10")) ){
                            oct_expense = oct_expense - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Expense") && (pocket.getMonth().equals("11"))){
                            nov_expense = nov_expense - pocket.getAmount();
                        }

                        if(pocket.getType().equals("Expense") && (pocket.getMonth().equals("12") )){
                            dec_expense = dec_expense - pocket.getAmount();
                        }


                        //expense part ends




                        mContext.getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putString("jan_income", "" + jan_income).commit();
                        mContext.getSharedPreferences("PREFERENCE2", MODE_PRIVATE).edit().putString("feb_income", "" + feb_income).commit();
                        mContext.getSharedPreferences("PREFERENCE3", MODE_PRIVATE).edit().putString("mar_income", "" + mar_income).commit();
                        mContext.getSharedPreferences("PREFERENCE4", MODE_PRIVATE).edit().putString("apr_income", "" + apr_income).commit();
                        mContext.getSharedPreferences("PREFERENCE5", MODE_PRIVATE).edit().putString("may_income", "" + may_income).commit();
                        mContext.getSharedPreferences("PREFERENCE6", MODE_PRIVATE).edit().putString("june_income", "" + june_income).commit();
                        mContext.getSharedPreferences("PREFERENCE7", MODE_PRIVATE).edit().putString("july_income", "" + july_income).commit();
                        mContext.getSharedPreferences("PREFERENCE8", MODE_PRIVATE).edit().putString("aug_income", "" + aug_income).commit();
                        mContext.getSharedPreferences("PREFERENCE9", MODE_PRIVATE).edit().putString("sep_income", "" + sep_income).commit();
                        mContext.getSharedPreferences("PREFERENCE10", MODE_PRIVATE).edit().putString("oct_income", "" + oct_income).commit();
                        mContext.getSharedPreferences("PREFERENCE11", MODE_PRIVATE).edit().putString("nov_income", "" + nov_income).commit();
                        mContext.getSharedPreferences("PREFERENCE12", MODE_PRIVATE).edit().putString("dec_income", "" + dec_income).commit();


                        mContext.getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putString("jan_expense", "" + jan_expense).commit();
                        mContext.getSharedPreferences("PREFERENCE2", MODE_PRIVATE).edit().putString("feb_expense", "" + feb_expense).commit();
                        mContext.getSharedPreferences("PREFERENCE3", MODE_PRIVATE).edit().putString("mar_expense", "" + mar_expense).commit();
                        mContext.getSharedPreferences("PREFERENCE4", MODE_PRIVATE).edit().putString("apr_expense", "" + apr_expense).commit();
                        mContext.getSharedPreferences("PREFERENCE5", MODE_PRIVATE).edit().putString("may_expense", "" + may_expense).commit();
                        mContext.getSharedPreferences("PREFERENCE6", MODE_PRIVATE).edit().putString("june_expense", "" + june_expense).commit();
                        mContext.getSharedPreferences("PREFERENCE7", MODE_PRIVATE).edit().putString("july_expense", "" + july_expense).commit();
                        mContext.getSharedPreferences("PREFERENCE8", MODE_PRIVATE).edit().putString("aug_expense", "" + aug_expense).commit();
                        mContext.getSharedPreferences("PREFERENCE9", MODE_PRIVATE).edit().putString("sep_expense", "" + sep_expense).commit();
                        mContext.getSharedPreferences("PREFERENCE10", MODE_PRIVATE).edit().putString("oct_expense", "" + oct_expense).commit();
                        mContext.getSharedPreferences("PREFERENCE11", MODE_PRIVATE).edit().putString("nov_expense", "" + nov_expense).commit();
                        mContext.getSharedPreferences("PREFERENCE12", MODE_PRIVATE).edit().putString("dec_expense", "" + dec_expense).commit();




                        try
                        {
                            mPocketList.remove(position);
                            mRecyclerV.removeViewAt(position);
                            notifyItemRemoved(position);
                            notifyItemRangeChanged(position, mPocketList.size());
                            notifyDataSetChanged();
                        }
                        catch (Exception e)
                        {

                        }

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });


    }


    private void goToUpdateActivity(long personId, String date, String type, String month, String category){
        Intent goToUpdate = new Intent(mContext, UpdatePocketActivity.class);
        goToUpdate.putExtra("POCKET_ID", personId);
        goToUpdate.putExtra("POCKET_DATE", date);
        goToUpdate.putExtra("POCKET_TYPE", type);
        goToUpdate.putExtra("POCKET_MONTH", month);
        goToUpdate.putExtra("POCKET_CATEGORY", category);
        mContext.startActivity(goToUpdate);
    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mPocketList.size();
    }


}
