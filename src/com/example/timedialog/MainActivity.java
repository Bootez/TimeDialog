package com.example.timedialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {
    private TextView selectedTextView;
    private Button dateButton;
    private Button timeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Calendar c = Calendar.getInstance();
        selectedTextView = (TextView)findViewById(R.id.tv_selected);
        selectedTextView.setText("Date: " + c.get(Calendar.MONTH) + "/"
                + c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.YEAR));
        
        dateButton = (Button)findViewById(R.id.btn_date);
        dateButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                
                new DatePickerDialog(MainActivity.this, 
                        new OnDateSetListener() {
                            
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                    int dayOfMonth) {
                                selectedTextView.setText("Date: "
                                        + monthOfYear + "/"
                                        + dayOfMonth + "/"
                                        + year);
                            }
                        }, 
                        c.get(Calendar.YEAR), 
                        c.get(Calendar.MONTH), 
                        c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        
        timeButton = (Button)findViewById(R.id.btn_time);
        timeButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                
                new TimePickerDialog(MainActivity.this, new OnTimeSetListener() {
                    
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectedTextView.setText("Time: " + hourOfDay + " : " + minute);
                    }
                        }, 
                        c.get(Calendar.HOUR_OF_DAY), 
                        c.get(Calendar.MINUTE),
                        true).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
