package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EncryptActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Encrypt Activity";

    private Button submit;

    private TextView result;

    private EditText input;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);

        init();
    }

    /**
     * Initialize widgets.
     */

    private void init()
    {
        submit = findViewById(R.id.submit_button);

        result = findViewById(R.id.tv_result);

        input = findViewById(R.id.tv_encrypt);
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
                    submit.setOnClickListener(EncryptActivity.this);
                }
            }
        });

        submit.setOnClickListener(EncryptActivity.this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.submit_button)
        {
            encryptString(input.getText().toString());
        }
    }

    private void encryptString(String str)
    {
        String resultStr = "";

        String [] words = str.split(" ", 10);

        int n;

        int[] freq;

        for (String word : words)
        {
            n = word.length();
            freq = new int[26];

            for (int i = 0; i < n; i++)
            {
                freq[word.charAt(i) - 'a']++;
            }

            for (int i = 0; i < n; i++) {

                if (freq[word.charAt(i) - 'a'] != 0)
                {
                    resultStr += String.valueOf(word.charAt(i));
                    resultStr += String.valueOf(freq[word.charAt(i) - 'a']);
                    freq[word.charAt(i) - 'a'] = 0;
                }
            }
            resultStr += " ";

        }
        result.setText(resultStr);

    }
}
