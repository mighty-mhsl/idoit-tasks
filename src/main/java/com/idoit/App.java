package com.idoit;

import com.idoit.character.Archer;
import com.idoit.character.Knight;
import com.idoit.character.Wizard;
import com.idoit.item.weapon.Bow;
import com.idoit.item.weapon.Staff;
import com.idoit.item.weapon.Sword;

public class App {

    public static void main(String[] args) {
        Knight knight1 = new Knight("Max");
        Knight knight2 = new Knight("Eugene");
        System.out.println(knight1.name);
        System.out.println(knight2.name);

        Wizard wizard = new Wizard();
        Archer archer = new Archer();
        System.out.println(wizard.intelligence);
        System.out.println(archer.agility);

        Sword sword = new Sword();
        Staff staff = new Staff();
        Bow bow = new Bow();
        System.out.println(sword.damage);
        System.out.println(staff.damage);
        System.out.println(bow.damage);
    }
}
