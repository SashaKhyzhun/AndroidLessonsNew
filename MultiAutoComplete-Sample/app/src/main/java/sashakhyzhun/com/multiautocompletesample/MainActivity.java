package sashakhyzhun.com.multiautocompletesample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends Activity  {

    private final String[] contacts = {
            "Sasha Khyzhun", "Masha Tylnyaj", "Pasha Velichko", "Kasha Manna", "Nasha Natawa",
            "Igor Yanovchik", "Vadik Padik", "Padik Vadik", "Alice Alice",
            "Mike 6.0", "Misha Dzebak", "Olga Petriwko", "Svetlana Banana", "Boroda Gysta",
            "Grabli OneLove", "Angela Geanla", "Michael Jackson" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, contacts);

        MultiAutoCompleteTextView textView = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView01);
        textView.setAdapter(adapter);
        textView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }


}
