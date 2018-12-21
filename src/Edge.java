public class Edge {
    private Cell beginCell;
    private Cell endCell;
    private boolean wasVisited = false;

    Edge(Cell node1, Cell node2) {
        beginCell = node1;
        endCell = node2;
    }

    public void setWasVisited(boolean b) {
        wasVisited = b;
    }

    public Cell getBeginCell() {
        return beginCell;
    }

    public Cell getEndCell() {
        return endCell;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public boolean hasUntouchableCell() {
        if (this.beginCell.isUntouchable() || this.endCell.isUntouchable()) return true;
        else return false;
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
