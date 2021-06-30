package com.example.weatherapp1;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {
    private String mtemperature, micon, mcity, mweathertype;
    private int mcondition;

    public static weatherData fromJson(JSONObject jsonObject) {

        try {
            weatherData weatherD = new weatherData();
            weatherD.mcity = jsonObject.getString("name");
            weatherD.mcondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mweathertype = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.micon = updateweatherIcon(weatherD.mcondition);
            double tempresult = jsonObject.getJSONObject("main").getDouble("temp") - 273.15;
            int roundedvalue = (int)Math.rint(tempresult);
            weatherD.mtemperature = Integer.toString(roundedvalue);
            return weatherD;
        }

        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String updateweatherIcon(int condition)
    {
        if (condition >= 0 && condition <= 300) {
            return "thunderstrom1";
        } else if (condition >= 300 && condition <= 500) {
            return "lightrain";
        } else if (condition >= 500 && condition <= 600) {
            return "shower";
        } else if (condition >= 600 && condition <= 700) {
            return "snow2";
        } else if (condition >= 701 && condition <= 771) {
            return "fog";
        } else if (condition >= 772 && condition <= 800) {
            return "overcast";
        } else if (condition == 800) {
            return "sunny";
        } else if (condition >= 801 && condition <= 804) {
            return "cloudy";
        } else if (condition >= 900 && condition <= 902) {
            return "lightrain";
        } else if (condition == 903) {
            return "snow1";
        } else if (condition == 904) {
            return "sunny";
        } else if (condition >= 905 && condition <= 1000) {
            return "thunderstorm2";
        }

        return "finding";
    }

    public String getMtemperature() {
        return mtemperature + "°C";
    }

    public String getMicon() {
        return micon;
    }

    public String getMcity() {
        return mcity;
    }

    public String getMweathertype() {
        return mweathertype;

    }
}
