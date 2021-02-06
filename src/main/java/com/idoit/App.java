package com.idoit;

import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) {
        System.out.println("I do it!");
        System.out.println(LocalDateTime.now().getYear()); //всегда пишет текущий год, но вы можете написать просто число
    }
}
