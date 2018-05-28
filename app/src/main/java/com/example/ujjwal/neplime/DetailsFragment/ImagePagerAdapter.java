package com.example.ujjwal.neplime.DetailsFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Ujjwal on 5/20/2018.
 */

public class ImagePagerAdapter extends FragmentPagerAdapter {

    String[] images;

    public ImagePagerAdapter(FragmentManager fm, String images[]) {
        super(fm);
        this.images = images;
    }

    @Override
    public Fragment getItem(int position) {
        ImageDisplayFragment fragment = new ImageDisplayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", images[position]);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return images.length;
    }
}
