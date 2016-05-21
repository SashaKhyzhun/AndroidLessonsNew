package sashakhyzhun.com.fragmentdynamicexam;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Switch;

import sashakhyzhun.com.fragmentdynamicexam.fragment.OneFragment;
import sashakhyzhun.com.fragmentdynamicexam.fragment.TwoFragment;

public class MainActivity extends FragmentActivity {

    private OneFragment oneFragment;
    private TwoFragment twoFragment;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    private Switch isBackStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        isBackStack = (Switch)findViewById(R.id.switchBackStack);
    }

    public void onClickFragment(View view) {
        transaction = manager.beginTransaction();

        switch (view.getId()) {
            case R.id.buttonAdd:
                if (manager.findFragmentByTag(OneFragment.TAG) == null) {
                    transaction.add(R.id.container, oneFragment, OneFragment.TAG);
                }
                break;
            case R.id.buttonRemove:
                if (manager.findFragmentByTag(OneFragment.TAG) != null) {
                    transaction.remove(oneFragment);
                }
                if (manager.findFragmentByTag(TwoFragment.TAG) != null) {
                    transaction.remove(twoFragment);
                }
                break;
            case R.id.buttonReplace:
                if (manager.findFragmentByTag(OneFragment.TAG) != null) {
                    transaction.replace(R.id.container, twoFragment, TwoFragment.TAG);
                }
                if (manager.findFragmentByTag(TwoFragment.TAG) != null) {
                    transaction.replace(R.id.container, oneFragment, OneFragment.TAG);
                }
                break;
        }
        if (isBackStack.isChecked()) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }


}
