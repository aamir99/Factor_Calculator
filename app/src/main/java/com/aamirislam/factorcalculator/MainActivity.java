package com.aamirislam.factorcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public int num = 0;
    public EditText textField;
    ArrayList<Integer> factors;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.textField);
        textField = (EditText)findViewById(R.id.editText);
        Button btn = (Button)findViewById(R.id.button);
        factors = new ArrayList<>();
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                text.setText("");
                try {
                    num = Integer.parseInt(textField.getText().toString());

                int j = 0;
                for(int i = 2; i < num; i++){
                    if(num%i==0){
                        j++;
                        factors.add(i);
                    }
                }
                String output = "";
                if(j==0){
                    output = "The number " + num + " is a prime number.";
                    text.setText(output);
                }else if(j>1){
                    output = "The number " + num + " has " + j + " factors. They are: " + factors.toString();
                    output = output.replace("[","");
                    output = output.replace("]","");
                    text.setText(output);
                }else if(j==1){
                    output = "The number " + num + " has one factor. It is: " + factors.toString();
                    output = output.replace("[","");
                    output = output.replace("]","");
                    text.setText(output);
                }
                factors.clear();
                }catch(Exception ex){
                    text.setText("Please enter a valid integer value. The maximum input is 2^23-1");
                }
            }
        });






    }
}
