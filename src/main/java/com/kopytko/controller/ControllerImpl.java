package com.kopytko.controller;

import com.kopytko.model.*;

public class ControllerImpl implements Controller {
    private  Model model = new ModelImpl();

    @Override
    public void createContainer() {
        model.createContainer();
    }

    @Override
    public void createPriorityQueue(int[] array) {
        model.createPriorityQueue(array);
    }

    @Override
    public void createArrayString() {
        model.createArrayString();
    }

    @Override
    public void getThirdArray(int n) {
        model.getThirdArray(n);
    }

    @Override
    public void removeRepeating(int n) {
        model.removeRepeating(n);
    }

    @Override
    public void removeConsecutive(int[] array) {
        model.removeConsecutive(array);
    }

    @Override
    public void getGame() {
        model.getGame();
    }
}
