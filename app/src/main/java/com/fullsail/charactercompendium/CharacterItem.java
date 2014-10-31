//Brett Gear
//MDF3 1409

package com.fullsail.charactercompendium;

import java.io.Serializable;
import java.util.ArrayList;

public class CharacterItem implements Serializable {

	private static final long serialVersionUID = 21715546239936891L;

    private boolean isCreated;
    private String nameString;
    private String classString;
    private String raceString;
    private String alignString;
    private String baseExpString;
    private String totExpString;
    private String backgroundString;
    private String personalityString;
    private String bondString;
    private String flawString;
    private int str;
    private int dex;
    private int con;
    private int intelligence;
    private int wis;
    private int cha;
    private int strMod;
    private int dexMod;
    private int conMod;
    private int intMod;
    private int wisMod;
    private int chaMod;
    private int hitDice;
    private int ac;
    private int baseHp;
    private int totHp;
    private int tempHp;
    private int speed;
    private int ini;
    private int prof;
    private boolean acrobaticsBool;
    private boolean animalBool;
    private boolean arcanaBool;
    private boolean athleticsBool;
    private boolean deceptionBool;
    private boolean historyBool;
    private boolean insightBool;
    private boolean intimidationBool;
    private boolean investigationBool;
    private boolean medicineBool;
    private boolean natureBool;
    private boolean perceptionBool;
    private boolean performanceBool;
    private boolean persuasionBool;
    private boolean religionBool;
    private boolean sleightBool;
    private boolean stealthBool;
    private boolean survivalBool;
    private boolean strBool;
    private boolean dexBool;
    private boolean conBool;
    private boolean intBool;
    private boolean wisBool;
    private boolean chaBool;
    private int acrobatics;
    private int animal;
    private int arcana;
    private int athletics;
    private int deception;
    private int history;
    private int insight;
    private int intimidation;
    private int investigation;
    private int medicine;
    private int nature;
    private int perception;
    private int performance;
    private int persuasion;
    private int religion;
    private int sleight;
    private int stealth;
    private int survival;
    private int strSave;
    private int dexSave;
    private int conSave;
    private int intSave;
    private int wisSave;
    private int chaSave;
    private ArrayList<AbilityItem> abilities;
    private String equipment;
    private String currency;
    private boolean inspiration;
    private String hpNote;
    private int tempStr;
    private int tempDex;
    private int tempCon;
    private int tempInt;
    private int tempWis;
    private int tempCha;
    private int tempStrMod;
    private int tempDexMod;
    private int tempConMod;
    private int tempIntMod;
    private int tempWisMod;
    private int tempChaMod;
    private String strNote;
    private String dexNote;
    private String conNote;
    private String intNote;
    private String wisNote;
    private String chaNote;



	public CharacterItem () {}

    public void initiate() {

        totHp = hitDice + conMod;
        baseHp = totHp;
        tempHp = 0;
        ac = 10 + dexMod;
        speed = 30;
        prof = 2;
        ini = dexMod;
        acrobaticsBool = false;
        animalBool = false;
        arcanaBool = false;
        athleticsBool = false;
        deceptionBool = false;
        historyBool = false;
        insightBool = false;
        intimidationBool = false;
        investigationBool = false;
        medicineBool = false;
        natureBool = false;
        perceptionBool = false;
        performanceBool = false;
        persuasionBool = false;
        religionBool = false;
        sleightBool = false;
        stealthBool = false;
        survivalBool = false;
        strBool = false;
        dexBool = false;
        conBool = false;
        intBool = false;
        wisBool = false;
        chaBool = false;
        setAcrobatics();
        setAnimal();
        setArcana();
        setAthletics();
        setDeception();
        setHistory();
        setInsight();
        setIntimidation();
        setInvestigation();
        setMedicine();
        setNature();
        setPerception();
        setPerformance();
        setPersuasion();
        setReligion();
        setSleight();
        setStealth();
        setSurvival();
        setStrSave();
        setDexSave();
        setConSave();
        setIntSave();
        setWisSave();
        setChaSave();
        abilities = new ArrayList<AbilityItem>();
        isCreated = true;
        strNote = "";
        dexNote = "";
        wisNote = "";
        conNote = "";
        intNote = "";
        chaNote = "";
        hpNote = "";
    }

    public void setName(String _name){
        nameString = _name;
    }
    public void setClass(String _class){ classString = _class; }
    public void setRace(String _race){ raceString = _race; }
    public void setAlignment(String _align) { alignString = _align; }
    public void setBaseExp (String _baseExp) { baseExpString = _baseExp; }
    public void setTotalExp (String _totExp) { totExpString = _totExp; }
    public void setBackground (String _background) { backgroundString = _background; }
    public void setPersonality (String _personality) {personalityString = _personality; }
    public void setBond (String _bond) {bondString = _bond; }
    public void setFlaw (String _flaw) {flawString = _flaw; }
    public void setStr (int _str) {str = _str; strMod = modCalc(str); }
    public void setDex (int _dex) {dex = _dex; dexMod = modCalc(dex); }
    public void setCon (int _con) {con = _con; conMod = modCalc(con); }
    public void setIntelligence (int _intelligence) {intelligence = _intelligence; intMod = modCalc(intelligence); }
    public void setWis (int _wis) {wis = _wis; wisMod = modCalc(wis); }
    public void setCha (int _cha) {cha = _cha; chaMod = modCalc(cha); }
    public void setHitDice (int _hd) { hitDice = _hd;}
    public void setAC (int _ac) { ac = _ac;}
    public void setBaseHp (int _baseHp) { baseHp = _baseHp;}
    public void setTotHp (int _totHp) { totHp = _totHp;}
    public void setTempHp (int _tempHp) { tempHp = _tempHp;}
    public void setSpeed (int _speed) { speed = _speed;}
    public void setInitiative (int _ini) { ini = _ini;}
    public void setProficiency (int _prof) { prof = _prof;}
    public void toggleAcrobatics (boolean _bool) { acrobaticsBool = _bool; }
    public void toggleAnimal(boolean _bool) {animalBool = _bool;}
    public void toggleArcana(boolean _bool) {arcanaBool = _bool;}
    public void toggleAthletics(boolean _bool) {athleticsBool = _bool;}
    public void toggleDeception(boolean _bool) {deceptionBool = _bool;}
    public void toggleHistory(boolean _bool) {historyBool = _bool;}
    public void toggleInsight(boolean _bool) {insightBool = _bool;}
    public void toggleIntimidation(boolean _bool) {intimidationBool = _bool;}
    public void toggleInvestigation(boolean _bool) {investigationBool = _bool;}
    public void toggleMedicine(boolean _bool) {medicineBool = _bool;}
    public void toggleNature(boolean _bool) {natureBool = _bool;}
    public void togglePerception(boolean _bool) {perceptionBool = _bool;}
    public void togglePerformance(boolean _bool) {performanceBool = _bool;}
    public void togglePersuasion(boolean _bool) {persuasionBool = _bool;}
    public void toggleReligion(boolean _bool) {religionBool = _bool;}
    public void toggleSleight(boolean _bool) {sleightBool = _bool;}
    public void toggleStealth(boolean _bool) {stealthBool = _bool;}
    public void toggleSurvival(boolean _bool) {survivalBool = _bool;}
    public void toggleStrSave(boolean _bool) {strBool = _bool;}
    public void toggleDexSave(boolean _bool) {dexBool = _bool;}
    public void toggleConSave(boolean _bool) {conBool = _bool;}
    public void toggleIntSave(boolean _bool) {intBool = _bool;}
    public void toggleWisSave(boolean _bool) {wisBool = _bool;}
    public void toggleChaSave(boolean _bool) {chaBool = _bool;}
    public void addAbility(AbilityItem item) { abilities.add(item);}
    public void setEquipment(String _equipment) { equipment = _equipment;}
    public void setCurrency(String _currency) { currency = _currency;}
    public void toggleCreated(boolean _bool) {isCreated = _bool;}
    public void toggleInspiration(boolean _bool) {inspiration = _bool;}
    public void setTempStr (int _tempStr){tempStr = _tempStr; tempStrMod = modCalc(_tempStr);}
    public void setTempDex (int _tempDex){tempDex = _tempDex; tempDexMod = modCalc(_tempDex);}
    public void setTempCon (int _tempCon){tempCon = _tempCon; tempConMod = modCalc(_tempCon);}
    public void setTempInt (int _tempInt){tempInt = _tempInt; tempIntMod = modCalc(_tempInt);}
    public void setTempWis (int _tempWis){tempWis = _tempWis; tempWisMod = modCalc(_tempWis);}
    public void setTempCha (int _tempCha){tempCha = _tempCha; tempChaMod = modCalc(_tempCha);}
    public void setHpNote (String _hpNote){hpNote = _hpNote;}
    public void setStrNote (String _strNote){strNote = _strNote;}
    public void setDexNote (String _dexNote){dexNote = _dexNote;}
    public void setConNote (String _conNote){conNote = _conNote;}
    public void setIntNote (String _intNote){intNote = _intNote;}
    public void setWisNote (String _wisNote){wisNote = _wisNote;}
    public void setChaNote (String _chaNote){chaNote = _chaNote;}



    public void setAcrobatics(){
        if (acrobaticsBool){
            acrobatics = dexMod + prof;
        } else {
            acrobatics = dexMod;
        }
    }

    public void setAnimal(){
        if (animalBool){
            animal = wisMod + prof;
        } else {
            animal = wisMod;
        }
    }

    public void setArcana(){
        if (arcanaBool){
            arcana = intMod + prof;
        } else {
            arcana = intMod;
        }
    }

    public void setAthletics(){
        if (athleticsBool){
            athletics = strMod + prof;
        } else {
            athletics = strMod;
        }
    }

    public void setDeception(){
        if (deceptionBool){
            deception = chaMod + prof;
        } else {
            deception = chaMod;
        }
    }

    public void setHistory(){
        if (historyBool){
            history = intMod + prof;
        } else {
            history = intMod;
        }
    }

    public void setInsight(){
        if (insightBool){
            insight = wisMod + prof;
        } else {
            insight = wisMod;
        }
    }

    public void setIntimidation(){
        if (intimidationBool){
            intimidation = chaMod + prof;
        } else {
            intimidation = chaMod;
        }
    }

    public void setInvestigation(){
        if (investigationBool){
            investigation = intMod + prof;
        } else {
            investigation = intMod;
        }
    }

    public void setMedicine(){
        if (medicineBool){
            medicine = wisMod + prof;
        } else {
            medicine = wisMod;
        }
    }

    public void setNature(){
        if (natureBool){
            nature = intMod + prof;
        } else {
            nature = intMod;
        }
    }

    public void setPerception(){
        if (perceptionBool){
            perception = wisMod + prof;
        } else {
            perception = wisMod;
        }
    }

    public void setPerformance(){
        if (performanceBool){
            performance = chaMod + prof;
        } else {
            performance = chaMod;
        }
    }

    public void setPersuasion(){
        if (persuasionBool){
            persuasion = chaMod + prof;
        } else {
            persuasion = chaMod;
        }
    }

    public void setReligion(){
        if (religionBool){
            religion = intMod + prof;
        } else {
            religion = intMod;
        }
    }

    public void setSleight(){
        if (sleightBool){
            sleight = dexMod + prof;
        } else {
            sleight = dexMod;
        }
    }

    public void setStealth(){
        if (stealthBool){
            stealth = dexMod + prof;
        } else {
            stealth = dexMod;
        }
    }

    public void setSurvival(){
        if (survivalBool){
            survival = wisMod + prof;
        } else {
            survival = wisMod;
        }
    }

    public void setStrSave(){
        if (strBool){
            strSave = strMod + prof;
        } else {
            strSave = strMod;
        }
    }

    public void setDexSave(){
        if (dexBool){
            dexSave = dexMod + prof;
        } else {
            dexSave = dexMod;
        }
    }

    public void setConSave(){
        if (conBool){
            conSave = conMod + prof;
        } else {
            conSave = conMod;
        }
    }

    public void setIntSave(){
        if (intBool){
            intSave = intMod + prof;
        } else {
            intSave = intMod;
        }
    }

    public void setWisSave(){
        if (wisBool){
            wisSave = wisMod + prof;
        } else {
            wisSave = wisMod;
        }
    }

    public void setChaSave(){
        if (chaBool){
            chaSave = chaMod + prof;
        } else {
            chaSave = chaMod;
        }
    }

    public int modCalc (int stat){
        int result;
        if (stat == 10){
            result = 0;
        } else if (stat > 10){
            result = (int) Math.floor((stat - 10) / 2);
        } else {
            result = (int) Math.floor(((stat - 1) - 10) / 2);
        }
        return result;
    }

    public String getName() {
        return nameString;
    }
    public String getClassString() { return classString; }
    public String getRace() { return raceString; }
    public String getAlign() {return alignString; }
    public String getBaseExpString() {return baseExpString; }
    public String getTotExpString() {return totExpString; }
    public String getBackground() {return backgroundString; }
    public String getPersonality() {return personalityString; }
    public String getBond() {return bondString; }
    public String getFlaw() {return flawString; }
    public int getStr() {return str; }
    public int getStrMod() {return strMod; }
    public int getDex() {return dex; }
    public int getDexMod() {return dexMod; }
    public int getIntelligence() {return intelligence; }
    public int getIntMod() {return intMod; }
    public int getCon() {return con; }
    public int getConMod() {return conMod; }
    public int getWis() {return wis; }
    public int getWisMod() {return wisMod; }
    public int getCha() {return cha; }
    public int getChaMod() {return chaMod; }
    public int getHitDice() {return hitDice; }
    public int getBaseHp() {return baseHp;}
    public int getTotHp() {return totHp;}
    public int getTempHp() {return tempHp;}
    public int getAC() {return ac;}
    public int getSpeed() {return speed;}
    public int getInitiative() {return ini;}
    public int getProf() {return prof;}
    public boolean getAcrobaticsBool() {return acrobaticsBool;}
    public boolean getAnimalBool() {return animalBool;}
    public boolean getArcanaBool() {return arcanaBool;}
    public boolean getAthleticsBool() {return athleticsBool;}
    public boolean getDeceptionBool() {return deceptionBool;}
    public boolean getHistoryBool() {return historyBool;}
    public boolean getInsightBool() {return insightBool;}
    public boolean getIntimidationBool() {return intimidationBool;}
    public boolean getInvestigationBool() {return investigationBool;}
    public boolean getMedicineBool() {return medicineBool;}
    public boolean getNatureBool() {return natureBool;}
    public boolean getPerceptionBool() {return perceptionBool;}
    public boolean getPerformanceBool() {return performanceBool;}
    public boolean getPersuasionBool() {return persuasionBool;}
    public boolean getReligionBool() {return religionBool;}
    public boolean getSleightBool() {return sleightBool;}
    public boolean getStealthBool() {return stealthBool;}
    public boolean getSurvivalBool() {return survivalBool;}
    public boolean getStrBool() {return strBool;}
    public boolean getDexBool() {return dexBool;}
    public boolean getConBool() {return conBool;}
    public boolean getIntBool() {return intBool;}
    public boolean getWisBool() {return wisBool;}
    public boolean getChaBool() {return chaBool;}
    public int getAcrobatics() {return acrobatics;}
    public int getAnimal() {return animal;}
    public int getArcana() {return arcana;}
    public int getAthletics() {return athletics;}
    public int getDeception() {return deception;}
    public int getHistory() {return history;}
    public int getInsight() {return insight;}
    public int getIntimidation() {return intimidation;}
    public int getInvestigation() {return investigation;}
    public int getMedicine() {return medicine;}
    public int getNature() {return nature;}
    public int getPerception() {return perception;}
    public int getPerformance() {return performance;}
    public int getPersuasion() {return persuasion;}
    public int getReligion() {return religion;}
    public int getSleight() {return sleight;}
    public int getStealth() {return stealth;}
    public int getSurvival() {return survival;}
    public int getStrSave() {return strSave;}
    public int getDexSave() {return dexSave;}
    public int getIntSave() {return intSave;}
    public int getConSave() {return conSave;}
    public int getWisSave() {return wisSave;}
    public int getChaSave() {return chaSave;}
    public ArrayList getAbilityList() {return abilities;}
    public String getEquipment() {return equipment;}
    public String getCurrency() {return currency;}
    public boolean isCreatedCheck() {return isCreated;}
    public boolean getInspiration() {return inspiration;}
    public String getHpNote() {return hpNote;}
    public String getStrNote() {return strNote;}
    public String getDexNote() {return dexNote;}
    public String getConNote() {return conNote;}
    public String getIntNote() {return intNote;}
    public String getWisNote() {return wisNote;}
    public String getChaNote() {return chaNote;}
    public int getTempStr() {return tempStr;}
    public int getTempDex() {return tempDex;}
    public int getTempCon() {return tempCon;}
    public int getTempInt() {return tempInt;}
    public int getTempWis() {return tempWis;}
    public int getTempCha() {return tempCha;}
    public int getTempStrMod() {return tempStrMod;}
    public int getTempDexMod() {return tempDexMod;}
    public int getTempConMod() {return tempConMod;}
    public int getTempIntMod() {return tempIntMod;}
    public int getTempWisMod() {return tempWisMod;}
    public int getTempChaMod() {return tempChaMod;}



}