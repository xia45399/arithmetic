package arithmetic.other.lru;

import java.util.LinkedHashMap;

public class Lru<K, V> extends LinkedHashMap<K, V> {

    private int cap;

    public Lru(int cap) {
        super(cap, 0.75f, true);
        this.cap = cap;
    }

    /**
     * 重写LinkedHashMap中的removeEldestEntry方法，当LRU中元素多余时，
     * 删除最不经常使用的元素
     */
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        return size() > this.cap;
    }

}
