import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordOccurrences {
    public static void main(String[] args) {
        // Tạo bảng băm (hash table) để lưu trữ các từ và danh sách vị trí dòng
        HashMap<String, TreeSet<Integer>> wordMap = new HashMap<>();

        try {
            // Đọc tệp tin (giả lập việc đọc tệp)
            Scanner scanner = new Scanner(new File("input.txt"));
            int lineNumber = 0;

            // Đọc từng dòng trong tệp
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine().toLowerCase(); // Chuyển tất cả thành chữ thường

                // Tách dòng thành các từ
                String[] words = line.split("[\\W]+"); // Tách theo dấu câu và khoảng trắng

                // Thêm từ và vị trí dòng vào bảng băm
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordMap.putIfAbsent(word, new TreeSet<>());
                        wordMap.get(word).add(lineNumber);
                    }
                }
            }

            // Đóng scanner sau khi đọc xong
            scanner.close();

            // Hiển thị kết quả theo định dạng yêu cầu
            System.out.println("Word occurrences in file:");
            for (Map.Entry<String, TreeSet<Integer>> entry : wordMap.entrySet()) {
                System.out.print(entry.getKey() + " ");
                TreeSet<Integer> lines = entry.getValue();
                
                if (lines.size() == 1) {
                    System.out.println(lines.first());
                } else {
                    System.out.println(lines.first() + "-" + lines.last());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
