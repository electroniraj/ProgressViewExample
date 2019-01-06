package com.example.niraj.progressviewexample;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button p1, p2;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1 = findViewById(R.id.progress1);
        p2 = findViewById(R.id.progress2);


    }

    public void circular(View view) {
        Toast.makeText(getApplicationContext(), "Circular Clicked", Toast.LENGTH_SHORT).show();
        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog = ProgressDialog.show(MainActivity.this, "Loading", "Upgrading", false, false);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.show();
    }

    public void horizontal(View view) {
        Toast.makeText(getApplicationContext(), "Horizontal Clicked", Toast.LENGTH_SHORT).show();
        final ProgressDialog pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setTitle("Loading");
        pDialog.setMessage("Please wait...");
        pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pDialog.setMax(100);
        pDialog.setProgress(0);
        pDialog.getWindow().setGravity(Gravity.CENTER);
        pDialog.setCancelable(true);
        pDialog.setCanceledOnTouchOutside(true);
        pDialog.show();

        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(100);

                    } catch (Exception e) {
                        e.printStackTrace();

                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pDialog.setProgress(i);
                        }
                    });
                    if (i == 100) {
                        pDialog.dismiss();
                    }
                }
            }

        }).start();
    }
}
