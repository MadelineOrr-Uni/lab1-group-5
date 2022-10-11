package com.example.lab1_androidcalculator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.math.BigDecimal;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Portrait Buttons
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSubtract, btnMultiply, btnDivide, btnEqual, btnClear, btnBracket, btnDecimal, btnPercent, btnSign;
    // Landscape Buttons
    Button btnMode, btnSquareRoot, btnCubeRoot, btnSin, btnInverseSin, btnCos, btnInverseCos, btnTan, btnInverseTan, btnNaturalLog, btnHyperSin, btnLog, btnHyperCos, btnInvert, btnHyperTan, btneExponent, btnInverseHyperSin, btnSquared, btnInverseHyperCos, btnXPowerY, btnInverseHyperTan, btnAbsoluteValue, btn2PowerX, btnPi, btne, btnCubed, btnFactorial;

    ImageButton btnSwap, btnBackspace;
    // Text Fields
    TextView currNum, currCalc, prevCalc;

    ScriptEngine mathCalc;

    // Temp strings
    String str, prevCalcValue;

    boolean showPrevCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showPrevCalc = false;

        currNum = findViewById(R.id.current_number);
        currCalc = findViewById(R.id.current_calculation);
        prevCalc = findViewById(R.id.previous_calculation);

        btn0 = findViewById(R.id.button_0);
        btn0.setOnClickListener(this);
        btn1 = findViewById(R.id.button_1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.button_2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.button_3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.button_4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.button_5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.button_6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.button_7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.button_8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.button_9);
        btn9.setOnClickListener(this);

        btnAdd = findViewById(R.id.button_add);
        btnAdd.setOnClickListener(this);
        btnSubtract = findViewById(R.id.button_minus);
        btnSubtract.setOnClickListener(this);
        btnMultiply = findViewById(R.id.button_multiply);
        btnMultiply.setOnClickListener(this);
        btnDivide = findViewById(R.id.button_divide);
        btnDivide.setOnClickListener(this);
        btnEqual = findViewById(R.id.button_equals);
        btnEqual.setOnClickListener(this);

        btnClear = findViewById(R.id.button_clear);
        btnClear.setOnClickListener(this);
        btnBracket = findViewById(R.id.button_bracket);
        btnBracket.setOnClickListener(this);
        btnDecimal = findViewById(R.id.button_decimal);
        btnDecimal.setOnClickListener(this);
        btnPercent = findViewById(R.id.button_percent);
        btnPercent.setOnClickListener(this);
        btnSign = findViewById(R.id.button_sign);
        btnSign.setOnClickListener(this);

        btnMode = findViewById(R.id.button_mode);
        btnMode.setOnClickListener(this);
        btnSquareRoot = findViewById(R.id.button_squareRoot);
        btnSquareRoot.setOnClickListener(this);
        btnCubeRoot = findViewById(R.id.button_cubeRoot);
        btnCubeRoot.setOnClickListener(this);
        btnSin = findViewById(R.id.button_sin);
        btnSin.setOnClickListener(this);
        btnInverseSin = findViewById(R.id.button_inverseSin);
        btnInverseSin.setOnClickListener(this);
        btnCos = findViewById(R.id.button_cos);
        btnCos.setOnClickListener(this);
        btnInverseCos = findViewById(R.id.button_inverseCos);
        btnInverseCos.setOnClickListener(this);
        btnTan = findViewById(R.id.button_tan);
        btnTan.setOnClickListener(this);
        btnInverseTan = findViewById(R.id.button_inverseTan);
        btnInverseTan.setOnClickListener(this);
        btnNaturalLog = findViewById(R.id.button_naturalLog);
        btnNaturalLog.setOnClickListener(this);
        btnHyperSin = findViewById(R.id.button_hyperSin);
        btnHyperSin.setOnClickListener(this);
        btnLog = findViewById(R.id.button_log);
        btnLog.setOnClickListener(this);
        btnHyperCos = findViewById(R.id.button_hyperCos);
        btnHyperCos.setOnClickListener(this);
        btnInvert = findViewById(R.id.button_invert);
        btnInvert.setOnClickListener(this);
        btnHyperTan = findViewById(R.id.button_hyperTan);
        btnHyperTan.setOnClickListener(this);
        btne = findViewById(R.id.button_e);
        btne.setOnClickListener(this);
        btneExponent = findViewById(R.id.button_eExponent);
        btneExponent.setOnClickListener(this);
        btnInverseHyperSin = findViewById(R.id.button_inverseHyperSin);
        btnInverseHyperSin.setOnClickListener(this);
        btnSquared = findViewById(R.id.button_squared);
        btnSquared.setOnClickListener(this);
        btnInverseHyperCos = findViewById(R.id.button_inverseHyperCos);
        btnInverseHyperCos.setOnClickListener(this);
        btnXPowerY = findViewById(R.id.button_XPowerY);
        btnXPowerY.setOnClickListener(this);
        btnInverseHyperTan = findViewById(R.id.button_inverseHyperTan);
        btnInverseHyperTan.setOnClickListener(this);
        btnAbsoluteValue = findViewById(R.id.button_absoluteValue);
        btnAbsoluteValue.setOnClickListener(this);
        btn2PowerX = findViewById(R.id.button_2PowerX);
        btn2PowerX.setOnClickListener(this);
        btnPi = findViewById(R.id.button_pi);
        btnPi.setOnClickListener(this);
        btnCubed = findViewById(R.id.button_cubed);
        btnCubed.setOnClickListener(this);
        btnFactorial = findViewById(R.id.button_factorial);
        btnFactorial.setOnClickListener(this);

        btnSwap = findViewById(R.id.button_swap);
        btnSwap.setOnClickListener(this);
        btnBackspace = findViewById(R.id.button_backspace);
        btnBackspace.setOnClickListener(this);
    }

    private void addText(String text) {
        String str = currNum.getText().toString();
        if (str.equals("0") || str.equals("Error")) {
            if (text.equals(".0")) {
                str += text;
                currNum.setText(str);
                return;
            }
            currNum.setText(text);
            return;
        }
        str+=text;
        currNum.setText(str);
    }

    @Override
    public void onClick(View view) {
        boolean doEval = true;
        System.out.println("Click");
        switch (view.getId()) {
            case R.id.button_0:
                addText("0");
                break;
            case R.id.button_1:
                addText("1");
                break;
            case R.id.button_2:
                addText("2");
                break;
            case R.id.button_3:
                addText("3");
                break;
            case R.id.button_4:
                addText("4");
                break;
            case R.id.button_5:
                addText("5");
                break;
            case R.id.button_6:
                addText("6");
                break;
            case R.id.button_7:
                addText("7");
                break;
            case R.id.button_8:
                addText("8");
                break;
            case R.id.button_9:
                addText("9");
                break;
            case R.id.button_add:
                addText("+");
                break;
            case R.id.button_minus:
                addText("-");
                break;
            case R.id.button_multiply:
                addText("*");
                break;
            case R.id.button_divide:
                addText("÷");
                break;
            case R.id.button_equals:
                String result;
                try {
                    result = evaluate(currNum.getText().toString().replaceAll("÷", "/"));
                    currNum.setText(result);
                    if (showPrevCalc) {
                        prevCalc.setText(prevCalcValue);
                        prevCalc.setVisibility(View.VISIBLE);
                    }
                    showPrevCalc = true;
                    prevCalcValue = result;
                } catch (ScriptException e) {
                    currNum.setText("Error");
                }
                currCalc.setVisibility(View.INVISIBLE);

                doEval = false;
                break;
            case R.id.button_clear:
                currNum.setText("0");
                currCalc.setVisibility(View.INVISIBLE);
                doEval = false;
                break;
            case R.id.button_pi:
                addText("3.14159");
                break;
            case R.id.button_bracket:
                str = currNum.getText().toString();
                int ascii = str.charAt(str.length()-1);
                if (ascii < 48 || ascii > 57)
                    break;
                str = "("+str+")";
                currNum.setText(str);
                break;
            case R.id.button_decimal:
                addText(".0");
                break;
            case R.id.button_percent:
                addText("÷100");
                try {
                    result = evaluate(currNum.getText().toString().replaceAll("÷", "/"));
                    currNum.setText(result);
                } catch (ScriptException e) {
                    currNum.setText("Error");
                }
                currCalc.setVisibility(View.INVISIBLE);
                doEval = false;
                break;
            case R.id.button_sign:
                str = currNum.getText().toString();
                if (str.equals("0"))
                    break;
                if (str.charAt(0) == '-') {
                    str = str.substring(1, str.length());
                } else {
                    str = "-"+str;
                }
                currNum.setText(str);
                break;
            case R.id.button_mode:
                break;
            case R.id.button_squareRoot:
                break;
            case R.id.button_cubeRoot:
                break;
            case R.id.button_log:
                break;
            case R.id.button_naturalLog:
                break;
            case R.id.button_sin:
                break;
            case R.id.button_cos:
                break;
            case R.id.button_tan:
                break;
            case R.id.button_inverseSin:
                break;
            case R.id.button_inverseCos:
                break;
            case R.id.button_inverseTan:
                break;
            case R.id.button_hyperSin:
                break;
            case R.id.button_hyperCos:
                break;
            case R.id.button_hyperTan:
                break;
            case R.id.button_inverseHyperSin:
                break;
            case R.id.button_inverseHyperCos:
                break;
            case R.id.button_inverseHyperTan:
                break;
            case R.id.button_invert:
                break;
            case R.id.button_eExponent:
                addText("2.71828");
                break;
            case R.id.button_XPowerY:
                break;
            case R.id.button_2PowerX:
                break;
            case R.id.button_squared:
                break;
            case R.id.button_cubed:
                break;
            case R.id.button_factorial:
                break;
            case R.id.button_absoluteValue:
                break;
            case R.id.button_swap:
                if (btnSin.getVisibility() == View.VISIBLE) {
                    btnSquareRoot.setVisibility(View.GONE);
                    btnCubeRoot.setVisibility(View.VISIBLE);

                    btnSin.setVisibility(View.GONE);
                    btnCos.setVisibility(View.GONE);
                    btnTan.setVisibility(View.GONE);
                    btnInverseSin.setVisibility(View.VISIBLE);
                    btnInverseCos.setVisibility(View.VISIBLE);
                    btnInverseTan.setVisibility(View.VISIBLE);

                    btnNaturalLog.setVisibility(View.GONE);
                    btnLog.setVisibility(View.GONE);
                    btnInvert.setVisibility(View.GONE);
                    btnHyperSin.setVisibility(View.VISIBLE);
                    btnHyperCos.setVisibility(View.VISIBLE);
                    btnHyperTan.setVisibility(View.VISIBLE);

                    btneExponent.setVisibility(View.GONE);
                    btnSquared.setVisibility(View.GONE);
                    btnXPowerY.setVisibility(View.GONE);
                    btnInverseHyperSin.setVisibility(View.VISIBLE);
                    btnInverseHyperCos.setVisibility(View.VISIBLE);
                    btnInverseHyperTan.setVisibility(View.VISIBLE);

                    btnAbsoluteValue.setVisibility(View.GONE);
                    btnPi.setVisibility(View.GONE);
                    btne.setVisibility(View.GONE);
                    btn2PowerX.setVisibility(View.VISIBLE);
                    btnCubed.setVisibility(View.VISIBLE);
                    btnFactorial.setVisibility(View.VISIBLE);
                    break;
                }
                btnSquareRoot.setVisibility(View.VISIBLE);
                btnCubeRoot.setVisibility(View.GONE);

                btnSin.setVisibility(View.VISIBLE);
                btnCos.setVisibility(View.VISIBLE);
                btnTan.setVisibility(View.VISIBLE);
                btnInverseSin.setVisibility(View.GONE);
                btnInverseCos.setVisibility(View.GONE);
                btnInverseTan.setVisibility(View.GONE);

                btnNaturalLog.setVisibility(View.VISIBLE);
                btnLog.setVisibility(View.VISIBLE);
                btnInvert.setVisibility(View.VISIBLE);
                btnHyperSin.setVisibility(View.GONE);
                btnHyperCos.setVisibility(View.GONE);
                btnHyperTan.setVisibility(View.GONE);

                btneExponent.setVisibility(View.VISIBLE);
                btnSquared.setVisibility(View.VISIBLE);
                btnXPowerY.setVisibility(View.VISIBLE);
                btnInverseHyperSin.setVisibility(View.GONE);
                btnInverseHyperCos.setVisibility(View.GONE);
                btnInverseHyperTan.setVisibility(View.GONE);

                btnAbsoluteValue.setVisibility(View.VISIBLE);
                btnPi.setVisibility(View.VISIBLE);
                btne.setVisibility(View.VISIBLE);
                btn2PowerX.setVisibility(View.GONE);
                btnCubed.setVisibility(View.GONE);
                btnFactorial.setVisibility(View.GONE);
                break;
            case R.id.button_backspace:
                str = currNum.getText().toString();
                if(str.length() == 0)
                    break;
                str = str.substring(0, str.length() - 1);
                currNum.setText(str);
                break;
        }
        if (!currNum.getText().toString().equals("0") && doEval == true)
            autoEval();
    }
    public void autoEval() {
        try {
            String autoResult = evaluate(currNum.getText().toString().replaceAll("÷", "/"));
            currCalc.setText(autoResult);
            currCalc.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            currCalc.setVisibility(View.INVISIBLE);
        }
    }

    public String evaluate(String expression) throws ScriptException {
        mathCalc=new ScriptEngineManager().getEngineByName("rhino");
        String result = mathCalc.eval(expression).toString();

        BigDecimal decimal = new BigDecimal(result);
        BigDecimal one = new BigDecimal("1.0");

        if(decimal.remainder(one).equals(one.subtract(one)))
            return decimal.setScale(0).toPlainString();
        return decimal.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
    }



}