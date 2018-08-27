package com.lizy.algorithms.algorithms4thEdition.ch3.ch3_2;

import java.util.NoSuchElementException;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-8-27 11:05
 */
//Binary Search Tree
public class BST<Key extends Comparable<Key>,Value> {
    private Node root; //root of BST

    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        private int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BST(){}

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return size(root);
    }

    public int size(Node x) {
        if(x == null)
            return 0;
        else
            return x.size;
    }

    public boolean contains(Key key) {
        if(key == null)
            throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if(x == null)
            throw new IllegalArgumentException("calls get() with a null key");
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            return get(x.left, key);
        else if(cmp > 0)
            return get(x.right, key);
        else
            return x.val;
    }

    public void put (Key key,Value val){
        if (key == null) {
            throw new IllegalArgumentException("call put() with a null key");
        }
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
        assert check();
    }

    public Node put(Node x,Key key,Value val){
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if(cmp > 0)
            x.right = put(x.right, key, val);
        else if(cmp < 0)
            x.left = put(x.left, key, val);
        else
            x.val = val;
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMin(){
        if(isEmpty())
            throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        assert check();
    }

    public Node deleteMin(Node x) {
        if(x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if(isEmpty())
            throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
        assert check();
    }

    public Node deleteMax(Node x) {
        if(x.right == null)
            return x.left;
        x.right = deleteMin(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }


    public void delete(Key key) {
        if(key == null)
            throw new IllegalArgumentException("call delete() with a null key");
        root = delete(root, key);
        assert check();
    }

    public Node delete(Node x, Key key) {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp > 0)
            x.right = delete(x.right, key);
        else if(cmp < 0)
            x.left = delete(x.left, key);
        else {
            if(x.left == null)
                return x.right;
            else if(x.right == null)
                return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        if(isEmpty())
            throw new NoSuchElementException("call min() with empty symbol table");
        return min(root).key;
    }

    private Node min(Node x) {
        if(x.left == null)
            return x;
        else
            return min(x.left);
    }
    public Key max() {
        if (isEmpty())
            throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null)
            return x;
        else
            return max(x.right);
    }



    public boolean check(){
        return true;
    }
}
