package com.example.calorietrackerapp;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DailyDietFragment extends Fragment {
    View vDisplayUnit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        vDisplayUnit = inflater.inflate(R.layout.dailydiet_fragment, container, false);


        List<String> list = new ArrayList<String>();
        list.add("Fruits");
        list.add("Indian");
        list.add("Continental");
        list.add("Sweets");
        list.add("Vegetable");
        list.add("Fried");
        list.add("Cheese");
        list.add("Beverage");
        list.add("Rice");


        final Spinner sFoodType = (Spinner) vDisplayUnit.findViewById(R.id.FoodType);
        final ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, list);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sFoodType.setAdapter(spinnerAdapter);


        sFoodType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedFoodType = parent.getItemAtPosition(position).toString();
                RequestQueue mque = Volley.newRequestQueue(getActivity().getApplicationContext());
                List<String> list2 = new ArrayList<String>();

                list2 =  parseFood(selectedFoodType);

                final Spinner sFood = (Spinner) vDisplayUnit.findViewById(R.id.Food);
                final ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, list2);
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sFood.setAdapter(spinnerAdapter);

            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        sFoodType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return vDisplayUnit;
    }

    public List<String> parseFood(String foodType) {
        String url = "http://192.168.1.118:8080/MyFitness/webresources/fitnesspal.foodtable/findByFoodCatogory/" + foodType;
        final List<String> list = new ArrayList<String>();

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                         {
                            try {

                                JSONArray jsonArray = response.getJSONArray(0);

                                for (int i = 0; i < jsonArray.length(); i++)
                                {
                                    JSONObject food = jsonArray.getJSONObject(i);
                                    list.add(food.getString("foodName"));


                                }
                            } catch (JSONException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }



                            }
                        },new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                error.printStackTrace();
                            }
                        });

        return list;
                    }
}




