package com.example.ujjwal.neplime;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;

/**
 * Created by Ujjwal on 5/17/2018.
 */

public class FilterFragment extends Fragment {

    String max, min;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.filter_fragment, null);

        CrystalRangeSeekbar rangeSeekbar = view.findViewById(R.id.rangeSeekbar1);
        final TextView max_value = view.findViewById(R.id.max_value);
        final TextView min_value = view.findViewById(R.id.min_value);
        TextView button = view.findViewById(R.id.ok_btn);

        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                max_value.setText(String.valueOf(maxValue));
                min_value.setText(String.valueOf(minValue));

                max = maxValue.toString();
                min = minValue.toString();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SearchLayoutFragment slf = new SearchLayoutFragment();
                Bundle args = new Bundle();
                args.putString("max_value", max);
                args.putString("min_value", min);
                slf.setArguments(args);

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.search_container, slf).commit();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, new HotelListFragment()).commit();
            }
        });

        return view;
    }
}
