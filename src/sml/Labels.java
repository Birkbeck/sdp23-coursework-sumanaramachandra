package sml;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

// TODO: write a JavaDoc for the class [completed]

/**
 * Represents a label class.
 * Each label is associated with memory address, thus allowing the machine to execute instructions referenced by the label.
 * @author Sumana Ramachandra
 */
public final class Labels {
	private final Map<String, Integer> labels = new HashMap<>();

	/**
	 * Adds a label with the associated address to the map.
	 *
	 * @param label the label
	 * @param address the address the label refers to
	 */
	public void addLabel(String label, int address) {
		Objects.requireNonNull(label);
		// TODO: Add a check that there are no label duplicates. [completed]
		if(labels.containsKey(label)){
			throw new IllegalArgumentException(label + " already exists");
		}
		labels.put(label, address);
	}

	/**
	 * Returns the address associated with the label.
	 *
	 * @param label the label
	 * @return the address the label refers to
	 */
	public int getAddress(String label){
		// TODO: Where can NullPointerException be thrown here?
		//       (Write an explanation.)
		//       Add code to deal with non-existent labels. [completed]
		// NullPointerException is thrown here, to handle the scenario
		// where the label (key) passed does not exist.
		if(labels.get(label)==null){
			throw new NullPointerException("Label cannot be null");
		}
		return labels.get(label);
	}

	/**
	 * representation of this instance,
	 * in the form "[label -> address, label -> address, ..., label -> address]"
	 *
	 * @return the string representation of the labels map
	 */
	@Override
	public String toString() {
		// TODO: Implement the method using the Stream API (see also class Registers). [completed]
		return labels.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.map(e -> e.getKey() + " -> " + e.getValue())
				.collect(Collectors.joining(", ", "[", "]"));
	}

	// TODO: Implement equals and hashCode (needed in class Machine). [completed]

	@Override
	public boolean equals(Object o) {
		if (o instanceof Labels lab) {
			return Objects.equals(this.labels, lab.labels);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(labels);
	}
	/**
	 * Removes the labels
	 */
	public void reset() {
		labels.clear();
	}
}
