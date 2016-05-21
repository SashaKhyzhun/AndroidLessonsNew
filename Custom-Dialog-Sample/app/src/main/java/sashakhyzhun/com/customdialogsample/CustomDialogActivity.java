package sashakhyzhun.com.customdialogsample;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CustomDialogActivity extends Activity implements View.OnClickListener {

    private final int IDD_EXIT = 0; //index of dialog window

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
    }

    @Override
    public void onClick(View v) {
        showDialog(IDD_EXIT);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case IDD_EXIT:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("HEY, YOU");
                builder.setMessage("WHERE IS MY MONEY?!");

                builder.setPositiveButton("GIVE THE MONEY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(CustomDialogActivity.this, "TNX, BB", Toast.LENGTH_SHORT).show();
                        CustomDialogActivity.this.finish();
                    }
                });

                builder.setNegativeButton("GIVE THE SHIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
