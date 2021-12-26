package com.example.loginform;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyConnection {

    private static VolleyConnection vInstance;
    private RequestQueue requestqueue;
    private static Context vCtx;

    private VolleyConnection (Context context){
        vCtx = context;
        requestqueue = getRequestqueue();
    }

    private RequestQueue getRequestqueue(){
        if(requestqueue == null ){
            requestqueue = Volley.newRequestQueue(vCtx.getApplicationContext());
        }
        return requestqueue;
    }

    public static synchronized VolleyConnection getInstance(Context context){

        if(vInstance == null){
            vInstance = new VolleyConnection(context);
        }
        return vInstance;
    }

    public<T> void addtorequestqueue (Request<T> request){
        getRequestqueue().add(request);
    }



}
