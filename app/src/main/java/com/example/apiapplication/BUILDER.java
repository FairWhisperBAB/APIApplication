package com.example.apiapplication;

import android.app.Activity;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class BUILDER
{
    public static final List<MODEL> ITEMS = new ArrayList<>();
    public static final Map<String, MODEL> MODEL_MAP = new HashMap<>();

    public static boolean active = false;

    public String setUp, punchLine;

    public void testAllThatJazz(Activity activity)
    {
        String url = "https://dad-jokes.p.rapidapi.com/random/joke";  // THAT should be in a strings.xml file!

        RequestQueue queue = Volley.newRequestQueue(activity);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        // NEXT, we need to use GSON to turn that JSON into a model
                        try
                        {
                            JSONArray object = response.getJSONArray("body");
                            //JSONArray array = object.getJSONArray("0");

                            for (int i = 0; i < object.length(); i++)
                            {
                                JSONObject zero = object.getJSONObject(i);

                                 setUp = zero.getString("setup");
                                 punchLine = zero.getString("punchline");

                            }

                            TextView setupTextView = activity.findViewById(R.id.SETUPtextView);
                            setupTextView.setText(setUp);

                            TextView punchLineTextView = activity.findViewById(R.id.PUNCHLINEtextView);
                            punchLineTextView.setText(punchLine);


                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                // you should drop a breakpoint RIGHT HERE if you need to see the error coming back
                error.printStackTrace();
            }
        })

        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {
                Map<String, String> header = new HashMap<>();
                header.put("X-RapidAPI-Key", "71842e3960msh987151c5c15ed2ep13efb9jsn9824476d4d66");
                header.put("X-RapidAPI-Host", "dad-jokes.p.rapidapi.com");
                return header;
            }
        };

        queue.add(request);
    }
}
