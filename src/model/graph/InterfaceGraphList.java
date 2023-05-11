package model.graph;

import java.util.List;

public interface InterfaceGraphList<T> {

    public void addVertex(T vertex);

    public void addEdge(T source, T destiny, int weight) throws Exception;

    public boolean validateVertexExists(int sourceIndex);

    public List<List<Edge<T>>> getAdj();

    public List<T> getVertices();



}
