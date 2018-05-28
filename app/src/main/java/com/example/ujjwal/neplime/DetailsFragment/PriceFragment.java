package com.example.ujjwal.neplime.DetailsFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ujjwal.neplime.R;

/**
 * Created by Ujjwal on 5/24/2018.
 */

public class PriceFragment extends Fragment {
    TextView room_delux, room_simple;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.price_fragment,null);
        room_delux = view.findViewById(R.id.room_delux);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new SimpleRoomFragment()).commit();
        room_simple = view.findViewById(R.id.room_simple);
        room_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new SimpleRoomFragment()).commit();
                room_simple.setBackgroundColor(Color.parseColor("#005596"));
                room_simple.setTextColor(Color.WHITE);
                room_delux.setBackgroundColor(Color.parseColor("#ebecee"));
                room_delux.setTextColor(Color.parseColor("#005596"));
            }
        });


        room_delux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RoomDeluxFragment()).commit();
                room_delux.setBackgroundColor(Color.parseColor("#005596"));
                room_delux.setTextColor(Color.WHITE);
                room_simple.setBackgroundColor(Color.parseColor("#ebecee"));
                room_simple.setTextColor(Color.parseColor("#005596"));
            }
        });
        return view;
    }
}
