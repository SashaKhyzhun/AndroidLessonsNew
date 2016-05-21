package sashakhyzhun.com.fragmentviewdata.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sashakhyzhun.com.fragmentviewdata.R;
import sashakhyzhun.com.fragmentviewdata.fragment.LastFragment;

public class MainActivity extends FragmentActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        initFragmentLast();
    }

    private void initFragmentLast() {
        transaction = manager.beginTransaction();
        transaction.add(R.id.container, new LastFragment());
        transaction.commit();
    }

}
