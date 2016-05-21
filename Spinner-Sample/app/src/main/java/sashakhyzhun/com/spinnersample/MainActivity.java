package sashakhyzhun.com.spinnersample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private TextView mLabel;

    private final String[] contacts = {
            "Sasha", "Masha", "Pasha", "Kasha", "Nasha", "Igor", "Vadik", "Padik", "Alice", "Mike", "Misha" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLabel = (TextView)findViewById(R.id.TextView01);

        final Spinner spinner = (Spinner)findViewById(R.id.Spinner01);
        spinner.setOnItemSelectedListener(this);

        //создаем наш адаптер
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, contacts);
        //задаем компоновку для списка
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mLabel.setText(contacts[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        mLabel.setText("");
    }
}
