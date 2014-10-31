package com.fullsail.charactercompendium;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by administrator on 10/24/14.
 */
public class StatManagementFragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener{

    public static final String ARG_CHAR = "StatManage.Character";
    public static final String ARG_STAT = "StatManage.Stat";
    public static final String TAG = "StatManage.TAG";
    public CharacterItem character;
    public TextView base;
    public TextView temp;
    public TextView statNote;
    public StatViewItem baseStat;
    public StatViewItem tempStat;

    private String stat;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statmanagement, container, false);
        return view;
    }

    public static StatManagementFragment newInstance(CharacterItem characterItem, String _stat) {
        StatManagementFragment frag = new StatManagementFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CHAR, characterItem);
        args.putString(ARG_STAT, _stat);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onActivityCreated(Bundle _savedInstanceState) {
        super.onActivityCreated(_savedInstanceState);

        Bundle args = getArguments();
        if (args != null && args.containsKey(ARG_CHAR)){
            character = (CharacterItem) args.getSerializable(ARG_CHAR);
            stat = args.getString(ARG_STAT);
        }
    }

    private Callbacks mCallbacks;


    public interface Callbacks {

        public void statSave(CharacterItem character);
        public void statClose();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (Callbacks) activity;
        } catch (ClassCastException ex) {
            Log.e(TAG, "Casting the activity as a Callbacks listener failed"
                    + ex);
            mCallbacks = null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();



        getView().findViewById(R.id.stat_saveButton).setOnClickListener(this);
        getView().findViewById(R.id.stat_canceButton).setOnClickListener(this);

        getView().findViewById(R.id.stat_baseEditText).setOnFocusChangeListener(this);
        getView().findViewById(R.id.stat_tempEditText).setOnFocusChangeListener(this);

        base = (TextView) getView().findViewById(R.id.stat_baseEditText);
        TextView baseMod = (TextView) getView().findViewById(R.id.stat_baseModText);
        TextView statDesc = (TextView) getView().findViewById(R.id.stat_baseText);
        TextView statTempDesc = (TextView) getView().findViewById(R.id.stat_tempText);
        temp = (TextView) getView().findViewById(R.id.stat_tempEditText);
        TextView tempMod = (TextView) getView().findViewById(R.id.stat_tempModText);
        statNote = (TextView) getView().findViewById(R.id.stat_noteEditText);

        baseStat = new StatViewItem(base, baseMod);
        tempStat = new StatViewItem(temp, tempMod);

        statDesc.setText(stat);
        statTempDesc.setText("TEMP " + stat);

        if (stat == "STR"){
            base.setText(String.valueOf(character.getStr()));
            temp.setText(String.valueOf(character.getTempStr()));
            statNote.setText(String.valueOf(character.getStrNote()));

            if (character.getStrMod() >= 0){
                baseMod.setText("(+" + String.valueOf(character.getStrMod()) + ")");
            } else {
                baseMod.setText("(" + String.valueOf(character.getStrMod()) + ")");
            }

            if (character.getTempStrMod() >= 0){
                tempMod.setText("(+" + String.valueOf(character.getTempStrMod())+ ")");
            } else {
                tempMod.setText("(" + String.valueOf(character.getTempStrMod()) + ")");
            }
        }

        if (stat == "DEX"){
            base.setText(String.valueOf(character.getDex()));
            temp.setText(String.valueOf(character.getTempDex()));
            statNote.setText(String.valueOf(character.getDexNote()));

            if (character.getDexMod() >= 0){
                baseMod.setText("(+" + String.valueOf(character.getDexMod())+ ")");
            } else {
                baseMod.setText("(" + String.valueOf(character.getDexMod()) + ")");
            }

            if (character.getTempDexMod() >= 0){
                tempMod.setText("(+" + String.valueOf(character.getTempDexMod())+ ")");
            } else {
                tempMod.setText("(" + String.valueOf(character.getTempDexMod()) + ")");
            }

        }

        if (stat == "CON"){
            base.setText(String.valueOf(character.getCon()));
            temp.setText(String.valueOf(character.getTempCon()));
            statNote.setText(String.valueOf(character.getConNote()));

            if (character.getConMod() >= 0){
                baseMod.setText("(+" + String.valueOf(character.getConMod())+ ")");
            } else {
                baseMod.setText("(" + String.valueOf(character.getConMod()) + ")");
            }

            if (character.getTempConMod() >= 0){
                tempMod.setText("(+" + String.valueOf(character.getTempConMod())+ ")");
            } else {
                tempMod.setText("(" + String.valueOf(character.getTempConMod()) + ")");
            }

        }

        if (stat == "INT"){
            base.setText(String.valueOf(character.getIntelligence()));
            temp.setText(String.valueOf(character.getTempInt()));
            statNote.setText(String.valueOf(character.getIntNote()));

            if (character.getIntMod() >= 0){
                baseMod.setText("(+" + String.valueOf(character.getIntMod())+ ")");
            } else {
                baseMod.setText("(" + String.valueOf(character.getIntMod()) + ")");
            }

            if (character.getTempIntMod() >= 0){
                tempMod.setText("(+" + String.valueOf(character.getTempIntMod())+ ")");
            } else {
                tempMod.setText("(" + String.valueOf(character.getTempIntMod()) + ")");
            }

        }

        if (stat == "WIS"){
            base.setText(String.valueOf(character.getWis()));
            temp.setText(String.valueOf(character.getTempWis()));
            statNote.setText(String.valueOf(character.getWisNote()));

            if (character.getWisMod() >= 0){
                baseMod.setText("(+" + String.valueOf(character.getWisMod())+ ")");
            } else {
                baseMod.setText("(" + String.valueOf(character.getWisMod()) + ")");
            }

            if (character.getTempWisMod() >= 0){
                tempMod.setText("(+" + String.valueOf(character.getTempWisMod())+ ")");
            } else {
                tempMod.setText("(" + String.valueOf(character.getTempWisMod()) + ")");
            }

        }

        if (stat == "CHA"){
            base.setText(String.valueOf(character.getCha()));
            temp.setText(String.valueOf(character.getTempCha()));
            statNote.setText(String.valueOf(character.getChaNote()));

            if (character.getChaMod() >= 0){
                baseMod.setText("(+" + String.valueOf(character.getChaMod())+ ")");
            } else {
                baseMod.setText("(" + String.valueOf(character.getChaMod()) + ")");
            }

            if (character.getTempChaMod() >= 0){
                tempMod.setText("(+" + String.valueOf(character.getTempChaMod())+ ")");
            } else {
                tempMod.setText("(" + String.valueOf(character.getTempChaMod()) + ")");
            }
        }
        checkBuffOrDebuff();
    }

    public void checkBuffOrDebuff(){

        Integer baseInt = Integer.parseInt(String.valueOf(base.getText()));
        Integer tempInt = Integer.parseInt(String.valueOf(temp.getText()));

        if (baseInt < tempInt){
            temp.setTextColor(Color.parseColor("#1ba124"));
        }
        if (baseInt > tempInt){
            temp.setTextColor(Color.parseColor("#ba1f1f"));
        }
        if (baseInt == tempInt){
            temp.setTextColor(Color.parseColor("#000000"));
        }

    }

    public void saveCharacter(){

        Integer baseInt = Integer.parseInt(String.valueOf(base.getText()));
        Integer tempInt = Integer.parseInt(String.valueOf(temp.getText()));
        String note = String.valueOf(statNote.getText());

        if (stat == "STR"){
            character.setStr(baseInt);
            character.setTempStr(tempInt);
            character.setStrNote(note);
        }
        if (stat == "DEX"){
            character.setDex(baseInt);
            character.setTempDex(tempInt);
            character.setDexNote(note);
        }
        if (stat == "CON"){
            character.setCon(baseInt);
            character.setTempCon(tempInt);
            character.setConNote(note);
        }
        if (stat == "INT"){
            character.setIntelligence(baseInt);
            character.setTempInt(tempInt);
            character.setIntNote(note);
        }
        if (stat == "WIS"){
            character.setWis(baseInt);
            character.setTempWis(tempInt);
            character.setWisNote(note);
        }
        if (stat == "CHA"){
            character.setCha(baseInt);
            character.setTempCha(tempInt);
            character.setChaNote(note);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.stat_saveButton) {
            saveCharacter();
            mCallbacks.statSave(character);
        }
        if (view.getId() == R.id.stat_canceButton) {
            mCallbacks.statClose();
        }

    }

    @Override
    public void onFocusChange(View view, boolean b) {
        TextView tv;
        if (b) {
            if (view.getId() == R.id.stat_tempEditText){
                temp.setTextColor(Color.parseColor("#000000"));
            }
        }
        if (!b) {
            if (view.getId() == R.id.stat_baseEditText) {
                tv = (TextView) getView().findViewById(R.id.stat_baseEditText);
                if (tv.getText().toString().matches("")) {
                    tv = (TextView) getView().findViewById(R.id.stat_baseModText);
                    if (character.getProf() >= 0) {
                        tv.setText("+");
                    } else {
                        tv.setText("");
                    }
                    tv = (TextView) getView().findViewById(R.id.stat_baseEditText);
                    if (stat == "STR") {
                        tv.setText(String.valueOf(character.getStr()));
                    }
                    if (stat == "DEX") {
                        tv.setText(String.valueOf(character.getDex()));
                    }
                    if (stat == "CON") {
                        tv.setText(String.valueOf(character.getCon()));
                    }
                    if (stat == "INT") {
                        tv.setText(String.valueOf(character.getIntelligence()));
                    }
                    if (stat == "WIS") {
                        tv.setText(String.valueOf(character.getWis()));
                    }
                    if (stat == "CHA") {
                        tv.setText(String.valueOf(character.getWis()));

                    }
                }
            }

            if (view.getId() == R.id.stat_tempEditText) {
                tv = (TextView) getView().findViewById(R.id.stat_tempEditText);
                if (tv.getText().toString().matches("")) {
                    tv = (TextView) getView().findViewById(R.id.stat_tempModText);
                    if (character.getProf() >= 0) {
                        tv.setText("+");
                    } else {
                        tv.setText("");
                    }
                    tv = (TextView) getView().findViewById(R.id.stat_tempEditText);
                    if (stat == "STR") {
                        tv.setText(String.valueOf(character.getTempStr()));
                    }
                    if (stat == "DEX") {
                        tv.setText(String.valueOf(character.getTempDex()));
                    }
                    if (stat == "CON") {
                        tv.setText(String.valueOf(character.getTempCon()));
                    }
                    if (stat == "INT") {
                        tv.setText(String.valueOf(character.getTempInt()));
                    }
                    if (stat == "WIS") {
                        tv.setText(String.valueOf(character.getTempWis()));
                    }
                    if (stat == "CHA") {
                        tv.setText(String.valueOf(character.getTempWis()));

                    }
                }
            }
            checkBuffOrDebuff();

        }
    }

}
