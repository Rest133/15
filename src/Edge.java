public class Edge {
    private Cell beginCell;
    private Cell endCell;
    private int weight;
    private boolean wasVisited = false;

    Edge(Cell node1, Cell node2, int w) {
        beginCell = node1;
        endCell = node2;
        weight = w;
    }

    public void setWasVisited(boolean b) {
        wasVisited = b;
    }

    public void setWeight(int w) {
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

    public boolean isWasVisited() {
        return wasVisited;
    }

    public String toString() {
        return "(" + beginCell.getNumberOnCell() + ")" + " - " + "(" + endCell.getNumberOnCell() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge second = (Edge) obj;
        if (beginCell == second.endCell && endCell == second.beginCell || beginCell == second.beginCell && endCell == second.endCell)
            return true;
        return false;
    }
}
