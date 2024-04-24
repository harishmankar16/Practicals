package com.example.dbcustomer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbManager extends SQLiteOpenHelper {
    private static  final  String DbName = "Student";
    private  static  final String TABLE_NAME ="tbl_student";
    private static final  String Id = "id";
    private static final String NAME = "name";
    private static  final  String ADDRESS ="address";
    private static  final  String PHO_N0="pho_no";

    private  static  final String CREATE_TABLE_QUERY=
            "CREATE TABLE " + TABLE_NAME + " ("+
                    Id + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    NAME + " TEXT NOT NULL ," +
                    ADDRESS + " TEXT NOT NULL ,"+
                    PHO_N0 + " TEXT NOT NULL);";

    public DbManager(Context context){
        super(context,DbName,null,1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long insert(String name,String address,String pho_no){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,name);
        values.put(ADDRESS,address);
        values.put(PHO_N0,pho_no);
        long id=db.insert(TABLE_NAME,null,values);
        return  id;
    }

    public Cursor getAllStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }
}
