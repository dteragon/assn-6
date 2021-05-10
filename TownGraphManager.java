import java.io.*;
import java.util.*;

public class TownGraphManager implements TownGraphManagerInterface {

	Graph graph = new Graph();
	
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		
		try {
			graph.addEdge(new Town(town1), new Town(town2), weight, roadName);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	public String getRoad(String town1, String town2) {
		
		Road road = graph.getEdge(new Town(town1), new Town(town2));
		if (road == null)
			return null;
		return road.getName();
	}

	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}

	public Town getTown(String name) {
		
		for (Town next : graph.vertexSet())
			if (next.getName().equals(name))
				return next;
		return null;
	}

	public boolean containsTown(String v) {
		return graph.containsVertex(new Town(v));
	}

	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(new Town(town1), new Town(town2));
	}

	public ArrayList<String> allRoads() {
		
		ArrayList<String> roads = new ArrayList();
		for (Road next : graph.edgeSet())
			roads.add(next.getName());
		
		return roads;
	}

	public boolean deleteRoadConnection(String town1, String town2, String road) {
		return graph.removeEdge(new Town(town1), new Town(town2), 1, road) != null;
	}

	public boolean deleteTown(String v) {
		return graph.removeVertex(new Town(v));
	}

	public ArrayList<String> allTowns() {
		
		ArrayList<String> towns = new ArrayList();
		for (Town next : graph.vertexSet())
			towns.add(next.getName());
		
		return towns;
	}

	public ArrayList<String> getPath(String town1, String town2) {
		return graph.shortestPath(new Town(town1), new Town(town2));
	}

	public void populateTownGraph(File text) throws FileNotFoundException, IOException {
		
		Scanner fileIn = new Scanner(text);
		while (fileIn.hasNextLine()) {
			
			String connection = fileIn.nextLine();
			
			String[] towns = connection.split(";");
			addTown(towns[1]);
			addTown(towns[2]);
			
			String[] road = towns[0].split(",");
			addRoad(towns[1], towns[2], Integer.parseInt(road[1]), road[0]);
		}
	}
}
