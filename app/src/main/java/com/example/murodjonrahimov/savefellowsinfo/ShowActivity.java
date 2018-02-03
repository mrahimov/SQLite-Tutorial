package com.example.murodjonrahimov.savefellowsinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

  public static final String KEY_NAME = "text";
  public static final String KEY_NUMBER = "phone";
  TextView textViewName;
  TextView textViewPhone;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_show);

    textViewName = findViewById(R.id.text_name_showactivity);
    textViewPhone = findViewById(R.id.text_phone_showactivity);

    Intent intent = getIntent();
    String name = intent.getStringExtra(KEY_NAME);
    String number = intent.getStringExtra(KEY_NUMBER);

    textViewName.setText(name);
    textViewPhone.setText(number);

  }
}
