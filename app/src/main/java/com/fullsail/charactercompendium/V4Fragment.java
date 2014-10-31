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
public class V4Fragment extends Fragment implements View.OnClickListener {

    public static final String ARG_CHAR = "V4Fragment.Character";
    public static final String TAG = "V4Fragment.TAG";
    public CharacterItem character;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page4, container, false);
        return view;
    }

    public static V4Fragment newInstance(CharacterItem characterItem) {
        V4Fragment frag = new V4Fragment();
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

        public void prevV3(CharacterItem character);
        public void nextV5(CharacterItem character);

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

        getView().findViewById(R.id.v4_nextButton).setOnClickListener(this);
        getView().findViewById(R.id.v4_prevButton).setOnClickListener(this);

        TextView tv = (TextView) getView().findViewById(R.id.v4_equipmentEditText);
        tv.setText(character.getEquipment());

        tv = (TextView) getView().findViewById(R.id.v4_currencyEditText);
        tv.setText(character.getCurrency());
    }

    public void saveCharacter() {

        TextView tv = (TextView) getView().findViewById(R.id.v4_equipmentEditText);
        character.setEquipment(String.valueOf(tv.getText()));

        tv = (TextView) getView().findViewById(R.id.v4_currencyEditText);
        character.setCurrency(String.valueOf(tv.getText()));

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.v4_nextButton) {
            saveCharacter();
            mCallbacks.nextV5(character);
        }
        if (view.getId() == R.id.v4_prevButton) {
            saveCharacter();
            mCallbacks.prevV3(character);
        }

    }
}
