package com.flas.volleystudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue mQueue = Volley.newRequestQueue(MainActivity.this);
                StringRequest stringRequest = new StringRequest("https://wkxjc.github.io/test_string.txt",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(final String response) {
                                textView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        textView.setText(response);
                                    }
                                });
                            }
                        }, null);
                mQueue.add(stringRequest);
            }
        });
    }
}
