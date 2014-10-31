package com.fullsail.charactercompendium;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by administrator on 10/9/14.
 */
public class StatViewItem implements TextWatcher{

    private TextView entry;
    private TextView mod;
    private String id;

    public StatViewItem(TextView _entry, TextView _mod) {
        entry = _entry;
        mod = _mod;
        entry.addTextChangedListener(this);
    }

    public void calculateMod(int stat) {
        int result;
        if (stat == 10){
            result = 0;
        } else if (stat > 10){
            result = (int) Math.floor((stat - 10) / 2);
        } else {
            result = (int) Math.floor(((stat - 1) - 10) / 2);
        }
        if (result >= 0 ){
            mod.setText("(+" + result + ")");
        } else {
            mod.setText("(" + result + ")");
        }

    }

    public void setEntryMin() {
        entry.setText("1");
        calculateMod(1);
    }
    public String getEntry() {
        return entry.getText().toString();
    }
    public TextView getMod() { return mod; }

    public void setText (String string){
        entry.setText(string);
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!entry.getText().toString().matches("")) {
            calculateMod(Integer.parseInt(entry.getText().toString()));
        } else {
            calculateMod(1);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

}
