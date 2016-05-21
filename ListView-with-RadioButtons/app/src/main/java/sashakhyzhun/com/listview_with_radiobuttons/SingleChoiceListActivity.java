package sashakhyzhun.com.listview_with_radiobuttons;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SingleChoiceListActivity extends ListActivity {

    private static final String[] contacts = {
            "Jacob Anderson", "Emily Duncan", "Michael Fuller",
            "Emma Greenman", "Joshua Harrison", "Madison Johnson",
            "Mattew Cotman", "Olivia Lawson", "AndrewChapman",
            "Jacob Anderson", "Emily Duncan", "Michael Fuller",
            "Emma Greenman", "Joshua Harrison", "Madison Johnson",
            "Mattew Cotman", "Olivia Lawson", "AndrewChapman" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Create adapter for data
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, contacts));

        //Create object ListView
        final ListView listView = getListView();
        listView.setItemsCanFocus(false);

        //Install view mode
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
}
