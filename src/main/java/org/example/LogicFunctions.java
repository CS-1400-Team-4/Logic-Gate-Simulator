package org.example;

import java.util.List;

public abstract class LogicFunctions {
    public static final MultiInputFunction AND = inputs -> inputs.stream().allMatch(i -> i);
    public static final MultiInputFunction OR = inputs -> inputs.stream().anyMatch(i -> i);
    public static final MultiInputFunction XOR = inputs -> inputs.stream().mapToInt(i -> i ? 1 : 0).sum() == 1;
    
    public static final MultiInputFunction NAND = inputs -> !inputs.stream().allMatch(i -> i);
    public static final MultiInputFunction NOR = inputs -> inputs.stream().noneMatch(i -> i);
    public static final MultiInputFunction XNOR = inputs -> inputs.stream().mapToInt(i -> i ? 1 : 0).sum() != 1;
    
    public static final SingleInputFunction NOT = input -> !input;
    
    
    @FunctionalInterface
    public interface MultiInputFunction {
        boolean apply(List<Boolean> inputs);
    }
    
    @FunctionalInterface
    public interface SingleInputFunction {
        boolean apply(boolean input);
    }
}
