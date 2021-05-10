
public class Road implements Comparable<Road> {
	
	private Town source;
	private Town dest;
	
	private int distance;
	private String name;

	public Road(Town a, Town b, int d, String n) {
		
		source = a;
		dest = b;
		distance = d;
		name = n;
	}
	
	public Road(Town a, Town b, String n) {
		this(a, b, 1, n);
	}
	
	public boolean contains(Town other) {
		return source.equals(other) || dest.equals(other);
	}
	
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	
	public Town getDestination() {
		return dest;
	}
	
	public Town getSource() {
		return source;
	}
	
	public int compareTo(Road other) {
		return name.compareTo(other.name);
	}
	
	public int getWeight() {
		return distance;
	}
	
	public boolean equals(Object other) {
		
		if (other instanceof Road)
			return compareTo((Road)other) == 0;
		return false;
	}

}
