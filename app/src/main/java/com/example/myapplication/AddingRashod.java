package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AddingRashod extends AppCompatActivity {
    Spinner currencySpinner, categorySpinner;
    public ImageButton timeBtn, dateBtn;
    public TextView currentDate, currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_rashod);
        final ImageButton sendBtn = (ImageButton) findViewById(R.id.send);
        EditText priceField = (EditText) findViewById(R.id.editRashod);
        currencySpinner = findViewById(R.id.currSpinR);
        categorySpinner = findViewById(R.id.category_minus);
        timeBtn = findViewById(R.id.time_button);
        dateBtn = findViewById(R.id.date_button);
        currentDate = findViewById(R.id.dateText);
        currentTime = findViewById(R.id.timeText);
        populateCurrencySpinner();
        populateCategorySpinner();

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleTimeButton();
            }
        });

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDateButton();
            }
        });

    }

    private void handleDateButton() {
        Calendar calendar = Calendar.getInstance();

        int DATE = calendar.get(Calendar.DATE);
        int MONTH = calendar.get(Calendar.MONTH);
        int YEAR = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dateString = dayOfMonth + "." + month + "." + year;
                currentDate.setText(dateString);
            }
        }, DATE, MONTH, YEAR);
        datePickerDialog.show();
    }

    private void handleTimeButton() {
        Calendar calendar = Calendar.getInstance();

        int HOUR = calendar.get(Calendar.HOUR);
        int MINUTE = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String timeString = hourOfDay + ":" + minute;
                currentTime.setText(timeString);
            }
        }, HOUR, MINUTE, true);

        timePickerDialog.show();
    }

    private void populateCurrencySpinner() {
        ArrayAdapter<String> currencyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.curr_spin));
        currencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(currencyAdapter);
    }

    private void populateCategorySpinner() {
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.categoryMinus));
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);
    }
}
