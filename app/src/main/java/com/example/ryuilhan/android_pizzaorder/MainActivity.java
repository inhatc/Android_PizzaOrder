package com.example.ryuilhan.android_pizzaorder;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    LinearLayout LL1;
    LinearLayout LL2;
    LinearLayout LL3;
    LinearLayout LL4;
    EditText ET1;
    EditText ET2;
    EditText ET3;
    CheckBox CB1;
    RadioGroup RG1;
    RadioButton RB1;
    RadioButton RB2;
    Button BT1;
    TextView TV1;
    TextView TV2;
    TextView TV3;
    ImageView IV1;
    int sum;
    double price;
    String option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RG1 = (RadioGroup) findViewById(R.id.RadioGroup1);
        RB1 = (RadioButton)findViewById(R.id.radioButton);
        RB2 = (RadioButton)findViewById(R.id.radioButton2);
        IV1 = (ImageView)findViewById(R.id.imageView);
        ET3 = (EditText)findViewById(R.id.editText3);
        RG1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(RB1.isChecked()){
                    IV1.setImageResource(R.drawable.pikle);
                    option = "피클을 선택했습니다.";
                }else if(RB2.isChecked()) {
                    IV1.setImageResource(R.drawable.so);
                    option = "소스를 선택했습니다.";
                }
            }
        });

        ET1 = (EditText)findViewById(R.id.editText);
        ET2 = (EditText)findViewById(R.id.editText2);

        BT1 = (Button)findViewById(R.id.button);
        TV1 = (TextView)findViewById(R.id.textView3);
        TV2 = (TextView)findViewById(R.id.textView4);
        TV3 = (TextView)findViewById(R.id.textView5);
        CB1 = (CheckBox)findViewById(R.id.checkBox);

        BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double pizza = Double.parseDouble(ET1.getText().toString());
                double spa = Double.parseDouble(ET2.getText().toString());
                double sal = Double.parseDouble(ET3.getText().toString());

                sum = Integer.parseInt(ET1.getText().toString()) + Integer.parseInt(ET2.getText().toString()) + Integer.parseInt(ET3.getText().toString());
                price = (pizza*16000)+(spa*11000)+(sal*4000);
                TV1.setText(Integer.toString(sum));
                TV3.setText(option);

                if(CB1.isChecked()){
                    price = price*0.93;
                    TV2.setText(Double.toString(price));
                }else {
                    TV2.setText(Double.toString(price));
                }
            }
        });



    }
}
