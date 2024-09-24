package org.example;

import java.util.ArrayList;

public class Input extends LogicGate {
    private boolean state;
    
    public Input(boolean state) {
        super(new ArrayList<>());
        this.state = state;
    }
    
    @Override
    public boolean compute() {
        return state;
    }
}
