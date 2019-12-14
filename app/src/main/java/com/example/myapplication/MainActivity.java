package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.adapters.ItemsAdapter;
import com.example.myapplication.model.ItemModel;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {

    private static final String HI = "https://gist.githubusercontent.com/iranjith4/522d5b466560e91b8ebab54743f2d0fc/raw/7b108e4aaac287c6c3fdf93c3343dd1c62d24faf/radius-mobile-intern.json";
    private RecyclerView rv;
    private ArrayList<ItemModel> list_data;
    private ItemsAdapter adapter;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=(RecyclerView)findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        list_data=new ArrayList<ItemModel>();
        adapter=new ItemsAdapter(this,list_data);

        getData();
        Log.e("Array1",""+"yes1");

    }

    private void getData() {
        Log.e("Array2",""+"yes2");

        StringRequest stringRequest=new StringRequest(Request.Method.GET, HI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    Log.e("Array","0"+jsonObject);

                    //JSONArray array=jsonObject.getJSONArray("trips");
                   // Log.e("chk",jsonObject.getString("data"));

                    JSONObject jsonObject1=jsonObject.getJSONObject("data");
                    JSONObject jsonObjectprofile=jsonObject1.getJSONObject("profile");
                    Log.e( "onResponse: ", jsonObjectprofile.getString("first_name"));

                    JSONObject jsonObjectstats=jsonObject1.getJSONObject("stats");
                    Log.e("ride",jsonObjectstats.getString("rides"));

                    JSONObject jsonObjectstats_credits=jsonObjectstats.getJSONObject("credits");
                    Log.e("values",jsonObjectstats_credits.getString("value"));

                    JSONArray jsonArraytrips=jsonObject1.getJSONArray("trips");
                    JSONObject jo=jsonArraytrips.getJSONObject(0);
                    Log.e("jo",""+jsonArraytrips.getJSONObject(0));
                   // JSONArray jsonArray
                  //  Log.e( "onResponse: ", jsonObject1);

                    for (int i=0; i<jsonArraytrips.length(); i++){
                        JSONObject ob=jsonArraytrips.getJSONObject(i);
                        Log.e("array",""+jsonArraytrips.getJSONObject(i));

                        JSONObject jsob=ob.getJSONObject("cost");
                        Log.e("costs",""+jsob);
                        Log.e("costs",""+ob.getJSONObject("cost"));

                       Log.e("vaal",""+jsob.getString("value"));
                      /*  ItemModel ld=new ItemModel(ob.getString("from"),ob.getString("to"),ob.getString("from_time"),ob.getString("to_time"));
                        list_data.add(ld);
                    */}
                   // rv.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("",""+error);
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
