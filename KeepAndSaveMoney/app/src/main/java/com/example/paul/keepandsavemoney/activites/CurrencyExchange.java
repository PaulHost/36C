package com.example.paul.keepandsavemoney.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.paul.keepandsavemoney.R;
import com.example.paul.keepandsavemoney.adapters.CurrenceListAdapter;
import com.example.paul.keepandsavemoney.api.ParsingCurrency;
import com.example.paul.keepandsavemoney.beans.Currency;
import com.example.paul.keepandsavemoney.interfaces.ISuccess;

import java.util.List;

public class CurrencyExchange extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_exchange);
        final ListView listView = (ListView) findViewById(R.id.listView);

        new ParsingCurrency().currencyList(new ISuccess<List<Currency>>() {
            @Override
            public void onSuccess(List<Currency> currencies) {
                listView.setAdapter(new CurrenceListAdapter(CurrencyExchange.this, currencies));
            }
        });
    }
}
