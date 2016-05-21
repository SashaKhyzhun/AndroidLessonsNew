package sashakhyzhun.com.datapickerdialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DataPickerDialogActivity extends Activity implements View.OnClickListener {

    static final int IDD_DATE = 0;
    private TextView text;
    private int years;
    private int months;
    private int days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_picker_dialog);

        text = (TextView)findViewById(R.id.text);
        //date for calender
        final Calendar c = Calendar.getInstance();
        years = c.get(Calendar.YEAR);
        months = c.get(Calendar.MONTH);
        days = c.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public void onClick(View v) {
        showDialog(IDD_DATE);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case IDD_DATE:
                return new DatePickerDialog(this, mDateSetListener, years, months, days);
        }
        return null;
    }

    private void updateDisplay() {
        text.setText(new StringBuilder().append(days).append(" ").append(months + 1).append(" ").append(years));
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    years = year;
                    months = monthOfYear;
                    days = dayOfMonth;
                    updateDisplay();
                }
    };

}
