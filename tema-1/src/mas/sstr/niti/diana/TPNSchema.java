package mas.sstr.niti.diana;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import mas.sstr.niti.diana.Model;
import mas.sstr.niti.diana.WriteToFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class TPNSchema implements Model {

    @SerializedName("nodes")
    private List<Node> nodes = null;
    @SerializedName("transitions")
    private List<Transition> transitions = null;
    private List<Transition> transitionsList = new ArrayList<>();
    private String firstMark;
    private String currentMark;
    private int deadLockCount;
    private boolean flag = true;

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

    public void setFirstMark(String firstMark) {
        this.firstMark = firstMark;
    }

    public Node getSpecificNodeById(int id) {
        for (Node node : nodes) {
            if (node.getId() == id) {
                return node;
            }
        }
        return null;
    }

    public String getMark() {
        String mark = "";
        for (Node node : nodes) {
            mark += node.getJeton() + " ";
        }
        return mark;
    }

    public void setTransitionTimeForTPNModel() {
        for (Transition transition : transitions) {
            transition.setTransitionTime(transition.generateRandomTemp());
        }
    }

    public List<Transition> generateTransitionTimeAscArray() {
        for (Transition transition : transitions) {
            transitionsList.add(transition);
        }
        Collections.sort(transitionsList, new Comparator<Transition>() {
            @Override
            public int compare(Transition o1, Transition o2) {
                if (o1.getTransitionTime() == o2.getTransitionTime()) {
                    return 0;
                }
                return o1.getTransitionTime() < o2.getTransitionTime() ? -1 : 1;
            }
        });
        return transitionsList;
    }

    @Override
    public void step(int step) {
        if (step == 1) {
            flag = false;
            firstMark = getMark();
            setTransitionTimeForTPNModel();
            generateTransitionTimeAscArray();
            WriteToFile.writeToFile("First mark: " + firstMark);
            System.out.println("First mark: " + firstMark);
        }
        deadLockCount = 0;
        for (Transition t : transitionsList) {
            List<Node> inputNodes = new ArrayList<>();
            List<Node> outputNodes = new ArrayList<>();
            for (int i = 0; i < t.getInputs().size(); i++) {
                inputNodes.add(getSpecificNodeById(t.getInputs().get(i).getId()));
            }
            for (int i = 0; i < t.getOutputs().size(); i++) {
                outputNodes.add(getSpecificNodeById(t.getOutputs().get(i).getId()));
            }
            if (t.execute(inputNodes, outputNodes)) {
                currentMark = getMark();
                WriteToFile.writeToFile(currentMark + "\n");
                System.out.println("Mark at step " + step + " : " + getMark());
            } else {
                deadLockCount++;
            }
        }
    }

    @Override
    public boolean canStop() {
        if (!flag) {
            if (firstMark.equals(currentMark)) {
                return true;
            }
        }
        if (deadLockCount == transitions.size()) {
            return true;
        }
        return false;
    }

}

