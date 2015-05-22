package com.cisco.trails.cache;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/6/14
 * Time: 3:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Cache<K, V> {

    private Map<K, V> map;

    Cache() {
        map = new ConcurrentHashMap<K, V>();
    }

    public void setMap(Map<K, V> map) {
        this.map = map;
    }

    public void add(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public boolean purge(K key) {
        return (map.remove(key) != null);
    }

    public Collection<K> getKeys() {
        return map.keySet();
    }

    public Collection<V> getValues() {
        return map.values();
    }
}

