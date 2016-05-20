package com.androidinputs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String opStr1 = "";
    String opStr2 = "";
    String sign = "";

    Double opStrDb1, opStrDb2, res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        editText = (EditText)findViewById(R.id.editText);
    }

    public void ClickBtn1 (View view)
    {
        editText.append("1");
    }
    public void ClickBtn2 (View view)
    {
        editText.append("2");
    }
    public void ClickBtn3 (View view)
    {
        editText.append("3");
    }
    public void ClickBtn4 (View view)
    {
        editText.append("4");
    }
    public void ClickBtn5 (View view)
    {
        editText.append("5");
    }
    public void ClickBtn6 (View view)
    {
        editText.append("6");
    }
    public void ClickBtn7 (View view)
    {
        editText.append("7");
    }
    public void ClickBtn8 (View view)
    {
        editText.append("8");
    }
    public void ClickBtn9 (View view)
    {
        editText.append("9");
    }
    public void ClickBtn0 (View view)
    {
        editText.append("0");
    }
    public void ClickBtnDot (View view)
    {
        editText.append(".");
    }
    public void ClickBtnPlus (View view)
    {
        opStr1 = editText.getText().toString();
        sign = "+";
        editText.setText("");
    }
    public void ClickBtnMinus (View view)
    {
        opStr1 = editText.getText().toString();
        sign = "-";
        editText.setText("");
    }
    public void ClickBtnDiv (View view)
    {
        opStr1 = editText.getText().toString();
        sign = "/";
        editText.setText("");
    }
    public void ClickBtnMul (View view)
    {
        opStr1 = editText.getText().toString();
        sign = "*";
        editText.setText("");
    }
    public void ClickBtnCalc (View view)
    {
        opStr2 = editText.getText().toString();

        opStrDb1 = Double.parseDouble(opStr1);
        opStrDb2 = Double.parseDouble(opStr2);

        if (sign.equals("+"))
        {
            res = opStrDb1 + opStrDb2;
        }
        if (sign.equals("-"))
        {
            res = opStrDb1 - opStrDb2;
        }
        if (sign.equals("/"))
        {
            res = opStrDb1 / opStrDb2;
        }
        if (sign.equals("*"))
        {
            res = opStrDb1 * opStrDb2;
        }
        editText.setText(res + "");


    }
    public void ClickBtnClear (View view)
    {
        opStr1="";
        opStr2="";
        sign="";
        editText.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
