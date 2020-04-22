package Lesson7;

import java.util.LinkedList;

public class MyGraph {
    private int vertexCount;
    private int edgeCount;
    private LinkedList<Integer>[] adjLists;

    public MyGraph(int vertexCount) {
        if (vertexCount < 0) {
            throw new IllegalArgumentException("Не допустимое количество вершин");
        }
        this.vertexCount = vertexCount;
        adjLists = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    public int vertexCount() {
        return vertexCount;
    }

    public int edgeCount() {
        return edgeCount;
    }

    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0) {
            throw new IllegalArgumentException("Номер не может быть отрицательным");
        }

        if (v1 >= vertexCount || v2 >= vertexCount) {
            throw new IndexOutOfBoundsException("Нет вершины с таким номером");
        }

        adjLists[v1].add(v2);
        adjLists[v2].add(v1);
    }

    public LinkedList<Integer> adjLists(int vertex) {
        return adjLists[vertex];
    }
}
