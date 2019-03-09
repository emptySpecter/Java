public class Main7 {

    public static void main(String[] args) {
//        testGraph();
//        testDfs();
        testBfs();
    }

    private static void testBfs() {
        Graph graph = new Graph(10);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        graph.addVertex("J");

        graph.addEdge("A","G");
        graph.addEdge("A","I");
        graph.addEdge("B","J");
        graph.addEdge("B","G");
        graph.addEdge("C","D");
        graph.addEdge("C","E");
        graph.addEdge("D","E");
        graph.addEdge("D","I");
        graph.addEdge("E","H");
        graph.addEdge("F","J");
        graph.addEdge("I","J");

        graph.calculateDistancis("A");

    }

    private static void testDfs() {
        Graph graph = new Graph(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdges("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        graph.dfs("A");
    }

    private static void testGraph() {
        Graph graph = new Graph(5);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdges("A", "B", "C");
        graph.addEdges("B", "A", "C", "D");
        graph.addEdges("C", "A", "B", "D");
        graph.addEdges("D", "B", "C");

        graph.display();
    }
}