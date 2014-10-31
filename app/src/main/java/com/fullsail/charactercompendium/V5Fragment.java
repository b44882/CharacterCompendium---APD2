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
 * Created by administrator on 10/18/14.
 */
public class V5Fragment extends Fragment implements View.OnClickListener {

    public static final String ARG_CHAR = "V5Fragment.Character";
    public static final String TAG = "V5Fragment.TAG";
    public CharacterItem character;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page5, container, false);
        return view;
    }

    public static V5Fragment newInstance(CharacterItem characterItem) {
        V5Fragment frag = new V5Fragment();
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

        public void prevV4(CharacterItem character);

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

        getView().findViewById(R.id.v5_prevButton).setOnClickListener(this);

        TextView tv = (TextView) getView().findViewById(R.id.v5_backgroundEditText);
        tv.setText(character.getBackground());

        tv = (TextView) getView().findViewById(R.id.v5_personalityEditText);
        tv.setText(character.getPersonality());

        tv = (TextView) getView().findViewById(R.id.v5_flawEditText);
        tv.setText(character.getFlaw());

        tv = (TextView) getView().findViewById(R.id.v5_bondEditText);
        tv.setText(character.getBond());
    }

    public void saveCharacter(){

        TextView tv = (TextView) getView().findViewById(R.id.v5_backgroundEditText);
        character.setBackground(String.valueOf(tv.getText()));

        tv = (TextView) getView().findViewById(R.id.v5_personalityEditText);
        character.setPersonality(String.valueOf(tv.getText()));

        tv = (TextView) getView().findViewById(R.id.v5_flawEditText);
        character.setFlaw(String.valueOf(tv.getText()));

        tv = (TextView) getView().findViewById(R.id.v5_bondEditText);
        character.setBond(String.valueOf(tv.getText()));


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.v5_prevButton){
            saveCharacter();
            mCallbacks.prevV4(character);
        }

    }
}
