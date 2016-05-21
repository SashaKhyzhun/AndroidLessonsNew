package sashakhyzhun.com.activityresultexam.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import sashakhyzhun.com.activityresultexam.R;
import sashakhyzhun.com.util.RequestCode;

public class MainActivity extends Activity {

    private TextView tvName, tvLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        tvName = (TextView)findViewById(R.id.tvName);
        tvLanguage = (TextView)findViewById(R.id.tvLanguage);
    }

    public void onShow(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnPresented:
                intent = new Intent(this, PresentedActivity.class);
                startActivityForResult(intent, RequestCode.REQUEST_CODE_PRESENTED);
                break;
            case R.id.btnLanguage:
                intent = new Intent(this, LanguageActivity.class);
                startActivityForResult(intent, RequestCode.REQUEST_CODE_LANGUAGE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case RequestCode.REQUEST_CODE_PRESENTED:
                    String name = data.getStringExtra("name");
                    tvName.setText("Рад знакомству, " + name);
                    break;
                case RequestCode.REQUEST_CODE_LANGUAGE:
                    String language = data.getStringExtra("language");
                    tvLanguage.setText("Ваш язык: " + language);
                    break;
            }
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}
