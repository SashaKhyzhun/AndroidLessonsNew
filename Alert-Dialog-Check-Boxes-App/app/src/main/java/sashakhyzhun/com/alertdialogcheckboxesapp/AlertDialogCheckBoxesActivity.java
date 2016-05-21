package sashakhyzhun.com.alertdialogcheckboxesapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogCheckBoxesActivity extends Activity implements View.OnClickListener {

    private final static int IDD_COLOR = 0;
    private final CharSequence[] colors = { "Red", "Green", "Blue" };
    private final boolean[] checkedItems = { true, false, true };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_check_boxes);
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
                builder.setTitle("Pick a Color");
                builder.setMultiChoiceItems(colors, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedItems[which] = isChecked;
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        StringBuilder state = new StringBuilder();
                        for (int i = 0; i < colors.length; i++) {
                            state.append("color: " + colors[i] + ", state: ");
                            if (checkedItems[i]) {
                                state.append("checked\n");
                            } else {
                                state.append("unchecked\n");
                            }
                        }
                        Toast.makeText(getApplicationContext(), state.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                    Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setCancelable(false);
                return builder.create();

            default:
                return null;
        }
    }

}
