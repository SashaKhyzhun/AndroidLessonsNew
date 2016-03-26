package com.khyzhun.sasha.vktestapp;

import android.content.Context;
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
import com.vk.sdk.api.model.VKList;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    public CustomAdapter(Context context, ArrayList<String> users, ArrayList<String> message, VKList<VKApiDialog> list) {
        this.users = users;
        this.message = message;
        this.context = context;
        this.list = list;
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
        setDate setDate = new setDate();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.style_list_view, null);

        setDate.user_name = (TextView)view.findViewById(R.id.userName);
        setDate.msg       = (TextView)view.findViewById(R.id.message);

        setDate.user_name.setText(users.get(position));
        setDate.msg.setText(message.get(position));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VKRequest request = new VKRequest("message.send", VKParameters.from(VKApiConst.USER_ID, list.get(position).message.user_id,
                        VKApiConst.MESSAGE, "Text msg"));
                request.executeWithListener(new VKRequest.VKRequestListener() {
                    @Override
                    public void onComplete(VKResponse response) {
                        super.onComplete(response);
                        System.out.println("Сообщение отправлено");
                    }
                });
            }
        });

        return view;
    }

    public class setDate {
        TextView user_name, msg;
    }

}
