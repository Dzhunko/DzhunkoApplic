package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.Calendar;

import static com.example.myapplication.R.id.dateText;
import static com.example.myapplication.R.id.send;

public class AddingActivity extends AppCompatActivity {

    public Spinner spinnerCurrency, spinnerCategory;
    public ImageButton dateBtn, timeBtn, sendBtn;
    public TextView currentDate, currentTime, testText;
    public EditText priceField;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
        spinnerCategory = findViewById(R.id.category_plus);
        spinnerCurrency = findViewById(R.id.currSpin);
        final ImageButton saveBtn = (ImageButton)findViewById(send);
        priceField = (EditText) findViewById(R.id.editText);
        currentDate = (TextView) findViewById(R.id.dateText);
        currentTime = (TextView) findViewById(R.id.timeText);
        testText = (TextView) findViewById(R.id.test);
        dateBtn = (ImageButton) findViewById(R.id.date_button);
        timeBtn = (ImageButton) findViewById(R.id.time_button);
        sendBtn = (ImageButton) findViewById(send);
        populateSpinnerCategory();
        populateSpinnerCurrency();


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = spinnerCategory.getSelectedItem().toString();
                String currency = spinnerCurrency.getSelectedItem().toString();
                String date = currentDate.getText().toString();
                String time = currentTime.getText().toString();
                int price = Integer.valueOf(priceField.getText().toString());

                ItemClass itemClass = new ItemClass(category, date, time, price, currency);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra(ItemClass.class.getSimpleName(), itemClass);
                startActivity(intent);

            }
        });
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDateButton();
            }
        });

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleTimeButton();
            }
        });
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

    private void handleDateButton() {
        Calendar calendar = Calendar.getInstance();

        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DAY = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dateString = dayOfMonth + "." + month + "." + year;
                currentDate.setText(dateString);
            }
        }, YEAR, MONTH, DAY);

        datePickerDialog.show();

    }

    private void populateSpinnerCurrency() {
        ArrayAdapter<String> currencyAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.curr_spin));
        currencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurrency.setAdapter(currencyAdapter);
    }

    private void populateSpinnerCategory() {
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.categoryPlus));
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoryAdapter);
    }



}
