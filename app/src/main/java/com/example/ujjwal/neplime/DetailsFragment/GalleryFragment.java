package com.example.ujjwal.neplime.DetailsFragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ujjwal.neplime.R;

import java.util.ArrayList;

/**
 * Created by Ujjwal on 5/20/2018.
 */

public class GalleryFragment extends Fragment implements View.OnClickListener {

    ViewPager pager;
    ImageView left_arrow, right_arrow;
    ArrayList<ImageView> imageList;
    LinearLayout imageContainer;
    View galleryView;

    //demo images
    String[] images = new String[]{"https://images.unsplash.com/photo-1516864356635-5688f0a3fe31?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=d42a84844536f995c15f6d0bab6102e9&auto=format&fit=crop&w=750&q=80",
            "https://images.unsplash.com/photo-1516914589923-f105f1535f88?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=f412a6ee4af609b0e3f4f85248f2879f&auto=format&fit=crop&w=750&q=80",
            "https://images.unsplash.com/photo-1463062511209-f7aa591fa72f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=3c7691cc1fdd32ce188f0b8881476015&auto=format&fit=crop&w=750&q=80",
            "https://images.unsplash.com/photo-1476231790875-016a80c274f3?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=52d21e330c0a86c06abc47beb451d20c&auto=format&fit=crop&w=750&q=80",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSD2XNJa0tena19L5iyMXR00PeFk2F3IXnwJ16pG0vFVyrSeuC6tg"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        galleryView = inflater.inflate(R.layout.gallery_fragment, null);
        imageList = new ArrayList<>();
        pager = galleryView.findViewById(R.id.pager);
        pager.setAdapter(new ImagePagerAdapter(getChildFragmentManager(), images));

        left_arrow = galleryView.findViewById(R.id.left_arrow);
        right_arrow = galleryView.findViewById(R.id.right_arrow);

        left_arrow.setOnClickListener(this);
        right_arrow.setOnClickListener(this);

        imageContainer = galleryView.findViewById(R.id.image_container);

        int imgNo = 5;
        imageList = new ArrayList<>();

        for (int i = 0; i < imgNo; i++) {

            final ImageView imageView = new ImageView(getContext());
            Drawable res = getResources().getDrawable(R.drawable.demo_image);
            imageView.setImageDrawable(res);


            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(220, 140); //165
            layoutParams.setMargins(0, 4, 8, 4);
            imageView.setLayoutParams(layoutParams);
            imageContainer.addView(imageView);
            imageView.setOnClickListener(imgClickListener);
            imageList.add(imageView);
            imageView.setId(i + 255);

        }



        return galleryView;
    }

    @Override
    public void onClick(View v) {
        int tab;
        switch (v.getId()) {

            case R.id.left_arrow:
                tab = pager.getCurrentItem();
                if (tab > 0) {
                    tab--;
                    pager.setCurrentItem(tab);
                } else if (tab == 0) {
                    pager.setCurrentItem(tab);
                }
                break;

            case R.id.right_arrow:

                tab = pager.getCurrentItem();
                tab++;
                pager.setCurrentItem(tab);
                break;
        }
    }

    View.OnClickListener imgClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int i = 255;
            pager.setCurrentItem(v.getId() - i);

        }
    };

}
