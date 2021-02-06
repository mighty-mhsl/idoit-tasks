package com.idoit;

import com.idoit.character.Archer;
import com.idoit.character.Knight;
import com.idoit.character.Wizard;
import com.idoit.character.npc.seller.Blacksmith;
import com.idoit.item.armor.Helmet;
import com.idoit.item.bijouterie.ring.StrengthRing;
import com.idoit.item.common.potion.HpPotion;
import com.idoit.item.weapon.Bow;
import com.idoit.item.weapon.Staff;
import com.idoit.item.weapon.Sword;

public class App {

    public static void main(String[] args) {
        Knight knight1 = new Knight("Lexa");
        Knight knight2 = new Knight("Eugene");
        Wizard wizard = new Wizard("Dumbledore");
        Archer archer = new Archer("Hood");

        Sword sword1 = new Sword("Sharp sword", 10);
        Sword sword2 = new Sword("Useless sword", 1);
        Staff staff = new Staff("Wooden staff", 7);
        Bow bow = new Bow("Student bow", 3);

        knight1.setSword(sword1);
        knight2.setSword(sword2);
        archer.setBow(bow);
        wizard.setStaff(staff);

        knight1.hit(knight2);
        knight2.hit(knight1);

        System.out.println(wizard.intelligence);
        System.out.println(archer.agility);

        System.out.println(sword1.damage);
        System.out.println(staff.damage);
        System.out.println(bow.damage);

        Blacksmith blacksmith = new Blacksmith("Vacula", 100);
        HpPotion hpPotion = new HpPotion("Small hp potion", 10);
        Helmet helmet = new Helmet("Helmet of ghosts", 10, 15);
        StrengthRing strengthRing = new StrengthRing("Usual strength ring", 1);
    }
}
