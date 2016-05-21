package sashakhyzhun.com.activityresultexam.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import sashakhyzhun.com.activityresultexam.R;
import sashakhyzhun.com.util.Language;

public class LanguageActivity extends Activity {

//    private Button buttonUA, buttonENG, buttonRUS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_layout);

//        buttonUA = (Button)findViewById(R.id.buttonUA);
//        buttonENG = (Button)findViewById(R.id.buttonENG);
//        buttonRUS = (Button)findViewById(R.id.buttonRUS);
    }

    public void onSelectedLanguage(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.buttonENG:
                intent= new Intent();
                intent.putExtra("language", Language.ENGLISH.getLanguage());
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.buttonUA:
                intent= new Intent();
                intent.putExtra("language", Language.UKRAINE.getLanguage());
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.buttonRUS:
                intent= new Intent();
                intent.putExtra("language", Language.RUSSIAN.getLanguage());
                setResult(RESULT_OK, intent);
                finish();
                break;
        }

    }
}

