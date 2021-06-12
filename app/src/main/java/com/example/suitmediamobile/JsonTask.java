package com.example.suitmediamobile;

import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class JsonTask extends AsyncTask<Void, Void, Void> {

    ArrayList<Guest> guestsList = null;
    int[] imgsrc = {R.drawable.guest1, R.drawable.guest2, R.drawable.guest3, R.drawable.guest4, R.drawable.guest5, R.drawable.guest6};

    @Override
    protected Void doInBackground(Void... voids) {
        String data="";
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;

        try {
            URL url = new URL("http://www.mocky.io/v2/596dec7f0f000023032b8017");
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(stream));

            String line = "";

            while (line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            guestsList = new ArrayList<>();
            JSONArray JA = new JSONArray(data);
            for (int i=0;i<JA.length();i++){
                Guest guest = new Guest();
                JSONObject JO = (JSONObject) JA.get(i);
                //{"id":5,"name":"Joko","birthdate":"2014-02-12"}
                guest.setName(JO.getString("name"));
                guest.setId(JO.getInt("id"));
                guest.setBirthdate(JO.getString("birthdate"));
                guest.setGuestImage(imgsrc[i]);
                guestsList.add(guest);
            }


        } catch (MalformedURLException | JSONException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection !=null){
                connection.disconnect();
            }
            try {
                if (bufferedReader!=null){
                    bufferedReader.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        GuestActivity.guestList1 = guestsList;
        GuestActivity.guestList1.addAll(guestsList);

    }
}
