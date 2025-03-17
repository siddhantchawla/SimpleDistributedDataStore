package distributed.datastore.storage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class Storage {

    private final Map<String ,String> storage = new ConcurrentHashMap<>();

    public void put(String key, String value) {
        System.out.println("Put request: " + key + ", " +  value);
        storage.put(key, value);
    }

    public String get(String key) {
        System.out.println("Get request: " + key);
        return storage.get(key);
    }
}