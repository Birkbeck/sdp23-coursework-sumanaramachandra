package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

/**
 * Represents a jnz instruction class.
 * Jnz instruction will transfer the control to an address specified in label if the content of the register is not zero.
 * @author Sumana Ramachandra
 */

public class JnzInstruction extends Instruction {

    private final RegisterName result;
    private final String jmpLabel;

    public static final String OP_CODE = "jnz";

    public JnzInstruction(String label, RegisterName result, String jmpLabel) {
        super(label, OP_CODE);
        this.result = result;
        this.jmpLabel = jmpLabel;
    }
    @Override
    public int execute(Machine machine) {
        int value = machine.getRegisters().get(result);
        if(value!=0){
            return machine.getLabels().getAddress(jmpLabel);
        }
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + result + " " + label;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof JnzInstruction other){
            return Objects.equals(this.label, other.label)
                    && Objects.equals(this.result, other.result)
                    && Objects.equals(this.jmpLabel, other.jmpLabel)
                    && this.opcode == other.opcode;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, result, jmpLabel, opcode);
    }
}
