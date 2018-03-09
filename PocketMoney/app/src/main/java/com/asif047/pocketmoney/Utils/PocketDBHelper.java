package com.asif047.pocketmoney.Utils;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.asif047.pocketmoney.Model.Pocket;

import java.util.LinkedList;
import java.util.List;

public class PocketDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "pocket.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "pocket";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_MONTH = "month";
    public static final String COLUMN_CATEGORY = "category";

    public PocketDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL( "CREATE TABLE "+ TABLE_NAME + "("+ COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, "+ COLUMN_TYPE +
                " TEXT NOT NULL, "+ COLUMN_DATE +
                " TEXT NOT NULL, "+ COLUMN_DESCRIPTION +
                " TEXT, "+ COLUMN_AMOUNT +
                " DOUBLE NOT NULL, " + COLUMN_MONTH +
                " TEXT, "+ COLUMN_CATEGORY +
                " TEXT);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        this.onCreate(db);

    }


    /** create record **/

    public void saveNewPocket(Pocket pocket)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TYPE, pocket.getType());
        values.put(COLUMN_DATE, pocket.getDate());
        values.put(COLUMN_DESCRIPTION, pocket.getDescription());
        values.put(COLUMN_AMOUNT, pocket.getAmount());
        values.put(COLUMN_MONTH, pocket.getMonth());
        values.put(COLUMN_CATEGORY, pocket.getCategory());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    /** Query records, give options to get results **/

    public List<Pocket> pocketList()
    {
        String query;
        query = "SELECT * FROM "+ TABLE_NAME ;

        List<Pocket> pocketLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Pocket pocket;

        if(cursor.moveToFirst())
        {
            do {
                pocket = new Pocket();
                pocket.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                pocket.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                pocket.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                pocket.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                pocket.setAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)));
                pocket.setMonth(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)));
                pocket.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));

                pocketLinkedList.add(pocket);
            }while(cursor.moveToNext());
        }

        return pocketLinkedList;
    }




    /**Query only 1 record**/
    public Pocket getPocket(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * FROM " + TABLE_NAME + " WHERE id="+ id;
        Cursor cursor = db.rawQuery(query, null);

        Pocket receivedPocket = new Pocket();
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();

            receivedPocket.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
            receivedPocket.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
            receivedPocket.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
            receivedPocket.setAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)));
            receivedPocket.setMonth(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)));
            receivedPocket.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));
        }



        return receivedPocket;


    }


    /**delete record**/
    public void deletePocketRecord(long id, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE id='"+id+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();

    }

    /**update record**/
    public void updatePocketRecord(long pocketId, Context context, Pocket updatedpocket) {
        SQLiteDatabase db = this.getWritableDatabase();
        //you can use the constants above instead of typing the column names
        db.execSQL("UPDATE  "+TABLE_NAME+" SET type ='"+ updatedpocket.getType() +
                "', date ='" + updatedpocket.getDate()+
                "', description ='"+ updatedpocket.getDescription() +
                "', amount ='"+ updatedpocket.getAmount() +
                "', month ='"+ updatedpocket.getMonth() +
                "', category ='"+ updatedpocket.getCategory() +
                "'  WHERE id='" + pocketId + "'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();


    }



    public List<Pocket> pocketListJan()
    {
        String query;
        query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_MONTH + " = '01' OR "+ COLUMN_MONTH + " = '1'";

        List<Pocket> pocketLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Pocket pocket;

        if(cursor.moveToFirst())
        {
            do {
                pocket = new Pocket();

                pocket.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                pocket.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                pocket.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                pocket.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                pocket.setAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)));
                pocket.setMonth(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)));
                pocket.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));

                pocketLinkedList.add(pocket);
            }while(cursor.moveToNext());
        }

        return pocketLinkedList;
    }


    public List<Pocket> pocketListFeb()
    {
        String query;
        query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_MONTH + " = '02' OR "+ COLUMN_MONTH + " = '2'";

        List<Pocket> pocketLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Pocket pocket;

        if(cursor.moveToFirst())
        {
            do {
                pocket = new Pocket();
                pocket.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                pocket.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                pocket.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                pocket.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                pocket.setAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)));
                pocket.setMonth(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)));
                pocket.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));

                pocketLinkedList.add(pocket);
            }while(cursor.moveToNext());
        }

        return pocketLinkedList;
    }


    public List<Pocket> pocketListMar()
    {
        String query;
        query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_MONTH + " = '03' OR "+ COLUMN_MONTH + " = '3'";

        List<Pocket> pocketLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Pocket pocket;

        if(cursor.moveToFirst())
        {
            do {
                pocket = new Pocket();
                pocket.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                pocket.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                pocket.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                pocket.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                pocket.setAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)));
                pocket.setMonth(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)));
                pocket.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));

                pocketLinkedList.add(pocket);
            }while(cursor.moveToNext());
        }

        return pocketLinkedList;
    }

    public List<Pocket> pocketListApr() {
        String query;
        query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_MONTH + " = '04' OR "+ COLUMN_MONTH + " = '4'";

        List<Pocket> pocketLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Pocket pocket;

        if(cursor.moveToFirst())
        {
            do {
                pocket = new Pocket();
                pocket.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                pocket.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                pocket.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                pocket.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                pocket.setAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)));
                pocket.setMonth(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)));
                pocket.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));

                pocketLinkedList.add(pocket);
            }while(cursor.moveToNext());
        }

        return pocketLinkedList;
    }


    public List<Pocket> pocketListMay() {
        String query;
        query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_MONTH + " = '05' OR "+ COLUMN_MONTH + " = '5'";

        List<Pocket> pocketLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Pocket pocket;

        if(cursor.moveToFirst())
        {
            do {
                pocket = new Pocket();
                pocket.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                pocket.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                pocket.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                pocket.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                pocket.setAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)));
                pocket.setMonth(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)));
                pocket.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));

                pocketLinkedList.add(pocket);
            }while(cursor.moveToNext());
        }

        return pocketLinkedList;
    }


    public List<Pocket> pocketListJune() {
        String query;
        query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_MONTH + " = '06' OR "+ COLUMN_MONTH + " = '6'";

        List<Pocket> pocketLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Pocket pocket;

        if(cursor.moveToFirst())
        {
            do {
                pocket = new Pocket();
                pocket.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                pocket.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                pocket.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                pocket.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                pocket.setAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)));
                pocket.setMonth(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)));
                pocket.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));

                pocketLinkedList.add(pocket);
            }while(cursor.moveToNext());
        }

        return pocketLinkedList;
    }


    public List<Pocket> pocketListJuly() {
        String query;
        query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_MONTH + " = '07' OR "+ COLUMN_MONTH + " = '7'";

        List<Pocket> pocketLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Pocket pocket;

        if(cursor.moveToFirst())
        {
            do {
                pocket = new Pocket();
                pocket.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                pocket.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                pocket.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                pocket.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                pocket.setAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)));
                pocket.setMonth(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)));
                pocket.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));

                pocketLinkedList.add(pocket);
            }while(cursor.moveToNext());
        }

        return pocketLinkedList;
    }



    public List<Pocket> pocketListAug() {
        String query;
        query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_MONTH + " = '08' OR "+ COLUMN_MONTH + " = '8'";

        List<Pocket> pocketLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Pocket pocket;

        if(cursor.moveToFirst())
        {
            do {
                pocket = new Pocket();
                pocket.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                pocket.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                pocket.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                pocket.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                pocket.setAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)));
                pocket.setMonth(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)));
                pocket.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));

                pocketLinkedList.add(pocket);
            }while(cursor.moveToNext());
        }

        return pocketLinkedList;
    }


    public List<Pocket> pocketListSep() {
        String query;
        query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_MONTH + " = '09' OR "+ COLUMN_MONTH + " = '9'";

        List<Pocket> pocketLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Pocket pocket;

        if(cursor.moveToFirst())
        {
            do {
                pocket = new Pocket();
                pocket.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                pocket.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                pocket.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                pocket.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                pocket.setAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)));
                pocket.setMonth(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)));
                pocket.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));

                pocketLinkedList.add(pocket);
            }while(cursor.moveToNext());
        }

        return pocketLinkedList;
    }

    public List<Pocket> pocketListOct() {
        String query;
        query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_MONTH + " = '10' ";

        List<Pocket> pocketLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Pocket pocket;

        if(cursor.moveToFirst())
        {
            do {
                pocket = new Pocket();
                pocket.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                pocket.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                pocket.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                pocket.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                pocket.setAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)));
                pocket.setMonth(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)));
                pocket.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));

                pocketLinkedList.add(pocket);
            }while(cursor.moveToNext());
        }

        return pocketLinkedList;
    }


    public List<Pocket> pocketListNov() {
        String query;
        query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_MONTH + " = '11' ";

        List<Pocket> pocketLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Pocket pocket;

        if(cursor.moveToFirst())
        {
            do {
                pocket = new Pocket();
                pocket.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                pocket.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                pocket.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                pocket.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                pocket.setAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)));
                pocket.setMonth(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)));
                pocket.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));

                pocketLinkedList.add(pocket);
            }while(cursor.moveToNext());
        }

        return pocketLinkedList;
    }

    public List<Pocket> pocketListDec() {
        String query;
        query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_MONTH + " = '12' ";

        List<Pocket> pocketLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Pocket pocket;

        if(cursor.moveToFirst())
        {
            do {
                pocket = new Pocket();
                pocket.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                pocket.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                pocket.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                pocket.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                pocket.setAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)));
                pocket.setMonth(cursor.getString(cursor.getColumnIndex(COLUMN_MONTH)));
                pocket.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));

                pocketLinkedList.add(pocket);
            }while(cursor.moveToNext());
        }

        return pocketLinkedList;
    }


}
