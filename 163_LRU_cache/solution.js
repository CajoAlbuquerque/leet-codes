class Node {
    constructor(key, value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

/**
 * @param {number} capacity
 */
var LRUCache = function (capacity) {
    this.capacity = capacity;
    // map that stores nodes
    this.hashmap = new Map();
    // double linked list
    this.head = new Node(0, 0);
    this.tail = new Node(0, 0);
    this.head.next = this.tail;
    this.tail.prev = this.head;
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function (key) {
    if (!this.hashmap.has(key))
        return -1;

    const node = this.hashmap.get(key);
    this._remove(node)
    this._add(node)

    return node.value;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function (key, value) {
    // Evict LRU
    if (this.hashmap.size >= this.capacity && !this.hashmap.has(key)) {
        const lruNode = this.tail.prev;
        this.hashmap.delete(lruNode.key);
        this._remove(lruNode);
    }

    if (this.hashmap.has(key)) {
        const existingNode = this.hashmap.get(key);
        this._remove(existingNode);
    }

    const newNode = new Node(key, value)
    this._add(newNode);
    this.hashmap.set(key, newNode);
};

LRUCache.prototype._remove = function (node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
};

LRUCache.prototype._add = function (node) {
    node.next = this.head.next;
    node.prev = this.head;
    this.head.next.prev = node;
    this.head.next = node;
};

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

let lRUCache = new LRUCache(3);
lRUCache.put(1, 1);
lRUCache.put(2, 2);
lRUCache.put(3, 3);
let return1 = lRUCache.get(2); // 2
lRUCache.put(4, 4);
let return2 = lRUCache.get(1); // -1
let return3 = lRUCache.get(3); // 3
lRUCache.put(5, 5);
let return4 = lRUCache.get(2); // -1
