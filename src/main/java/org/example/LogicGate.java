package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class LogicGate {
    public abstract boolean apply();
    
    public static MultiInput and(LogicGate ... inputs) {
        return new MultiInput(LogicFunctions.AND).setInputs(Arrays.asList(inputs));
    }
    
    public static MultiInput and(Boolean ... inputs) {
        return new MultiInput(LogicFunctions.AND).setInputs(Arrays.stream(inputs).map(Input::new).collect(Collectors.toList()));
    }
    
    public static MultiInput or(LogicGate ... inputs) {
        return new MultiInput(LogicFunctions.OR).setInputs(Arrays.asList(inputs));
    }
    
    public static MultiInput or(Boolean ... inputs) {
        return new MultiInput(LogicFunctions.OR).setInputs(Arrays.stream(inputs).map(Input::new).collect(Collectors.toList()));
    }
    
    public static MultiInput xor(LogicGate ... inputs) {
        return new MultiInput(LogicFunctions.XOR).setInputs(Arrays.asList(inputs));
    }
    
    public static MultiInput xor(Boolean ... inputs) {
        return new MultiInput(LogicFunctions.XOR).setInputs(Arrays.stream(inputs).map(Input::new).collect(Collectors.toList()));
    }
    
    public static MultiInput nand(LogicGate ... inputs) {
        return new MultiInput(LogicFunctions.NAND).setInputs(Arrays.asList(inputs));
    }
    
    public static MultiInput nand(Boolean ... inputs) {
        return new MultiInput(LogicFunctions.NAND).setInputs(Arrays.stream(inputs).map(Input::new).collect(Collectors.toList()));
    }
    
    public static MultiInput nor(LogicGate ... inputs) {
        return new MultiInput(LogicFunctions.NOR).setInputs(Arrays.asList(inputs));
    }
    
    public static MultiInput nor(Boolean ... inputs) {
        return new MultiInput(LogicFunctions.NOR).setInputs(Arrays.stream(inputs).map(Input::new).collect(Collectors.toList()));
    }
    
    public static MultiInput xnor(LogicGate ... inputs) {
        return new MultiInput(LogicFunctions.XNOR).setInputs(Arrays.asList(inputs));
    }
    
    public static MultiInput xnor(Boolean ... inputs) {
        return new MultiInput(LogicFunctions.XNOR).setInputs(Arrays.stream(inputs).map(Input::new).collect(Collectors.toList()));
    }
    
    public static SingleInput not(LogicGate input) {
        return new SingleInput(LogicFunctions.NOT).setInput(input);
    }
    
    public static SingleInput not(boolean input) {
        return new SingleInput(LogicFunctions.NOT).setInput(new Input(input));
    }
    
    public static Input input(boolean state) {
        return new Input(state);
    }
    
    public static class MultiInput extends LogicGate {
        private final LogicFunctions.MultiInputFunction function;
        private List<LogicGate> inputs;
        
        private MultiInput(LogicFunctions.MultiInputFunction function) {
            this.function = function;
        }
        
        public MultiInput setInputs(List<LogicGate> inputs) {
            this.inputs = inputs;
            return this;
        }
        
        @Override
        public boolean apply() {
            return function.apply(this.inputs.stream().map(LogicGate::apply).collect(Collectors.toList()));
        }
    }
    
    public static class SingleInput extends LogicGate {
        private final LogicFunctions.SingleInputFunction function;
        private LogicGate input;
    
        private SingleInput(LogicFunctions.SingleInputFunction function) {
            this.function = function;
        }
    
        public SingleInput setInput(LogicGate input) {
            this.input = input;
            return this;
        }
        
        @Override
        public boolean apply() {
            return function.apply(input.apply());
        }
    }
    
    public static class Input extends LogicGate {
        private boolean state;
    
        private Input(boolean state) {
            this.state = state;
        }
    
        public void setState(boolean state) {
            this.state = state;
        }
    
        @Override
        public boolean apply() {
            return state;
        }
    }
}
