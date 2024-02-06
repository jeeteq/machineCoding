package multilevelcache;

public interface CacheInterface {

    String readKey(String key);

    void writeKey(String key, String value);

    void deleteKey(String key);

}
