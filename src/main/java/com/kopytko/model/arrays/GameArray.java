package com.kopytko.model.arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameArray {
    public int hero;
    public int[] doors;
    private static Logger log = LogManager.getLogger(GameArray.class);

    public GameArray() {
        this.hero = 25;
        this.doors = new int[10];
        Random random = new Random();
        for (int i = 0; i < doors.length; i++) {
            int e = random.nextInt((80 - (-100)) + 1) + (-100);
            if ((e <= (-5)) || (e >= 10) ) {
                doors[i] = e;
            }
            else {
                i--;
            }
        }
    }

    public void print() {
        for (int i = 0; i < doors.length; i++) {
            log.info("Door №" + (i+1) + ": " + doors[i]);
        }
    }

    public int getDeath() {
        int count = 0;
        int result;
        for (int i = 0; i < doors.length; i++) {
            result = doors[i] + hero;
            if (result < 0) {
                count++;
            }
        }
        return count;
    }

    public void stayAlive() {
        List<Integer> order = new ArrayList();
        List<Integer> elseIndex = new ArrayList<>();
        List<Integer> elseElse = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < doors.length; i++) {
            hero += doors[i];
            if (hero > 0) {
                order.add(i+1);
            }
            else {
                elseIndex.add(i);
                hero -= doors[i];
            }
        }
        for (int i = 0; i < elseIndex.size(); i++) {
            hero += doors[elseIndex.get(i)];
            if (hero > 0 ) {
                order.add(elseIndex.get(i) + 1);
            } else {
                elseElse.add(elseIndex.get(i));
                hero -= doors[elseIndex.get(i)];
            }
        }

        for (int i = 0; i < elseElse.size(); i++) {
            hero += doors[elseElse.get(i)];
            if (hero > 0) {
                order.add(elseElse.get(i));
            }
            else {
                index = elseElse.get(i) + 1;
                break;
            }
        }

            if (hero < 0) {
                for (int j = 0; j < order.size(); j++) {
                    log.info((j + 1) + ". " + order.get(j));
                }
                log.info("Hero died in Door №" + index);
            } else {
                log.info("Right order to stay alive: ");
                for (int j = 0; j < order.size(); j++) {
                    log.info((j + 1) + ". " + order.get(j));
                }
            }
            log.info("Now hero have " + hero + " powers.");
    }

}
