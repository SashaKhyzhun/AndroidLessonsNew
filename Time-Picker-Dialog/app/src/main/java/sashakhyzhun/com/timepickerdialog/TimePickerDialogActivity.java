package sashakhyzhun.com.timepickerdialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerDialogActivity extends Activity implements View.OnClickListener {

    public static final int IDD_TIME = 0;

    private TextView text;

    private int hours;
    private int min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_dialog);

        text = (TextView)findViewById(R.id.text);

        final Calendar calendar = Calendar.getInstance();
        hours = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);
        updateDisplay();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case IDD_TIME:
                return new TimePickerDialog(this, mTimeSetListener, hours, min, true);
        }
        return null;
    }

    @Override
    public void onClick(View v) {
        showDialog(IDD_TIME);
    }

    private void updateDisplay() {
        text.setText(new StringBuilder().append(pad(hours)).append(":").append(pad(min)));
    }

    private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet (TimePicker view, int hourOfDay, int minute) {
            hours = hourOfDay;
            min = minute;
            updateDisplay();
        }
    };

    private static String pad (int c) {
        if (c >= 10) {
            return String.valueOf(c);
        } else {
            return "0" + String.valueOf(c);
        }
    }

}
