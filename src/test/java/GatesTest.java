import org.example.LogicGate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GatesTest {
    @Test
    public void testNotGate() {
        // Given NOT gate with false input
        var not = LogicGate.not(false);
        // When tested, it should return true
        assertTrue(not.apply());
        // Given NOT gate with true input
        not = LogicGate.not(true);
        // When tested, it should return false
        assertFalse(not.apply());
    }
    
    @Test
    public void testAndGate() {
        // Given AND gate with both false
        var and = LogicGate.and(false, false);
        // When tested, it should return false
        assertFalse(and.apply());
        // Given AND gate with one true one false
        and = LogicGate.and(false, true);
        // When tested, it should return false
        assertFalse(and.apply());
        // Given AND gate with one true one false in the opposite order
        and = LogicGate.and(true, false);
        // When tested, it should return false
        assertFalse(and.apply());
        // Given AND gate with both true
        and = LogicGate.and(true, true);
        // When tested, it should return true
        assertTrue(and.apply());
    }
}
