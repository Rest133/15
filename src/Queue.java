import java.util.LinkedList;

class Queue {
    private LinkedList<Edge> queList;

    public Queue() {
        queList = new LinkedList<>();
    }

    public void insert(Edge edge) {
        queList.add(edge);
    }

    public Edge remove() {
        Edge lastElement = queList.getFirst();
        queList.removeFirst();
        return lastElement;
    }

    public boolean isEmpty() {
        return queList.isEmpty();
    }
}
