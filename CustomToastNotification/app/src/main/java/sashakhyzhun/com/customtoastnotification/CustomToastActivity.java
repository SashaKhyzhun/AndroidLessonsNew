package sashakhyzhun.com.customtoastnotification;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CustomToastActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);
    }

    @Override
    public void onClick(View v) {
        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.activity_custom_toast,
                (ViewGroup) findViewById(R.id.toast_layout));

        final ImageView image = (ImageView)layout.findViewById(R.id.image);
        image.setImageResource(R.mipmap.ic_launcher);

        final TextView text = (TextView)findViewById(R.id.text);
        text.setText("Hello! This is a custom toast!");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();


    }
}
