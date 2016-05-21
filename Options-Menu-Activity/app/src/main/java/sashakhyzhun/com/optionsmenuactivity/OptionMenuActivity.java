package sashakhyzhun.com.optionsmenuactivity;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionMenuActivity extends ActionBarActivity {

    public static final int IDM_OPEN = 101;
    public static final int IDM_SAVE = 102;
    public static final int IDM_EDIT = 103;
    public static final int IDM_HELP = 104;
    public static final int IDM_EXIT = 105;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);
    }

    //создание меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //добавляем пункты меню
        menu.add(Menu.NONE, IDM_OPEN, Menu.NONE, "Open").setAlphabeticShortcut('o');
        menu.add(Menu.NONE, IDM_EDIT, Menu.NONE, "Edit").setAlphabeticShortcut('e');
        menu.add(Menu.NONE, IDM_SAVE, Menu.NONE, "Save").setAlphabeticShortcut('s');
        menu.add(Menu.NONE, IDM_HELP, Menu.NONE, "Help").setAlphabeticShortcut('h');
        menu.add(Menu.NONE, IDM_EXIT, Menu.NONE, "Exit").setAlphabeticShortcut('x');

        return super.onCreateOptionsMenu(menu);
    }

    //обработка события выбора пункта меню


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CharSequence message;
        switch (item.getItemId()) {
            case IDM_OPEN:
                message = "Open item selected";
                item.setChecked(true);
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
            default:
                return false;
        }

        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        return true;
    }
}
