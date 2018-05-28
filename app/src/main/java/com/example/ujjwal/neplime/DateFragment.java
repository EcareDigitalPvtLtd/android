package com.example.ujjwal.neplime;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ujjwal on 5/17/2018.
 */

public class DateFragment extends Fragment implements View.OnClickListener{

    private CalendarPickerView calendar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setHasOptionsMenu(true);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.date_fragment, null);

        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        calendar = view.findViewById(R.id.calendar_view);
        Date today = new Date();
        calendar.init(today, nextYear.getTime())
                .withSelectedDate(today)
                .inMode(CalendarPickerView.SelectionMode.RANGE);

        Button setDate = view.findViewById(R.id.set_date);
        setDate.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.set_date){
            ArrayList<Date> selectedDates = (ArrayList<Date>)calendar
                    .getSelectedDates();
            String firstdate, lastdate;
            firstdate = getDateOnly(selectedDates.get(0).toString());
            lastdate = getDateOnly(selectedDates.get(selectedDates.size()-1).toString());
            Toast.makeText(getContext(), firstdate+" "+lastdate,
                    Toast.LENGTH_LONG).show();

            SearchLayoutFragment slf = new SearchLayoutFragment();
            Bundle args = new Bundle();
            args.putString("firstdate", firstdate);
            args.putString("lastdate", lastdate);
            slf.setArguments(args);

            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.search_container, slf).commit();


        }
    }

    public String getDateOnly(String date){

        String month;
        String day;

        month = date.split(" ")[1];
        day = date.split(" ")[2];

        return day+" "+month;
    }
}
