package sashakhyzhun.com.myminiwordpad;

import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EditorActivity extends ActionBarActivity {

    //идентификаторы пунктов меню
    private static final int IDM_NEW = 200;
    private static final int IDM_OPEN = 201;
    private static final int IDM_SAVE = 202;
    private static final int IDM_EXIT = 203;
    //констнта с именем директории на карте памяти
    private static final String DIR_DOC = "/docs";
    //расширение для файлов
    private static final String FILE_EXT = ".txt";

    private EditText editText;
    private String curFileName = "";
    private String dir;
    private int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        editText = (EditText)findViewById(R.id.edit);

        //Читаем директорию на карте памяти, которую использует наше приложение
        dir = Environment.getExternalStorageDirectory().toString() + DIR_DOC;
        File folder = new File(dir);

        //если директория не существует, то создаем ее
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, IDM_NEW, Menu.NONE, R.string.menu_new);
        menu.add(Menu.NONE, IDM_OPEN, Menu.NONE, R.string.menu_open);
        menu.add(Menu.NONE, IDM_SAVE, Menu.NONE, R.string.menu_save);
        menu.add(Menu.NONE, IDM_EXIT, Menu.NONE, R.string.menu_exit);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case IDM_NEW:
                curFileName = "";
                editText.setText("");
                this.setTitle(R.string.app_name);
                break;
            case IDM_OPEN:
                callOpenDialog();
                break;
            case IDM_SAVE:
                callSaveDialog();
                break;
            case IDM_EXIT:
                finish();
                break;
            default:
                return true;
        }

        return true;
    }

    //Выхов диалога для сохранения файла
    private void callSaveDialog() {
        LayoutInflater inflater = this.getLayoutInflater();
        View root = inflater.inflate(R.layout.savedialog, null);

        final EditText editFileName = (EditText)root.findViewById(R.id.edit_filename);
        editFileName.setText(curFileName);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(root);
        builder.setTitle(R.string.title_save);

        //закрываем диалог с сохранением файла
        builder.setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                saveFile(editFileName.getText().toString());
            }
        });

        //закрываем диалог без сохранения файла
        builder.setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        builder.show();
    }

    //Вызов диалога для выбора файла
    private void callOpenDialog() {
        try {
            final String[] files = findFiles(dir);

            //Диалог создается только при наличии файлов в директории
            if (files.length > 0) {
                pos = 0;
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.title_open);

                //отображаем в диалоге список файлов
                builder.setSingleChoiceItems(
                    files, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int item) {
                            pos = item;
                        }
                    });

                //обработка закрытия диалога с выбранным файлом (ОК)
                builder.setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        curFileName = files[pos];
                        openFile(curFileName);
                    }
                });

                //обработка закрытия диалога (Cancel)
                builder.setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                builder.setCancelable(false);
                builder.show();
            }
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    //Сохранение файла
    private void saveFile(String fileName) {
        try {
            if (!fileName.endsWith(FILE_EXT)) {
                fileName += FILE_EXT;
            }

            File file = new File(dir, fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(editText.getText().toString().getBytes());
            fos.close();
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    //Открытие файла с заданым именем и загрузка его в текстовый редактор
    private void openFile(String fileName) {
        try {
            File file = new File(dir, fileName);
            FileInputStream inStream = new FileInputStream(file);

            if (inStream != null) {
                InputStreamReader tmp = new InputStreamReader(inStream);
                BufferedReader reader = new BufferedReader(tmp);
                String str;
                StringBuffer buffer = new StringBuffer();

                while ((str = reader.readLine()) != null) {
                    buffer.append(str).append("\n");
                }

                inStream.close();
                editText.setText(buffer.toString());

                curFileName = fileName;

                //Отображаем название файла в заголовке Activity
                setTitle(getResources().getString(R.string.app_name) + ": " + curFileName);
            }
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    //Поиск файла по имени
    private String[] findFiles(String dirPath) {
        ArrayList<String> items = new ArrayList<>();
        try {
            File f = new File(dirPath);
            File[] files = f.listFiles();

            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                
                //Если это файл, а не каталог, то добавляем его в список файлов
                if (!file.isDirectory()) {
                    items.add(file.getName());
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        return items.toArray(new String[items.size()]);
    }

}
