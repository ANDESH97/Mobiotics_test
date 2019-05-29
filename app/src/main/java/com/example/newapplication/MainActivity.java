package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Main Activity";

    private Button encrypt, decrypt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }


    /**
     * Initialize Widgets.
     */
    private void init()
    {
        encrypt = findViewById(R.id.encrypt_button);
        decrypt = findViewById(R.id.decrypt_button);

        encrypt.setOnClickListener(this);
        decrypt.setOnClickListener(this);
    }

    /**
     * Override onClick method.
     */

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.encrypt_button:
            {
                startActivity(new Intent(this, EncryptActivity.class));
            }
            break;

            case R.id.decrypt_button:
            {
                startActivity(new Intent(this, DecryptActivity.class));
            }
        }
    }
}
