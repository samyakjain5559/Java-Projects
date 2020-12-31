package topological;

public class Graph {  // BOOK
/*
 /∗∗ Returns a list of verticies of directed acyclic graph g in topological order. ∗/
2 public static <V,E> PositionalList<Vertex<V>> topologicalSort(Graph<V,E> g) {
3 // list of vertices placed in topological order
4 PositionalList<Vertex<V>> topo = new LinkedPositionalList<>( );
5 // container of vertices that have no remaining constraints
6 Stack<Vertex<V>> ready = new LinkedStack<>( );
7 // map keeping track of remaining in-degree for each vertex
8 Map<Vertex<V>, Integer> inCount = new ProbeHashMap<>( );
9 for (Vertex<V> u : g.vertices( )) {
10 inCount.put(u, g.inDegree(u)); // initialize with actual in-degree
11 if (inCount.get(u) == 0) // if u has no incoming edges,
12 ready.push(u); // it is free of constraints
13 }
14 while (!ready.isEmpty( )) {   // NEVER COME OUT OF IT AS NEXT VERTECT BECOME 0 AFTER REDUCING INCOUNT O ALL THE OUTGOING EDGING OF PREDECISOR OF v
15 Vertex<V> u = ready.pop( );
16 topo.addLast(u);
17 for (Edge<E> e : g.outgoingEdges(u)) { // consider all outgoing neighbors of u
18 Vertex<V> v = g.opposite(u, e);
19 inCount.put(v, inCount.get(v) − 1); // v has one less constraint without u
20 if (inCount.get(v) == 0)
21 ready.push(v);
22 }
23 }
24 return topo;
25 }
*/  
}
