package org.example;

import java.util.ArrayList;

public class AndGate extends LogicGate {
    public AndGate(ArrayList<LogicGate> inputs) {
        super(inputs);
    }
    
    @Override
    public boolean compute() {
        return this.inputs.stream().allMatch(LogicGate::compute);
    }
}
