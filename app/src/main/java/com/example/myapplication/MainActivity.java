package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.adapters.ItemsAdapter;
import com.example.myapplication.model.ItemModel;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String HI = "https://gist.githubusercontent.com/iranjith4/522d5b466560e91b8ebab54743f2d0fc/raw/7b108e4aaac287c6c3fdf93c3343dd1c62d24faf/radius-mobile-intern.json";
    private RecyclerView rv;
    private ArrayList<ItemModel> list_data=new ArrayList<>();
    private ItemsAdapter adapter;
    Context context;

    ImageView profile_pic;
    private ImageView mTvBack;
    /**
     * My Profile
     */
    private TextView mTxtTitleBar;
    private ImageView mBtnOpenDrawer;
    private CircleImageView mProfilePic;
    /**
     * Canada
     */
    private TextView mName;
    /**
     * Canada
     */
    private TextView mAddress;
    private RelativeLayout mPersonInfo;
    /**
     * Rides
     */
    private TextView mRides;
    /**
     * 67
     */
    private TextView mRidesCount;
    /**
     * Free Rides
     */
    private TextView mFreeRides;
    /**
     * 67
     */
    private TextView mFreeridesCount;
    /**
     * Credits
     */
    private TextView mCredits;
    /**
     * 67
     */
    private TextView mCreditsCount;
    private RelativeLayout originalToolbar,layout;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        listener();

        rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        list_data = new ArrayList<ItemModel>();

        new ArrayList<ItemModel>();

        adapter=new ItemsAdapter(this,list_data);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                RecyclerView.VERTICAL, false));

        getData();

    }

    private void listener() {
        mTvBack.setOnClickListener(this);
        mBtnOpenDrawer.setOnClickListener(this);
    }

    private void getData() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, HI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                    JSONObject jsonObjectprofile = jsonObject1.getJSONObject("profile");

                    String url="https://randomuser.me/api/portraits/men/78.jpg";
                    Picasso.with(MainActivity.this).load(url).placeholder(R.drawable.ic_launcher_background).into(mProfilePic);
                    mName.setText(jsonObjectprofile.getString("first_name") + " " + jsonObjectprofile.getString("last_name"));
                    mAddress.setText(jsonObjectprofile.getString("city") + ", " + jsonObjectprofile.getString("Country"));

                    JSONObject jsonObjectstats = jsonObject1.getJSONObject("stats");
                    mRidesCount.setText(jsonObjectstats.getString("rides"));
                    mFreeridesCount.setText(jsonObjectstats.getString("free_rides"));

                    JSONObject jsonObjectstats_credits = jsonObjectstats.getJSONObject("credits");
                    mCreditsCount.setText(jsonObjectstats_credits.getString("currency_symbol") + jsonObjectstats_credits.getString("value"));

                    JSONArray jsonArraytrips = jsonObject1.getJSONArray("trips");

                    for (int i = 0; i < jsonArraytrips.length(); i++) {

                        JSONObject ob = jsonArraytrips.getJSONObject(i);
                        Log.e("array", "" + jsonArraytrips.getJSONObject(i));
                        JSONObject jsob = ob.getJSONObject("cost");

                        //1574618400;

                        ItemModel itemModel=new ItemModel(ob.getString("from"),ob.getString("from_time"),ob.getString("to"),ob.getString("to_time"),jsob,jsob.getString("value"),jsob.getString("currency_symbol"),"Travel time : "+ob.getString("trip_duration_in_mins")+" min");

                        list_data.add(itemModel);
                    }

                    //Fetch Color

                    JSONObject jsonObjecttheme = jsonObject1.getJSONObject("theme");

                    originalToolbar.setBackgroundColor(Color.parseColor(jsonObjecttheme.getString("light_colour")));
                    layout.setBackgroundColor(Color.parseColor(jsonObjecttheme.getString("dark_colour")));

                rv.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("", "" + error);
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void initView() {
        mTvBack = (ImageView) findViewById(R.id.tv_back);
        mTxtTitleBar = (TextView) findViewById(R.id.txtTitleBar);
        mBtnOpenDrawer = (ImageView) findViewById(R.id.btn_openDrawer);
        mProfilePic = (CircleImageView) findViewById(R.id.profile_pic);
        mName = (TextView) findViewById(R.id.name);
        mAddress = (TextView) findViewById(R.id.address);
        mPersonInfo = (RelativeLayout) findViewById(R.id.person_info);
        mRides = (TextView) findViewById(R.id.rides);
        mRidesCount = (TextView) findViewById(R.id.rides_count);
        mFreeRides = (TextView) findViewById(R.id.free_rides);
        mFreeridesCount = (TextView) findViewById(R.id.freerides_count);
        mCredits = (TextView) findViewById(R.id.credits);
        mCreditsCount = (TextView) findViewById(R.id.credits_count);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        originalToolbar = findViewById(R.id.originalToolbar);
        layout = findViewById(R.id.layout);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tv_back:
                onBackPressed();
                break;

            case R.id.btn_openDrawer:
                Toast.makeText(MainActivity.this,"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
