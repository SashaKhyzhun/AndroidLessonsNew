package sashakhyzhun.com.alertdialogradiobuttons;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AlertDialogRadioButtonsActivity extends Activity implements View.OnClickListener {

    private final static int IDD_COLOR = 0;
    private final CharSequence[] colors = { "Red", "Green", "Blue" };
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        showDialog(IDD_COLOR);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case IDD_COLOR:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Pick a color");
                builder.setSingleChoiceItems(colors, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        result = item;
                    }
                });
                builder.setPositiveButton("OKI-DOKI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(), "Color: " + colors[result], Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(), "Dialog cancel", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setCancelable(false);
                return builder.create();
            default:
                return null;
        }

    }

}
