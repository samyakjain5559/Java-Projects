package Least_costpath_ingraph;

import java.util.*;

//data structure to store graph edges
class Edge {
	public final int src, dest, weight;

	private Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	// Factory method for creating a Edge immutable instance
	public static Edge of(int a, int b, int c) {
		return new Edge(a, b, c);		// calls private constructor
	}
}

//BFS Node
class Node
{
	int vertex, depth, weight;

	Node(int vertex, int depth, int weight) {
		this.vertex = vertex;
		this.depth = depth;
		this.weight = weight;
	}
}

//class to represent a graph object
class Graph {
	// A list of lists to represent adjacency list
	List<List<Edge>> adj = new ArrayList<>();

	// Constructor to construct graph
	public Graph(List<Edge> edges, int N)
	{
		// resize the List to N elements of type List<Edge>
		for (int i = 0; i < N; i++) {
			adj.add(new ArrayList<>());
		}

		// add edges to the undirected graph
		for (Edge e : edges) {
			adj.get(e.src).add(e);
			adj.get(e.dest).add(e);
		}
	}
}

class Main
{
	// Perform BFS on graph g starting from vertex v
	public static int modifiedBFS(Graph g, int src, int dest, int m)
	{
		// create a queue used to do BFS
		Queue<Node> q = new ArrayDeque<>();

		// push source vertex into the queue
		q.add(new Node(src, 0, 0));

		// stores least-cost from source to destination
		int minCost = Integer.MAX_VALUE;

		// loop till queue is empty
		while (!q.isEmpty())
		{
			// pop front node from queue
			Node node = q.poll();

			int v = node.vertex;
			int depth = node.depth;
			int cost = node.weight;

			// if destination is reached and BFS depth is equal to m
			// update minimum cost calculated so far
			if (v == dest && depth == m) {
				minCost = Math.min(minCost, cost);  // cost here is increase by adding current node cost to its parent cost
			}

			// don't consider nodes having BFS depth more than m.
			// This check will result in optimized code and also
			// handle cycles in the graph (else loop will never break)
			if (depth > m)
				break;

			// do for every adjacent edge of v
			for (Edge edge : g.adj.get(v))
			{
				// push every vertex (discovered or undiscovered) into
				// the queue with depth as +1 of parent and cost equal
				// to cost of parent plus weight of current edge
				q.add(new Node(edge.dest, depth + 1, cost + edge.weight));
			}
		}

		// return least-cost
		return minCost;
	}

	public static void main(String[] args)
	{
		// List of graph edges as per above diagram
		List<Edge> edges = Arrays.asList(Edge.of(0, 6, -1), Edge.of(0, 1, 5),
										Edge.of(1, 6, 3), Edge.of(1, 5, 5),
										Edge.of(1, 2, 7), Edge.of(2, 3, 8),
										Edge.of(3, 4, 10), Edge.of(5, 2, -1),
										Edge.of(5, 3, 9), Edge.of(5, 4, 1),
										Edge.of(6, 5, 2), Edge.of(7, 6, 9),
										Edge.of(7, 1, 6));

		// Number of vertices in the graph
		int N = 8;

		// create a graph from edges
		Graph g = new Graph(edges, N);

		int src = 0, dest = 3, m = 4;

		// Do modified BFS traversal from source vertex src
		System.out.print(modifiedBFS(g, src, dest, m));
	}
}