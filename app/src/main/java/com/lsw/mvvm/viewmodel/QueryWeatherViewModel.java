package com.lsw.mvvm.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.lsw.mvvm.model.WeatherData;
import com.lsw.mvvm.model.WeatherInfo;

/**
 * Created by sweeneyliu on 2018/12/27.
 */
public class QueryWeatherViewModel {
    private static final String TAG = "QueryWeatherViewModel";

    public final ObservableBoolean loading = new ObservableBoolean(false);

    public final ObservableBoolean loadingSuccess = new ObservableBoolean(false);

    public final ObservableBoolean loadingFailure = new ObservableBoolean(false);

    public final ObservableField<String> city = new ObservableField<>();

    public final ObservableField<String> cityId = new ObservableField<>();

    public final ObservableField<String> temp1 = new ObservableField<>();

    public final ObservableField<String> temp2 = new ObservableField<>();

    public final ObservableField<String> weather = new ObservableField<>();

    public final ObservableField<String> time = new ObservableField<>();

    private String jsonData = "{\n" +
            "        \"city\":\"杭州\",\n" +
            "        \"cityid\":\"101210101\",\n" +
            "        \"temp1\":\"5℃\",\n" +
            "        \"temp2\":\"20℃\",\n" +
            "        \"weather\":\"晴转多云\",\n" +
            "        \"img1\":\"n0.gif\",\n" +
            "        \"img2\":\"d1.gif\",\n" +
            "        \"ptime\":\"18:00\"\n" +
            "    }";

    public QueryWeatherViewModel() {

    }

    public void queryWeather() {
        loading.set(true);
        loadingSuccess.set(false);
        loadingFailure.set(false);

        if (TextUtils.isEmpty(jsonData)) {
            loading.set(false);
            loadingFailure.set(true);
        } else {
            Gson gson = new Gson();
            WeatherInfo weatherInfo = gson.fromJson(jsonData, WeatherInfo.class);
            city.set(weatherInfo.getCity());
            cityId.set(weatherInfo.getCityid());
            temp1.set(weatherInfo.getTemp1());
            temp2.set(weatherInfo.getTemp2());
            weather.set(weatherInfo.getWeather());
            time.set(weatherInfo.getPtime());

            loading.set(false);
            loadingSuccess.set(true);

        }

    }
}
