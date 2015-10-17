public class Vertex{
	public final String name;
	public Edge[] adjacencies;
	public Double minDistance = Double.POSITIVE_INFINITI;
	public Vertex previous;

	public Vertex(String name) {
		this.name = name;
	}
	public String toString() {
		eturn name;
	}
	public int compareTo(Vertex v) {
		return Double.compare(minDistance, v.minDistance);
	}
}