package com.kmsr.models.graph;

import com.kmsr.models.linkedlist.LinkedList;
import lombok.Data;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Data
public class Graph<T> {
    private List<T> vertices;
    private Map<T, LinkedList<T>> adjacencyLists;
    private final boolean directed;

    private Graph(boolean directed) {
        this.directed = directed;
    }

    public static <V> Graph<V> createGraph(@NonNull List<V> vertices) {
        Graph<V> graph = new Graph<V>(false);
        graph.setVertices(vertices);
        return graph;
    }

    public void addEdge(T source, T destination) {
        doAddEdge(source, destination);

        if (!directed) {
            doAddEdge(destination, source);
        }
    }

    public boolean edgeExists(T source, T destination) {
        if (isNull(adjacencyLists)) return false;

        LinkedList<T> sourceAdjacencyList = adjacencyLists.get(source);

        if (isNull(sourceAdjacencyList)) return false;

        if (nonNull(sourceAdjacencyList.findNode(destination))) return true;

        return false;
    }

    private void doAddEdge(T source, T destination) {
        if (isNull(adjacencyLists)) {
            adjacencyLists = new HashMap<>();
        }

        LinkedList<T> sourceAdjacencyList = adjacencyLists.get(source);
        if (isNull(sourceAdjacencyList)) {
            adjacencyLists.put(source, LinkedList.createList(destination));
        } else {
            sourceAdjacencyList.addNode(destination);
        }
    }
}
