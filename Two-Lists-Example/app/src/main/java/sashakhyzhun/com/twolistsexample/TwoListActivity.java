package sashakhyzhun.com.twolistsexample;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TwoListActivity extends ListActivity {

    private static final String[] contacts = {
            "Jacob Anderson", "Emily Duncan", "Michael Fuller",
            "Emma Greenman", "Joshua Harrison", "Madison Johnson",
            "Mattew Cotman", "Olivia Lawson", "AndrewChapman",
            "Jacob Anderson", "Emily Duncan", "Michael Fuller",
            "Emma Greenman", "Joshua Harrison", "Madison Johnson",
            "Mattew Cotman", "Olivia Lawson", "AndrewChapman" };

    private static final String[] details = {
            "Mobile", "Home", "Address", "Email", "Back on Contacts" };

    private ArrayAdapter<String> daContacts, daDetails;
    private String strMonth, strDayOfWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        daContacts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts);
        daDetails = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, details);

        setListAdapter(daContacts);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (getListAdapter() == daContacts) {
            //переходим на список с детализацией
            setListAdapter(daDetails);
            daDetails.notifyDataSetChanged();
        } else {
            if ((String)getListView().getItemAtPosition(position) == "Back on Contacts") {
                //переходим на список контактов
                setListAdapter(daContacts);
                daContacts.notifyDataSetChanged();
            } else {
                Toast.makeText(getApplicationContext(), "Clicked: " + position, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
