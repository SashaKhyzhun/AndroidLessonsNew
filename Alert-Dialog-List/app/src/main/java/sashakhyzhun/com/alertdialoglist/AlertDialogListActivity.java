package sashakhyzhun.com.alertdialoglist;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AlertDialogListActivity extends Activity implements View.OnClickListener {

    private final int IDD_COLOR = 0; //identifier of dialog window
    private final CharSequence[] colors = { "red", "green", "blue" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_list);
    }

    @Override
    public void onClick(View v) {
        showDialog(IDD_COLOR);
    }

    @Override
    protected Dialog onCreateDialog(final int id) {
        switch (id) {
            case IDD_COLOR:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Pick a color");

                builder.setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        Toast.makeText(getApplicationContext(), "Color: " + colors[item], Toast.LENGTH_LONG).show();
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
