package IO;

import Models.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class JsonParser{
    private String lastPath;

    public JsonParser() {
    }

    public <T> void writeJson(T obj, String pathToRoot) {
        this.lastPath = pathToRoot + "object-" + obj.hashCode() + "_" + new Random().nextLong() + ".json";
        File file = new File(this.lastPath);
        ObjectMapper mapper = new ObjectMapper();

        try {
            file.createNewFile();
            // Java objects to JSON file
            mapper.writeValue(file, obj);

            // Java objects to JSON string - compact-print
            String jsonString = mapper.writeValueAsString(obj);

            System.out.println(jsonString);

            // Java objects to JSON string - pretty-print
            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

            System.out.println(jsonInString2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> T readJson(T obj, String pathToFile){
        ObjectMapper mapper = new ObjectMapper();

        try {
            // JSON file to Java object
            if(this.lastPath.isEmpty())
                this.lastPath = pathToFile;

            var newObj = mapper.readValue(new File(this.lastPath), T.class);
            
            // pretty print
            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newObj);

            System.out.println(prettyStaff1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}