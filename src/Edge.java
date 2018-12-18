public class Edge {
    private Cell beginCell;
    private Cell endCell;
    private int weight;

    Edge(Cell node1, Cell node2, int w) {
        beginCell = node1;
        endCell = node2;
        weight = w;
    }

    public Cell getBeginCell() {
        return beginCell;
    }

    public Cell getEndCell() {
        return endCell;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "(" + beginCell.getNumberOnCell() + ")" + " - " + "(" + endCell.getNumberOnCell() + ")";
    }
}
