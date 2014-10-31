package com.fullsail.charactercompendium;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by administrator on 10/7/14.
 */
public class CC1Fragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "CC1Fragment.TAG";
    public static final String ARG_CHAR = "CC1Fragment.Character";
    public CharacterItem character;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_charactercreation1, container, false);

        return view;

    }

    public static CC1Fragment newInstance(CharacterItem characterItem) {
        CC1Fragment frag = new CC1Fragment();
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

        public void nextCC2(CharacterItem character);

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
        getView().findViewById(R.id.cc1_nextButton).setOnClickListener(this);

        TextView tv = (TextView) getView().findViewById(R.id.cc1_nameEditText);
        tv.setText(character.getName());

        tv = (TextView) getView().findViewById(R.id.cc1_classlvlEditText);
        tv.setText(character.getClassString());

        tv = (TextView) getView().findViewById(R.id.cc1_raceEditText);
        tv.setText(character.getRace());

        tv = (TextView) getView().findViewById(R.id.cc1_alignEditText);
        tv.setText(character.getAlign());

        tv = (TextView) getView().findViewById(R.id.cc1_baseExpEditText);
        tv.setText(character.getBaseExpString());

        tv = (TextView) getView().findViewById(R.id.cc1_totalExpEditText);
        tv.setText(character.getTotExpString());


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.cc1_nextButton){
            saveCharacter();
            mCallbacks.nextCC2(character);
        }
    }

    public void saveCharacter(){
        TextView tv = (TextView) getView().findViewById(R.id.cc1_nameEditText);
        String sample = String.valueOf(tv.getText());
        character.setName(String.valueOf(tv.getText()));

        tv = (TextView) getView().findViewById(R.id.cc1_classlvlEditText);
        character.setClass(String.valueOf(tv.getText()));

        tv = (TextView) getView().findViewById(R.id.cc1_raceEditText);
        character.setRace(String.valueOf(tv.getText()));

        tv = (TextView) getView().findViewById(R.id.cc1_alignEditText);
        character.setAlignment(String.valueOf(tv.getText()));

        tv = (TextView) getView().findViewById(R.id.cc1_baseExpEditText);
        character.setBaseExp(String.valueOf(tv.getText()));

        tv = (TextView) getView().findViewById(R.id.cc1_totalExpEditText);
        character.setTotalExp(String.valueOf(tv.getText()));

    }
}
