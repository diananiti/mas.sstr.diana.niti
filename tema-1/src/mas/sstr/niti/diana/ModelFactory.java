package mas.sstr.niti.diana;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;
//import org.json.*;


public class ModelFactory {

    private static final Type TPNMODEL_TYPE = new TypeToken<List<TPNSchema>>() {
    }.getType();

    public static Model loadTpnModelFromJsonFile(String modelFile) throws Exception {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(modelFile));
        TPNSchema tpnModel = gson.fromJson(reader, TPNSchema.class);
        return tpnModel;
    }

}