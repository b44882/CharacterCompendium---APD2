package com.fullsail.charactercompendium;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by administrator on 10/16/14.
 */
public class AbilityListFragment extends ListFragment {

    ArrayList adapterList;
    public static final String TAG = "AbilityListFragment.TAG";
    private static final String ARG_TEXT = "AbilityListFragment.ARG_ARRAY";


    public static AbilityListFragment newInstance(ArrayList listArray) {
        AbilityListFragment frag = new AbilityListFragment();
        Bundle args = new Bundle();
        ArrayList list = listArray;
        args.putParcelableArrayList(ARG_TEXT, listArray);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onActivityCreated(Bundle _savedInstanceState) {
        super.onActivityCreated(_savedInstanceState);
        Bundle args = getArguments();
        if(args != null && args.containsKey(ARG_TEXT)) {
            adapterList = args.getParcelableArrayList(ARG_TEXT);
            setListArray(adapterList);
        }
    }

    private void setListArray(ArrayList listArray){
        Bundle args = getArguments();
        if(args != null && args.containsKey(ARG_TEXT)) {
            args.putParcelableArrayList(ARG_TEXT, listArray);
        }
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listArray);
        if (adapter != null){
            setListAdapter(adapter);
        }
    }

    private Callbacks mCallbacks;

    public interface Callbacks {

        public void onItemSelected();
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
    public void onListItemClick(ListView l, View v, int position, long id) {
        AbilityItem item = (AbilityItem) this.getListAdapter().getItem(position);
        new AlertDialog.Builder(getActivity())
                .setTitle(item.getName())
                .setMessage("Damage: " + item.getDamage() + "\nDescription: " + item.getDesc())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
        Log.i(TAG, "Breakpoint");

    }
}
