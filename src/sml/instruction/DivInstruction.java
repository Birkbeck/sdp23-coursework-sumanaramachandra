package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

/**
 * Represents a division instruction class.
 * Div instruction will result in dividing the content of the registers.
 * @author Sumana Ramachandra
 */

public class DivInstruction extends Instruction{
    private final RegisterName result;
    private final RegisterName source;

    public static final String OP_CODE = "div";

    public DivInstruction(String label, RegisterName result, RegisterName source) {
        super(label, OP_CODE);
        this.result = result;
        this.source = source;
    }
    @Override
    public int execute(Machine machine) {
        int value1 = machine.getRegisters().get(result);
        int value2 = machine.getRegisters().get(source);
        machine.getRegisters().set(result, value1 / value2);
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + result + " " + source;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof DivInstruction other){
            return Objects.equals(this.label, other.label)
                    && Objects.equals(this.result, other.result)
                    && Objects.equals(this.source, other.source)
                    && this.opcode == other.opcode;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, result, source, opcode);
    }
}
