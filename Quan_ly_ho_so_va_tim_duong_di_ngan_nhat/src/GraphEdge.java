public class GraphEdge implements Comparable<GraphEdge> {
    int start;
    int end;
    int edge;

    public GraphEdge(int start, int end, int edge) {
        this.start = start;
        this.end = end;
        this.edge = edge;
    }

    @Override
    public int compareTo(GraphEdge k) {
        return Integer.compare(this.edge, k.edge);
    }
}
