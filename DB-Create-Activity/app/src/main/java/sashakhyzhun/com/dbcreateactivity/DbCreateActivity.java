package sashakhyzhun.com.dbcreateactivity;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DbCreateActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase db = new ContactDbHelper(getApplicationContext()).getWritableDatabase();

        // ! Всегда надо проверять возвращаемый результат.
        // ! если он null, то при создании произошла ошибка
        if (db != null) {
            Toast.makeText(getApplicationContext(), "DB Contacts is created", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Error create database", Toast.LENGTH_LONG).show();
        }
    }
}
