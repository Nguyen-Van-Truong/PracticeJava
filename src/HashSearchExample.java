import java.util.LinkedList;

// Lớp riêng cho Separate Chaining Hashing
class SeparateChainingHashST<Key, Value> {
    private int M; // Số lượng chuỗi (bucket)
    private LinkedList<Node>[] st; // Mảng của các danh sách liên kết (linked lists)

    // Node trong chuỗi liên kết
    private static class Node {
        Object key;
        Object val;
        Node(Object key, Object val) {
            this.key = key;
            this.val = val;
        }
    }

    // Khởi tạo với số bucket là M
    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (LinkedList<Node>[]) new LinkedList[M];
        for (int i = 0; i < M; i++) {
            st[i] = new LinkedList<>();
        }
    }

    // Hàm băm (hash function) để lấy chỉ số của bucket
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    // Thêm hoặc cập nhật cặp khóa-giá trị
    public void put(Key key, Value val) {
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                node.val = val; // Cập nhật giá trị nếu khóa đã tồn tại
                return;
            }
        }
        st[i].add(new Node(key, val)); // Thêm mới vào chuỗi liên kết
    }

    // Tìm kiếm giá trị dựa trên khóa
    public Value get(Key key) {
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                return (Value) node.val; // Trả về giá trị nếu tìm thấy khóa
            }
        }
        return null; // Trả về null nếu không tìm thấy khóa
    }

    // Hiển thị bảng băm
    public void displayHashTable() {
        for (int i = 0; i < M; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Node node : st[i]) {
                System.out.print("[" + node.key + " : " + node.val + "] ");
            }
            System.out.println();
        }
    }
}

public class HashSearchExample {
    public static void main(String[] args) {
        // Tạo bảng băm với 5 bucket
        SeparateChainingHashST<String, Integer> hashTable = new SeparateChainingHashST<>(5);

        // Thêm các cặp key-value vào bảng băm
        hashTable.put("S2", 0);
        hashTable.put("E0", 1);
        hashTable.put("A", 0);
        hashTable.put("R", 4);
        hashTable.put("C", 4);
        hashTable.put("H", 4);
        hashTable.put("E", 0);
        hashTable.put("X", 2);
        hashTable.put("M", 9);
        hashTable.put("P", 10);
        hashTable.put("L", 11);

        // Hiển thị bảng băm
        System.out.println("Hash Table:");
        hashTable.displayHashTable();

        // Tìm kiếm một số khóa
        System.out.println("\nSearching for keys:");
        String[] keysToSearch = {"A", "M", "X", "P", "Z"};
        for (String key : keysToSearch) {
            Integer val = hashTable.get(key);
            if (val != null) {
                System.out.println("Key " + key + " found with value: " + val);
            } else {
                System.out.println("Key " + key + " not found.");
            }
        }
    }
}
