import java.util.*;

public class Town implements Comparable<Town> {

	private String name;
	private Map<Town, Integer> towns;
	
	public Town(String n) {
		name = n;
		towns = new HashMap();
	}
	
	public Town(Town template) {
		this(template.name);
	}
	
	public Set<Town> getAdjacents() {
		return towns.keySet();
	}

	public String getName() {
		return name;
	}

	public int compareTo(Town other) {
		return name.compareTo(other.name);
	}
	
	public String toString() {
		return name;
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	
	public boolean equals(Object other) {
		
		if (other instanceof Town)
			return compareTo((Town)other) == 0;
		return false;
	}
}
