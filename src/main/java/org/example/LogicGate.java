package org.example;

import java.util.ArrayList;

public abstract class LogicGate {
    protected ArrayList<LogicGate> inputs;
    
    public LogicGate(ArrayList<LogicGate> inputs) {
        this.inputs = inputs;
    }
    
    public LogicGate(LogicGate input) {
        this.inputs = new ArrayList<>();
        this.inputs.add(input);
    }
    
    public abstract boolean compute();
}
