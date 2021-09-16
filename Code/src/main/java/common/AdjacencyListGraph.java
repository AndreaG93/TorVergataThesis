package common;

/**
 * This class is used to model a graph using "Adjacency List" representation.
 * <p>
 * We have adopted this representation because:
 * <ul>
 *   <li>
 *   Since we expect to build very sparse graphs (that is a graph in which the number of edges is much less than the
 *   possible number of edges), this representation ables us to save a lot of space.
 *   </li>
 *   <li>
 *   Is very easy to find the vertices adjacent to a vertex.
 *   </li>
 *   <li>
 *   Because we expect to build graphs where each vertex has at most 2 adjacent vertices and, more commonly, only one
 *   adjacent vertex, is possible to explore adjacency lists very quickly (cost O(1) or, at most, O(2)).
 *   </li>
 * </ul>
 * </p>
 */
public class AdjacencyListGraph {

    public final int maxNumberOfVertices;
    private final AdjacencyListGraphVertex[] vertices;

    public AdjacencyListGraph(int maxNumberOfVertices) {
        this.maxNumberOfVertices = maxNumberOfVertices;
        this.vertices = new AdjacencyListGraphVertex[maxNumberOfVertices];
    }

    /**
     * This function is used to insert a vertex inside this graph.
     *
     * @param vertex A @code{AdjacencyListGraphVertex} object which 'id' must be between 0 and the max number of
     *               vertices of current graph.
     * @throws IllegalArgumentException Raised when vertex 'id' value is illegal.
     */
    public void insertGraphVertex(AdjacencyListGraphVertex vertex) throws IllegalArgumentException {

        if ((vertex.id < 0) || (vertex.id >= this.maxNumberOfVertices))
            throw new IllegalArgumentException("[Error] Vertex 'id' value is illegal!");
        else
            this.vertices[vertex.id] = vertex;
    }

    public AdjacencyListGraphVertex getGraphVertex(int vertexId) {
        return this.vertices[vertexId];
    }
}
