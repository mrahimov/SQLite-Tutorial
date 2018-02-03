package com.example.murodjonrahimov.savefellowsinfo.data_base;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by murodjon.rahimov on 2/2/18.
 */

public class DataBase extends SQLiteOpenHelper{
  public DataBase(Context context) {
    super(context, "Data Base", null, 1);
  }

  public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version,
                  DatabaseErrorHandler errorHandler) {
    super(context, name, factory, version, errorHandler);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table Contact(id integer primary key autoincrement, name text, phone integer);");

  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }
}
