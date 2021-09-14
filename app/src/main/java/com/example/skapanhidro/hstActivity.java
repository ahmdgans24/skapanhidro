package com.example.skapanhidro;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class hstActivity extends AppCompatActivity {

    EditText TxTanggal;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateFormatter;
    private String pattern;
    private Context context;

    @SuppressLint({"MissingSuperCall", "SimpleDateFormat"})
    @Override
    protected void onCreate(Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);
        setContentView(R.layout.activity_hst);

        TxTanggal = (EditText)findViewById(R.id.txtTanggal);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

        TxTanggal.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            
            @Override
            public void onClick(View v) {
                showDateDialog();

            }
        });
    }

    private void showDateDialog() {
        Calendar calendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog ( this, new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfmonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, dayOfmonth);
                TxTanggal.setText(dateFormatter.format(newDate.getTime()));
            }
        },  calendar.get((calendar.YEAR)), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}

