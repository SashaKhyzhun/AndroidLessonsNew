package sashakhyzhun.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    int a, b, c;
    EditText editText500;
    TextView resultFor500, textView500;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultFor500 = (TextView) findViewById(R.id.resultFor500);
        textView500 = (TextView) findViewById(R.id.tvFor500);

        editText500 = (EditText) findViewById(R.id.editText500);

        final Button button1 = (Button) findViewById(R.id.buttonOK);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    a = Integer.parseInt(editText500.getText().toString());
                    b = Integer.parseInt(String.valueOf(500));

                } catch (NumberFormatException e) {
                    a = 0;
                    b = 0;
                }

                c = a * b;
                resultFor500.setText(c + " грн");
            }


        });

    }
}