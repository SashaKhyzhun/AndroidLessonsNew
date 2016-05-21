package sashakhyzhun.com.readwritefilesample;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;

public class EditorActivity extends ActionBarActivity {

    private static final int IDM_OPEN = 101;
    private static final int IDM_SAVE = 102;
    private static final int IDM_EXIT = 103;

    private final static String FILENAME = "file.txt";
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        edit = (EditText)findViewById(R.id.edit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, IDM_OPEN, Menu.NONE, "Open").setIcon(R.mipmap.ic_launcher).setAlphabeticShortcut('o');
        menu.add(Menu.NONE, IDM_SAVE, Menu.NONE, "Save").setIcon(R.mipmap.ic_launcher).setAlphabeticShortcut('s');
        menu.add(Menu.NONE, IDM_EXIT, Menu.NONE, "Exit").setIcon(R.mipmap.ic_launcher).setAlphabeticShortcut('x');
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case IDM_OPEN:
                openFile(FILENAME);
                break;
            case IDM_SAVE:
                saveFile(FILENAME);
                break;
            case IDM_EXIT:
                finish();
                break;
            default:
                return false;
        }
        return true;
    }

    private void openFile(String fileName) {
        try {
            InputStream inputStream = openFileInput(FILENAME);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String string;
                StringBuffer buffer = new StringBuffer();

                while ((string = bufferedReader.readLine()) != null) {
                    buffer.append(string + "\n");
                }

                inputStream.close();
                edit.setText(buffer.toString());
            }
        } catch (Throwable t) {
            Toast.makeText(getApplicationContext(), "Exception" + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    private void saveFile(String fileName) {
        try {
            OutputStreamWriter outStream = new OutputStreamWriter(openFileOutput(FILENAME, 0));
            outStream.write(edit.getText().toString());
            outStream.close();
        } catch (Throwable t) {
            Toast.makeText(getApplicationContext(), "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }


}
