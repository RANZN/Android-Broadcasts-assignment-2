package com.ranzan.androidbroadcastsassignment_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity2 extends AppCompatActivity {
    private EditText fName;
    private EditText lName;
    private EditText age;
    private EditText occupation;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ranzan.abcd");
                intent.putExtra("fName", fName.getText().toString());
                intent.putExtra("lName", lName.getText().toString());
                intent.putExtra("age", age.getText().toString());
                intent.putExtra("occ", occupation.getText().toString());
                LocalBroadcastManager.getInstance(MainActivity2.this).sendBroadcast(intent);
            }
        });


    }

    private void initViews() {
        fName = findViewById(R.id.etFname);
        lName = findViewById(R.id.etLname);
        age = findViewById(R.id.etage);
        occupation = findViewById(R.id.etocc);
        button = findViewById(R.id.btn2);
    }
}