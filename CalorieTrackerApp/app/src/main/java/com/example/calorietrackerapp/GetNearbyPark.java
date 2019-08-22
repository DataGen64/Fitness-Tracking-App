package com.example.calorietrackerapp;

import android.os.AsyncTask;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class GetNearbyPark extends AsyncTask <Object,String, String> {

    String placeData;
    GoogleMap mMap;
    String url;

    @Override
    protected String doInBackground(Object... objects) {

        mMap = (GoogleMap) objects[0];
        url = (String) objects[1];


        DownloadMapUrl downloadMapurl = new DownloadMapUrl();
        try {
            placeData = downloadMapurl.readURL(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return placeData;
    }

    @Override
    protected void onPostExecute(String s) {
       List<HashMap<String, String>> nearbyPlace = null;
        MapDataParser parser = new MapDataParser();
        nearbyPlace = parser.parse(s);
        showNearbyPark(nearbyPlace);
    }

    private void showNearbyPark(List<HashMap<String,String>> nearbyPlace){


        for (int i=0 ; i<nearbyPlace.size(); i++){

            MarkerOptions markeroptions = new MarkerOptions();
            HashMap<String, String> googlePlace = nearbyPlace.get(i);

            String placeName = googlePlace.get("place_name");
            String vicinity =googlePlace.get("vicinity");
            double lat = Double.parseDouble(googlePlace.get("lat"));
            double lng = Double.parseDouble(googlePlace.get("lng"));

            LatLng latlnt = new LatLng(lat, lng);
            markeroptions.position((new LatLng(lat, lng)));
            markeroptions.title((placeName+" : "+vicinity));
            markeroptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));

            mMap.addMarker(markeroptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLng((latlnt)));
            mMap.animateCamera((CameraUpdateFactory.zoomTo(10)));

        }


    }

}
