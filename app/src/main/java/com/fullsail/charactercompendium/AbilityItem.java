package com.fullsail.charactercompendium;
import java.io.Serializable;

/**
 * Created by administrator on 10/16/14.
 */
public class AbilityItem implements Serializable{

    private static final long serialVersionUID = 117541243238672491L;

    String name;
    String damage;
    String desc;

    public AbilityItem (String _name, String _damage, String _desc) {

        name = _name;
        damage = _damage;
        desc = _desc;

    }

    public String getName (){return name;}
    public String getDamage(){return damage;}
    public String getDesc(){return desc;}

    @Override
    public String toString() {
        return this.name;
    }


}
