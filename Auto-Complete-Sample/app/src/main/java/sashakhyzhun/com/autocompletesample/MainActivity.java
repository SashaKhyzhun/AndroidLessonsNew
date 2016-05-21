package sashakhyzhun.com.autocompletesample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements TextWatcher {

    private TextView textView;
    private AutoCompleteTextView mAutoComplete;

    private  String[] contacts = {
            "Sasha", "Masha", "Pasha", "Kasha", "Nasha", "Igor", "Vadik", "Padik", "Alice",
            "Mike", "Misha", "Olga", "Svetlana", "Borda", "Grabli", "Angela", "Michael" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.text);

        mAutoComplete = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        mAutoComplete.addTextChangedListener(this);

        mAutoComplete.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, contacts));
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        textView.setText("Your name is " + mAutoComplete.getText());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
