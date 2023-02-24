package sml;

// TODO: write a JavaDoc for the class

/**
 * Represents an abstract instruction.
 * An abstract instruction class that defines the concrete methods for executing instructions.
 * Each instruction has a label and an opcode, indicating the operation to be performed.
 *  @author Sumana Ramachandra
 */
public abstract class Instruction {
	protected final String label;
	protected final String opcode;

	/**
	 * Constructor: an instruction with a label and an opcode
	 * (opcode must be an operation of the language)
	 *
	 * @param label optional label (can be null)
	 * @param opcode operation name
	 */
	public Instruction(String label, String opcode) {
		this.label = label;
		this.opcode = opcode;
	}

	public String getLabel() {
		return label;
	}

	public String getOpcode() {
		return opcode;
	}

	public static int NORMAL_PROGRAM_COUNTER_UPDATE = -1;

	/**
	 * Executes the instruction in the given machine.
	 *
	 * @param machine the machine the instruction runs on
	 * @return the new program counter (for jump instructions)
	 *          or NORMAL_PROGRAM_COUNTER_UPDATE to indicate that
	 *          the instruction with the next address is to be executed
	 */

	public abstract int execute(Machine machine);

	protected String getLabelString() {
		return (getLabel() == null) ? "" : getLabel() + ": ";
	}

	// TODO: What does abstract in the declaration below mean?
	//       (Write a short explanation.)
	/*An abstract method declaration of toString would require all its subclasses to provide implementation.
	Thus ensuring that all the subclasses of this class contains a method 'toString' with their own implementation
	that returns a string format of the object/value provided to it.
	*/
	@Override
	public abstract String toString();

	// TODO: Make sure that subclasses also implement equals and hashCode (needed in class Machine).
	@Override
	public abstract boolean equals(Object o);

	@Override
	public abstract int hashCode();
}
