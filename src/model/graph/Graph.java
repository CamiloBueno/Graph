package model.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph<T> {
    private final List<T> vertices;
    private final List<List<Edge<T>>> adj;

    public Graph() {
        vertices = new ArrayList<>();
        adj = new ArrayList<>();
    }

    public void addVertex(T vertex) {
        vertices.add(vertex);
        // Fill the existent rows with a new Edge
        for (List<Edge<T>> row : adj) {
            row.add(new Edge<>());
        }
        // Add a new row with a new ArrayList that contains n copies of Edge (n = adj.size + 1 E.g. 3 existing edges plus 1 new edge to add)
        adj.add(new ArrayList<>(Collections.nCopies(adj.size() + 1, new Edge<>())));
    }

    public void addEdge(T source, T destiny, int weight) {
        int sourceIndex = vertices.indexOf(source);
        int destinyIndex = vertices.indexOf(destiny);
        validateVertexExists(sourceIndex, destinyIndex);
        adj.get(sourceIndex).get(destinyIndex).setWeight(weight);
        adj.get(destinyIndex).get(sourceIndex).setWeight(weight);
    }

    private void validateVertexExists(int sourceIndex, int destinyIndex) {
        if (sourceIndex == -1 || destinyIndex == -1)
            throw new IllegalArgumentException("Both vertices must be in the graph.");
    }

    public List<List<Edge<T>>> getAdj() {
        return adj;
    }

    public List<T> getVertices() {
        return vertices;
    }
}
