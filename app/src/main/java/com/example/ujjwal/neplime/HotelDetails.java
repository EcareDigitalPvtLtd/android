package com.example.ujjwal.neplime;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ujjwal.neplime.DetailsFragment.FaciilitiesFragment;
import com.example.ujjwal.neplime.DetailsFragment.GalleryFragment;
import com.example.ujjwal.neplime.DetailsFragment.GuestReviewFragment;
import com.example.ujjwal.neplime.DetailsFragment.PoliciesFragment;
import com.example.ujjwal.neplime.DetailsFragment.PriceFragment;

import static android.graphics.Typeface.*;

public class HotelDetails extends AppCompatActivity implements View.OnClickListener {

    TextView gallery_tab, price_tab, facilities_tab, policies_tab, review_tab;
    LinearLayout gallery_layout, price_layout, facilities_layout, policies_layout, review_layout;
    ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Hotel Details");

        getSupportFragmentManager().beginTransaction().replace(R.id.gallery_layout, new GalleryFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.price_layout, new PriceFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.policies_layout, new PoliciesFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.facilities_layout, new FaciilitiesFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.review_layout, new GuestReviewFragment()).commit();

        gallery_tab = findViewById(R.id.gallery_tab);
        price_tab = findViewById(R.id.price_tab);
        facilities_tab = findViewById(R.id.facilities_tab);
        policies_tab = findViewById(R.id.policies_tab);
        review_tab = findViewById(R.id.review_tab);

        scrollView = findViewById(R.id.scroll_view);

        gallery_layout = findViewById(R.id.gallery_layout);
        price_layout = findViewById(R.id.price_layout);
        facilities_layout = findViewById(R.id.facilities_layout);
        policies_layout = findViewById(R.id.policies_layout);
        review_layout = findViewById(R.id.review_layout);

        gallery_tab.setOnClickListener(this);
        price_tab.setOnClickListener(this);
        facilities_tab.setOnClickListener(this);
        policies_tab.setOnClickListener(this);
        review_tab.setOnClickListener(this);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View v) {

        gallery_tab.setBackgroundResource(R.color.white);
        price_tab.setBackgroundResource(R.color.white);
        facilities_tab.setBackgroundResource(R.color.white);
        policies_tab.setBackgroundResource(R.color.white);
        review_tab.setBackgroundResource(R.color.white);

        gallery_tab.setTypeface(null, Typeface.NORMAL);
        price_tab.setTypeface(null, Typeface.NORMAL);
        facilities_tab.setTypeface(null, Typeface.NORMAL);
        policies_tab.setTypeface(null, Typeface.NORMAL);
        review_tab.setTypeface(null, Typeface.NORMAL);


        switch (v.getId()) {
            case R.id.gallery_tab:
                gallery_tab.setBackgroundResource(R.drawable.tab_bg);
                gallery_tab.setTypeface(null, Typeface.BOLD);
                focusOnView(gallery_layout);
                break;
            case R.id.price_tab:
                price_tab.setBackgroundResource(R.drawable.tab_bg);
                price_tab.setTypeface(null, Typeface.BOLD);
                focusOnView(price_layout);
                break;
            case R.id.facilities_tab:
                facilities_tab.setBackgroundResource(R.drawable.tab_bg);
                facilities_tab.setTypeface(null, Typeface.BOLD);
                focusOnView(facilities_layout);
                break;
            case R.id.policies_tab:
                policies_tab.setBackgroundResource(R.drawable.tab_bg);
                policies_tab.setTypeface(null, Typeface.BOLD);
                focusOnView(policies_layout);
                break;
            case R.id.review_tab:
                review_tab.setBackgroundResource(R.drawable.tab_bg);
                review_tab.setTypeface(null, Typeface.BOLD);
                focusOnView(review_layout);
                break;
        }

    }


    private final void focusOnView(final LinearLayout l) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, l.getTop());
            }
        });
    }
}
