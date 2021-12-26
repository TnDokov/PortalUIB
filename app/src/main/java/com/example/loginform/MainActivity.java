package com.example.loginform;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nim = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        Button login = (Button) findViewById(R.id.login);
        progressDialog = new ProgressDialog(MainActivity.this);

        TextView forget = (TextView) findViewById(R.id.forgetpassword);

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( MainActivity.this, forgotpassword.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String snim = nim.getText().toString();
                String spass = password.getText().toString();
                CheckLogin(snim,spass);
            }
        });
    }


    public void CheckLogin(final String nim , final String password){
        if(checkNetworkConnection()){
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, ContractDB.LOGIN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String resp = jsonObject.getString("server_response");
                                if (resp.equals("[{\"status\":\"OK\"}]")){
                                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_LONG).show();
                                    Intent i = new Intent( MainActivity.this, DashboardActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("nama","Louis Vernando");
                                    bundle.putString("npm",nim);
                                    i.putExtras(bundle);
                                    startActivity(i);
                                } else {
                                    Toast.makeText(getApplicationContext(),"Login Gagal", Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
                @Override
                protected Map<String,String> getParams() throws AuthFailureError{
                    Map<String,String> params = new HashMap<>();
                    params.put("nim",nim);
                    params.put("password",password);
                    return params;
                }
            };
        VolleyConnection.getInstance(MainActivity.this).addtorequestqueue(stringRequest);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.cancel();
            }
        },2000);
        }else{
            Toast.makeText(getApplicationContext(),"Tidak ada koneksi Internet",Toast.LENGTH_LONG).show();
        }
    }


     public boolean checkNetworkConnection(){
         ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
         NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
         return (networkInfo != null && networkInfo.isConnected());


     }


}