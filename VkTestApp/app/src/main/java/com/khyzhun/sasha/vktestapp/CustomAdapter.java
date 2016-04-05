package com.khyzhun.sasha.vktestapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiDialog;
import com.vk.sdk.api.model.VKApiMessage;
import com.vk.sdk.api.model.VKList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    public CustomAdapter(Context context, ArrayList<String> users, ArrayList<String> message, VKList<VKApiDialog> list) {
        this.users = users;
        this.message = message;
        this.context = context;
        this.list = list;
    }

    public CustomAdapter(Context context, ArrayList<String> users, ArrayList<String> message) {
        this.users = users;
        this.message = message;
        this.context = context;
    }

    private ArrayList<String> users, message;
    private Context context;
    private VKList<VKApiDialog> list;

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        setData setData = new setData();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.style_list_view, null);

        setData.user_name = (TextView)view.findViewById(R.id.userName);
        setData.msg       = (TextView)view.findViewById(R.id.message);

        setData.user_name.setText(users.get(position));
        setData.msg.setText(message.get(position));

        if(list != null)
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayList<String> inList = new ArrayList<>();
                final ArrayList<String> outList = new ArrayList<>();
                final int id = list.get(position).message.user_id;

                VKRequest request = new VKRequest("messages.getHistory", VKParameters.from(VKApiConst.USER_ID, id));
                request.executeWithListener(new VKRequest.VKRequestListener() {
                    @Override
                    public void onComplete(VKResponse response) {
                        super.onComplete(response);

                        try {
                            JSONArray array = response.json.getJSONObject("response").getJSONArray("items");
                            VKApiMessage[] msg = new VKApiMessage[array.length()];
                            for (int i = 0; i < array.length(); i++) {
                                VKApiMessage mes = new VKApiMessage(array.getJSONObject(i));
                                msg[i] = mes;
                            }

                            for (VKApiMessage mess : msg) {
                                if (mess.out) {
                                    outList.add(mess.body);
                                } else {
                                    inList.add(mess.body);
                                }
                            }

                            context.startActivity(new Intent(context, SendMessage.class).putExtra("id", id)
                                            .putExtra("in", inList).putExtra("out", outList));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                });
            }
        });

        return view;
    }

    public class setData {
        TextView user_name, msg;
    }

}
