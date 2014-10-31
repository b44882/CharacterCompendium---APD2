package com.fullsail.charactercompendium;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by administrator on 10/15/14.
 */
public class V2Fragment extends Fragment implements View.OnClickListener {

    public static final String ARG_CHAR = "V2Fragment.Character";
    public static final String TAG = "V2Fragment.TAG";
    public CharacterItem character;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page2, container, false);
        return view;
    }

    public static V2Fragment newInstance(CharacterItem characterItem) {
        V2Fragment frag = new V2Fragment();
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


        public void prevV1(CharacterItem character);
        public void nextV3(CharacterItem character);

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
        getView().findViewById(R.id.v2_acrobaticsCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_animalCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_athleticsCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_arcanaCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_chaCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_conCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_deceptionCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_dexCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_historyCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_insightCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_intCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_intimidationCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_invetigateCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_medicineCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_natureCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_perceptionCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_performanceCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_persuasionCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_religionCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_sleightCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_stealthCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_strCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_survivalCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_wisCheck).setOnClickListener(this);
        getView().findViewById(R.id.v2_nextButton).setOnClickListener(this);
        getView().findViewById(R.id.v2_prevButton).setOnClickListener(this);

        TextView tv = (TextView) getView().findViewById(R.id.v2_acrobaticsMod);
        if (character.getAcrobatics() >= 0) {
            tv.setText("(+" + String.valueOf(character.getAcrobatics()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getAcrobatics()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_animalMod);
        if (character.getAnimal() >= 0) {
            tv.setText("(+" + String.valueOf(character.getAnimal()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getAnimal()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_athleticsMod);
        if (character.getAthletics() >= 0) {
            tv.setText("(+" + String.valueOf(character.getAthletics()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getAthletics()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_arcanaMod);
        if (character.getArcana() >= 0) {
            tv.setText("(+" + String.valueOf(character.getArcana()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getArcana()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_chaMod);
        if (character.getChaSave() >= 0) {
            tv.setText("(+" + String.valueOf(character.getChaSave()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getChaSave()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_conMod);
        if (character.getConSave() >= 0) {
            tv.setText("(+" + String.valueOf(character.getConSave()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getConSave()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_deceptionMod);
        if (character.getDeception() >= 0) {
            tv.setText("(+" + String.valueOf(character.getDeception()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getDeception()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_dexMod);
        if (character.getDexSave() >= 0) {
            tv.setText("(+" + String.valueOf(character.getDexSave()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getDexSave()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_historyMod);
        if (character.getHistory() >= 0) {
            tv.setText("(+" + String.valueOf(character.getHistory()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getHistory()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_insightMod);
        if (character.getInsight() >= 0) {
            tv.setText("(+" + String.valueOf(character.getInsight()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getInsight()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_intMod);
        if (character.getIntSave() >= 0) {
            tv.setText("(+" + String.valueOf(character.getIntSave()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getIntSave()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_investigationMod);
        if (character.getInvestigation() >= 0) {
            tv.setText("(+" + String.valueOf(character.getInvestigation()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getInvestigation()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_intimidationMod);
        if (character.getIntimidation() >= 0) {
            tv.setText("(+" + String.valueOf(character.getIntimidation()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getIntimidation()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_medicineMod);
        if (character.getMedicine() >= 0) {
            tv.setText("(+" + String.valueOf(character.getMedicine()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getMedicine()) + ")");
        }
        tv = (TextView) getView().findViewById(R.id.v2_natureMod);
        if (character.getNature() >= 0) {
            tv.setText("(+" + String.valueOf(character.getNature()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getNature()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_perceptionMod);
        if (character.getPerception() >= 0) {
            tv.setText("(+" + String.valueOf(character.getPerception()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getPerception()) + ")");
        }
        tv = (TextView) getView().findViewById(R.id.v2_performanceMod);
        if (character.getPerformance() >= 0) {
            tv.setText("(+" + String.valueOf(character.getPerformance()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getPerformance()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_persuasionMod);
        if (character.getPersuasion() >= 0) {
            tv.setText("(+" + String.valueOf(character.getPersuasion()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getPersuasion()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_religionMod);
        if (character.getReligion() >= 0) {
            tv.setText("(+" + String.valueOf(character.getReligion()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getReligion()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_stealthMod);
        if (character.getStealth() >= 0) {
            tv.setText("(+" + String.valueOf(character.getStealth()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getStealth()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_sleightMod);
        if (character.getSleight() >= 0) {
            tv.setText("(+" + String.valueOf(character.getSleight()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getSleight()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_strMod);
        if (character.getStrSave() >= 0) {
            tv.setText("(+" + String.valueOf(character.getStrSave()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getStrSave()) + ")");
        }

        tv = (TextView) getView().findViewById(R.id.v2_survivalMod);
        if (character.getSurvival() >= 0) {
            tv.setText("(+" + String.valueOf(character.getSurvival()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getSurvival()) + ")");
        }
        tv = (TextView) getView().findViewById(R.id.v2_wisMod);
        if (character.getWisSave() >= 0) {
            tv.setText("(+" + String.valueOf(character.getWisSave()) + ")");
        } else {
            tv.setText("(" + String.valueOf(character.getWisSave()) + ")");
        }

    }

    @Override
    public void onClick(View view) {

        int mod;
        if (view.getId() == R.id.v2_acrobaticsCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_acrobaticsMod);
            if (checkBox.isChecked()){
                character.toggleAcrobatics(true);
            }
            else {
                character.toggleAcrobatics(false);
            }
            character.setAcrobatics();
            mod = character.getAcrobatics();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }
        }
        if (view.getId() == R.id.v2_animalCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_animalMod);
            if (checkBox.isChecked()){
                character.toggleAnimal(true);
            }
            else {
                character.toggleAnimal(false);
            }
            character.setAnimal();
            mod = character.getAnimal();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }
        }
        if (view.getId() == R.id.v2_athleticsCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_athleticsMod);
            if (checkBox.isChecked()){
                character.toggleAthletics(true);
            }
            else {
                character.toggleAthletics(false);
            }
            character.setAthletics();
            mod = character.getAthletics();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }
        }
        if (view.getId() == R.id.v2_arcanaCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_arcanaMod);
            if (checkBox.isChecked()){
                character.toggleArcana(true);
            }
            else {
                character.toggleArcana(false);
            }
            character.setArcana();
            mod = character.getArcana();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }
        }
        if (view.getId() == R.id.v2_chaCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_chaMod);
            if (checkBox.isChecked()){
                character.toggleChaSave(true);
            }
            else {
                character.toggleChaSave(false);
            }
            character.setChaSave();
            mod = character.getChaSave();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_conCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_conMod);
            if (checkBox.isChecked()){
                character.toggleConSave(true);
            }
            else {
                character.toggleConSave(false);
            }
            character.setConSave();
            mod = character.getConSave();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_deceptionCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_deceptionMod);
            if (checkBox.isChecked()){
                character.toggleDeception(true);
            }
            else {
                character.toggleDeception(false);
            }
            character.setDeception();
            mod = character.getDeception();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_dexCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_dexMod);
            if (checkBox.isChecked()){
                character.toggleDexSave(true);
            }
            else {
                character.toggleDexSave(false);
            }
            character.setDexSave();
            mod = character.getDexSave();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_intCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_intMod);
            if (checkBox.isChecked()){
                character.toggleIntSave(true);
            }
            else {
                character.toggleIntSave(false);
            }
            character.setIntSave();
            mod = character.getIntSave();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_historyCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_historyMod);
            if (checkBox.isChecked()){
                character.toggleHistory(true);
            }
            else {
                character.toggleHistory(false);
            }
            character.setHistory();
            mod = character.getHistory();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_intimidationCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_intimidationMod);
            if (checkBox.isChecked()){
                character.toggleIntimidation(true);
            }
            else {
                character.toggleIntimidation(false);
            }
            character.setIntimidation();
            mod = character.getIntimidation();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_invetigateCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_investigationMod);
            if (checkBox.isChecked()){
                character.toggleInvestigation(true);
            }
            else {
                character.toggleInvestigation(false);
            }
            character.setInvestigation();
            mod = character.getInvestigation();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_insightCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_insightMod);
            if (checkBox.isChecked()){
                character.toggleInsight(true);
            }
            else {
                character.toggleInsight(false);
            }
            character.setInsight();
            mod = character.getInsight();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_intCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_intMod);
            if (checkBox.isChecked()){
                character.toggleIntSave(true);
            }
            else {
                character.toggleIntSave(false);
            }
            character.setIntSave();
            mod = character.getIntSave();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_medicineCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_medicineMod);
            if (checkBox.isChecked()){
                character.toggleMedicine(true);
            }
            else {
                character.toggleMedicine(false);
            }
            character.setMedicine();
            mod = character.getMedicine();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_natureCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_natureMod);
            if (checkBox.isChecked()){
                character.toggleNature(true);
            }
            else {
                character.toggleNature(false);
            }
            character.setNature();
            mod = character.getNature();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_perceptionCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_perceptionMod);
            if (checkBox.isChecked()){
                character.togglePerception(true);
            }
            else {
                character.togglePerception(false);
            }
            character.setPerception();
            mod = character.getPerception();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_performanceCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_performanceMod);
            if (checkBox.isChecked()){
                character.togglePerformance(true);
            }
            else {
                character.togglePerformance(false);
            }
            character.setPerformance();
            mod = character.getPerformance();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_persuasionCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_persuasionMod);
            if (checkBox.isChecked()){
                character.togglePersuasion(true);
            }
            else {
                character.togglePersuasion(false);
            }
            character.setPersuasion();
            mod = character.getPersuasion();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_religionCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_religionMod);
            if (checkBox.isChecked()){
                character.toggleReligion(true);
            }
            else {
                character.toggleReligion(false);
            }
            character.setReligion();
            mod = character.getReligion();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_sleightCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_sleightMod);
            if (checkBox.isChecked()){
                character.toggleSleight(true);
            }
            else {
                character.toggleSleight(false);
            }
            character.setSleight();
            mod = character.getSleight();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_stealthCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_stealthMod);
            if (checkBox.isChecked()){
                character.toggleStealth(true);
            }
            else {
                character.toggleStealth(false);
            }
            character.setStealth();
            mod = character.getStealth();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_strCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_strMod);
            if (checkBox.isChecked()){
                character.toggleStrSave(true);
            }
            else {
                character.toggleStrSave(false);
            }
            character.setStrSave();
            mod = character.getStrSave();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_survivalCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_survivalMod);
            if (checkBox.isChecked()){
                character.toggleSurvival(true);
            }
            else {
                character.toggleSurvival(false);
            }
            character.setSurvival();
            mod = character.getSurvival();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_wisCheck){
            CheckBox checkBox = (CheckBox)view;
            TextView tv = (TextView) getView().findViewById(R.id.v2_wisMod);
            if (checkBox.isChecked()){
                character.toggleWisSave(true);
            }
            else {
                character.toggleWisSave(false);
            }
            character.setWisSave();
            mod = character.getWisSave();
            if (mod >= 0) {
                tv.setText("(+" + String.valueOf(mod) + ")");
            } else {
                tv.setText("(" + String.valueOf(mod) + ")");
            }

        }
        if (view.getId() == R.id.v2_nextButton){
            mCallbacks.nextV3(character);

        }
        if (view.getId() == R.id.v2_prevButton){
            mCallbacks.prevV1(character);

        }
    }

    public String buildPositiveString(String string){
        return "(+" + string + ")";
    }

    public String buildNegativeString(String string){
        return "(" + string + ")";
    }
}
