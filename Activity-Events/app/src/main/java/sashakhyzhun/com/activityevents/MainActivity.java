package sashakhyzhun.com.activityevents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.text);
        text.append("OnCreate()\n");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        text.append("OnRestart()\n");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        text.append("OnStart()\n");
        super.onStart();
    }

    @Override
    protected void onPause() {
        text.append("OnPause()\n");
        super.onPause();
    }

    @Override
    protected void onStop() {
        text.append("OnStop()\n");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        text.append("OnDestroy()\n");
        super.onDestroy();
    }
}
