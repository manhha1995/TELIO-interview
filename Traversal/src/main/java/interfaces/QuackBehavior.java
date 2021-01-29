package main.java.interfaces;

public interface QuackBehavior {
    public void quack();
    default void sound(){
        System.out.println("quack quack");
    }
}
