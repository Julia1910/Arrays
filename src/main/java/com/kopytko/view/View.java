package com.kopytko.view;

import com.kopytko.controller.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Logger log = LogManager.getLogger(View.class);
    private Controller controller;
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public View() {
        controller = new ControllerImpl();
        menu = new LinkedHashMap<>();
        menu.put("1", "  1 - work with Container");
        menu.put("2", "  2 - work with PriorityQueue");
        menu.put("3", "  3 - work with Container of String");
        menu.put("4", "  4 - work with 2 arrays");
        menu.put("5", "  5 - remove number that repeat more than 2 times");
        menu.put("6", "  6 - remove identical consecutive numbers");
        menu.put("7", "  7 - game");
        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("1", this::pressButton1);
        methodsMenu.put("2", this::pressButton2);
        methodsMenu.put("3", this::pressButton3);
        methodsMenu.put("4", this::pressButton4);
        methodsMenu.put("5", this::pressButton5);
        methodsMenu.put("6", this::pressButton6);
        methodsMenu.put("7", this::pressButton7);
    }

    private void pressButton1() {
        controller.createContainer();
    }

    private void pressButton2() {
        log.info("How much numbers you want to add?");
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            log.info("Input " + (i+1)+ " element");
            int e = input.nextInt();
            array[i] = e;
        }
        controller.createPriorityQueue(array);
    }

    private void pressButton3() {
        controller.createArrayString();
    }

    private void pressButton4() {
        log.info("Enter size of array: ");
        int n = input.nextInt();
        controller.getThirdArray(n);
    }

    private void pressButton5() {
        log.info("Enter size of array: ");
        int n = input.nextInt();
        controller.removeRepeating(n);
    }

    private void pressButton6() {
        log.info("Enter size of array: ");
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            log.info("Input " + (i+1) + " element");
            int e = input.nextInt();
            array[i] = e;
        }
        controller.removeConsecutive(array);
    }

    private void pressButton7() {
        controller.getGame();
    }

    private void outputMenu() {
        log.info("\nMENU:");
        for (String str : menu.values()) {
            log.info(str);
        }
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            log.info("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("Q"));
    }

}
