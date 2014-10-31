package com.fullsail.charactercompendium;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by administrator on 10/23/14.
 */
public class HpFragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener{

    public static final String ARG_CHAR = "HpFragment.Character";
    public static final String TAG = "HpFragment.TAG";
    public CharacterItem character;
    private DiceViewItem dice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hpmanagement, container, false);
        return view;
    }

    public static HpFragment newInstance(CharacterItem characterItem) {
        HpFragment frag = new HpFragment();
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

        public void hpClose(CharacterItem character);

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

        getView().findViewById(R.id.hp_restButton).setOnClickListener(this);
        getView().findViewById(R.id.hp_closeButton).setOnClickListener(this);
        getView().findViewById(R.id.hp_rollButton).setOnClickListener(this);

        getView().findViewById(R.id.hp_currentHpEditText).setOnFocusChangeListener(this);
        getView().findViewById(R.id.hp_maxHpEditText).setOnFocusChangeListener(this);
        getView().findViewById(R.id.hp_tempHpEditText).setOnFocusChangeListener(this);

        dice = new DiceViewItem((TextView) getView().findViewById(R.id.hp_rollDiceText), (LinearLayout) getView().findViewById(R.id.hp_rollDiceView), character.getHitDice());

        ImageView img= (ImageView) getView().findViewById(R.id.hp_diceImage);
        if (character.getHitDice() == 4){
            img.setImageResource(R.drawable.d4);
        } else if (character.getHitDice() == 6) {
            img.setImageResource(R.drawable.d6);
        } else if (character.getHitDice() == 8) {
            img.setImageResource(R.drawable.d8);
        } else if (character.getHitDice() == 10) {
            img.setImageResource(R.drawable.d10);
        } else if (character.getHitDice() == 12) {
            img.setImageResource(R.drawable.d12);
        } else if (character.getHitDice() == 20) {
            img.setImageResource(R.drawable.d20);
        }

        TextView tv = (TextView) getView().findViewById(R.id.hp_currentHpEditText);
        tv.setText(String.valueOf(character.getBaseHp()));

        tv = (TextView) getView().findViewById(R.id.hp_maxHpEditText);
        tv.setText(String.valueOf(character.getTotHp()));

        tv = (TextView) getView().findViewById(R.id.hp_tempHpEditText);
        tv.setText(String.valueOf(character.getTempHp()));

        tv = (TextView) getView().findViewById(R.id.hp_notesEditText);
        tv.setText(String.valueOf(character.getHpNote()));


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
            dice.setTextView(String.valueOf(randInt(1,character.getHitDice())));

        }


        protected void onPostExecute(Integer integer){

            dice.setTextView(String.valueOf(randInt(1, character.getHitDice())));

        }
    }

    public static int randInt(int min, int max) {
        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.hp_rollButton){
            new diceAnimation().execute();
        }
        if (view.getId() == R.id.hp_restButton){
           TextView current = (TextView) getView().findViewById(R.id.hp_currentHpEditText);
           TextView max = (TextView) getView().findViewById(R.id.hp_maxHpEditText);
           current.setText(String.valueOf(max.getText()));
            character.setBaseHp(character.getTotHp());
        }
        if (view.getId() == R.id.hp_closeButton){
            TextView tv = (TextView) getView().findViewById(R.id.hp_notesEditText);
            character.setHpNote(String.valueOf(tv.getText()));

            tv = (TextView) getView().findViewById(R.id.hp_currentHpEditText);
            character.setBaseHp(Integer.parseInt(String.valueOf(tv.getText())));

            tv = (TextView) getView().findViewById(R.id.hp_maxHpEditText);
            character.setTotHp(Integer.parseInt(String.valueOf(tv.getText())));

            tv = (TextView) getView().findViewById(R.id.hp_tempHpEditText);
            character.setTempHp(Integer.parseInt(String.valueOf(tv.getText())));

            mCallbacks.hpClose(character);
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        TextView tv;
        if (!b){
            if(view.getId() == R.id.hp_currentHpEditText){
                tv = (TextView) getView().findViewById(R.id.hp_currentHpEditText);
                if(tv.getText().toString().matches("")){
                    tv = (TextView) getView().findViewById(R.id.hp_currentHpEditText);
                    tv.setText(String.valueOf(character.getBaseHp()));
                } else {
                    character.setBaseHp(Integer.parseInt(String.valueOf(tv.getText())));
                }
            }
            if(view.getId() == R.id.hp_maxHpEditText){
                tv = (TextView) getView().findViewById(R.id.hp_maxHpEditText);
                if(tv.getText().toString().matches("")){
                    tv.setText(String.valueOf(character.getTotHp()));
                } else {
                    character.setTotHp(Integer.parseInt(String.valueOf(tv.getText())));
                }
            }
            if(view.getId() == R.id.hp_tempHpEditText){
                tv = (TextView) getView().findViewById(R.id.hp_tempHpEditText);
                if(tv.getText().toString().matches("")){
                    tv.setText(String.valueOf(character.getTempHp()));
                } else {
                    character.setTempHp(Integer.parseInt(String.valueOf(tv.getText())));
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
}
