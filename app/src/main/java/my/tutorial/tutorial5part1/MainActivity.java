package my.tutorial.tutorial5part1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private NumberPicker picker1;
    String datetime3;
    EditText name_text;
    TextView display_message;
    String valuePicker1;
    private CalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valuePicker1 = "0";
        calendar = findViewById(R.id.calendarView);
        display_message=findViewById(R.id.displaymessage);
        name_text = findViewById(R.id.name);
        datetime3 = "";

        picker1 = findViewById(R.id.numberpicker_main_picker);
        picker1.setMaxValue(100);
        picker1.setMinValue(0);

        picker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                valuePicker1 = String.valueOf(picker1.getValue());
            }
        });

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {

                datetime3 = String.valueOf(dayOfMonth) + "/" + String.valueOf(month + 1) + "/" + String.valueOf(year);
            }
        });
    }



    public void displayMessage(View view)
    {
        String name = name_text.getText().toString();
        display_message.setText("Hello " + name + " your DoB is: " + datetime3 + " and your age is " + valuePicker1);
    }
}