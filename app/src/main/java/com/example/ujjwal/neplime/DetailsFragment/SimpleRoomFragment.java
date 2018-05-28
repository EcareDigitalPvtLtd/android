package com.example.ujjwal.neplime.DetailsFragment;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ujjwal.neplime.R;

/**
 * Created by Ujjwal on 5/24/2018.
 */

public class SimpleRoomFragment extends Fragment {
    TextView more_details;
    PopupWindow popupWindow;
    GridView listView;
    ListView listView_2;
    Button close;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.simple_fragment, null);
        more_details = view.findViewById(R.id.more_details);

        more_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] name = {
                        "Smoke free Room",
                        "Brakfast available",
                        "Hair Dryer",
                        "Luggage Storage",
                        "Air Condition",
                        "Balcony",
                        "Terrace",
                        "Electric Kettle",
                        "NewsAPaper",
                        "Atached Bathroom",
                        "Shower",
                        "Sliper Fan/Celling Fan",
                        "Towel",
                        "Free Wifi"
                };

                final String[] child = {
                        "Window Guard","Children Toys","Baby Bath"
                };


                popupWindow = new PopupWindow();

                Point size = new Point();
                Display display = getActivity().getWindowManager().getDefaultDisplay();
                display.getSize(size);
                int width = size.x;
                int height = size.y;
                popupWindow.setWidth(width-20);
                popupWindow.setHeight(height-20);

                View view = getLayoutInflater().inflate(R.layout.more_details, null);
                listView= view.findViewById(R.id.listview);
                listView_2= view.findViewById(R.id.listview_2);
                close = view.findViewById(R.id.close);
                popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);//Create of popup
                popupWindow.setAnimationStyle(android.R.style.Animation_Dialog);

                popupWindow.showAtLocation(view, Gravity.CENTER, 0,0);//Display popup

                ListAdapterMoreService adapterMoreService = new ListAdapterMoreService(getActivity(),name);
                listView.setAdapter(adapterMoreService);

                ListAdapterChilren  listAdapterChilren= new ListAdapterChilren(getActivity(),child);
                listView_2.setAdapter(listAdapterChilren);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        popupWindow.dismiss();
                    }
                });
            }
        });
        return view;
    }
}

