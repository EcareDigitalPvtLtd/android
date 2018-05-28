package com.example.ujjwal.neplime;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Ujjwal on 5/17/2018.
 */

public class SearchLayoutFragmentMin extends Fragment implements View.OnClickListener{


    ImageView drop_btn;
    LinearLayout  filter_layout, sort_layout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.searchlayout_min, null);
        drop_btn = view.findViewById(R.id.drop_btn);
        filter_layout = view.findViewById(R.id.filter_layout);
        sort_layout = view.findViewById(R.id.sort_layout);

        drop_btn.setOnClickListener(this);
        filter_layout.setOnClickListener(this);
        sort_layout.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {

       switch (v.getId()){

           case R.id.drop_btn:
               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.search_container, new SearchLayoutFragment()).commit();

               break;
           case R.id.filter_layout:
               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.search_container, new SearchLayoutFragmentMin()).commit();
               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, new FilterFragment()).commit();
               break;
           case R.id.sort_layout:
               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.search_container, new SearchLayoutFragmentMin()).commit();
               break;
       }

    }
}
