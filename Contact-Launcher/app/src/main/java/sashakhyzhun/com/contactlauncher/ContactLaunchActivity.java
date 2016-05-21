package sashakhyzhun.com.contactlauncher;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ContactLaunchActivity extends Activity implements View.OnClickListener {

    //константа, идентифицирующая вызываемый Activity
    private final static String ACTION_VIEW_CONTACTS =
            "sashakhyzhun.com.contact.VIEW_CONTACTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_launcher);
    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(ACTION_VIEW_CONTACTS));
    }
}
