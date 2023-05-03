package com.example.practic1504.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.practic1504.R;

public class Adapter extends BaseAdapter {

    LayoutInflater inflator;
    String[] mCounting;

    public Adapter(Context context , String[] counting)
    {
        inflator = LayoutInflater.from(context);
        mCounting=counting;
    }

    @Override
    public int getCount()
    {
        return mCounting.length;
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = inflator.inflate(R.layout.spinadapt, null);
        TextView tv = (TextView) convertView.findViewById(R.id.tvCust);
        tv.setText(Integer.toString(position));
        return convertView;
    }
}
