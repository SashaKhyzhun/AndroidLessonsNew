package sashakhyzhun.com.fragmentviewdata.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import sashakhyzhun.com.fragmentviewdata.R;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button button = (Button) getActivity().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) getActivity().findViewById(R.id.text);
                TextView textView = (TextView) getActivity().findViewById(R.id.textView);
                textView.setText(editText.getText());
            }
        });
    }

}
