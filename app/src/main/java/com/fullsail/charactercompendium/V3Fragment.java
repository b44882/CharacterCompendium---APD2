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

/**
 * Created by administrator on 10/16/14.
 */
public class V3Fragment extends Fragment implements View.OnClickListener{

    public static final String ARG_CHAR = "V3Fragment.Character";
    public static final String TAG = "V3Fragment.TAG";
    public CharacterItem character;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page3, container, false);
        return view;
    }

    public static V3Fragment newInstance(CharacterItem characterItem) {
        V3Fragment frag = new V3Fragment();
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

        public void prevV2(CharacterItem character);
        public void nextV4(CharacterItem character);
        public void createAbility();

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

        getView().findViewById(R.id.v3_createAbilityButton).setOnClickListener(this);
        getView().findViewById(R.id.v3_nextButton).setOnClickListener(this);
        getView().findViewById(R.id.v3_prevButton).setOnClickListener(this);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        AbilityListFragment abilityListFragment = AbilityListFragment.newInstance(character.getAbilityList());
        transaction.replace(R.id.v3_abilityListHolder, abilityListFragment, CC1Fragment.TAG);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.v3_createAbilityButton) {
            mCallbacks.createAbility();
        }
        if (view.getId() == R.id.v3_nextButton) {
            mCallbacks.nextV4(character);
        }
        if (view.getId() == R.id.v3_prevButton) {
            mCallbacks.prevV2(character);
        }

    }

}
