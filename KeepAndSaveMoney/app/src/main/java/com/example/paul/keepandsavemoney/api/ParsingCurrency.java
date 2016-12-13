package com.example.paul.keepandsavemoney.api;

import android.os.Handler;
import android.os.Looper;

import com.example.paul.keepandsavemoney.beans.Currency;
import com.example.paul.keepandsavemoney.interfaces.ISuccess;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.paul.keepandsavemoney.Constants.BANK_API_URL;
import static com.example.paul.keepandsavemoney.Constants.GET;

/**
 * Created by paul on 12.12.16.
 */

public class ParsingCurrency {

    private List<Currency> currences = new ArrayList<Currency>();
    Handler handler = new Handler(Looper.myLooper());


public void currencyList(final ISuccess<List<Currency>> success) {
        new ApiConnection().connect(BANK_API_URL, GET, new ISuccess<String>() {
            @Override
            public void onSuccess(String s) {
                try {
                    JSONArray items = new JSONArray(s);
                    for (int i = 0; i < items.length(); i++) {
                        Currency currency = new Currency();
                        JSONObject item = (JSONObject) items.getJSONObject(i);
//                        EXCHANGE_DETA = item.getString("Date");
                        currency.setAbbreviation(item.getString("Cur_Abbreviation"));
                        currency.setScale(item.getString("Cur_Scale"));
                        currency.setName(item.getString("Cur_Name"));
                        currency.setOfficialRate(item.getString("Cur_OfficialRate"));
                        currences.add(currency);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        success.onSuccess(currences);
                    }
                });
            }
        });
    }
}
