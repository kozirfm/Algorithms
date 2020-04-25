package Lesson7;

import java.util.LinkedList;

public class DepthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DepthFirstSearch(MyGraph graph, int source) {
        if (source < 0) {
            throw new IllegalArgumentException();
        }
        if (source >= graph.vertexCount()) {
            throw new IndexOutOfBoundsException();
        }
        this.source = source;
        edgeTo = new int[graph.vertexCount()];
        marked = new boolean[graph.vertexCount()];
        dfs(graph, source);
    }

    private void dfs(MyGraph graph, int vertex) {
        marked[vertex] = true;
        for (int w : graph.adjLists(vertex)) {
            if (!marked[w]) {
                edgeTo[w] = vertex;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int dist) {
        if (dist < 0) {
            throw new IllegalArgumentException();
        }
        if (dist >= marked.length) {
            throw new IndexOutOfBoundsException();
        }
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();

        int v = dist;
        while (v != source) {
            stack.push(v);
            v = edgeTo[v];
        }
        return stack;
    }
}
