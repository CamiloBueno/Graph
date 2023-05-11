package model.graph;

import java.util.Comparator;

public class Edge<T> implements Comparator<Edge<T>> {
    private T source;
    private T destiny;
    private int weight;

    public Edge() {}

    public Edge(T source, T destiny, int weight) {
        this.source = source;
        this.destiny = destiny;
        this.weight = weight;
    }

    public T getSource() {
        return source;
    }

    public void setSource(T source) {
        this.source = source;
    }

    public T getDestiny() {
        return destiny;
    }

    public void setDestiny(T destiny) {
        this.destiny = destiny;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compare(Edge<T> e1, Edge<T> e2) {
        return e1.getWeight() - e2.getWeight();
    }
}
