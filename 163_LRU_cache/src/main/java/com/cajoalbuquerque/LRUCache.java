package com.cajoalbuquerque;

import java.util.HashMap;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node getPrev() {
        return this.prev;
    }

    public Node getNext() {
        return this.next;
    }

    public int getKey() {
        return this.key;
    }

    public int getValue() {
        return this.value;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void remove() {
        this.prev.setNext(this.next);
        this.next.setPrev(this.prev);
    }
}

class LRUCache {
    HashMap<Integer, Node> cache;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.setNext(tail);
        tail.setPrev(head);
    }

    public int get(int key) {
        Node node = cache.get(key);

        if(node == null)
            return -1;

        node.remove();
        addNode(node);

        return node.getValue();
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.remove();
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        cache.put(key, newNode);

        if (cache.size() > capacity) {
            Node lru = tail.getPrev();
            cache.remove(lru.getKey());
            lru.remove();
        }
    }

    private void addNode(Node node) {
        Node next = head.getNext();
        node.setNext(next);
        next.setPrev(node);

        head.setNext(node);
        node.setPrev(head);
    }
}