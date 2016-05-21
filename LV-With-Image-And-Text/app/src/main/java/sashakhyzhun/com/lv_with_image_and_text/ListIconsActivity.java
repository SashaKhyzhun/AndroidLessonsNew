package sashakhyzhun.com.lv_with_image_and_text;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListIconsActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_icons);
        setListAdapter(new CustomAdapter(getApplicationContext()));
    }
}
