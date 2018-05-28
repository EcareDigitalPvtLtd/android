package com.example.ujjwal.neplime;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Ujjwal on 5/27/2018.
 */

public class HotelListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.hotel_list_fragment, null);
        ListView listView = view.findViewById(R.id.hotel_listview);


        final String[] name = {
                "nure",
                "santosh"
        };
        int[] image = {
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background
        };

        HotelListAdapter adapter = new HotelListAdapter(getActivity(),image,name);
        listView.setAdapter(adapter);


        return view;


    }
}
