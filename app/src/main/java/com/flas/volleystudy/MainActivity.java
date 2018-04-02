package com.flas.volleystudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.text);

        requestString();//Volley请求String

//        requestJson();//Volley请求Json

//        requestJsonArray();//Volley请求JsonArray

//        requestStringPOST();//Volley POST数据

    }

    private void requestString() {
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

    private void requestJson() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue mQueue = Volley.newRequestQueue(MainActivity.this);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("https://wkxjc.github.io/test_json.json",
                        null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(final JSONObject response) {
                        textView.post(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(response.toString());
                            }
                        });
                    }
                }, null);
                mQueue.add(jsonObjectRequest);
            }
        });
    }

    private void requestJsonArray() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue mQueue = Volley.newRequestQueue(MainActivity.this);
                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("https://wkxjc.github.io/test_json_array.json",
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(final JSONArray response) {
                                textView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        textView.setText(response.toString());
                                    }
                                });
                            }
                        },null);
                mQueue.add(jsonArrayRequest);
            }
        });
    }

    private void requestStringPOST() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue mQueue = Volley.newRequestQueue(MainActivity.this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://wkxjc.github.io/test_post.txt",
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
                        }, null) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> map = new HashMap<>();
                        map.put("params1", "value1");
                        map.put("params2", "value2");
                        return map;
                    }
                };
                mQueue.add(stringRequest);
            }
        });
    }
}

