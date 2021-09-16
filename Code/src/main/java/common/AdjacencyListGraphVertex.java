package common;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to model a vertex of a graph represented using "Adjacency List" method.
 */
public class AdjacencyListGraphVertex {

    public final int id;
    public final Object content;
    private final List<AdjacencyListGraphVertex> adjacencyList;

    public AdjacencyListGraphVertex(int id, Object content) throws IllegalArgumentException {

        if (id < 0)
            throw new IllegalArgumentException("[Error] Vertex 'id' cannot be negative!");
        else {
            this.id = id;
            this.content = content;
            this.adjacencyList = new ArrayList<>();
        }
    }

    public void addAdjacentVertex(AdjacencyListGraphVertex vertex) {

        if (vertex == null)
            throw new IllegalArgumentException("[Error] Vertex cannot 'null'!");
        else
            this.adjacencyList.add(vertex);
    }

    public List<AdjacencyListGraphVertex> getAdjacencyList() {
        return adjacencyList;
    }
}
