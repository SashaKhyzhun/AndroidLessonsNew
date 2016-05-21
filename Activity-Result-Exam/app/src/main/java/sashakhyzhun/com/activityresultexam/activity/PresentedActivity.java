package sashakhyzhun.com.activityresultexam.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sashakhyzhun.com.activityresultexam.R;

public class PresentedActivity extends Activity {

    private EditText editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presented_layout);

        editName = (EditText)findViewById(R.id.editName);
    }

    public void onPresented(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", editName.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

}
