package org.example;

public class NotGate extends LogicGate {
    public NotGate(LogicGate input) {
        super(input);
    }
    
    @Override
    public boolean compute() {
        if (inputs.size() != 1) {
            throw new IllegalStateException("Not Gate may only have one input!");
        }
        
        return !inputs.get(0).compute();
    }
}
