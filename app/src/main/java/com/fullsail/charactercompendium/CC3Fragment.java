package com.fullsail.charactercompendium;

import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by administrator on 10/9/14.
 */
public class CC3Fragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {

    public static final String TAG = "CC3Fragment.TAG";
    public static final String ARG_CHAR = "CC3Fragment.Character";
    private CharacterItem character;
    private StatViewItem strStat;
    private StatViewItem dexStat;
    private StatViewItem conStat;
    private StatViewItem intStat;
    private StatViewItem wisStat;
    private StatViewItem chaStat;
    private DiceViewItem dice1;
    private DiceViewItem dice2;
    private DiceViewItem dice3;
    private DiceViewItem dice4;
    private TextView diceSum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_charactercreation3, container, false);

        return view;

    }

    public static CC3Fragment newInstance(CharacterItem characterItem) {
        CC3Fragment frag = new CC3Fragment();
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

        public void nextCC4(CharacterItem character);
        public void prevCC2(CharacterItem character);

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

        strStat = new StatViewItem((TextView) getView().findViewById(R.id.cc3_strEdit),(TextView) getView().findViewById(R.id.cc3_strMod));
        dexStat = new StatViewItem((TextView) getView().findViewById(R.id.cc3_dexEdit),(TextView) getView().findViewById(R.id.cc3_dexMod));
        conStat = new StatViewItem((TextView) getView().findViewById(R.id.cc3_conEdit),(TextView) getView().findViewById(R.id.cc3_conMod));
        intStat = new StatViewItem((TextView) getView().findViewById(R.id.cc3_intEdit),(TextView) getView().findViewById(R.id.cc3_intMod));
        wisStat = new StatViewItem((TextView) getView().findViewById(R.id.cc3_wisEdit),(TextView) getView().findViewById(R.id.cc3_wisMod));
        chaStat = new StatViewItem((TextView) getView().findViewById(R.id.cc3_chaEdit),(TextView) getView().findViewById(R.id.cc3_chaMod));

        dice1 = new DiceViewItem((TextView) getView().findViewById(R.id.cc3_statDiceText1), (LinearLayout) getView().findViewById(R.id.cc3_statDiceView1), 6);
        dice2 = new DiceViewItem((TextView) getView().findViewById(R.id.cc3_statDiceText2), (LinearLayout) getView().findViewById(R.id.cc3_statDiceView2), 6);
        dice3 = new DiceViewItem((TextView) getView().findViewById(R.id.cc3_statDiceText3), (LinearLayout) getView().findViewById(R.id.cc3_statDiceView3), 6);
        dice4 = new DiceViewItem((TextView) getView().findViewById(R.id.cc3_statDiceText4), (LinearLayout) getView().findViewById(R.id.cc3_statDiceView4), 6);

        diceSum = (TextView) getView().findViewById(R.id.cc3_statRollTotal);

        getView().findViewById(R.id.cc3_statDiceRollButton).setOnClickListener(this);
        getView().findViewById(R.id.cc3_prev).setOnClickListener(this);
        getView().findViewById(R.id.cc3_next).setOnClickListener(this);

        getView().findViewById(R.id.cc3_strEdit).setOnFocusChangeListener(this);
        getView().findViewById(R.id.cc3_dexEdit).setOnFocusChangeListener(this);
        getView().findViewById(R.id.cc3_conEdit).setOnFocusChangeListener(this);
        getView().findViewById(R.id.cc3_intEdit).setOnFocusChangeListener(this);
        getView().findViewById(R.id.cc3_wisEdit).setOnFocusChangeListener(this);
        getView().findViewById(R.id.cc3_chaEdit).setOnFocusChangeListener(this);

        dice4.enableView();
        diceSum.setText("-");

        if (character.getStr() != 0){
            strStat.setText(String.valueOf(character.getStr()));
        }
        if (character.getDex() != 0){
            dexStat.setText(String.valueOf(character.getDex()));
        }
        if (character.getCon() != 0){
            conStat.setText(String.valueOf(character.getCon()));
        }
        if (character.getIntelligence() != 0){
            intStat.setText(String.valueOf(character.getIntelligence()));
        }
        if (character.getWis() != 0){
            wisStat.setText(String.valueOf(character.getWis()));
        }
        if (character.getCha() != 0){
            chaStat.setText(String.valueOf(character.getCha()));
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.cc3_statDiceRollButton){

            dice4.enableView();
            new diceAnimation().execute();

        }
        if (view.getId() == R.id.cc3_prev){
            saveCharacter();
            mCallbacks.prevCC2(character);

        }
        if (view.getId() == R.id.cc3_next){
            saveCharacter();
            mCallbacks.nextCC4(character);

        }

    }

    public void saveCharacter(){
        TextView tv = (TextView) getView().findViewById(R.id.cc3_strEdit);
        character.setStr(Integer.parseInt(String.valueOf(tv.getText())));
        character.setTempStr(character.getStr());

        tv = (TextView) getView().findViewById(R.id.cc3_dexEdit);
        character.setDex(Integer.parseInt(String.valueOf(tv.getText())));
        character.setTempDex(character.getDex());

        tv = (TextView) getView().findViewById(R.id.cc3_conEdit);
        character.setCon(Integer.parseInt(String.valueOf(tv.getText())));
        character.setTempCon(character.getCon());

        tv = (TextView) getView().findViewById(R.id.cc3_intEdit);
        character.setIntelligence(Integer.parseInt(String.valueOf(tv.getText())));
        character.setTempInt(character.getIntelligence());

        tv = (TextView) getView().findViewById(R.id.cc3_wisEdit);
        character.setWis(Integer.parseInt(String.valueOf(tv.getText())));
        character.setTempWis(character.getWis());

        tv = (TextView) getView().findViewById(R.id.cc3_chaEdit);
        character.setCha(Integer.parseInt(String.valueOf(tv.getText())));
        character.setTempCha(character.getCha());

    }


    private class diceAnimation extends AsyncTask<Void, Void, Integer> {

        @Override
        protected void onPreExecute(){

        }

        @Override
        protected Integer doInBackground(Void... voids) {
            for (int i = 0; i < 50; i++){
                publishProgress();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return 0;
        }
        protected void onProgressUpdate(Void... voids){
            dice1.setTextView(String.valueOf(randInt(1,6)));
            dice2.setTextView(String.valueOf(randInt(1,6)));
            dice3.setTextView(String.valueOf(randInt(1,6)));
            dice4.setTextView(String.valueOf(randInt(1,6)));

        }


        protected void onPostExecute(Integer integer){
            ArrayList <Integer> rollList = new ArrayList<Integer>();
            rollList.add(randInt(1, 6));
            rollList.add(randInt(1, 6));
            rollList.add(randInt(1, 6));
            rollList.add(randInt(1, 6));
            Collections.sort(rollList, new Comparator<Integer>() {
                @Override
                public int compare(Integer x, Integer y) {
                    return y - x;
                }
            });

            dice1.setTextView(rollList.get(0).toString());
            dice2.setTextView(rollList.get(1).toString());
            dice3.setTextView(rollList.get(2).toString());
            dice4.setTextView(rollList.get(3).toString());
            Integer total = rollList.get(0) + rollList.get(1) + rollList.get(2);
            diceSum.setText(total.toString());

            dice4.disableView();



        }
    }

    public static int randInt(int min, int max) {
        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    @Override
    public void onFocusChange(View view, boolean b) {

        if(!b) {
            if (view.getId() == R.id.cc3_strEdit) {
                if (strStat.getEntry().equals("") || strStat.getEntry().equals("0")) {
                    strStat.setEntryMin();
                }
            }
            if (view.getId() == R.id.cc3_dexEdit) {
                if (dexStat.getEntry().equals("") || dexStat.getEntry().equals("0")) {
                    dexStat.setEntryMin();
                }

            }
            if (view.getId() == R.id.cc3_conEdit) {
                if (conStat.getEntry().equals("") || conStat.getEntry().equals("0")) {
                    conStat.setEntryMin();
                }

            }
            if (view.getId() == R.id.cc3_intEdit) {
                if (intStat.getEntry().equals("") || intStat.getEntry().equals("0")) {
                    intStat.setEntryMin();
                }

            }
            if (view.getId() == R.id.cc3_wisEdit) {
                if (wisStat.getEntry().equals("") || wisStat.getEntry().equals("0")) {
                    wisStat.setEntryMin();
                }

            }
            if (view.getId() == R.id.cc3_chaEdit) {
                if (chaStat.getEntry().equals("") || chaStat.getEntry().equals("0")) {
                    chaStat.setEntryMin();
                }

            }
        }

    }
}
