package com.kmsr.models.graph;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphTest extends TestCase {

    public void testCreateGraph_nullVertices() {
        try {
            Graph<String> graph = Graph.createGraph(null);
            Assert.fail("Expected exception");
        } catch (NullPointerException e) {
            System.out.println(e.getCause() + e.getMessage());
        }
    }

    public void testCreateGraph_nonNullVertices() {
        Graph<String> graph = Graph.createGraph(getVertices());
        assertEquals(3, graph.getVertices().size());
        assertTrue(graph.getVertices().contains("A"));
        assertTrue(graph.getVertices().contains("B"));
        assertTrue(graph.getVertices().contains("C"));
    }

    public void testAddEdge_nullSource() {
        try {
            Graph<String> graph = Graph.createGraph(getVertices());
            graph.addEdge(null, "B");
            Assert.fail("Expected exception");
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    public void testAddEdge_nullDestination() {
        try {
            Graph<String> graph = Graph.createGraph(getVertices());
            graph.addEdge("A", null);
            Assert.fail("Expected exception");
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    public void testAddEdge_singleEdge() {
        Graph<String> graph = Graph.createGraph(getVertices());
        graph.addEdge("A", "B");

        Assert.assertTrue(graph.edgeExists("A", "B"));
        Assert.assertTrue(graph.edgeExists("B", "A"));
        Assert.assertFalse(graph.edgeExists("A", "C"));
    }

    public void testAddEdge_multipleEdges() {
        List<String> vertices = List.of("A", "B", "C", "D", "E");
        Graph<String> graph = Graph.createGraph(vertices);
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");

        Assert.assertTrue(graph.edgeExists("A", "B"));
        Assert.assertTrue(graph.edgeExists("B", "C"));
        Assert.assertTrue(graph.edgeExists("B", "D"));
        Assert.assertTrue(graph.edgeExists("B", "E"));
        Assert.assertTrue(graph.edgeExists("E", "B"));
        Assert.assertTrue(graph.edgeExists("D", "B"));
        Assert.assertTrue(graph.edgeExists("C", "B"));
        Assert.assertTrue(graph.edgeExists("B", "A"));
    }

    private List<String> getVertices() {
        List<String> vertices = new ArrayList<>();
        vertices.add("A");
        vertices.add("B");
        vertices.add("C");
        return vertices;
    }
}
