package com.example.calorietrackerapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapDataParser {

    private HashMap<String, String> getPlace(JSONObject googlePlaceJson){

        HashMap<String, String> googlePlaceMap = new HashMap<>();
        String placeName = "-NA-";
        String vicinity = "";
        String latitude = "";
        String longitude = "";
        String reference = "";


        try {
        if (!googlePlaceJson.isNull("name"))
        {
                placeName = googlePlaceJson.getString("name");
        }
            if (!googlePlaceJson.isNull("vicinity"))
            {
                vicinity = googlePlaceJson.getString("vicinity");

                latitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lat");
                longitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lng");

                reference = googlePlaceJson.getString("reference");
                googlePlaceMap.put("place_name", placeName);
                googlePlaceMap.put("vicinity", vicinity);
                googlePlaceMap.put("latitude", latitude);
                googlePlaceMap.put("longitude", longitude);
                googlePlaceMap.put("reference", reference);


            }
        }

        catch (JSONException e)
        {
                e.printStackTrace();

         }

       return googlePlaceMap;

    }

    private List<HashMap<String, String > > getPlace(JSONArray jsonArray) {
        int count = jsonArray.length();
        List<HashMap<String, String>> placesList = new ArrayList<>();
        HashMap<String, String> placeMap = null;

        for (int i = 0; i < count; i++) {

            try {
                placeMap = getPlace((JSONObject) jsonArray.get(i));
                placesList.add(placeMap);

            } catch (JSONException e) {
                e.printStackTrace();
            }



        }
        return placesList;
    }

    public List<HashMap<String,String>> parse(String jsonData){


            JSONArray jsonarray = null;
            JSONObject jsonobject;

            try {
                jsonobject = new JSONObject(jsonData);
                jsonarray = jsonobject.getJSONArray("results");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return getPlace(jsonarray);

        }


    }




