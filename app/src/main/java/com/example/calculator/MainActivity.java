package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    TextView ans;
    private EditText activeField;
    private boolean isNull = true;
    long result = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editText1 = findViewById(R.id.editText_1);
        editText2 = findViewById(R.id.editText_2);
        editText1.setRawInputType(InputType.TYPE_NULL);
        activeField = editText1;
        ans = findViewById(R.id.ans);
    }

    public void click(View view) {
        int id = view.getId();
        String curNumber = activeField.getText().toString();
        if (isNull) {
            curNumber = "";
            isNull = false;
        }
        if (id == R.id.button1) {
            curNumber += "1";
            activeField.setText(curNumber);
        } else if (id == R.id.button2) {
            curNumber += "2";
            activeField.setText(curNumber);
        } else if (id == R.id.button3) {
            curNumber += "3";
            activeField.setText(curNumber);
        } else if (id == R.id.button4) {
            curNumber += "4";
            activeField.setText(curNumber);
        } else if (id == R.id.button5) {
            curNumber += "5";
            activeField.setText(curNumber);
        } else if (id == R.id.button6) {
            curNumber += "6";
            activeField.setText(curNumber);
        } else if (id == R.id.button7) {
            curNumber += "7";
            activeField.setText(curNumber);
        } else if (id == R.id.button8) {
            curNumber += "8";
            activeField.setText(curNumber);
        } else if (id == R.id.button9) {
            curNumber += "9";
            activeField.setText(curNumber);
        } else if (id == R.id.buttonZero) {
            curNumber += "0";
            activeField.setText(curNumber);
        } else if (id == R.id.buttonPlus) {
            result = Long.valueOf(editText1.getText().toString()) + Long.valueOf(editText2.getText().toString());
        } else if (id == R.id.buttonMinus) {
            result = Long.valueOf(editText1.getText().toString()) - Long.valueOf(editText2.getText().toString());
        } else if (id == R.id.buttonMultiply) {
            result = Long.valueOf(editText1.getText().toString()) * Long.valueOf(editText2.getText().toString());
        } else if (id == R.id.buttonDivide) {
            if (!editText2.getText().toString().equals("0")) {
                result = Long.valueOf(editText1.getText().toString()) / Long.valueOf(editText2.getText().toString());
            } else ans.setText("error");
        } else if (id == R.id.buttonAC) {
            editText1.setText("0");
            editText2.setText("0");
            ans.setText("0");
            isNull = true;
        } else if (id == R.id.buttonChange) {
            if (activeField == editText1) {
                activeField = editText2;
            } else {
                activeField = editText1;
            }
            isNull = true;
        } else if (id == R.id.buttonEqual) {
            ans.setText(result + "");
        }
    }
}