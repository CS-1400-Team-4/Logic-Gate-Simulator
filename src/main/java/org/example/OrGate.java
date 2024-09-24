package org.example;

import java.util.ArrayList;

public class OrGate extends LogicGate {
    public OrGate(ArrayList<LogicGate> inputs) {
        super(inputs);
    }
    
    @Override
    public boolean compute() {
        return this.inputs.stream().anyMatch(LogicGate::compute);
    }
}
