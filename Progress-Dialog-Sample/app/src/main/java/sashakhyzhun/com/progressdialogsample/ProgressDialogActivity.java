package sashakhyzhun.com.progressdialogsample;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ProgressDialogActivity extends Activity implements View.OnClickListener {

    public static final int IDD_PROGRESS = 0;
    private ProgressDialog dialog;
    private ProgressThread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);
    }

    @Override
    public void onClick(View v) {
        showDialog(IDD_PROGRESS);
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case IDD_PROGRESS:
                dialog = new ProgressDialog(ProgressDialogActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setMessage("Угоняем твои данные...");
                thread = new ProgressThread(handler);
                thread.start();
                dialog.setCancelable(false);
                return dialog;
            default: return null;
        }
    }

    final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            int total = msg.getData().getInt("total");
            dialog.setProgress(total);

            if (total >= 100) {
                dismissDialog(IDD_PROGRESS);
                thread.setState(ProgressThread.STATE_DONE);
                Toast.makeText(getApplicationContext(), "Спасибо, твои пароли у нас", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
