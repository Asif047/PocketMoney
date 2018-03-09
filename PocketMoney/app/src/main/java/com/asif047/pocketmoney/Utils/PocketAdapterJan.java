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

public class PocketAdapterJan extends RecyclerView.Adapter<PocketAdapterJan.ViewHolder> {

    private List<Pocket> mPocketList;
    private Context mContext;
    private RecyclerView mRecyclerV;


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
    public PocketAdapterJan(List<Pocket> myDataset, Context context, RecyclerView recyclerView) {
        mPocketList = myDataset;
        mContext = context;
        mRecyclerV = recyclerView;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PocketAdapterJan.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_item_january, parent, false);
        // set the view's size, margins, paddings and layout parameters
        PocketAdapterJan.ViewHolder vh = new PocketAdapterJan.ViewHolder(v);
        return vh;
    }



    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(PocketAdapterJan.ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final Pocket pocket = mPocketList.get(position);
        holder.tvId.setText("Id: " + pocket.getId());
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
