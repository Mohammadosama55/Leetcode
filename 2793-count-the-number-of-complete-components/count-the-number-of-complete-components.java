class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Create adjacency list
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Build the graph
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int completeComponents = 0;
        
        // Check each unvisited node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Get all nodes in this component
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);
                
                // Check if this component is complete
                if (isComplete(component, graph)) {
                    completeComponents++;
                }
            }
        }
        
        return completeComponents;
    }
    
    private void dfs(int node, List<Integer>[] graph, boolean[] visited, 
                     List<Integer> component) {
        visited[node] = true;
        component.add(node);
        
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }
    
    private boolean isComplete(List<Integer> component, List<Integer>[] graph) {
        int size = component.size();
        
        // A complete component with 'size' nodes should have
        // each node with exactly (size - 1) connections within the component
        for (int node : component) {
            if (graph[node].size() != size - 1) {
                return false;
            }
        }
        
        return true;
    }
}
