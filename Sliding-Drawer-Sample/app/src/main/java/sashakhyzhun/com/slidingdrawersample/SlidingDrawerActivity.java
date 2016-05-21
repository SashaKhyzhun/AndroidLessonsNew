package sashakhyzhun.com.slidingdrawersample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class SlidingDrawerActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private TextView selectText;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_drawer);

        selectText = (TextView)findViewById(R.id.label);

        GridView gridView = (GridView)findViewById(R.id.grid);
        adapter = new ImageAdapter(this);
        gridView.setAdapter(adapter);
        gridView.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectText.setText("Selected items ID: " + adapter.getItemId(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        selectText.setText("Selected items: none");
    }
}
