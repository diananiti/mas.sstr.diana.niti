package mas.sstr.niti.diana.exemplu;

public class Node {
    private int dir;
    private int value;

    public Node(int value, int dir) {
        this.dir = dir;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public int execute() {
        this.value += this.dir;
        return this.value;
    }
}