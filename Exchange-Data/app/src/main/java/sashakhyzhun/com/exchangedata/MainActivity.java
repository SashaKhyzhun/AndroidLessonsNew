package sashakhyzhun.com.exchangedata;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView textName;
    private TextView textPhone;

    public final static String NAME = "Name";
    public final static String PHONE = "Phone";

    private final static int ACTION_EDIT = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = (TextView)findViewById(R.id.textName);
        textPhone = (TextView)findViewById(R.id.textPhone);

        textName.setText("Andrew Ivanov");
        textPhone.setText("1234567890");
    }

    public void onClick(View v) {
        //create intent
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), SecondActivity.class);

        //add extra params
        intent.putExtra(NAME, textName.getText());
        intent.putExtra(PHONE, textPhone.getText());

        //call activity
        startActivityForResult(intent, ACTION_EDIT);
    }

    protected void onActivityResault (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            textName.setText(extras.getString(NAME));
            textPhone.setText(extras.getInt(PHONE));
        }
    }

}
