package com.lizy.algorithms.algorithms4thEdition.ch3.ch3_1;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * @author: lizhiyong_tech@foxmail.com
 * @date: 2018-08-26 11:15.
 */
public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    private TreeMap<Key, Value> st;

    public ST(){
        st = new TreeMap<>();
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with null key");
        }
        return st.get(key);
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("calls put() with null key");
        }
        if (value == null) {
            st.remove(key);
        } else {
            st.put(key, value);
        }
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with null key");
        st.remove(key);
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("calls contains() with null key");
        return st.containsKey(key);
    }

    public int size() {
        return st.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Key> keys() {
        return st.keySet();
    }

    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }
}
