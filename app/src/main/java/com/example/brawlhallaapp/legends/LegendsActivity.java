package com.example.brawlhallaapp.legends;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.brawlhallaapp.APIKeys;
import com.example.brawlhallaapp.R;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class LegendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legends);
        final ScrollView scroll = (ScrollView) this.findViewById(R.id.scrollView);
        final LinearLayout legendsList = (LinearLayout) this.findViewById(R.id.LegendsLinearLayout);

        //Create the API call using volley.
        RequestQueue queue = Volley.newRequestQueue(this);
       //create the API object that holds the api class. I believe this will make everything private.
        APIKeys key = new APIKeys();

        //Holds the API URL.
        String apiURL = ("https://api.brawlhalla.com/legend/all/?api_key=" + key.getKey());
        Log.i("URL", apiURL);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, apiURL, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.i("API CALL CORRECT.", "Response: " + response.toString());

                        for(int i = 0; i < response.length(); i++) {
                            JSONObject legend;
                            try {
                                legend = response.getJSONObject(i);
                                Button legendButton = new Button(LegendsActivity.this);
                                legendButton.setText(legend.get("legend_name_key").toString());
                                legendsList.addView(legendButton);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("API CALL ERROR STATUS", error.toString());
                        TextView errorMessage = new TextView(LegendsActivity.this);
                        errorMessage.setText("Error connecting to the Internet.");
                        legendsList.addView(errorMessage);

                    }
                });






        queue.add(jsonArrayRequest);

        Log.i("API CALL" , "Request added");



        //scroll.addView(tv1);
    }




}