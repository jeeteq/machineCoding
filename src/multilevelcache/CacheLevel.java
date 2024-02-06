package multilevelcache;

public class CacheLevel implements CacheInterface {
    int level;
    CacheInterface nextCacheLevel;
    LFUCache<String, String> lfuCache;

    public  CacheLevel(int level, int capacity, CacheInterface nextCacheLevel) {
        this.level = level;
        this.nextCacheLevel = nextCacheLevel;
        this.lfuCache = new LFUCache<>(capacity);
    }


    @Override
    public String readKey(String key) {
        String value = lfuCache.get(key);
        if (value == null && nextCacheLevel != null) {
            value = nextCacheLevel.readKey(key);
            if (value != null) {
                writeKey(key, value);
            }
        }
        return value;
    }

    @Override
    public void writeKey(String key, String value) {
        lfuCache.put(key, value);
        if (lfuCache.isFull()) {
            String evictedKey = lfuCache.getEvictedKey();
            String evictedValue = lfuCache.getEvictedValue();
            if (nextCacheLevel != null) {
                nextCacheLevel.writeKey(evictedKey, evictedValue);
            }
        }
    }

    @Override
    public void deleteKey(String key) {
        lfuCache.removeKey(key);
        if (nextCacheLevel != null) {
            nextCacheLevel.deleteKey(key);
        }
    }
}
