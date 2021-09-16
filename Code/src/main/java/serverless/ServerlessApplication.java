package serverless;


import common.AdjacencyListGraph;
import common.AdjacencyListGraphVertex;

/**
 * This class is used to model a generic composition of serverless functions which is represented by a 'Control Flow
 * Graph' (CFG) where each vertex contains either a @code{ServerlessFunction} object or a @code{ServerlessControlFunction} object
 * which is used to manage the control flow of the composition.
 */
public class ServerlessApplication {

    private final AdjacencyListGraph controlFlowGraph;
    private float currentExecutionTime;
    private float currentBilledTime;
    private int firstServerlessFunctionId;

    public ServerlessApplication(int numberOfServerlessFunctions, int numberOfControlFunctions) {
        this.controlFlowGraph = new AdjacencyListGraph(numberOfServerlessFunctions + numberOfControlFunctions);
    }

    public void insertServerlessFunction(ServerlessFunction serverlessFunction) {

    }


    public void Execute() {

        AdjacencyListGraphVertex currentVertex = this.controlFlowGraph.getGraphVertex(0);
        /*
        while (currentVertex != null) {

            ServerlessFunction serverlessFunction = (ServerlessFunction) currentVertex.content;

            serverlessFunction.Execute(null);
            this.currentBilledTime += serverlessFunction.getBilledTime();
            this.currentExecutionTime += serverlessFunction.getExecutionTime();

            currentVertex = currentVertex.getAdjacencyList().get(0);
        }
        */

    }


    public float getExecutionTime() {
        return this.currentExecutionTime;
    }


    public float getBilledTime() {
        return this.currentBilledTime;
    }
}
