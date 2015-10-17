import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class dijkstra {

	public static void computePaths(Vertex s) {
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.offer(s);
		s.minDistance = 0;
		while (!pq.isEmpty()) {
			Vertex v = pq.poll();
			for (Edge e : v.adjacencies) {
				Vertex tmp = e.target;
				double currDistance = v.minDistance + e.weight;
				if (currDistance < tmp.minDistance) {
					pq.remove(tmp);
					tmp.minDistance = currDistance;
					tmp.previous = v;
					pq.offer(tmp);
				}
			}
		}
	}
	public static List<Vertex> getShortestPathTo(Vertex v) {
		List<Vertex> list = new ArrayList<Vertex>();
		Vertex curr = v;
		while (curr != null) {
			list.add(curr);
			curr = curr.previous;
		}
		Collections.reverse(list);
		return list;
	}
	
	public static void main(String[] args)
    {
        Vertex v0 = new Vertex("Redvile");
	Vertex v1 = new Vertex("Blueville");
	Vertex v2 = new Vertex("Greenville");
	Vertex v3 = new Vertex("Orangeville");
	Vertex v4 = new Vertex("Purpleville");

	v0.adjacencies = new Edge[]{ new Edge(v1, 5),
	                             new Edge(v2, 10),
                               new Edge(v3, 8) };
	v1.adjacencies = new Edge[]{ new Edge(v0, 5),
	                             new Edge(v2, 3),
	                             new Edge(v4, 7) };
	v2.adjacencies = new Edge[]{ new Edge(v0, 10),
                               new Edge(v1, 3) };
	v3.adjacencies = new Edge[]{ new Edge(v0, 8),
	                             new Edge(v4, 2) };
	v4.adjacencies = new Edge[]{ new Edge(v1, 7),
                               new Edge(v3, 2) };
	Vertex[] vertices = { v0, v1, v2, v3, v4 };
		computePaths(v0);
        for (Vertex v : vertices){
		    System.out.println("Distance to " + v + ": " + v.minDistance);
		    List<Vertex> path = getShortestPathTo(v);
		    System.out.println("Path: " + path);
		}
    }
	
}
