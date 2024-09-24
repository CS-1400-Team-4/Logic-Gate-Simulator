package org.example;

public class Main {
    public static void main(String[] args) {
        Input input = new Input(false);
        NotGate gate = new NotGate(input);
        System.out.println(gate.compute());
    }
}