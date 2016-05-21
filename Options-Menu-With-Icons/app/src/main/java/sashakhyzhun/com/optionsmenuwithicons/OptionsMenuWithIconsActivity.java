package sashakhyzhun.com.optionsmenuwithicons;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionsMenuWithIconsActivity extends ActionBarActivity {

    // идентификаторы пунктов основного меню
    public static final int IDM_OPEN = 101;
    public static final int IDM_EDIT = 102;
    public static final int IDM_SAVE = 103;
    public static final int IDM_HELP = 104;
    public static final int IDM_EXIT = 105;
    // идентификаторы пунктов расщиренного меню
    public static final int IDM_FIND_REPLACE = 106;
    public static final int IDM_FIND_NEXT = 107;
    public static final int IDM_FIND_PREV = 108;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu_with_icons);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;*/
        //пункты для основного меню
        menu.add(Menu.NONE, IDM_OPEN, Menu.NONE, "Open").setIcon(R.drawable.ic_open);
        menu.add(Menu.NONE, IDM_EDIT, Menu.NONE, "Open").setIcon(R.drawable.ic_edit);
        menu.add(Menu.NONE, IDM_SAVE, Menu.NONE, "Open").setIcon(R.drawable.ic_save);
        menu.add(Menu.NONE, IDM_HELP, Menu.NONE, "Open").setIcon(R.drawable.ic_help);
        menu.add(Menu.NONE, IDM_EXIT, Menu.NONE, "Open").setIcon(R.drawable.ic_exit);
        //пункты для расширенного меню
        menu.add(Menu.NONE, IDM_FIND_REPLACE, Menu.NONE, "Find/Replace");
        menu.add(Menu.NONE, IDM_FIND_REPLACE, Menu.NONE, "Find Next");
        menu.add(Menu.NONE, IDM_FIND_PREV, Menu.NONE, "Find Previous");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CharSequence message;

        switch (item.getItemId()) {
            case IDM_OPEN:
                message = "Open item selected";
                break;
            case IDM_EDIT:
                message = "Edit item selected";
                break;
            case IDM_SAVE:
                message = "Save item selected";
                break;
            case IDM_HELP:
                message = "Help item selected";
                break;
            case IDM_EXIT:
                message = "Exit item selected";
                break;
            case IDM_FIND_REPLACE:
                message = "Find/Replace item selected";
                break;
            case IDM_FIND_NEXT:
                message = "Find next item selected";
                break;
            case IDM_FIND_PREV:
                message = "Find previous item selected";
                break;
            default:
                return false;
        }

        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        return true;
    }
}
