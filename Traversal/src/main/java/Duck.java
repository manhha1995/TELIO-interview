package main.java;

import main.java.interfaces.FlyBehavior;
import main.java.interfaces.QuackBehavior;

public abstract class Duck {
    public abstract void display();

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks can swim");
    }
}
