package mas.sstr.niti.diana;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Node {

    @SerializedName("id")
    private int id;
    @SerializedName("jeton")
    private int jeton;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJeton() {
        return jeton;
    }

    public void setJeton(int jeton) {
        this.jeton = jeton;
    }

}
