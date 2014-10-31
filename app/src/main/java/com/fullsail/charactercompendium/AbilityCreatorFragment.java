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
 * Created by administrator on 10/16/14.
 */
public class AbilityCreatorFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "AbilityCreatorFragment.TAG";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_abilitycreator, container, false);
        return view;

    }

    public static AbilityCreatorFragment newInstance() {
        return new AbilityCreatorFragment();
    }

    private Callbacks mCallbacks;

    public interface Callbacks {

        public void saveAbility(AbilityItem item);
        public void cancelAbility();

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
        getView().findViewById(R.id.ac_saveAndCloseButton).setOnClickListener(this);
        getView().findViewById(R.id.ac_cancelButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ac_saveAndCloseButton){
            mCallbacks.saveAbility(saveAbility());
        }
        if (view.getId() == R.id.ac_cancelButton){
            mCallbacks.cancelAbility();
        }
    }

    public AbilityItem saveAbility(){
        TextView tv = (TextView) getView().findViewById(R.id.ac_nameEditText);
        String name = String.valueOf(tv.getText());
        tv = (TextView) getView().findViewById(R.id.ac_damageEditText);
        String damage = String.valueOf(tv.getText());
        tv = (TextView) getView().findViewById(R.id.ac_descEditText);
        String desc = String.valueOf(tv.getText());
        return new AbilityItem(name,damage,desc);


    }





}
