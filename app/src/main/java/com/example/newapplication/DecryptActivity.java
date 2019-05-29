package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DecryptActivity extends AppCompatActivity implements View.OnClickListener {

    private Button submit;

    private TextView result;

    private EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);

        init();
    }

    /**
     * Initialize Widgets
     */

    private void init()
    {
        submit = findViewById(R.id.submit_button1);

        input = findViewById(R.id.et_decrypt);
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                submit.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                result.setText("");
                if(s.toString().isEmpty()){
                    submit.setEnabled(false);
                } else {
                    submit.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().isEmpty()){
                    submit.setEnabled(false);
                } else {
                    submit.setEnabled(true);
                    submit.setOnClickListener(DecryptActivity.this);
                }
            }
        });

        result = findViewById(R.id.tv_result1);

        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.submit_button1)
        {
            decryptString(input.getText().toString());
        }
    }

    private void decryptString(String str)
    {
        String [] words = str.split(" ", 10);

        int n;

        String compiledStr = "";

        for(String word: words)
        {
            n = word.length();

            for(int i=0; i<n; i=i+2)
            {
                if(i+1 < n)
                {
                    for(int j = 0; j< Character.getNumericValue(word.charAt(i + 1)); j++)
                    {
                        compiledStr = compiledStr + word.charAt(i);
                    }
                }
            }

            compiledStr += " ";
        }

        result.setText(compiledStr);
    }
}
