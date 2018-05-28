package com.example.ujjwal.neplime.FontUse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.example.ujjwal.neplime.R;

public class RangeBarDemo extends AppCompatActivity {

    CrystalRangeSeekbar rangeSeekbar;
    TextView max_value, min_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_bar_demo);

        rangeSeekbar = findViewById(R.id.rangeSeekbar1);
        max_value= findViewById(R.id.max_value);
        min_value= findViewById(R.id.min_value);

        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                max_value.setText(String.valueOf(maxValue));
                min_value.setText(String.valueOf(minValue));
            }
        });

    }
}
