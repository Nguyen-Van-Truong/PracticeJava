package WishdomInterview.InterviewQuestion4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class WordPositionTracker {
    public static void main(String[] args) {
        String fileName = "src/WishdomInterview/InterviewQuestion4/textfile.txt";
        Map<String, TreeSet<Integer>> wordLines = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordLines.putIfAbsent(word, new TreeSet<>());
                        wordLines.get(word).add(lineNumber);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        for (Map.Entry<String, TreeSet<Integer>> entry : wordLines.entrySet()) {
            String word = entry.getKey();
            TreeSet<Integer> lines = entry.getValue();

            if (lines.size() > 1) {
                System.out.println(word + " " + lines.first() + "-" + lines.last());
            } else {
                System.out.println(word + " " + lines.first());
            }
        }
    }
}
