package com.fullsail.charactercompendium;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by administrator on 10/15/14.
 */
public class SkillSaveItem implements View.OnClickListener {

    private CheckBox skill;
    private TextView result;
    private int statBase;
    private int statMod;
    private int prof;
    private Boolean isChecked;

    public SkillSaveItem(CheckBox _skill, TextView _result, int _statBase, int _statMod, int _prof, Boolean _isChecked) {
        skill = _skill;
        result = _result;
        statBase = _statBase;
        statMod = _statMod;
        prof = _prof;
        isChecked = _isChecked;
    }


    @Override
    public void onClick(View view) {

    }
}
