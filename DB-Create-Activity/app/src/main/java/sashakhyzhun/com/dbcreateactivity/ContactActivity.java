package sashakhyzhun.com.dbcreateactivity;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

public class ContactActivity extends ListActivity {
    // id for menu
    private static final int IDM_ADD = 101;
    private static final int IDM_EDIT = 102;
    private static final int IDM_DELETE = 103;

    //Name of fields in table "Contact"
    private static final String ID = "_id";
    private static final String NAME = "first_name";
    private static final String PHONE = "phone";

    private static final Uri CONTENT_URI = Uri.parse(
            "content://sashakhyzhun.com.dbcreateactivity.contactdbhelper/people");

    private ContentResolver resolver;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        resolver = this.getContentResolver();

        final String[] projection = new String[] { ID, NAME, PHONE };

        cursor = resolver.query(CONTENT_URI, projection, null, null, null);

        final ListAdapter mAdapter = new SimpleCursorAdapter(this,
                R.layout.activity_contact228, cursor,
                new String[] {NAME, PHONE},
                new int[] { R.id.name, R.id.phone});
        setListAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, IDM_ADD, Menu.NONE, R.string.menu_add);
        menu.add(Menu.NONE, IDM_EDIT, Menu.NONE, R.string.menu_delete);
        menu.add(Menu.NONE, IDM_DELETE, Menu.NONE, R.string.menu_delete);

        return (super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final long id = this.getSelectedItemId();

        switch (item.getItemId()) {
            case IDM_ADD:
                callAddContactDialog();
                break;
            case IDM_EDIT:
                if (id > 1) {
                    callEditContactDialog(id);
                } else {
                    Toast.makeText(this, R.string.toast_notify, Toast.LENGTH_SHORT).show();
                }
                break;
            case IDM_DELETE:
                if (id > 1) {
                    callDeleteContactDialog(id);
                } else {
                    Toast.makeText(this, R.string.toast_notify, Toast.LENGTH_SHORT).show();
                }
                break;
        }

        return (super.onOptionsItemSelected(item));
    }

    private void callAddContactDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.activity_contact228, null);

        final EditText editName = (EditText)findViewById(R.id.edit_name);
        final EditText editPhone = (EditText)findViewById(R.id.edit_phone);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setTitle(R.string.title_add);
        builder.setPositiveButton(R.string.btn_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ContentValues values = new ContentValues(2);
                values.put(NAME, editName.getText().toString());
                values.put(PHONE, editPhone.getText().toString());

                resolver.insert(CONTENT_URI, values);
                cursor.requery();
            }
        });

        builder.setNegativeButton(R.string.btn_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.show();
    }

    private void callEditContactDialog(final long id) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.activity_contact228, null);

        final EditText editName = (EditText)findViewById(R.id.edit_name);
        final EditText editPhone = (EditText)findViewById(R.id.edit_phone);

        cursor.moveToPosition(this.getSelectedItemPosition());
        editName.setText(cursor.getString(1));
        editPhone.setText(cursor.getString(2));

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setTitle(R.string.title_edit);

        builder.setPositiveButton(R.string.btn_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ContentValues values = new ContentValues(2);

                values.put(NAME, editName.getText().toString());
                values.put(PHONE, editPhone.getText().toString());

                resolver.update(CONTENT_URI, values, "_ID=" + id, null);
                cursor.requery();
            }
        });

        builder.setNegativeButton(R.string.btn_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
    }

    private void callDeleteContactDialog(final long id) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title_delete);
        builder.setMessage(cursor.getString(1) + "\nPhone: " + cursor.getString(2));

        builder.setPositiveButton(R.string.btn_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resolver.delete(CONTENT_URI, "_ID" + id, null);
                cursor.requery();
            }
        });

        builder.setNegativeButton(R.string.btn_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.show();
    }


}
