package com.geektech.java2hw7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtChange;
    private Integer first;
    private Integer second;
    private Boolean isOperationClick;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtChange = findViewById(R.id.txt_change);
    }

    public void OnNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_clear:
                txtChange.setText("0");
                first = 0;
                second = 0;
                break;
            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;
            case R.id.btn_three:
                setNumber("3");
                break;
            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;
            case R.id.btn_six:
                setNumber("6");
                break;
            case R.id.btn_seven:
                setNumber("7");
                break;
            case R.id.btn_eight:
                setNumber("8");
                break;
            case R.id.btn_nine:
                setNumber("9");
                break;
            case R.id.btn_zero:
                setNumber("0");
        }
    }

    private void setNumber(String number) {
        if (txtChange.getText().toString().equals("0")) {
            txtChange.setText(number);
        } else if (isOperationClick) {
            txtChange.setText(number);
        } else {
            txtChange.append(number);
        }
        isOperationClick = false;
    }

    public void OnActionClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                first = Integer.parseInt(txtChange.getText().toString());
                isOperationClick = true;
                operation = "+";
                break;
            case R.id.btn_minus:
                first = Integer.parseInt(txtChange.getText().toString());
                isOperationClick = true;
                operation = "-";
                break;
            case R.id.btn_multiplied:
                first = Integer.parseInt(txtChange.getText().toString());
                isOperationClick = true;
                operation = "*";
            case R.id.btn_divided:
                first = Integer.parseInt(txtChange.getText().toString());
                isOperationClick = true;
                operation = "/";
            case R.id.btn_ravno:
                second = Integer.parseInt(txtChange.getText().toString());
                Integer result = 0;
                switch (operation) {
                    case "+":
                        result = first + second;
                        break;

                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = first / second;
                        break;
                }
                txtChange.setText(result.toString());
                break;

        }
    }
}