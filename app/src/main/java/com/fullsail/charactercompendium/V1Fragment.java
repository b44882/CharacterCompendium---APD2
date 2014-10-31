package com.fullsail.charactercompendium;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by administrator on 10/14/14.
 */
public class V1Fragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {

    public static final String ARG_CHAR = "V1Fragment.Character";
    public static final String TAG = "V1Fragment.TAG";
    public CharacterItem character;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page1, container, false);
        return view;
    }

    public static V1Fragment newInstance(CharacterItem characterItem) {
        V1Fragment frag = new V1Fragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CHAR, characterItem);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onActivityCreated(Bundle _savedInstanceState) {
        super.onActivityCreated(_savedInstanceState);

        Bundle args = getArguments();
        if (args != null && args.containsKey(ARG_CHAR)){
            character = (CharacterItem) args.getSerializable(ARG_CHAR);
        }
    }

    private Callbacks mCallbacks;

    public interface Callbacks {

        public void nextV2(CharacterItem character);
        public void hpOpen(CharacterItem character);
        public void statOpen(CharacterItem character, String _stat);

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
    public void onStart(){
        super.onStart();

        toggleInspirationView();

        getView().findViewById(R.id.v1_nextButton).setOnClickListener(this);
        getView().findViewById(R.id.v1_inspirationView).setOnClickListener(this);
        getView().findViewById(R.id.v1_hpView).setOnClickListener(this);

        getView().findViewById(R.id.v1_strView).setOnClickListener(this);
        getView().findViewById(R.id.v1_dexView).setOnClickListener(this);
        getView().findViewById(R.id.v1_conView).setOnClickListener(this);
        getView().findViewById(R.id.v1_intView).setOnClickListener(this);
        getView().findViewById(R.id.v1_wisView).setOnClickListener(this);
        getView().findViewById(R.id.v1_chaView).setOnClickListener(this);

        getView().findViewById(R.id.v1_proficencyEditText).setOnFocusChangeListener(this);
        getView().findViewById(R.id.v1_acEditText).setOnFocusChangeListener(this);
        getView().findViewById(R.id.v1_iniEditText).setOnFocusChangeListener(this);
        getView().findViewById(R.id.v1_speedEditText).setOnFocusChangeListener(this);

        TextView tv = (TextView) getView().findViewById(R.id.v1_nameText);
        tv.setText(character.getName());

        tv = (TextView) getView().findViewById(R.id.v1_alignText);
        tv.setText(character.getAlign());

        tv = (TextView) getView().findViewById(R.id.v1_classText);
        tv.setText(character.getClassString());

        tv = (TextView) getView().findViewById(R.id.v1_expText);
        tv.setText(character.getBaseExpString() + '/' + character.getTotExpString());

        tv = (TextView) getView().findViewById(R.id.v1_raceText);
        tv.setText(character.getRace());

        tv = (TextView) getView().findViewById(R.id.v1_strStatText);
        tv.setText(String.valueOf(character.getTempStr()));

        tv = (TextView) getView().findViewById(R.id.v1_dexStatText);
        tv.setText(String.valueOf(character.getTempDex()));

        tv = (TextView) getView().findViewById(R.id.v1_conStatText);
        tv.setText(String.valueOf(character.getTempCon()));

        tv = (TextView) getView().findViewById(R.id.v1_IntStatText);
        tv.setText(String.valueOf(character.getTempInt()));

        tv = (TextView) getView().findViewById(R.id.v1_wisStatText);
        tv.setText(String.valueOf(character.getTempWis()));

        tv = (TextView) getView().findViewById(R.id.v1_chaStatText);
        tv.setText(String.valueOf(character.getTempCha()));

        tv = (TextView) getView().findViewById(R.id.v1_strModText);
        if (character.getTempStrMod() >= 0){
            tv.setText("(+" + String.valueOf(character.getTempStrMod())+ ")");
        } else {
            tv.setText("(" + String.valueOf(character.getTempStrMod()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v1_dexModText);
        if (character.getTempDexMod() >= 0){
            tv.setText("(+" + String.valueOf(character.getTempDexMod())+ ")");
        } else {
            tv.setText("(" + String.valueOf(character.getTempDexMod()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v1_conModText);
        if (character.getTempConMod() >= 0){
            tv.setText("(+" + String.valueOf(character.getTempConMod())+ ")");
        } else {
            tv.setText("(" + String.valueOf(character.getTempConMod()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v1_intModText);
        if (character.getTempIntMod() >= 0){
            tv.setText("(+" + String.valueOf(character.getTempIntMod())+ ")");
        } else {
            tv.setText("(" + String.valueOf(character.getTempIntMod()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v1_wisModText);
        if (character.getTempWisMod() >= 0){
            tv.setText("(+" + String.valueOf(character.getTempWisMod())+ ")");
        } else {
            tv.setText("(" + String.valueOf(character.getTempWisMod()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v1_chaModText);
        if (character.getTempChaMod() >= 0){
            tv.setText("(+" + String.valueOf(character.getTempChaMod())+ ")");
        } else {
            tv.setText("(" + String.valueOf(character.getTempChaMod()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v1_baseHpEditText);
        tv.setText(String.valueOf(character.getBaseHp()));

        tv = (TextView) getView().findViewById(R.id.v1_totHpEditText);
        tv.setText(String.valueOf(character.getTotHp()));

        tv = (TextView) getView().findViewById(R.id.v1_acEditText);
        tv.setText(String.valueOf(character.getAC()));

        tv = (TextView) getView().findViewById(R.id.v1_iniPosNeg);
        if (character.getInitiative() >= 0){
            tv.setText("+");
        } else {
            tv.setText("");
        }
        tv = (TextView) getView().findViewById(R.id.v1_iniEditText);
        tv.setText(String.valueOf(character.getInitiative()));

        tv = (TextView) getView().findViewById(R.id.v1_profPosNeg);
        if (character.getProf() >= 0){
            tv.setText("+");
        } else {
            tv.setText("");
        }
        tv = (TextView) getView().findViewById(R.id.v1_proficencyEditText);
        tv.setText(String.valueOf(character.getProf()));

        tv = (TextView) getView().findViewById(R.id.v1_speedEditText);
        tv.setText(String.valueOf(character.getSpeed()));

        checkBuffOrDebuff();

    }

    public void saveCharacter(){
        TextView tv = (TextView) getView().findViewById(R.id.v1_proficencyEditText);
        character.setProficiency(Integer.parseInt(String.valueOf(tv.getText())));

        tv = (TextView) getView().findViewById(R.id.v1_acEditText);
        character.setAC(Integer.parseInt(String.valueOf(tv.getText())));

        tv = (TextView) getView().findViewById(R.id.v1_iniEditText);
        character.setInitiative(Integer.parseInt(String.valueOf(tv.getText())));

        tv = (TextView) getView().findViewById(R.id.v1_speedEditText);
        character.setSpeed(Integer.parseInt(String.valueOf(tv.getText())));

    }



    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.v1_nextButton){
            saveCharacter();
            mCallbacks.nextV2(character);
        }
        if (view.getId() == R.id.v1_inspirationView){
            saveCharacter();
            character.toggleInspiration(!character.getInspiration());
            toggleInspirationView();

        }
        if (view.getId() == R.id.v1_hpView){
            saveCharacter();
            mCallbacks.hpOpen(character);
        }
        if (view.getId() == R.id.v1_strView){
            saveCharacter();
            mCallbacks.statOpen(character, "STR");
        }
        if (view.getId() == R.id.v1_dexView){
            saveCharacter();
            mCallbacks.statOpen(character, "DEX");
        }
        if (view.getId() == R.id.v1_conView){
            saveCharacter();
            mCallbacks.statOpen(character, "CON");
        }
        if (view.getId() == R.id.v1_intView){
            saveCharacter();
            mCallbacks.statOpen(character, "INT");
        }
        if (view.getId() == R.id.v1_wisView){
            saveCharacter();
            mCallbacks.statOpen(character, "WIS");
        }
        if (view.getId() == R.id.v1_chaView){
            saveCharacter();
            mCallbacks.statOpen(character, "CHA");
        }
    }

    public void toggleInspirationView (){
        boolean bool = character.getInspiration();
        LinearLayout layout = (LinearLayout) getView().findViewById(R.id.v1_inspirationView);
        if (bool){
            layout.setBackgroundColor(Color.parseColor("#ffb2ffbe"));
        } else {
            layout.setBackgroundColor(Color.parseColor("#ffffb8b0"));
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        TextView tv;
        if (!b){
            if(view.getId() == R.id.v1_proficencyEditText){
                tv = (TextView) getView().findViewById(R.id.v1_proficencyEditText);
                if(tv.getText().toString().matches("")){
                    tv = (TextView) getView().findViewById(R.id.v1_profPosNeg);
                    if (character.getProf() >= 0){
                        tv.setText("+");
                    } else {
                        tv.setText("");
                    }
                    tv = (TextView) getView().findViewById(R.id.v1_proficencyEditText);
                    tv.setText(String.valueOf(character.getProf()));
                } else {
                    character.setProficiency(Integer.parseInt(String.valueOf(tv.getText())));
                }
            }
            if(view.getId() == R.id.v1_acEditText){
                tv = (TextView) getView().findViewById(R.id.v1_acEditText);
                if(tv.getText().toString().matches("")){
                    tv.setText(String.valueOf(character.getAC()));
                } else {
                    character.setAC(Integer.parseInt(String.valueOf(tv.getText())));
                }
            }
            if(view.getId() == R.id.v1_iniEditText){
                tv = (TextView) getView().findViewById(R.id.v1_iniEditText);
                if(tv.getText().toString().matches("")){
                    tv = (TextView) getView().findViewById(R.id.v1_iniPosNeg);
                    if (character.getInitiative() >= 0){
                        tv.setText("+");
                    } else {
                        tv.setText("");
                    }
                    tv = (TextView) getView().findViewById(R.id.v1_iniEditText);
                    tv.setText(String.valueOf(character.getInitiative()));
                } else {
                    character.setInitiative(Integer.parseInt(String.valueOf(tv.getText())));
                }
            }
            if(view.getId() == R.id.v1_speedEditText){
                tv = (TextView) getView().findViewById(R.id.v1_speedEditText);
                if(tv.getText().toString().matches("")){
                    tv.setText(String.valueOf(character.getSpeed()));
                } else {
                    character.setSpeed(Integer.parseInt(String.valueOf(tv.getText())));
                }
            }
            objectSerialize(character);
        }

    }

    public void objectSerialize (CharacterItem item){

        try {
            FileOutputStream fos = getActivity().openFileOutput("testcharacter.bin", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(item);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public CharacterItem openObjectSerialize() {
        CharacterItem item;
        try {
            FileInputStream fin = getActivity().openFileInput("testcharacter.bin");
            ObjectInputStream oin = new ObjectInputStream(fin);
            item = (CharacterItem) oin.readObject();
            oin.close();
        } catch(Exception e) {
            e.printStackTrace();
            item = new CharacterItem();
        }

        return item;
    }

    public void checkBuffOrDebuff(){

     //STRENGTH
        TextView baseStat = (TextView) getView().findViewById(R.id.v1_strStatText);
        TextView modStat = (TextView) getView().findViewById(R.id.v1_strModText);

        if (character.getStr() < character.getTempStr()){
            baseStat.setTextColor(Color.parseColor("#1ba124"));
            modStat.setTextColor(Color.parseColor("#1ba124"));
        }
        if (character.getStr() > character.getTempStr()){
            baseStat.setTextColor(Color.parseColor("#ba1f1f"));
            modStat.setTextColor(Color.parseColor("#ba1f1f"));
        }
        if (character.getStr() == character.getTempStr()){
            baseStat.setTextColor(Color.parseColor("#000000"));
            modStat.setTextColor(Color.parseColor("#000000"));
        }

     //DEXTERITY
        baseStat = (TextView) getView().findViewById(R.id.v1_dexStatText);
        modStat = (TextView) getView().findViewById(R.id.v1_dexModText);

        if (character.getDex() < character.getTempDex()){
            baseStat.setTextColor(Color.parseColor("#1ba124"));
            modStat.setTextColor(Color.parseColor("#1ba124"));
        }
        if (character.getDex() > character.getTempDex()){
            baseStat.setTextColor(Color.parseColor("#ba1f1f"));
            modStat.setTextColor(Color.parseColor("#ba1f1f"));
        }
        if (character.getDex() == character.getTempDex()){
            baseStat.setTextColor(Color.parseColor("#000000"));
            modStat.setTextColor(Color.parseColor("#000000"));
        }

     //CONSTITUTION
        baseStat = (TextView) getView().findViewById(R.id.v1_conStatText);
        modStat = (TextView) getView().findViewById(R.id.v1_conModText);

        if (character.getCon() < character.getTempCon()){
            baseStat.setTextColor(Color.parseColor("#1ba124"));
            modStat.setTextColor(Color.parseColor("#1ba124"));
        }
        if (character.getCon() > character.getTempCon()){
            baseStat.setTextColor(Color.parseColor("#ba1f1f"));
            modStat.setTextColor(Color.parseColor("#ba1f1f"));
        }
        if (character.getCon() == character.getTempCon()){
            baseStat.setTextColor(Color.parseColor("#000000"));
            modStat.setTextColor(Color.parseColor("#000000"));
        }

     //INTELLIGENCE
        baseStat = (TextView) getView().findViewById(R.id.v1_IntStatText);
        modStat = (TextView) getView().findViewById(R.id.v1_intModText);

        if (character.getIntelligence() < character.getTempInt()){
            baseStat.setTextColor(Color.parseColor("#1ba124"));
            modStat.setTextColor(Color.parseColor("#1ba124"));
        }
        if (character.getIntelligence() > character.getTempInt()){
            baseStat.setTextColor(Color.parseColor("#ba1f1f"));
            modStat.setTextColor(Color.parseColor("#ba1f1f"));
        }
        if (character.getIntelligence() == character.getTempInt()){
            baseStat.setTextColor(Color.parseColor("#000000"));
            modStat.setTextColor(Color.parseColor("#000000"));
        }

     //WISDOM
        baseStat = (TextView) getView().findViewById(R.id.v1_wisStatText);
        modStat = (TextView) getView().findViewById(R.id.v1_wisModText);

        if (character.getWis() < character.getTempWis()){
            baseStat.setTextColor(Color.parseColor("#1ba124"));
            modStat.setTextColor(Color.parseColor("#1ba124"));
        }
        if (character.getWis() > character.getTempWis()){
            baseStat.setTextColor(Color.parseColor("#ba1f1f"));
            modStat.setTextColor(Color.parseColor("#ba1f1f"));
        }
        if (character.getWis() == character.getTempWis()){
            baseStat.setTextColor(Color.parseColor("#000000"));
            modStat.setTextColor(Color.parseColor("#000000"));
        }

     //CHARISMA
        baseStat = (TextView) getView().findViewById(R.id.v1_chaStatText);
        modStat = (TextView) getView().findViewById(R.id.v1_chaModText);

        if (character.getCha() < character.getTempCha()){
            baseStat.setTextColor(Color.parseColor("#1ba124"));
            modStat.setTextColor(Color.parseColor("#1ba124"));
        }
        if (character.getCha() > character.getTempCha()){
            baseStat.setTextColor(Color.parseColor("#ba1f1f"));
            modStat.setTextColor(Color.parseColor("#ba1f1f"));
        }
        if (character.getCha() == character.getTempCha()){
            baseStat.setTextColor(Color.parseColor("#000000"));
            modStat.setTextColor(Color.parseColor("#000000"));
        }

    }
}
