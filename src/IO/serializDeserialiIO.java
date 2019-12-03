package IO;

import Models.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.time.LocalDate;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class serializDeserialiIO {
    private String lastPath;

    public serializDeserialiIO() {}

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    /*  JSON parser BEGIN     */
    public <T> void SserializeJson(T obj, String pathToRoot) {
        this.lastPath = pathToRoot + obj.getClass().getSimpleName().toLowerCase() + "_object-" + Math.abs(new Random().nextLong()) + ".json";
        File file = new File(this.lastPath);
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            file.createNewFile();
            mapper.writeValue(file, obj);
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Client DeserializeJson(Client obj, String pathToFile){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            if(pathToFile.isEmpty())
                return obj;

            Client newObj = mapper.readValue(new File(this.lastPath), Client.class);
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newObj));

            return newObj;
        } catch (IOException e) {
            e.printStackTrace();
            return obj;
        }
    }

    public Country DeserializeJson(Country obj, String pathToFile){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            if(pathToFile.isEmpty())
                return null;

            Country newObj = mapper.readValue(new File(this.lastPath), Country.class);
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newObj));

            return newObj;
        } catch (IOException e) {
            e.printStackTrace();
            return obj;
        }
    }

    public Location DeserializeJson(Location obj, String pathToFile){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            if(pathToFile.isEmpty())
                return obj;

            Location newObj = mapper.readValue(new File(this.lastPath), Location.class);
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newObj));

            return newObj;
        } catch (IOException e) {
            e.printStackTrace();
            return obj;
        }
    }

    public Order DeserializeJson(Order obj, String pathToFile){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            if(pathToFile.isEmpty())
                return obj;

            Order newObj = mapper.readValue(new File(this.lastPath), Order.class);
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newObj));

            return newObj;
        } catch (IOException e) {
            e.printStackTrace();
            return obj;
        }
    }

    public Service DeserializeJson(Service obj, String pathToFile){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            if(pathToFile.isEmpty())
                return obj;

            Service newObj = mapper.readValue(new File(this.lastPath), Service.class);
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newObj));

            return newObj;
        } catch (IOException e) {
            e.printStackTrace();
            return obj;
        }
    }

    public Tour DeserializeJson(Tour obj, String pathToFile){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            if(pathToFile.isEmpty())
                return obj;

            Tour newObj = mapper.readValue(new File(this.lastPath), Tour.class);
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newObj));

            return newObj;
        } catch (IOException e) {
            e.printStackTrace();
            return obj;
        }
    }

    public Worker DeserializeJson(Worker obj, String pathToFile){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            if(pathToFile.isEmpty())
                return obj;

            Worker newObj = mapper.readValue(new File(this.lastPath), Worker.class);
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newObj));

            return newObj;
        } catch (IOException e) {
            e.printStackTrace();
            return obj;
        }
    }
    /*  JSON parser END     */


    /*  XML parser  BEGIN   */
    public <T> void SerializeXml(T obj, String pathToRoot) throws IOException {
        this.lastPath = pathToRoot + obj.getClass().getSimpleName().toLowerCase() + "_object-" + Math.abs(new Random().nextLong()) + ".xml";

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        xmlMapper.writeValue(new File(this.lastPath), obj);
        File file = new File(this.lastPath);
        assertNotNull(file);
    }

    public Client DeserializeXml(Client obj, String pathToFile) throws IOException {
        if(pathToFile.isEmpty())
            return obj;

        File file = new File(pathToFile);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String xml = inputStreamToString(new FileInputStream(file));
        Client newObj = xmlMapper.readValue(xml, Client.class);
        assertNotNull(newObj);
        return newObj;
    }

    public Country DeserializeXml(Country obj, String pathToFile) throws IOException {
        if(pathToFile.isEmpty())
            return obj;

        File file = new File(pathToFile);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String xml = inputStreamToString(new FileInputStream(file));
        Country newObj = xmlMapper.readValue(xml, Country.class);
        assertNotNull(newObj);
        return newObj;
    }

    public Location DeserializeXml(Location obj, String pathToFile) throws IOException {
        if(pathToFile.isEmpty())
            return obj;

        File file = new File(pathToFile);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String xml = inputStreamToString(new FileInputStream(file));
        Location newObj = xmlMapper.readValue(xml, Location.class);
        assertNotNull(newObj);
        return newObj;
    }

    public Order DeserializeXml(Order obj, String pathToFile) throws IOException {
        if(pathToFile.isEmpty())
            return obj;

        File file = new File(pathToFile);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String xml = inputStreamToString(new FileInputStream(file));
        Order newObj = xmlMapper.readValue(xml, Order.class);
        assertNotNull(newObj);
        return newObj;
    }

    public Service DeserializeXml(Service obj, String pathToFile) throws IOException {
        if(pathToFile.isEmpty())
            return obj;

        File file = new File(pathToFile);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String xml = inputStreamToString(new FileInputStream(file));
        Service newObj = xmlMapper.readValue(xml, Service.class);
        assertNotNull(newObj);
        return newObj;
    }

    public Tour DeserializeXml(Tour obj, String pathToFile) throws IOException {
        if(pathToFile.isEmpty())
            return obj;

        File file = new File(pathToFile);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String xml = inputStreamToString(new FileInputStream(file));
        Tour newObj = xmlMapper.readValue(xml, Tour.class);
        assertNotNull(newObj);
        return newObj;
    }

    public Worker DeserializeXml(Worker obj, String pathToFile) throws IOException {
        if(pathToFile.isEmpty())
            return obj;

        File file = new File(pathToFile);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String xml = inputStreamToString(new FileInputStream(file));
        Worker newObj = xmlMapper.readValue(xml, Worker.class);
        assertNotNull(newObj);
        return newObj;
    }
    /*  XML parser  END   */
}