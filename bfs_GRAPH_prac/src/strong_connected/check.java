package strong_connected;
import java.util.*;


	// Data structure to store graph edges
	class Edge
	{
		int source, dest;

		public Edge(int source, int dest) {
			this.source = source;
			this.dest = dest;
		}
	}

	// Class to represent a graph object
	class Graph
	{
		// A List of Lists to represent an adjacency list
		List<List<Integer>> adjList = null;

		// Constructor
		Graph(List<Edge> edges, int N)
		{
			adjList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				adjList.add(new ArrayList<>());
			}

			// add edges to the directed graph
			for (Edge edge: edges)
			{
				int src = edge.source;
				int dest = edge.dest;

				adjList.get(src).add(dest);
			}
		}
	}
	
class check
{
		// Function to perform DFS Traversal
		private static void DFS(Graph graph, int v, boolean[] visited)
		{
			
			Stack<Integer> s = new Stack<>();
			List<Integer> list = new ArrayList();
			s.add(v);
			if(visited[v] == false) {
				list.add(v);
			}
			visited[v] = true;
			while(! s.isEmpty()){
				
				int u = s.pop();
				list.add(v);
			    for(int edge : graph.adjList.get(u)) {
			    	
			    	if(!visited[edge]) {
			    		s.add(edge);
			    		visited[edge] = true;
			    	}
			    }
			}
			
		}

		// Check if graph is strongly connected or not
		public static boolean check1(Graph graph, int N)
		{
			// do for every vertex
			for (int i = 0; i < N; i++)
			{
				// stores vertex is visited or not
				boolean[] visited = new boolean[N];

				// start DFS from first vertex
				DFS(graph, i, visited);

				// If DFS traversal doesn’t visit all vertices,
				// then graph is not strongly connected
				for (boolean b: visited)
					if (!b)
					return false;
			}
			return true;
		}

  public static void main(String[] args)
   {
			// List of graph edges as per above diagram
			List<Edge> edges = Arrays.asList(
					new Edge(0, 4), new Edge(1, 0), new Edge(1, 2),
					new Edge(2, 1), new Edge(2, 4), new Edge(3, 1),
					new Edge(3, 2) , new Edge(4, 3)
			);

			// Number of vertices in the graph
			final int N = 5;

			// construct graph
			Graph graph = new Graph(edges, N);

			// check if graph is not strongly connected or not
			if (check1(graph, N))
				System.out.println("Graph is Strongly Connected");
			else
				System.out.println("Graph is not Strongly Connected");
	}
}

