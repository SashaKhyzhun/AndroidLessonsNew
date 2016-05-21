package sashakhyzhun.com.progressbarsample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class ProgressBarActivity extends Activity implements View.OnClickListener {

    private ProgressBar progress;
    private TextView text;
    private boolean isRunning = false;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            progress.incrementProgressBy(1);
            text.setText("Progress: " + progress.getProgress() + "%");
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        progress = (ProgressBar)findViewById(R.id.progressBar);
        text = (TextView)findViewById(R.id.text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_start:
                onStart();
                break;
            case R.id.button_stop:
                onStop();
                break;
        }
    }


    public void onStart() {
        super.onStart();
        progress.setProgress(0);
        // Create new thread
        Thread background = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Log.e("ERROR", "Thread Interrupted");
                    }
                    handler.sendMessage(handler.obtainMessage());
                }
            }
        });
        isRunning = true;
        background.start();
    }

    public void onStop() {
        super.onStop();
        isRunning = false;
    }

}
