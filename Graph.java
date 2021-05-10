import java.util.*;

public class Graph implements GraphInterface<Town, Road> {
	
	Set<Town> towns = new HashSet();
	Set<Road> roads = new HashSet();
	
	Set<Town> open = new HashSet();
	Set<Town> closed = new HashSet();
	Map<Town, Integer> distances = new HashMap();

	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		
		if (sourceVertex == null || destinationVertex == null)
			return null;
		
		for(Road next : roads)
			if (next.contains(sourceVertex) && next.contains(destinationVertex))
				return next;
		return null;
	}
	
	private Town getVertex(Town vertex) {
		
		if (vertex == null)
			return null;
		
		for (Town next : towns)
			if (next.equals(vertex))
				return next;
		return null;
	}

	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		if (containsVertex(sourceVertex) && containsVertex(destinationVertex)) {
			
			Road newRoad = new Road(sourceVertex, destinationVertex, weight, description);
			roads.add(newRoad);
			return newRoad;
		}
		throw new IllegalArgumentException();
	}

	public boolean addVertex(Town v) {
		
		if (containsVertex(v))
			return false;
		
		towns.add(new Town(v)); // This makes adds a new copy of the town, not the original town. change if needed
		return true;
	}

	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		return getEdge(sourceVertex, destinationVertex) != null;
	}

	public boolean containsVertex(Town v) {
		return getVertex(v) != null;
	}

	public Set<Road> edgeSet() {
		return roads;
	}

	public Set<Road> edgesOf(Town vertex) {
		
		Set<Road> allEdges = new HashSet();
		for (Road next : roads)
			if (next.contains(vertex))
				allEdges.add(next);
		
		return allEdges;
	}

	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		Road edge = getEdge(sourceVertex, destinationVertex);
		if (edge == null || edge.getWeight() != weight
				|| description == null || description.equals(edge.getName()))
			return null;
		roads.remove(edge);
		return edge;
	}

	public boolean removeVertex(Town v) {
		
		if (v != null && containsVertex(v)) {
			
			Set<Road> edges = edgesOf(v);
			for (Road next : edges)
				roads.remove(next);
			
			towns.remove(v);
			return true;
		}
		return false;
	}

	public Set<Town> vertexSet() {
		return towns;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	public void dijkstraShortestPath(Town sourceVertex) {
		
		

//		while (!open.isEmpty()) {
//			int minWt = Integer.MAX_VALUE;
//			Town minAdjVertex = null; // at each step the vertex that is the closest to source but not yet in "closed"
//									// set
//			for (Town vertex : closed) {
//				for (Town adjVertex : getOpenVert(vertex, open)) { // adjTownsInOpen) {
//					int wt = getEdge(adjVertex, vertex).getWeight() + distances.get(vertex);
//					if (wt < minWt) {
//						minWt = wt;
//						minAdjVertex = adjVertex;
//						//adjVertex.setBackPath(vertex);
//					}
//				}
//			}
//			if (minAdjVertex != null) {
//				distances.put(minAdjVertex, minWt);
//				open.remove(minAdjVertex);
//				closed.add(minAdjVertex);
//			}
//		}

	}
	
	private Set<Town> getOpenVert(Town town, Set<Town> set) {
		
		Set<Town> toReturn = new HashSet();
		for(Town next : town.getAdjacents())
			if (set.contains(next))
				toReturn.add(next);
		return toReturn;
	}

}
