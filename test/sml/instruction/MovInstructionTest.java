package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.*;

public class MovInstructionTest {
    private Machine machine;

    @BeforeEach
    void setUp() {
        machine = new Machine(new Registers());
        //...
    }

    @AfterEach
    void tearDown() {
        machine = null;
    }

    @Test
    void executeValid() {
        Instruction instruction = new MovInstruction(null, EAX, 10);
        instruction.execute(machine);
        Assertions.assertEquals(10, machine.getRegisters().get(EAX));
    }

    @Test
    void executeValidTwo() {
        Instruction instruction = new MovInstruction(null, EAX, -90);
        instruction.execute(machine);
        Assertions.assertEquals(-90, machine.getRegisters().get(EAX));
    }
}
