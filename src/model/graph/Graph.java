package model.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph<T> implements InterfaceGraphList{
    private final List<T> vertices;
    private final List<List<Edge<T>>> adj;

    public Graph() {
        vertices = new ArrayList<>();
        adj = new ArrayList<>();
    }

   /* @Override
    public void addVertex(Object vertex) {
        vertices.add((T) vertex);
        // Fill the existent rows with a new Edge
        for (List<Edge<T>> row : adj) {
            row.add(new Edge<>());
        }
        // Add a new row with a new ArrayList that contains n copies of Edge (n = adj.size + 1 E.g. 3 existing edges plus 1 new edge to add)
        adj.add(new ArrayList<>(Collections.nCopies(adj.size() + 1, new Edge<>())));
    }*/
   public void addVertex(Object vertex){
       if(validateVertexExists(getVertixIndex(vertex))){
           vertices.add((T) vertex);
       }
   }
    public int getVertixIndex(Object vertex){

        for (int i = 0; i < vertices.size(); i++) {
            if(vertices.get(i).equals(vertex)){
                return i;
            }
        }
       return -1;
    }

    @Override
    public void addEdge(Object vertex1, Object vertex2, int weight) throws Exception {
        int i = getVertixIndex(vertex1);
        int j = getVertixIndex(vertex2);

        if(i == -1 || j == -1){
            throw new Exception("Uno de los dos vertices no existe");
        } else{
            if(adj.get(i).isEmpty()){
                List<Edge<T>> adjvertex1 = new ArrayList<>();
                adjvertex1.add(new Edge<T>((T) vertex1, (T) vertex2, weight));
                adj.add(i, adjvertex1);
            } else{
                adj.get(i).add(new Edge<T>((T) vertex1, (T) vertex2, weight));
            }

            if(adj.get(j).isEmpty()){
                List<Edge<T>> adjvertex2 = new ArrayList<>();
                adjvertex2.add(new Edge<T>((T) vertex2, (T) vertex1, weight));
                adj.add(i, adjvertex2);
            } else{
                adj.get(i).add(new Edge<T>((T) vertex2, (T) vertex1, weight));
            }
        }
    }

    public boolean validateVertexExists(int sourceIndex) {
        if (sourceIndex == -1){
            throw new IllegalArgumentException("Both vertices must be in the graph.");
        } else{
            return true;
        }

    }

    public List<List<Edge<T>>> getAdj() {
        return adj;
    }

    public List<T> getVertices() {
        return vertices;
    }
}
