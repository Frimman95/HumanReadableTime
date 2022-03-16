package com.company;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        humanReadable();

    }

    public static void humanReadable() {
        Map<String, Long> map = new LinkedHashMap<>();

        Scanner sc = new Scanner(System.in);

        //Bekérek egy számot és megvizsgálja, hogy az pozitív e
        System.out.println("Enter a number which will represent seconds: ");
        long numberSeconds = sc.nextLong();
        while (numberSeconds < 0) {
            System.out.println("Please enter a positive number: ");
            numberSeconds = sc.nextLong();
        }

        //Végül amikor teszteltem különböző számokkal, 100 évnek megfelelő számnál már hibát dobott, ezért döntöttem a long-nál
        long yearSeconds = 31536000;/* 1 évben a másodpercek száma */
        long daySeconds = 86400; /* 1 napban a másodpercek száma */
        long hourSeconds = 3600; /* 1 órában a másodpercek száma */
        long minuteSeconds = 60; /* 1 percben a másodpercek száma */
        long seconds = 1; /*másodperc számolásához*/

        /*most kiírása*/
        if (numberSeconds == 0) {
            System.out.println("now");
        }

        /*évek*/
        long currentYears = numberSeconds / yearSeconds;
        if (currentYears != 0) {
            map.put("year(s)", currentYears);
        }

        /*napok*/
        long currentDays = numberSeconds % yearSeconds / daySeconds;
        if (currentDays != 0) {
            map.put("day(s)", currentDays);

        }

        /*órák*/
        long currentHours = (numberSeconds % yearSeconds) % daySeconds / hourSeconds;
        if (currentHours != 0) {
            map.put("hour(s)", currentHours);

        }

        /*percek*/
        long currentMinutes = (numberSeconds % yearSeconds) % daySeconds % hourSeconds / minuteSeconds;
        if (currentMinutes != 0) {
            map.put("minute(s)", currentMinutes);

        }


        /*másodpercek*/
        long currentSeconds = numberSeconds % minuteSeconds / seconds;
        if (currentSeconds != 0) {
            map.put("second(s)", currentSeconds);

        }

        //kiiratás, ahol megnézi, hogy melyik HashMap-ben van érték és azt iratja ki
        int i = 0;
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (i == 0) {
                System.out.print(value + " " + key);
                if (map.size() == 1) {
                    break;
                }
            } else if (i == map.size() - 1) {
                System.out.print(" and " + value + " " + key);
            } else {
                System.out.print(", " + value + " " + key);
            }
            i++;
        }

    }
}
