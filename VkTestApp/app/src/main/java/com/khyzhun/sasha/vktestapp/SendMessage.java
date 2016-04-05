package com.khyzhun.sasha.vktestapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SendMessage extends Activity{

    ArrayList<String> inList = new ArrayList<>();
    ArrayList<String> outList = new ArrayList<>();
    int id = 0;

    EditText text;
    Button send;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogs);
        inList = getIntent().getStringArrayListExtra("in");
        outList = getIntent().getStringArrayListExtra("out");
        id = getIntent().getIntExtra("id", 0);

        Arrays.sort(inList.toArray(), Collections.reverseOrder());
        Arrays.sort(outList.toArray(), Collections.reverseOrder());

        text = (EditText)findViewById(R.id.editText);
        listView = (ListView)findViewById(R.id.dialogList);
        listView.setAdapter(new CustomAdapter(this, inList, outList));
        send = (Button)findViewById(R.id.sendButton);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VKRequest request = new VKRequest("messages.send", VKParameters.from(VKApiConst.USER_ID, id,
                        VKApiConst.MESSAGE, text.getText().toString()));
                request.executeWithListener(new VKRequest.VKRequestListener() {
                    @Override
                    public void onComplete(VKResponse response) {
                        super.onComplete(response);
                        System.out.println("Сообщение отправлено");
                    }
                });
            }
        });
    }
}
