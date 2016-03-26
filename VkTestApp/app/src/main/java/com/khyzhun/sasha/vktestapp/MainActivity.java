package com.khyzhun.sasha.vktestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiDialog;
import com.vk.sdk.api.model.VKApiGetDialogResponse;
import com.vk.sdk.api.model.VKApiGetMessagesResponse;
import com.vk.sdk.api.model.VKApiMessage;
import com.vk.sdk.api.model.VKList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] scope = new String[]{VKScope.MESSAGES, VKScope.FRIENDS, VKScope.WALL};
    private ListView listView;
    private Button showMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VKSdk.login(this, scope);

        listView = (ListView) findViewById(R.id.listView);
        showMessageButton = (Button) findViewById(R.id.showMessageButton);
        showMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final VKRequest request = VKApi.messages().get(VKParameters.from(VKApiConst.COUNT, "10" ));
                request.executeWithListener(new VKRequest.VKRequestListener() {
                    @Override
                    public void onComplete(VKResponse response) {
                        super.onComplete(response);

                        VKApiGetDialogResponse getDialogResponse = (VKApiGetDialogResponse)response.parsedModel;

                        final VKList<VKApiDialog> list = getDialogResponse.items;

                        ArrayList<String> messages = new ArrayList<>();
                        ArrayList<String> users = new ArrayList<>();

                        for(VKApiDialog msg : list) {
                            users.add(String.valueOf(msg.message.user_id));
                            messages.add(msg.message.body);
                        }

                        listView.setAdapter(new CustomAdapter(MainActivity.this, users, messages, list));
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {

                final VKRequest request = VKApi.friends().get(VKParameters.from(VKApiConst.FIELDS, "first_name, last_name"));
                request.executeWithListener(new VKRequest.VKRequestListener() {
                    @Override
                    public void onComplete(VKResponse response) {
                        super.onComplete(response);

                        final VKList list = (VKList)response.parsedModel;

                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_expandable_list_item_1, list);

                        listView.setAdapter(arrayAdapter);
                    }
                });

                Toast.makeText(getApplicationContext(), "Good", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onError(VKError error) {
                Toast.makeText(getApplicationContext(), "Oops", Toast.LENGTH_SHORT).show();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
