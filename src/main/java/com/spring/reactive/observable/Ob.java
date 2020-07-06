package com.spring.reactive.observable;

import java.util.Observable;
import java.util.Observer;


@SuppressWarnings("deprecation")
public class Ob {
    static class InitObservable extends Observable implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                setChanged();
                notifyObservers(i); //push
            }
        }
    }

    public static void main(String[] args) {
        Observer ob = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(arg);
            }
        };

        InitObservable io = new InitObservable();
        io.addObserver(ob);
        io.run();
    }
}
