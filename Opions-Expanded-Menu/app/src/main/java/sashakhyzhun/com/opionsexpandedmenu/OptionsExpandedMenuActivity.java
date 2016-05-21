package sashakhyzhun.com.opionsexpandedmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionsExpandedMenuActivity extends AppCompatActivity {

    public static final int IDM_OPEN = 101;
    public static final int IDM_SAVE = 102;
    public static final int IDM_EDIT = 103;
    public static final int IDM_HELP = 104;
    public static final int IDM_EXIT = 105;
    //дополнительное меню
    public static final int IDM_FIND_REPLACE = 106;
    public static final int IDM_FIND_NEXT = 107;
    public static final int IDM_FIND_PREV = 108;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_expanded_menu);
    }

    //создание меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //добавляем пункты меню
        menu.add(Menu.NONE, IDM_OPEN, Menu.NONE, "Open")
                .setIcon(R.drawable.ic_open).setAlphabeticShortcut('o');
        menu.add(Menu.NONE, IDM_EDIT, Menu.NONE, "Edit")
                .setIcon(R.drawable.ic_edit).setAlphabeticShortcut('e');
        menu.add(Menu.NONE, IDM_SAVE, Menu.NONE, "Save")
                .setIcon(R.drawable.ic_save).setAlphabeticShortcut('s');
        menu.add(Menu.NONE, IDM_HELP, Menu.NONE, "Help")
                .setIcon(R.drawable.ic_help).setAlphabeticShortcut('h');
        menu.add(Menu.NONE, IDM_EXIT, Menu.NONE, "Exit")
                .setIcon(R.drawable.ic_exit).setAlphabeticShortcut('x');

        menu.add(Menu.NONE, IDM_FIND_REPLACE, Menu.NONE, "Find/Replace");
        menu.add(Menu.NONE, IDM_FIND_NEXT, Menu.NONE, "Find Next");
        menu.add(Menu.NONE, IDM_FIND_PREV, Menu.NONE, "Find Previous");

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
