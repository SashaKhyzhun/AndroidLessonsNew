package sashakhyzhun.com.fragmentdynamicexam.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sashakhyzhun.com.fragmentdynamicexam.R;

public class OneFragment extends Fragment {

    public static final String TAG = "OneFragmentTag";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.one_fragment, null);
    }
}
