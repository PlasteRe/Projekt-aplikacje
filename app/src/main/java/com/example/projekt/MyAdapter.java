package com.example.projekt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    Context context;
    int [] zdjecia;
    String [] opisy;
    LayoutInflater layoutInflater;
    ImageView imageView;
    TextView textView;
    public MyAdapter(Context context, int[] zdjecia, String[] opisy) {
        super();
        this.context = context;
        this.zdjecia = zdjecia;
        this.opisy = opisy;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return zdjecia.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.spinner,null);
        imageView = convertView.findViewById(R.id.imageView);
        textView = convertView.findViewById(R.id.textView);
        imageView.setImageResource(zdjecia[position]);
        textView.setText(opisy[position]);
        return convertView;
    }
}