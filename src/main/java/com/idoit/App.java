package com.idoit;

import com.idoit.character.Archer;
import com.idoit.character.Knight;
import com.idoit.character.Wizard;
import com.idoit.character.npc.Blacksmith;
import com.idoit.item.armor.Helmet;
import com.idoit.item.bijouterie.ring.StrengthRing;
import com.idoit.item.common.potion.HpPotion;
import com.idoit.item.weapon.Bow;
import com.idoit.item.weapon.Staff;
import com.idoit.item.weapon.Sword;

public class App {

    public static void main(String[] args) {
        Knight knight1 = new Knight("Max");
        Knight knight2 = new Knight("Eugene");

        Wizard wizard = new Wizard("Dumbledore");
        Archer archer = new Archer("Hood");
        System.out.println(wizard.intelligence);
        System.out.println(archer.agility);

        Sword sword = new Sword("Sharp sword", 10);
        Staff staff = new Staff("Wooden staff", 7);
        Bow bow = new Bow("Student bow", 3);

        knight1.hit(knight2);
        knight2.hit(knight1);

        System.out.println(sword.damage);
        System.out.println(staff.damage);
        System.out.println(bow.damage);

        Blacksmith blacksmith = new Blacksmith("Vacula", 100);
        HpPotion hpPotion = new HpPotion("Small hp potion", 10);
        Helmet helmet = new Helmet("Helmet of ghosts", 10, 15);
        StrengthRing strengthRing = new StrengthRing("Usual strength ring", 1);
    }
}
