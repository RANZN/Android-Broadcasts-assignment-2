package com.ranzan.androidbroadcastsassignment_2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {
    private TextView fName;
    private TextView lName;
    private TextView age;
    private TextView occ;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });
        IntentFilter intentFilter = new IntentFilter("com.ranzan.abcd");
        LocalBroadcastManager.getInstance(this).registerReceiver(new BroadcastReceiver(), intentFilter);
    }

    private void initViews() {
        fName = findViewById(R.id.Fname);
        lName = findViewById(R.id.Lname);
        age = findViewById(R.id.age);
        occ = findViewById(R.id.occ);
        btn = findViewById(R.id.btn1);
    }

    private class BroadcastReceiver extends android.content.BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                fName.setText(intent.getStringExtra("fName"));
                lName.setText(intent.getStringExtra("lName"));
                age.setText(intent.getStringExtra("age"));
                occ.setText(intent.getStringExtra("occ"));

            }
        }
    }
}