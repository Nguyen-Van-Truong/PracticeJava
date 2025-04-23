package WishdomInterview.InterviewQuestion2;

import java.util.LinkedList;

class SequentialSearchST<Key, Value> {
    private LinkedList<Node>[] table;
    private int size;

    private class Node {
        Key key;
        Value value;
        
        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public SequentialSearchST(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }

    public void put(Key key, Value value) {
        int index = hash(key);
        for (Node node : table[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        table[index].add(new Node(key, value));
    }

    public Value get(Key key) {
        int index = hash(key);
        for (Node node : table[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void displayTable() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            for (Node node : table[i]) {
                System.out.print("[" + node.key + " -> " + node.value + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> hashTable = new SequentialSearchST<>(5);

        hashTable.put("S", 2);
        hashTable.put("E", 0);
        hashTable.put("X", 7);
        hashTable.put("A", 8);
        hashTable.put("R", 4);
        hashTable.put("C", 4);
        hashTable.put("H", 5);
        hashTable.put("P", 10);
        hashTable.put("L", 11);
        hashTable.put("M", 3);

        hashTable.displayTable();

        System.out.println("Gia tri cua 'E': " + hashTable.get("E"));
        System.out.println("Gia tri cua 'M': " + hashTable.get("M"));
        System.out.println("Gia tri cua 'X': " + hashTable.get("X"));
    }
}
