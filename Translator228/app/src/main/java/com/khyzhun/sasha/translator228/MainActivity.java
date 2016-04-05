package com.khyzhun.sasha.translator228;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit.Call;
import retrofit.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText etInputText;
    private TextView tvResult;
    private Button btTranslate;

    private final String URL = "http://translate.yandex.ru";
    private final String KEY = "trns1.1.1.20151210T140339Z.7a97f1c54bad842e.3a05d473055e420227feld451f3b16eb5d56cb70";

    private Gson gson = new GsonBuilder().create();

    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(URL)
            .build();

    private Link intf = retrofit.create(Link.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInputText = (EditText)findViewById(R.id.etInputText);
        tvResult = (TextView)findViewById(R.id.tvResult);
        btTranslate = (Button)findViewById(R.id.btTranslate);

        btTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Map<String, String> mapJson = new HashMap<String, String>();
                mapJson.put("key", KEY);
                mapJson.put("text", etInputText.getText().toString());
                mapJson.put("lang", "en-ru");

                Call<Object> call = intf.translate(mapJson);

                try {
                    Response<Object> response = call.execute();
                    Map<String, String> map = gson.fromJson(response.body().toString(), Map.class);

                    for(Map.Entry e : map.entrySet()) {
                        if (e.getKey().equals("text")) {
                            btTranslate.setText(e.getValue().toString());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
