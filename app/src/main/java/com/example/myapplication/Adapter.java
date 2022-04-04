package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private Context ctx;
    private int layoutItem;
    private ArrayList<Contact> arrayList;

    public Adapter(Context ctx, int layoutItem, ArrayList<Contact> arrayList) {
        this.ctx = ctx;
        this.layoutItem = layoutItem;
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(ctx).inflate(layoutItem, viewGroup, false);
        //Anh xa
        TextView tvName = (TextView) view.findViewById(R.id.textView);
        //
        tvName.setText(arrayList.get(i).getName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,arrayList.get(i).getName(),Toast.LENGTH_LONG).show();

                notifyDataSetChanged();

            }
        });
        return view;
    }
}
