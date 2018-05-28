package com.example.ujjwal.neplime.DetailsFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidquery.AQuery;
import com.example.ujjwal.neplime.R;

/**
 * Created by Ujjwal on 5/20/2018.
 */

public class ImageDisplayFragment extends Fragment {

    AQuery aQuery;
    String url;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        aQuery = new AQuery(getActivity());
        url = getArguments().getString("url");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.image_display_layout, null);
        ImageView imageView = view.findViewById(R.id.image_view);

        aQuery.id(imageView).image(url, true, true);

        return view;
    }
}
