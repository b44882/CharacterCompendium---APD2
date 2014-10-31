package com.fullsail.charactercompendium;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by administrator on 10/11/14.
 */
public class CC4Fragment extends Fragment implements View.OnClickListener {

    public static final String ARG_CHAR = "CC4Fragment.Character";
    public static final String TAG = "CC4Fragment.TAG";
    public CharacterItem character;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_charactercreation4, container, false);
        return view;
    }

    public static CC4Fragment newInstance(CharacterItem characterItem) {
        CC4Fragment frag = new CC4Fragment();
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

        public void prevCC3(CharacterItem character);
        public void saveCharacter(CharacterItem character);

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

        getView().findViewById(R.id.cc4_prev).setOnClickListener(this);
        getView().findViewById(R.id.cc4_complete).setOnClickListener(this);

        TextView tv = (TextView) getView().findViewById(R.id.cc4_backgroundEdit);
        tv.setText(character.getBackground());

        tv = (TextView) getView().findViewById(R.id.cc4_personalityEdit);
        tv.setText(character.getPersonality());

        tv = (TextView) getView().findViewById(R.id.cc4_flawEdit);
        tv.setText(character.getFlaw());

        tv = (TextView) getView().findViewById(R.id.cc4_bondEdit);
        tv.setText(character.getBond());

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.cc4_prev){
            saveCharacter();
            mCallbacks.prevCC3(character);
        }
        if (view.getId() == R.id.cc4_complete){
            saveCharacter();
            mCallbacks.saveCharacter(character);
        }

    }

    public void saveCharacter(){

        TextView tv = (TextView) getView().findViewById(R.id.cc4_backgroundEdit);
        character.setBackground(String.valueOf(tv.getText()));

        tv = (TextView) getView().findViewById(R.id.cc4_personalityEdit);
        character.setPersonality(String.valueOf(tv.getText()));

        tv = (TextView) getView().findViewById(R.id.cc4_flawEdit);
        character.setFlaw(String.valueOf(tv.getText()));

        tv = (TextView) getView().findViewById(R.id.cc4_bondEdit);
        character.setBond(String.valueOf(tv.getText()));


    }



}
