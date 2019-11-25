package com.kopytko.model;

import com.kopytko.model.arrays.*;
import com.kopytko.model.classes.*;
import com.kopytko.model.generics.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ModelImpl implements Model {
    private static Logger log = LogManager.getLogger(ModelImpl.class);

    @Override
    public void createContainer() {
        log.info("I created a new container that contains \n" +
                "Object, which are extended from 'Father'.\n");
        Son son = new Son("Danny", "John", "Smith", "green", "kind");
        Son son1 = new Son("Paulo", "John", "Smith", "blue", "bad");
        Container<Father> container = new Container(son);
        log.info(container.getElement());
        container.setElement(son1);
        log.info(container.getElement());
        Daughter daughter = new Daughter("Julia", "John", "Smith", "blue", "shy");
        container.setElement(daughter);
        log.info(container.getElement());
        log.info("       ");
        log.info("There is a ArrayList, which was created with wildcard");
        List<? super Father> list = new ArrayList<>();
        List<Daughter> daughters = new ArrayList<>();
        daughters.add(daughter);
        List<Son> sons = new ArrayList<>();
        sons.add(son);
        sons.add(son1);
        list.add(son);
        list.add(son1);
        list.add(daughter);
        for (int i = 0; i < list.size(); i++) {
            log.info(list.get(i));
        }
    }

    @Override
    public void createPriorityQueue(int[] array) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++){
            queue.add(array[i]);
        }

        for (int i = 0; i < queue.length(); i++ ) {
            log.info(queue.peek(i));
        }
        queue.poll();
        log.info("After poll");
        for (int i = 0; i < queue.length(); i++ ) {
            log.info(queue.peek(i));
        }
    }

    @Override
    public void createArrayString() {
        log.info("There is a array, that contains only String");
        ArrayString array = new ArrayString();
        array.add("Hello,");
        array.add("how");
        array.add("are");
        array.add("you");
        array.add("?");
        for (int i = 0; i < array.getSize(); i++) {
            log.info(array.get(i));
        }
    }

    @Override
    public void getThirdArray(int n) {
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int e = random.nextInt(10);
            firstArray[i] = e;
        }

        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int e = random.nextInt(10);
            secondArray[i] = e;
        }
        log.info("First array: ");
        for (int i = 0; i < firstArray.length; i++) {
            log.info((i+1) + ". " + firstArray[i]);
        }

        log.info("Second array");
        for (int i = 0; i < secondArray.length; i++) {
            log.info((i+1) + ". " + secondArray[i]);
        }

        ThirdArray thirdArray = new ThirdArray(firstArray,secondArray);
        thirdArray.getThirdArrayBoth();
        log.info("Result: ");
        log.info("Array that contains both");
        for (int i = 0; i < thirdArray.thirdArrayBoth.size(); i++) {
            log.info((i+1) + ". " + thirdArray.thirdArrayBoth.get(i));
        }

        log.info("Array that contains only one");
        for (int i = 0; i < thirdArray.array3.length; i++) {
            log.info((i+1) + ". " + thirdArray.array3[i]);
        }

    }

    @Override
    public void removeRepeating(int n) {
        log.info("Your elements: ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int e = random.nextInt(10);
            array[i] = e;
        }
        for (int i = 0; i < array.length; i++) {
            log.info((i+1) + ". " + array[i]);
        }
        ClearArray clearArray = new ClearArray(array);
        clearArray.clear();
        log.info("Your new array");
        for (int i = 0; i < clearArray.array.length; i++){
            log.info((i+1) + ". " +clearArray.array[i]);
        }
    }

    @Override
    public void removeConsecutive(int[] array) {
        DuplicateArray duplicateArray = new DuplicateArray(array);
        duplicateArray.deleteDuplicate();
        log.info("New Array: ");
        for (int i = 0; i < duplicateArray.array.length; i++) {
            log.info((i+1) + ". " + duplicateArray.array[i]);
        }
    }

    @Override
    public void getGame() {
        log.info("_____________________");
        log.info("NEW GAME");
        GameArray game = new GameArray();
        game.print();
        log.info("Hero can die in " + game.getDeath() + " doors");
        game.stayAlive();

    }


}
