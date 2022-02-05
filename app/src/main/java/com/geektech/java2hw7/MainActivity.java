package com.geektech.java2hw7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtChange;
    private Double first;
    private Double second;
    private Boolean isOperationClick;
    private String operation;
    private Button ravno, click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtChange = findViewById(R.id.txt_change);
        ravno = findViewById(R.id.btn_ravno);
        click = findViewById(R.id.btn_other);
        ravno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.setVisibility(View.VISIBLE);
            }
        });
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public void OnNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_clear:
                click.setVisibility(View.GONE);
                txtChange.setText("0");
                first = 0.0;
                second = 0.0;
                break;
            case R.id.btn_one:
                click.setVisibility(View.GONE);
                setNumber("1");
                break;
            case R.id.btn_two:
                click.setVisibility(View.GONE);
                setNumber("2");
                break;
            case R.id.btn_three:
                click.setVisibility(View.GONE);
                setNumber("3");
                break;
            case R.id.btn_four:
                click.setVisibility(View.GONE);
                setNumber("4");
                break;
            case R.id.btn_five:
                click.setVisibility(View.GONE);
                setNumber("5");
                break;
            case R.id.btn_six:
                click.setVisibility(View.GONE);
                setNumber("6");
                break;
            case R.id.btn_seven:
                click.setVisibility(View.GONE);
                setNumber("7");
                break;
            case R.id.btn_eight:
                click.setVisibility(View.GONE);
                setNumber("8");
                break;
            case R.id.btn_nine:
                click.setVisibility(View.GONE);
                setNumber("9");
                break;
            case R.id.btn_zero:
                click.setVisibility(View.GONE);
                setNumber("0");
                break;
            case R.id.btn_tochka:
                click.setVisibility(View.GONE);
                setNumber(".");
                break;
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
                click.setVisibility(View.GONE);
                first = Double.parseDouble(txtChange.getText().toString());
                isOperationClick = true;
                operation = "+";
                break;
            case R.id.btn_minus:
                click.setVisibility(View.GONE);
                first = Double.parseDouble(txtChange.getText().toString());
                isOperationClick = true;
                operation = "-";
                break;
            case R.id.btn_multiplied:
                click.setVisibility(View.GONE);
                first = Double.parseDouble(txtChange.getText().toString());
                isOperationClick = true;
                operation = "*";
                 break;
            case R.id.btn_divided:
                click.setVisibility(View.GONE);
                first = Double.parseDouble(txtChange.getText().toString());
                isOperationClick = true;
                operation = "/";
                break;
            case R.id.btn_procent:
                click.setVisibility(View.GONE);
                first = Double.parseDouble(txtChange.getText().toString());
                Double procent;
                procent = first / 100;
                txtChange.setText(procent.toString());
                break;
            case R.id.btn_mp:
                first = Double.parseDouble(txtChange.getText().toString());
                Double mp;
                mp = first - first * 2;
                txtChange.setText(mp.toString());
                break;

            case R.id.btn_ravno:
                click.setVisibility(View.GONE);
                second = Double.parseDouble(txtChange.getText().toString());
                Double result = 0.0;
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