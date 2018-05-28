package com.example.ujjwal.neplime;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ujjwal on 5/17/2018.
 */

public class RoomFragment extends Fragment implements View.OnClickListener {

    ImageView btn_minus, btn_plus, adult_plus, adult_minus, children_plus, children_minus;
    TextView room_no, adult_no, children_no;
    int room, adult, children;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.room_fragment, null);


        btn_minus = view.findViewById(R.id.btn_minus);
        btn_plus = view.findViewById(R.id.btn_plus);

        adult_minus = view.findViewById(R.id.adult_minus);
        adult_plus = view.findViewById(R.id.adult_plus);

        children_minus = view.findViewById(R.id.children_minus);
        children_plus = view.findViewById(R.id.children_plus);

        room_no = view.findViewById(R.id.room_no);
        room = Integer.parseInt(room_no.getText().toString());

        adult_no = view.findViewById(R.id.adult_no);
        adult = Integer.parseInt(adult_no.getText().toString());

        children_no = view.findViewById(R.id.children_no);
        children = Integer.parseInt(children_no.getText().toString());

        btn_minus.setOnClickListener(this);
        btn_plus.setOnClickListener(this);

        adult_plus.setOnClickListener(this);
        adult_minus.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_minus:

                minusRoom();
                break;

            case R.id.btn_plus:

                plusRoom();
                break;

            case R.id.adult_minus:
                minusAdult();
                break;

            case R.id.adult_plus:
                plusAdult();
                break;

            case R.id.children_minus:
                minusChildren();
                break;

            case R.id.children_plus:
                plusChildren();
                break;


        }

    }

    public void plusRoom() {
        btn_minus.setImageResource(R.drawable.ic_remove_black_24dp);
        btn_minus.setBackgroundResource(R.drawable.add_bg);

        if (room >= 8) {
            btn_plus.setImageResource(R.drawable.ic_add_black_fade_24dp);
            btn_plus.setBackgroundResource(R.drawable.add_fade_bg);
        } else {
            room++;
            room_no.setText(room + "");

            if (room >= 8) {
                btn_plus.setImageResource(R.drawable.ic_add_black_fade_24dp);
                btn_plus.setBackgroundResource(R.drawable.add_fade_bg);
            }
        }

    }

    public void minusRoom() {
        btn_plus.setImageResource(R.drawable.ic_add_black_24dp);
        btn_plus.setBackgroundResource(R.drawable.add_bg);

        if (room == 0) {
            btn_minus.setImageResource(R.drawable.ic_remove_black_fade_24dp);
            btn_minus.setBackgroundResource(R.drawable.add_fade_bg);
        } else {
            room--;
            room_no.setText(room + "");

            if (room == 0) {
                btn_minus.setImageResource(R.drawable.ic_remove_black_fade_24dp);
                btn_minus.setBackgroundResource(R.drawable.add_fade_bg);
            }
        }
    }

    public void plusAdult() {

        adult_minus.setImageResource(R.drawable.ic_remove_black_24dp);
        adult_minus.setBackgroundResource(R.drawable.add_bg);

        if (adult >= 8) {
            adult_plus.setImageResource(R.drawable.ic_add_black_fade_24dp);
            adult_plus.setBackgroundResource(R.drawable.add_fade_bg);
        } else {
            adult++;
            adult_no.setText(adult + "");

            if (adult >= 8) {
                adult_plus.setImageResource(R.drawable.ic_add_black_fade_24dp);
                adult_plus.setBackgroundResource(R.drawable.add_fade_bg);
            }
        }
    }

    public void minusAdult() {

    }

    public void plusChildren() {

    }

    public void minusChildren() {

    }

}
