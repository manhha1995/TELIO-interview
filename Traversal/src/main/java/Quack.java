package main.java;

import main.java.interfaces.QuackBehavior;

public class Quack implements QuackBehavior{
    public void quack() {
        System.out.println("Quack");
    }
}
