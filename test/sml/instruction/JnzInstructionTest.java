package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.*;
public class JnzInstructionTest {
    private Machine machine;
    private Registers registers;

    @BeforeEach
    void setUp() {
        machine = new Machine(new Registers());
        registers = machine.getRegisters();
        //...
    }

    @AfterEach
    void tearDown() {
        machine = null;
        registers = null;
    }

    @Test
    void executeJNZ() {
        registers.set(EAX, 5);
        machine.getLabels().addLabel("f1", 100);
        Instruction instruction = new JnzInstruction(null, EAX, "f1");
        Assertions.assertEquals(100, instruction.execute(machine));
    }

    @Test
    void executeJNZero() {
        registers.set(EAX, 0);
        machine.getLabels().addLabel("f2", 200);
        Instruction instruction = new JnzInstruction(null, EAX, "f2");
        Assertions.assertEquals(-1, instruction.execute(machine));
    }
}
