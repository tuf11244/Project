package GraphProblemsPartIII;
import java.util.*;

/**
 * https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
 * Date: 03/20/2025
 * @author Parth
 */
public class FindAllPossibleRecipesfromGivenSupplies {
    
    public static void main(String[] args) {
        // Main method left empty, likely used for testing purposes.
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        // Map to store the in-degree (number of dependencies) for each recipe
        HashMap<String, Integer> indegree = new HashMap<>();
        
        // Adjacency list representation of the graph, where each ingredient points to recipes that depend on it
        HashMap<String, List<String>> graph = new HashMap<>();

        // Set to store all available supplies for quick lookup
        HashSet<String> supply = new HashSet<>();

        // Add all supplies to the set, as these are immediately available ingredients
        for (int i = 0; i < supplies.length; i++) {
            supply.add(supplies[i]);
        }

        // Construct the graph by iterating over each recipe and its ingredients
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];

            // Iterate over the required ingredients for the current recipe
            for (int j = 0; j < ingredients.get(i).size(); j++) {
                String ingredient = ingredients.get(i).get(j);

                // If the ingredient already exists as a key in the graph, retrieve its list of dependent recipes
                if (graph.containsKey(ingredient)) {
                    List<String> list = graph.get(ingredient);
                    list.add(recipe); // Add the current recipe as dependent on this ingredient
                    graph.put(ingredient, list);
                } else {
                    // Otherwise, create a new list with the current recipe as dependent on this ingredient
                    List<String> list = new ArrayList<>();
                    list.add(recipe);
                    graph.put(ingredient, list);
                }

                // Increase the in-degree count for the recipe (it depends on one more ingredient)
                indegree.put(recipe, indegree.getOrDefault(recipe, 0) + 1);
            }
        }

        // Queue to process nodes in a topological order
        Queue<String> queue = new LinkedList<>();

        // Add all ingredients that are not dependent on anything (i.e., have no in-degree)
        for (String ingredient : graph.keySet()) {
            if (!indegree.containsKey(ingredient)) { // If an ingredient is not in the in-degree map, it has no dependencies
                queue.add(ingredient);
            }
        }

        List<String> result = new ArrayList<>();

        // Process the queue using topological sorting (similar to Kahn's algorithm)
        while (!queue.isEmpty()) {
            String current = queue.poll(); // Get the next available ingredient

            // If the current ingredient is in the supply and has dependent recipes, process them
            if (supply.contains(current) && graph.containsKey(current)) {
                List<String> dependentRecipes = graph.get(current);

                for (int i = 0; i < dependentRecipes.size(); i++) {
                    String recipe = dependentRecipes.get(i);

                    // Reduce the in-degree count for the dependent recipe
                    indegree.put(recipe, indegree.get(recipe) - 1);

                    // If all ingredients required for this recipe are now available (in-degree becomes 0)
                    if (indegree.get(recipe) == 0) {
                        queue.add(recipe); // Add the recipe to the queue for processing
                        indegree.remove(recipe); // Remove it from in-degree map as it's now processed
                        result.add(recipe); // Add to result list since it can now be made
                        supply.add(recipe); // Add to supply so it can be used for other recipes
                    }
                }
            }
        }

        return result;
    }
}
