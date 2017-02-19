package com.tuyenmonkey.monkeyapp.temp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tuyenmonkey.monkeyapp.R;

public class MainActivity extends AppCompatActivity {
  @BindView(R.id.btOpenDialog) Button btOpenDialog;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    btOpenDialog.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance();
        datePickerDialog.setOnDatePickListener(new DatePickerDialog.OnDatePickedListener() {
          @Override public void onDatePicked(int date, int month, int year) {
            Log.e("tete", String.format("%02d-%02d-%d", date, month, year));
          }
        });
        datePickerDialog.show(getSupportFragmentManager(), "datePickerDialog");
      }
    });
  }
}
