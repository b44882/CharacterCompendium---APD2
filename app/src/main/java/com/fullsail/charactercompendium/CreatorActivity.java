package com.fullsail.charactercompendium;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class CreatorActivity extends Activity implements
        CC1Fragment.Callbacks,
        CC2Fragment.Callbacks,
        CC3Fragment.Callbacks,
        CC4Fragment.Callbacks,
        V1Fragment.Callbacks,
        V2Fragment.Callbacks,
        V3Fragment.Callbacks,
        AbilityCreatorFragment.Callbacks,
        V4Fragment.Callbacks,
        V5Fragment.Callbacks,
        HpFragment.Callbacks,
        StatManagementFragment.Callbacks{

    public CharacterItem mainCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creator);

        mainCharacter = openObjectSerialize();

        if (mainCharacter.isCreatedCheck()){
            prepareV1();
        } else {
            prepareCC1();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void prevCC1(CharacterItem character) {
        mainCharacter = character;
        prepareCC1();

    }
    @Override
    public void prevCC2(CharacterItem character) {
        mainCharacter = character;
        prepareCC2();
    }

    @Override
    public void nextCC2(CharacterItem character) {
        mainCharacter = character;
        prepareCC2();
    }
    @Override
    public void prevCC3(CharacterItem character) {
        mainCharacter = character;
        prepareCC3();
    }

    @Override
    public void prevV1(CharacterItem character) {
        mainCharacter = character;
        objectSerialize(mainCharacter);
        prepareV1();
    }

    @Override
    public void prevV2(CharacterItem character) {
        mainCharacter = character;
        objectSerialize(mainCharacter);
        prepareV2();
    }

    @Override
    public void prevV3(CharacterItem character) {
        mainCharacter = character;
        objectSerialize(mainCharacter);
        prepareV3();

    }

    @Override
    public void prevV4(CharacterItem character) {
        mainCharacter = character;
        objectSerialize(mainCharacter);
        prepareV4();

    }

    @Override
    public void nextCC3(CharacterItem character) {
        mainCharacter = character;
        prepareCC3();

    }

    @Override
    public void nextCC4(CharacterItem character) {
        mainCharacter = character;
        prepareCC4();
    }

    @Override
    public void nextV2(CharacterItem character) {
        mainCharacter = character;
        objectSerialize(mainCharacter);
        prepareV2();
    }

    @Override
    public void nextV3(CharacterItem character) {
        mainCharacter = character;
        objectSerialize(mainCharacter);
        prepareV3();
    }

    @Override
    public void nextV4(CharacterItem character) {
        mainCharacter = character;
        objectSerialize(mainCharacter);
        prepareV4();

    }

    @Override
    public void nextV5(CharacterItem character) {
        mainCharacter = character;
        objectSerialize(mainCharacter);
        prepareV5();

    }

    @Override
    public void saveCharacter(CharacterItem character) {
        mainCharacter.initiate();
        objectSerialize(mainCharacter);
        Toast.makeText(getApplicationContext(), "Character saved.",
                Toast.LENGTH_LONG).show();
        prepareV1();
    }


    @Override
    public void saveAbility(AbilityItem item) {
        mainCharacter.addAbility(item);
        objectSerialize(mainCharacter);
        prepareV3();
    }

    @Override
    public void cancelAbility() {
        prepareV3();
    }

    @Override
    public void hpClose(CharacterItem character) {
        mainCharacter = character;
        objectSerialize(mainCharacter);
        prepareV1();
    }

    @Override
    public void hpOpen(CharacterItem character) {
        mainCharacter = character;
        objectSerialize(mainCharacter);
        prepareHpView();
    }

    @Override
    public void statOpen(CharacterItem character, String _stat) {
       mainCharacter = character;
        objectSerialize(mainCharacter);
        prepareStatView(_stat);
    }

    @Override
    public void statSave(CharacterItem character) {
        mainCharacter = character;
        objectSerialize(mainCharacter);
        prepareV1();
    }

    @Override
    public void statClose() {
        prepareV1();
    }

    @Override
    public void createAbility() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        AbilityCreatorFragment abilityCreatorFragment = AbilityCreatorFragment.newInstance();
        transaction.replace(R.id.creator_holder, abilityCreatorFragment, CC1Fragment.TAG);
        transaction.commit();
    }

    public void prepareHpView() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        HpFragment hpFragment = HpFragment.newInstance(mainCharacter);
        transaction.replace(R.id.creator_holder, hpFragment, CC1Fragment.TAG);
        transaction.commit();
    }

    public void prepareStatView(String _stat) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        StatManagementFragment statManagementFragment = StatManagementFragment.newInstance(mainCharacter, _stat);
        transaction.replace(R.id.creator_holder, statManagementFragment, CC1Fragment.TAG);
        transaction.commit();
    }


    public void prepareCC1(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        CC1Fragment cc1Fragment = CC1Fragment.newInstance(mainCharacter);
        transaction.replace(R.id.creator_holder, cc1Fragment, CC1Fragment.TAG);
        transaction.commit();
    }

    public void prepareCC2(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        CC2Fragment cc2Fragment = CC2Fragment.newInstance(mainCharacter);
        transaction.replace(R.id.creator_holder, cc2Fragment, CC1Fragment.TAG);
        transaction.commit();
    }

    public void prepareCC3(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        CC3Fragment cc3Fragment = CC3Fragment.newInstance(mainCharacter);
        transaction.replace(R.id.creator_holder, cc3Fragment, CC1Fragment.TAG);
        transaction.commit();
    }

    public void prepareCC4(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        CC4Fragment cc4Fragment = CC4Fragment.newInstance(mainCharacter);
        transaction.replace(R.id.creator_holder, cc4Fragment, CC1Fragment.TAG);
        transaction.commit();
    }

    public void prepareV1(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        V1Fragment v1Fragment = V1Fragment.newInstance(mainCharacter);
        transaction.replace(R.id.creator_holder, v1Fragment, CC1Fragment.TAG);
        transaction.commit();
    }

    public void prepareV2(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        V2Fragment v2Fragment = V2Fragment.newInstance(mainCharacter);
        transaction.replace(R.id.creator_holder, v2Fragment, CC1Fragment.TAG);
        transaction.commit();
    }

    public void prepareV3(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        V3Fragment v3Fragment = V3Fragment.newInstance(mainCharacter);
        transaction.replace(R.id.creator_holder, v3Fragment, CC1Fragment.TAG);
        transaction.commit();
    }

    public void prepareV4(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        V4Fragment v4Fragment = V4Fragment.newInstance(mainCharacter);
        transaction.replace(R.id.creator_holder, v4Fragment, CC1Fragment.TAG);
        transaction.commit();
    }

    public void prepareV5(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        V5Fragment v5Fragment = V5Fragment.newInstance(mainCharacter);
        transaction.replace(R.id.creator_holder, v5Fragment, CC1Fragment.TAG);
        transaction.commit();
    }

    public void objectSerialize (CharacterItem item){

        try {
            FileOutputStream fos = openFileOutput("character.bin", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(item);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public CharacterItem openObjectSerialize() {
        CharacterItem item;
        try {
            FileInputStream fin = openFileInput("character.bin");
            ObjectInputStream oin = new ObjectInputStream(fin);
            item = (CharacterItem) oin.readObject();
            oin.close();
        } catch(Exception e) {
            e.printStackTrace();
            item = new CharacterItem();
        }

        return item;
    }

}
