package GraphProblemsPartII;
import java.util.*;

/**
 * Date: 05/29/2024
 * https://leetcode.com/problems/evaluate-division/
 * @author parth
 */
public class EvaluateDivision {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Example usage:
        List<List<String>> equations = Arrays.asList(
            Arrays.asList("a", "b"), Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
            Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x")
        );

        double[] result = evaluateDivision(equations, values, queries);
        System.out.println(Arrays.toString(result));
    }

    public static double[] evaluateDivision(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // We create a HashMap as our adjacency list 
        HashMap<String, List<pair>> graph = new HashMap<>();

        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            double factor = values[i];

            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dest, new ArrayList<>());

            graph.get(src).add(new pair(dest, factor));        // To handle u/v
            graph.get(dest).add(new pair(src, 1.0 / factor));  // To handle v/u
        }

        double[] answer = new double[queries.size()];

        // Evaluate each query
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            double[] result = {-1.0};
            HashSet<String> visited = new HashSet<>();

            if (graph.containsKey(src) && graph.containsKey(dest)) {
                dfs(graph, src, dest, visited, 1.0, result);
            }

            answer[i] = result[0];
        }

        return answer;
    }

    public static void dfs(HashMap<String, List<pair>> graph, String src, String dest, HashSet<String> visited, double product, double[] result) {
        if (src.equals(dest)) {
            result[0] = product;
            return;
        }

        visited.add(src);

        for (pair neighbor : graph.get(src)) {
            if (!visited.contains(neighbor.vertex)) {
                dfs(graph, neighbor.vertex, dest, visited, product * neighbor.factor, result);
                if (result[0] != -1.0) { // Early exit if a valid path is found
                    return;
                }
            }
        }
    }
}

class pair {
    String vertex;
    double factor;

    public pair(String vertex, double factor) {
        this.vertex = vertex;
        this.factor = factor;
    }
}
