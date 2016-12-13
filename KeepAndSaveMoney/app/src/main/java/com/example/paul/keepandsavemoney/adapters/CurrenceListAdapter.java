package com.example.paul.keepandsavemoney.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.paul.keepandsavemoney.R;
import com.example.paul.keepandsavemoney.beans.Currency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 13.12.16.
 */

public class CurrenceListAdapter extends BaseAdapter {

    private List<Currency> currencies = new ArrayList<Currency>();

    Context ctx;
    LayoutInflater lInflater;

    public CurrenceListAdapter(Context context, List<Currency> currencies) {
        ctx = context;
        this.currencies = currencies;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return currencies.size();
    }

    @Override
    public Object getItem(int position) {
        return currencies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.currensy_list_item, parent, false);
        }

        Currency c = currencies.get(position);

        ((TextView) view.findViewById(R.id.abbreviation)).setText(c.getAbbreviation());
        ((TextView) view.findViewById(R.id.name)).setText(c.getName());
        ((TextView) view.findViewById(R.id.scale)).setText(c.getScale());
        ((TextView) view.findViewById(R.id.rate)).setText(c.getOfficialRate());

        return view;
    }

}
