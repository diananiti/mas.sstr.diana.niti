package mas.sstr.niti.diana;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Input {

    @SerializedName("id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}