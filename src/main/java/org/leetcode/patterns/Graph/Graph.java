package org.leetcode.patterns.Graph;

import java.util.*;

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

    // Remove an edge between two vertices.
    public void removeEdge(int vertex1, int vertex2) {
        if (adjacencyList.get(vertex1) == null || adjacencyList.get(vertex2) == null) {
            return;
        }
        adjacencyList.get(vertex1).remove(vertex2);
        adjacencyList.get(vertex2).remove(vertex1);

    }

    // Get a list of all vertices.
    public ArrayList<Integer> getVertices() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    // Check if two vertices are adjacent.
    public boolean isAdjacent(int vertex1, int vertex2) {
        if (adjacencyList.get(vertex1) == null || adjacencyList.get(vertex2) == null) {
            return false;
        }
        return adjacencyList.get(vertex1).contains(vertex2) && adjacencyList.get(vertex2).contains(vertex1);
    }

    // Get the total number of vertices.
    public int getVertexCount() {
        return adjacencyList.size();
    }

    // Get the total number of edges.
    public int getEdgeCount() {
        int count = 0;
        for (List<Integer> neighbors : adjacencyList.values()) {
            count += neighbors.size();
        }
        return count / 2;
    }

    // Get a list of all edges.
    public ArrayList<Pair<Integer, Integer>> getEdges() {
        ArrayList<Pair<Integer, Integer>> edges = new ArrayList<>();
        for (Integer vertexLeft : adjacencyList.keySet()) {
            for (Integer vertexRight : adjacencyList.get(vertexLeft)) {
                edges.add(new Pair<>(vertexLeft, vertexRight));
            }
        }
        return edges;
    }

    // Get a list of neighbors of a given vertex.
    public ArrayList<Integer> getNeighbors(int vertex) {
        ArrayList<Integer> neighborList = new ArrayList<>();
        for (List<Integer> neighbors : adjacencyList.values()) {
            neighborList.addAll(neighbors);
        }
        return neighborList;
    }
}