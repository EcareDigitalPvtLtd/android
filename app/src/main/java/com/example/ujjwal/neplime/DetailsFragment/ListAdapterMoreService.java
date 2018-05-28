package com.example.ujjwal.neplime.DetailsFragment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ujjwal.neplime.R;

/**
 * Created by Ujjwal on 5/24/2018.
 */

public class ListAdapterMoreService extends ArrayAdapter<String> {
    Activity activity;
    String name[];
    LayoutInflater layoutInflater;
    public ListAdapterMoreService(Activity activity, String name[]) {
        super(activity, R.layout.moreserviceinflatete,name);
        this.activity=activity;
        this.name=name;
        layoutInflater = activity.getLayoutInflater();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = layoutInflater.from(activity).inflate(R.layout.moreserviceinflatete,null);
        TextView na= view.findViewById(R.id.service);
        na.setText(name[position]);
        return view;
    }
}