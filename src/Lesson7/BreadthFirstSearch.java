package Lesson7;

import java.util.LinkedList;

public class BreadthFirstSearch {
    private int[] edgeTo;
    private int[] distTo;
    private boolean[] marked;
    private int source;
    private static final int INFINITY = Integer.MAX_VALUE;

    public BreadthFirstSearch(MyGraph graph, int source) {
        if (source < 0) {
            throw new IllegalArgumentException();
        }
        if (source >= graph.vertexCount()) {
            throw new IndexOutOfBoundsException();
        }
        marked = new boolean[graph.vertexCount()];
        edgeTo = new int[graph.vertexCount()];
        distTo = new int[graph.vertexCount()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = INFINITY;
        }
        this.source = source;
        bfs(graph, source);
    }

    private void bfs(MyGraph graph, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;
        distTo[source] = 0;

        while (!queue.isEmpty()) {
            int v = queue.removeFirst();
            for (int w : graph.adjLists(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    queue.addLast(w);
                }
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

    public int distTo(int dist) {
        if (dist < 0) {
            throw new IllegalArgumentException();
        }
        if (dist >= marked.length) {
            throw new IndexOutOfBoundsException();
        }
        return distTo[dist];
    }
}
