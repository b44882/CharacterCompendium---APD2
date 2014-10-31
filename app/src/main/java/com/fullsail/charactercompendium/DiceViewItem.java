package com.fullsail.charactercompendium;

import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by administrator on 10/8/14.
 */
public class DiceViewItem {

    private TextView textView;
    private LinearLayout layout;
    private int dice;

    public DiceViewItem(TextView _tv, LinearLayout _layout, int _dice) {
        textView = _tv;
        layout = _layout;
        dice = _dice;

    }

    public void enableView () {
        textView.setTypeface(null, Typeface.NORMAL);
        textView.setTextColor(Color.parseColor("#000000"));
        layout.setBackgroundColor(Color.parseColor("#fffaf5dc"));
    }

    public void disableView () {
        textView.setTypeface(null, Typeface.ITALIC);
        textView.setTextColor(Color.parseColor("#ff636866"));
        layout.setBackgroundColor(Color.parseColor("#ffa19c88"));
    }

    public void randomAnimation () {

        textView.setText(String.valueOf(randInt(1,dice)));

    }

    public static int randInt(int min, int max) {
        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public void setTextView (String string){

        textView.setText(string);

    }



    public TextView getTextView() {
        return textView;
    }
    public LinearLayout getLayout() { return layout; }


}