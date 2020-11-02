package mas.sstr.niti.diana;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Transition {
    @SerializedName("inputs")
    private List<Input> inputs = null;
    @SerializedName("outputs")
    private List<Output> outputs = null;
    @SerializedName("tmin")
    private int tmin;
    @SerializedName("tmax")
    private int tmax;
    private int transitionTime;

    public List<Input> getInputs() {
        return inputs;
    }

    public void setInputs(List<Input> inputs) {
        this.inputs = inputs;
    }

    public List<Output> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<Output> outputs) {
        this.outputs = outputs;
    }

    public int getTmin() {
        return tmin;
    }

    public void setTmin(int tmin) {
        this.tmin = tmin;
    }

    public int getTmax() {
        return tmax;
    }

    public void setTmax(int tmax) {
        this.tmax = tmax;
    }

    public void setTransitionTime(int transitionTime) {
        this.transitionTime = transitionTime;
    }

    public int getTransitionTime() {
        return transitionTime;
    }

    public boolean execute(List<Node> inputNodes, List<Node> outputNodes) {

        if (!isExecutable(inputNodes)) {
            return false;
        }
        int transitionTimeCount = 0;
        for (Node node : inputNodes) {
            node.setJeton(node.getJeton() - 1);
        }
        for (int i = 0; i < transitionTime; i++) {
            transitionTimeCount++;
            if (transitionTimeCount == transitionTime) {
                for (Node node : outputNodes) {
                    node.setJeton(node.getJeton() + 1);
                }
            }
        }
        return true;
    }

    public boolean isExecutable(List<Node> nodes) {
        for (Node node : nodes) {
            if (node.getJeton() <= 0) {
                return false;
            }
        }
        return true;
    }

    public int generateRandomTemp() {
        if (tmin == tmax) {
            return tmin;
        } else {
            return (tmin + (int) (Math.random() * ((tmax - tmin) + 1)));
        }
    }
}
