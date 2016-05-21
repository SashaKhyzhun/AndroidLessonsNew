package sashakhyzhun.com.alertdialogbuttonapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AlertDialogButtonActivity extends Activity implements View.OnClickListener {

    private final int IDO_EXIT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_button);
    }

    @Override
    public void onClick(View v) {
        showDialog(IDO_EXIT); // вызываем диалог
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case IDO_EXIT:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("HEY BROOOOOS?!");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("Are you sure?");

                // create button "YAAAAAAAAS"
                builder.setPositiveButton("YAAAS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int
                                        id) {
                        AlertDialogButtonActivity.this.finish();
                    }
                });

                // create button "NOOOY"
                builder.setNegativeButton("NOOOY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                builder.setCancelable(false);
                return builder.create();
            default:
                return null;
        }
    }
}
