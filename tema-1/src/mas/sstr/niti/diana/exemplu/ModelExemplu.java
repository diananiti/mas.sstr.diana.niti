package mas.sstr.niti.diana.exemplu;


import mas.sstr.niti.diana.Model;
//import mas.sstr.niti.diana.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ModelExemplu implements Model {
    List<Node> nodes = new ArrayList();

    public ModelExemplu(int n1, int n2) {
        this.nodes.add(new Node(n1, 1));
        this.nodes.add(new Node(n2, -1));
    }

    public void step(int step) {
        Iterator var2 = this.nodes.iterator();

        while(var2.hasNext()) {
            Node n = (Node)var2.next();
            n.execute();
        }

        System.out.println("node1 = " + ((Node)this.nodes.get(0)).getValue() + " node2 = " + ((Node)this.nodes.get(1)).getValue() + " at step " + step);
    }

    public boolean canStop() {
        return Math.abs(((Node)this.nodes.get(1)).getValue() - ((Node)this.nodes.get(0)).getValue()) < 2;
    }
}