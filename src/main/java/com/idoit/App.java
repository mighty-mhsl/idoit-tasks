package com.idoit;

import com.idoit.character.Archer;
import com.idoit.character.Knight;
import com.idoit.character.Wizard;

public class App {

    public static void main(String[] args) {
        Knight knight1 = new Knight();
        Knight knight2 = new Knight();
        System.out.println(knight1.hp);
        System.out.println(knight2.hp);

        Wizard wizard = new Wizard();
        Archer archer = new Archer();
    }
}
