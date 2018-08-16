package com.lizy.algorithms.algorithms4thEdition.ch1.dataAbstraction;

import com.lizy.algorithms.util.StdIn;
import com.lizy.algorithms.util.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-8-16 20:05
 */
public class LinkedStack<Item> implements Iterable<Item> {
    private int n;
    private Node first;

    private class Node{
        private Item item;
        private Node next;
    }

    public LinkedStack(){
        first = null;
        n = 0;
        assert check();
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return n;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
        assert check();
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        assert check();
        return item;                   // return the saved item
    }

    public Item peek(){
        if(isEmpty())
            throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if(!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private boolean check() {
        if (n < 0) {
            return false;
        }
        if (n == 0) {
            if (first != null) return false;
        }
        else if (n == 1) {
            if (first == null)      return false;
            if (first.next != null) return false;
        }
        else {
            if (first == null)      return false;
            if (first.next == null) return false;
        }

        int numberOfNodes = 0;
        for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }

}
