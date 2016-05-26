package sashakhyzhun.com.nominalpayment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    EditText et500, et200, et100, et50, et20, et10, et5, et2, et1;
    TextView resFor500, resFor200, resFor100, resFor50, resFor20, resFor10, resFor5, resFor2, resFor1,
             tv500, tv200, tv100, tv50, tv20, tv10, tv5, tv2, tv1, tvTotalResult;
    int aIntParse, aInteger, aResult, bIntParse, bInteger, bResult, cIntParse, cInteger, cResult,
        dIntParse, dInteger, dResult, eIntParse, eInteger, eResult, fIntParse, fInteger, fResult,
        gIntParse, gInteger, gResult, hIntParse, hInteger, hResult, jIntParse, jInteger, jResult, sumParse, sumResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        initView();

        Button buttonOK = (Button) findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonOK:
                try {
                    initParse();
                    //initCheckNullable();
                    calculateTotalSum();
                } catch (NumberFormatException e) {
                    initSetToZero();
                    Toast.makeText(getApplicationContext(), "Хьюстон, у нас проблемы!", Toast.LENGTH_LONG).show();
                }
                initSetResult();

                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_help:
                initAlertDialog();
                break;
            case R.id.menu_share:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{""});
                i.putExtra(Intent.EXTRA_SUBJECT, "3BIT");
                i.putExtra(Intent.EXTRA_TEXT   , " ");
                startActivity(Intent.createChooser(i, "Send mail..."));

                break;
            case R.id.menu_clear:
                initClear();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //инициализируем все view
    private void initView() {
        resFor500 = (TextView) findViewById(R.id.resultFor500);
        resFor200 = (TextView) findViewById(R.id.resultFor200);
        resFor100 = (TextView) findViewById(R.id.resultFor100);
        resFor50 = (TextView) findViewById(R.id.resultFor50);
        resFor20 = (TextView) findViewById(R.id.resultFor20);
        resFor10 = (TextView) findViewById(R.id.resultFor10);
        resFor5 = (TextView) findViewById(R.id.resultFor5);
        resFor2 = (TextView) findViewById(R.id.resultFor2);
        resFor1 = (TextView) findViewById(R.id.resultFor1);

        tv500 = (TextView) findViewById(R.id.tvFor500);
        tv200 = (TextView) findViewById(R.id.tvFor200);
        tv100 = (TextView) findViewById(R.id.tvFor100);
        tv50 = (TextView) findViewById(R.id.tvFor50);
        tv20 = (TextView) findViewById(R.id.tvFor20);
        tv10 = (TextView) findViewById(R.id.tvFor10);
        tv5 = (TextView) findViewById(R.id.tvFor5);
        tv2 = (TextView) findViewById(R.id.tvFor2);
        tv1 = (TextView) findViewById(R.id.tvFor1);

        et500 = (EditText) findViewById(R.id.editText500);
        et200 = (EditText) findViewById(R.id.editText200);
        et100 = (EditText) findViewById(R.id.editText100);
        et50 = (EditText) findViewById(R.id.editText50);
        et20 = (EditText) findViewById(R.id.editText20);
        et10 = (EditText) findViewById(R.id.editText10);
        et5 = (EditText) findViewById(R.id.editText5);
        et2 = (EditText) findViewById(R.id.editText2);
        et1 = (EditText) findViewById(R.id.editText1);

        tvTotalResult = (TextView)findViewById(R.id.tvTotalSum);
    }

    //делаем с EditText-ов переменные и умножаем их на нужную цифру
    private void initParse() {
        aIntParse = Integer.parseInt(et500.getText().toString());
        bIntParse = Integer.parseInt(et200.getText().toString());
        cIntParse = Integer.parseInt(et100.getText().toString());
        dIntParse = Integer.parseInt(et50.getText().toString());
        eIntParse = Integer.parseInt(et20.getText().toString());
        fIntParse = Integer.parseInt(et10.getText().toString());
        gIntParse = Integer.parseInt(et5.getText().toString());
        hIntParse = Integer.parseInt(et2.getText().toString());
        jIntParse = Integer.parseInt(et1.getText().toString());

        aInteger = Integer.parseInt(String.valueOf(500));
        bInteger = Integer.parseInt(String.valueOf(200));
        cInteger = Integer.parseInt(String.valueOf(100));
        dInteger = Integer.parseInt(String.valueOf(50));
        eInteger = Integer.parseInt(String.valueOf(20));
        fInteger = Integer.parseInt(String.valueOf(10));
        gInteger = Integer.parseInt(String.valueOf(5));
        hInteger = Integer.parseInt(String.valueOf(2));
        jInteger = Integer.parseInt(String.valueOf(1));
    }

    //если что-то пойдет не так или юзер не укажет цифру, то делаем её нулем.
    private void initSetToZero() {
        aIntParse = 0;
        bIntParse = 0;
        cIntParse = 0;
        dIntParse = 0;
        eIntParse = 0;
        fIntParse = 0;
        gIntParse = 0;
        hIntParse = 0;
        jIntParse = 0;
        aInteger = 0;
        bInteger = 0;
        cInteger = 0;
        dInteger = 0;
        eInteger = 0;
        fInteger = 0;
        gInteger = 0;
        hInteger = 0;
        jInteger = 0;
        sumResult = 0;
    }

    //имножаем и передаем это все int-у, а так же устанавливаем текст на наш TextView
    private void initSetResult() {
        aResult = aIntParse * aInteger;
        bResult = bIntParse * bInteger;
        cResult = cIntParse * cInteger;
        dResult = dIntParse * dInteger;
        eResult = eIntParse * eInteger;
        fResult = fIntParse * fInteger;
        gResult = gIntParse * gInteger;
        hResult = hIntParse * hInteger;
        jResult = jIntParse * jInteger;
        resFor500.setText(aResult + " грн");
        resFor200.setText(bResult + " грн");
        resFor100.setText(cResult + " грн");
        resFor50.setText(dResult + " грн");
        resFor20.setText(eResult + " грн");
        resFor10.setText(fResult + " грн");
        resFor5.setText(gResult + " грн");
        resFor2.setText(hResult + " грн");
        resFor1.setText(jResult + " грн");

        tvTotalResult.setText(sumParse + " грн");
    }

    //чистим все значение при нажатии на кнопку Clear
    private void initClear() {
        et500.setText("");
        et200.setText("");
        et100.setText("");
        et50.setText("");
        et20.setText("");
        et10.setText("");
        et5.setText("");
        et2.setText("");
        et1.setText("");
        resFor500.setText("0 грн");
        resFor200.setText("0 грн");
        resFor100.setText("0 грн");
        resFor50.setText("0 грн");
        resFor20.setText("0 грн");
        resFor10.setText("0 грн");
        resFor5.setText("0 грн");
        resFor2.setText("0 грн");
        resFor1.setText("0 грн");
        sumParse = 0;
        tvTotalResult.setText("");
    }

    //считает загальную сумму
    private void calculateTotalSum() {
        sumParse = ((aIntParse * aInteger) + (bIntParse * bInteger) + (cIntParse * cInteger)
                + (dIntParse * dInteger) + (eIntParse * eInteger) + (fIntParse * fInteger)
                + (gIntParse * gInteger) + (hIntParse * hInteger) + (jIntParse * jInteger));
    }

    //in future буде заміняти всі пусті поля на "0"
    private void initCheckNullable() {
        if (aIntParse == Integer.parseInt(null)) {
            aIntParse = 0;
        }
    }

    //создаем Alert Dialog
    private void initAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Help");
        builder.setIcon(R.drawable.ic_help_outline_black_24dp);
        builder.setMessage("Do you really need it?");
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

}