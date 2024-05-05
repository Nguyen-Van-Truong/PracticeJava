import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MyStringTokenizer {
    private String line;
    private final String del; // Make del final

    public MyStringTokenizer(String line, String del) {
        this.line = line;
        this.del = del;
        removerDelimiters();
    }

    public void removerDelimiters() {
        while(line.startsWith(del)) {
            line = line.substring(del.length());
        }
    }

    public boolean hasMoreTokens() {
        return !line.isEmpty(); // Corrected the logic here
    }

    public String nextToken() {
        String token;
        int index = line.indexOf(del);
        if(index < 0) {
            token = line;
            line = "";
        } else {
            token = line.substring(0, index);
            line = line.substring(index + del.length()); // Adjust to remove the delimiter
            removerDelimiters();
        }
        return token;
    }

    public static void main(String[] args) {
        String del = "abc";
        String line = "abcabc123abcabc789";

        MyStringTokenizer tokenizer = new MyStringTokenizer(line, del);

        while (tokenizer.hasMoreTokens()) { // Added braces for clarity and future-proofing
            System.out.println(tokenizer.nextToken());
        }
    }
}