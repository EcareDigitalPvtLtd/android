package com.example.ujjwal.neplime;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ujjwal on 5/17/2018.
 */

public class SearchLayoutFragment extends Fragment implements View.OnClickListener {

    LinearLayout date_layout, room_layout, filter_layout, sort_layout;
    TextView firstdate, lastdate;

    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM");

    String first_date;
    String last_date;



    //for date picker
    private CalendarPickerView calendar;
    PopupWindow date_popup;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        Bundle args = getArguments();

        if (args  != null){
            Toast.makeText(getContext(), args.getString("max_value")+" "+args.getString("min_value"), Toast.LENGTH_SHORT).show();
        }

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.searchlayout, null);


        date_layout = view.findViewById(R.id.date_layout);
        room_layout = view.findViewById(R.id.room_layout);
        filter_layout = view.findViewById(R.id.filter_layout);
        sort_layout = view.findViewById(R.id.sort_layout);

        firstdate = view.findViewById(R.id.firstdate);
        lastdate = view.findViewById(R.id.lastdate);

        date_layout.setOnClickListener(this);
        room_layout.setOnClickListener(this);
        filter_layout.setOnClickListener(this);
        sort_layout.setOnClickListener(this);


        first_date = sdf.format(cal.getTime());
        cal.add(Calendar.DATE, 3);
        last_date = sdf.format(cal.getTime());


        firstdate.setText(first_date);
        lastdate.setText(last_date);


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.date_layout:

                date_popup = new PopupWindow();

                Point size = new Point();
                Display display = getActivity().getWindowManager().getDefaultDisplay();
                display.getSize(size);
                int width = size.x;
                int height = size.y;

                date_popup.setWidth(width - 20);
                date_popup.setHeight(height - 20);

                final View popUpView = getLayoutInflater().inflate(R.layout.activity_test_calender,
                        null);

                popUpView.setFocusable(true);
                popUpView.setClickable(true);


                LinearLayout cal_Layout = popUpView.findViewById(R.id.calendar_layout);
                Button set_date = popUpView.findViewById(R.id.set_date);

                final TextView check_in = popUpView.findViewById(R.id.check_in);
                final TextView check_out = popUpView.findViewById(R.id.check_out);

                date_popup = new PopupWindow(popUpView, ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, true); // Creation of popup
                date_popup.setAnimationStyle(android.R.style.Animation_Dialog);

                date_popup.showAtLocation(popUpView, Gravity.CENTER, 0, 0); // Displaying popup

                //for date picker
                Calendar nextYear = Calendar.getInstance();
                nextYear.add(Calendar.YEAR, 1);

                calendar = popUpView.findViewById(R.id.calendar_view);
                Date today = new Date();
                calendar.init(today, nextYear.getTime())
                        .withSelectedDate(today)
                        .inMode(CalendarPickerView.SelectionMode.RANGE);


                final ArrayList<String> dateArray = new ArrayList<>();
                dateArray.add(first_date);

                //cell click listener

                calendar.setCellClickInterceptor(new CalendarPickerView.CellClickInterceptor() {
                    @Override
                    public boolean onCellClicked(Date date) {


                        String mydate = date.toString();

                        if (dateArray.size()==1) {
                            dateArray.add(getDateOnly(mydate));
                        } else {
                            dateArray.set(1, getDateOnly(mydate));
                        }
                        check_in.setText(dateArray.get(0));
                        check_out.setText(dateArray.get(1));

                        dateArray.set(0, dateArray.get(1));


                        return false;
                    }
                });

                set_date.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        firstdate.setText(check_in.getText());
                        lastdate.setText(check_out.getText());

                        date_popup.dismiss();

                    }
                });


                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, new DateFragment()).commit();
                break;
            case R.id.room_layout:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, new RoomFragment()).commit();
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

    //for date picker
    public String getDateOnly(String date) {

        String month;
        String day;

        month = date.split(" ")[1];
        day = date.split(" ")[2];

        return day + " " + month;
    }
}
