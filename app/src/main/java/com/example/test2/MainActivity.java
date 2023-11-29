package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity {

    private String serverIP = "192.168.10.102";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button1);
        Client client = new Client();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hello hello = client.hello;
            }
        });
    }
}