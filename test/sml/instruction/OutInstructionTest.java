package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sml.Instruction;
import sml.Machine;
import sml.Registers;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static sml.Registers.Register.*;
public class OutInstructionTest {
    private Machine machine;
    private Registers registers;

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream pOut = System.out;

    @BeforeEach
    void setUp() {
        machine = new Machine(new Registers());
        registers = machine.getRegisters();
        System.setOut(new PrintStream(out));
        //...
    }

    @AfterEach
    void tearDown() {
        machine = null;
        registers = null;
        System.setOut(pOut);
    }

    @Test
    void executeOut() {
        registers.set(EAX, 5);
        Instruction instruction = new OutInstruction(null, EAX);
        instruction.execute(machine);
        Assertions.assertEquals("5", out.toString().trim());
    }

    @Test
    void executeOutTwo() {
        registers.set(EAX, -5);
        Instruction instruction = new OutInstruction(null, EAX);
        instruction.execute(machine);
        Assertions.assertEquals("-5", out.toString().trim());
    }
}
