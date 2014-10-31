package com.fullsail.charactercompendium;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by administrator on 10/8/14.
 */
public class CC2Fragment extends Fragment implements View.OnClickListener{


    public static final String ARG_CHAR = "CC2Fragment.Character";
    public static final String TAG = "CC2Fragment.TAG";
    private CharacterItem character;
    private int dice;
    private DiceViewItem d4;
    private DiceViewItem d6;
    private DiceViewItem d8;
    private DiceViewItem d10;
    private DiceViewItem d12;
    private DiceViewItem d20;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_charactercreation2, container, false);
        return view;

    }

    public static CC2Fragment newInstance(CharacterItem characterItem) {
        CC2Fragment frag = new CC2Fragment();
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

        public void nextCC3(CharacterItem character);
        public void prevCC1(CharacterItem character);

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

        d4 = new DiceViewItem((TextView) getView().findViewById(R.id.cc2_d4text), (LinearLayout) getView().findViewById(R.id.cc2_d4view), 4);
        d6 = new DiceViewItem((TextView) getView().findViewById(R.id.cc2_d6text), (LinearLayout) getView().findViewById(R.id.cc2_d6view), 6);
        d8 = new DiceViewItem((TextView) getView().findViewById(R.id.cc2_d8text), (LinearLayout) getView().findViewById(R.id.cc2_d8view), 8);
        d10 = new DiceViewItem((TextView) getView().findViewById(R.id.cc2_d10text), (LinearLayout) getView().findViewById(R.id.cc2_d10view), 10);
        d12 = new DiceViewItem((TextView) getView().findViewById(R.id.cc2_d12text), (LinearLayout) getView().findViewById(R.id.cc2_d12view), 12);
        d20 = new DiceViewItem((TextView) getView().findViewById(R.id.cc2_d20text), (LinearLayout) getView().findViewById(R.id.cc2_d20view), 20);

        getView().findViewById(R.id.cc2_prevButton).setOnClickListener(this);
        getView().findViewById(R.id.cc2_nextButton).setOnClickListener(this);
        getView().findViewById(R.id.cc2_d4view).setOnClickListener(this);
        getView().findViewById(R.id.cc2_d6view).setOnClickListener(this);
        getView().findViewById(R.id.cc2_d8view).setOnClickListener(this);
        getView().findViewById(R.id.cc2_d10view).setOnClickListener(this);
        getView().findViewById(R.id.cc2_d12view).setOnClickListener(this);
        getView().findViewById(R.id.cc2_d20view).setOnClickListener(this);

        dice = character.getHitDice();
        if (dice == 0){
            dice = 4;
        }
        viewManager(dice);
    }

    public void viewManager (int dice) {
        if (dice == 4){
            d4.enableView();
        } else {
            d4.disableView();
        }
        if (dice == 6){
            d6.enableView();
        } else {
            d6.disableView();
        }
        if (dice == 8){
            d8.enableView();
        } else {
            d8.disableView();
        }
        if (dice == 10){
            d10.enableView();
        } else {
            d10.disableView();
        }
        if (dice == 12){
            d12.enableView();
        } else {
            d12.disableView();
        }
        if (dice == 20){
            d20.enableView();
        } else {
            d20.disableView();
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.cc2_d4view){
            dice = 4;
            viewManager(dice);
        }
        if (view.getId() == R.id.cc2_d6view){
            dice = 6;
            viewManager(dice);
        }
        if (view.getId() == R.id.cc2_d8view){
            dice = 8;
            viewManager(dice);
        }
        if (view.getId() == R.id.cc2_d10view){
            dice = 10;
            viewManager(dice);
        }
        if (view.getId() == R.id.cc2_d12view){
            dice = 12;
            viewManager(dice);
        }
        if (view.getId() == R.id.cc2_d20view){
            dice = 20;
            viewManager(dice);
        }
        if (view.getId() == R.id.cc2_prevButton){
            saveCharacter();
            mCallbacks.prevCC1(character);
        }
        if (view.getId() == R.id.cc2_nextButton){
            saveCharacter();
            mCallbacks.nextCC3(character);
        }
    }

    public void saveCharacter(){
        character.setHitDice(dice);

    }

}
