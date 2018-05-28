package com.example.ujjwal.neplime;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ujjwal on 5/27/2018.
 */


public class HotelListAdapter extends ArrayAdapter<String> {
    Activity activity;
    int image[];
    String name[];
    LayoutInflater layoutInflater;
    public HotelListAdapter(Activity activity,int image[], String name[]) {
        super(activity, R.layout.hotel_list_item,name);
        this.activity=activity;
        this.image=image;
        this.name=name;
        layoutInflater = activity.getLayoutInflater();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = layoutInflater.from(activity).inflate(R.layout.hotel_list_item,null);
        TextView na= view.findViewById(R.id.name);
        ImageView img= view.findViewById(R.id.img);
        na.setText(name[position]);
        img.setImageResource(image[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, HotelDetails.class);
                activity.startActivity(i);
            }
        });

        return view;
    }
}
