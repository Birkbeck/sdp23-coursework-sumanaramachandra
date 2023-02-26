package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;


/**
 * Represents an output instruction class.
 * Out instruction will result in printing the content of the register on console.
 * @author Sumana Ramachandra
 */

public class OutInstruction extends Instruction{

    private final RegisterName result;

    public static final String OP_CODE = "out";

    public OutInstruction(String label, RegisterName result) {
        super(label, OP_CODE);
        this.result = result;
    }
    @Override
    public int execute(Machine machine) {
        System.out.println(machine.getRegisters().get(result));
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + result;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof OutInstruction other){
            return Objects.equals(this.label, other.label)
                    && Objects.equals(this.result, other.result)
                    && this.opcode == other.opcode;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, result, opcode);
    }
}
