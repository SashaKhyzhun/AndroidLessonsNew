package sashakhyzhun.com.listviewsample;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewActivity extends ListActivity {

    private TextView mTextView;

    private static String[] contacts = {
            "Jacob Anderson", "Emily Duncan", "Michael Fuller",
            "Emma Greenman", "Joshua Harrison", "Madison Johnson",
            "Mattew Cotman", "Olivia Lawson", "AndrewChapman",
            "Jacob Anderson", "Emily Duncan", "Michael Fuller",
            "Emma Greenman", "Joshua Harrison", "Madison Johnson",
            "Mattew Cotman", "Olivia Lawson", "AndrewChapman" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //Создаем адаптер и отображаем данные в списке
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, contacts));

        mTextView = (TextView)findViewById(R.id.textSelected);
    }

    public void onListItemClick(ListView parent, View v, int pos, long id) {
        mTextView.setText(
           String.format("Select: %s; pos: %s; id: %s", contacts[pos], pos, id));
    }

}
