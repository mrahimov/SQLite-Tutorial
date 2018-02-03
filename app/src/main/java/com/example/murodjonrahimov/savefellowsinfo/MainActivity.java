package com.example.murodjonrahimov.savefellowsinfo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.murodjonrahimov.savefellowsinfo.data_base.DataBase;

public class MainActivity extends AppCompatActivity {

  EditText editName;
  EditText editPhoneNumber;
  Button buttonSave;
  Button buttonShow;
  Button buttonDelete;
  DataBase dataBase;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    dataBase = new DataBase(this);

    editName = findViewById(R.id.edit_name);
    editPhoneNumber = findViewById(R.id.edit_phone_number);
    buttonDelete = findViewById(R.id.button_delete);
    buttonShow = findViewById(R.id.button_show);
    buttonSave = findViewById(R.id.button_save);

    final SQLiteDatabase sqLiteDatabase = dataBase.getWritableDatabase();

    buttonSave.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", editName.getText()
          .toString());
        contentValues.put("phone", editPhoneNumber.getText()
          .toString());

        sqLiteDatabase.insert("Contact", null, contentValues);
        editName.setText("");
        editPhoneNumber.setText("");
      }
    });

    buttonShow.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Cursor cursor = sqLiteDatabase.query("Contact", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
          String name = "";
          int num = 0;
          do {

            Log.d("log", "id"
              + cursor.getInt(cursor.getColumnIndex("id")) + "name "
              + cursor.getString(cursor.getColumnIndex("name")) + "phone "
              + cursor.getInt(cursor.getColumnIndex("phone")));

            //Intent intent = new Intent(MainActivity.this, ShowActivity.class);
            //intent.putExtra(ShowActivity.KEY_EXTRA, name);
            //intent.putExtra(ShowActivity.KEY_EXTRA, name);
            //startActivity(intent);

          } while (cursor.moveToNext());
        } else {
          Log.d("TAG", "ERROR");
        }
      }
    });

    buttonDelete.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        sqLiteDatabase.delete("Contact", null, null);
      }
    });
  }
}
