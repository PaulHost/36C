package com.example.paul.keepandsavemoney.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.paul.keepandsavemoney.constants.SQLiteConstants.CURRENCY_TABLE_NAME;

/**
 * Created by paul on 16.12.16.
 */

public class BDHelper extends SQLiteOpenHelper {

    public BDHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s", CURRENCY_TABLE_NAME));
                onCreate(sqLiteDatabase);
    }
}
