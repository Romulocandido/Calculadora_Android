package com.example.calculadora2.app;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    public ButtonClickListener btnClick;
    private EditText Scr;
    private float NumberBf;
    private String Operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Scr = (EditText) findViewById(R.id.editText);
        Scr.setEnabled(false);

        ButtonClickListener btnClick = new ButtonClickListener();
        int idList[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9, R.id.buttonDot,R.id.buttonMul, R.id.buttonDiv, R.id.buttonAdd,
                R.id.buttonSub, R.id.buttonC, R.id.buttonEq};

        for (int id:idList){
            View v = (View) findViewById(id);
            v.setOnClickListener(btnClick);
        }
    }

    public void mMath(String str){
        NumberBf = Float.parseFloat(Scr.getText().toString());
        Operation = str;
        Scr.setText("0");
    }

    public void getKeyBoard(String str){
        String ScrCurrent = Scr.getText().toString();
        if(ScrCurrent.equals("0"))
            ScrCurrent = "";
        ScrCurrent += str;
        Scr.setText(ScrCurrent);
    }

    public void mResult(){
        float NumAf = Float.parseFloat(Scr.getText().toString());
        float result = 0;
        if(Operation.equals("+")) {
            result = NumAf + NumberBf;
        }

        if(Operation.equals("-")) {
            result = NumberBf - NumAf;
        }

        if(Operation.equals("*")) {
            result = NumAf * NumberBf;
        }

        if(Operation.equals("/")) {
            result = NumberBf / NumAf;
        }
        Scr.setText(String.valueOf(result));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class ButtonClickListener implements View.OnClickListener {
        private float NumberBf;
        private String Operation;
        private ButtonClickListener btnClick;

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonC:
                    Scr.setText("0");
                    NumberBf = 0;
                    Operation = "";
                    break;
                case R.id.buttonAd:
                    mMath("+");
                    break;
                case R.id.buttonSub:
                    mMath("-");
                    break;
                case R.id.buttonMul:
                    mMath("*");
                    break;
                case R.id.buttonDiv:
                    mMath("/");
                    break;
                case R.id.buttonEq:
                    mResult();
                    break;
                default:
                    String numb = ((Button) v).getText().toString();
                    getKeyBoard(numb);
                    break;
            }
        }
    }
}
