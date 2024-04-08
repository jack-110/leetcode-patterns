package org.leetcode.patterns.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Graph {
    private final HashMap<Integer, ArrayList<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add a new vertex to the graph.
    public void addVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<>());
        }
    }

    // Remove a vertex from the graph.
    public void removeVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return;
        }
        adjacencyList.remove(vertex);
        for (List<Integer> neighbors : adjacencyList.values()) {
            if (neighbors.contains(vertex)) {
                neighbors.removeIf(v -> v == vertex);
            }
        }

    }

    // Add an edge between two vertices.
    public void addEdge(int vertex1, int vertex2) {
        if (adjacencyList.get(vertex1) == null) {
            addVertex(vertex1);
        }
        ArrayList<Integer> vertex1Edges = adjacencyList.get(vertex1);
        vertex1Edges.add(vertex2);

        if (adjacencyList.get(vertex2) == null) {
            addVertex(vertex2);
        }
        ArrayList<Integer> vertex2Edges = adjacencyList.get(vertex2);
        vertex2Edges.add(vertex1);
    }

    public void removeEdge(int vertex1, int vertex2) {

    }
    // Remove an edge between two vertices.

    public ArrayList<Integer> getVertices() {
        return null;
    }
    // Get a list of all vertices.

    public boolean isAdjacent(int vertex1, int vertex2) {
        return false;
    }
    // Check if two vertices are adjacent.

    public int getVertexCount() {
        return 0;
    }
    // Get the total number of vertices.

    public int getEdgeCount() {
        return 0;
    }
    // Get the total number of edges.

    public ArrayList<Pair<Integer, Integer>> getEdges() {
        return null;
    }
    // Get a list of all edges.

    public ArrayList<Integer> getNeighbors(int vertex) {
        return null;
    }
    // Get a list of neighbors of a given vertex.
}