import org.example.AndGate;
import org.example.Input;
import org.example.LogicGate;
import org.example.NotGate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GatesTest {
    @Test
    public void testNotGate() {
        Input trueInput = new Input(true);
        NotGate gate = new NotGate(trueInput);
        assertFalse(gate.compute());
        
        Input falseInput = new Input(false);
        gate = new NotGate(falseInput);
        assertTrue(gate.compute());
    }
    
    @Test
    public void andGate() {
        Input inputA = new Input(true);
        Input inputB = new Input(true);
        ArrayList<LogicGate> inputs = new ArrayList<>();
        inputs.add(inputA);
        inputs.add(inputB);
        AndGate andGate = new AndGate(inputs);
        assertTrue(andGate.compute());
    
        inputA = new Input(false);
        inputB = new Input(true);
        inputs = new ArrayList<>();
        inputs.add(inputA);
        inputs.add(inputB);
        andGate = new AndGate(inputs);
        assertFalse(andGate.compute());
    }
}
