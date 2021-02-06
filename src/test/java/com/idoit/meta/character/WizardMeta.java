package com.idoit.meta.character;

import com.idoit.meta.Meta;
import com.idoit.meta.item.weapon.StaffMeta;

public class WizardMeta extends CharacterMeta {
    public WizardMeta() throws ClassNotFoundException {
        className = "Wizard";
        fields.put("staff", Meta.getClassFromMeta(new StaffMeta()));
    }
}
