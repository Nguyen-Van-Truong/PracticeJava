import java.util.*;

class LogEntry {
    String location;
    String time;

    public LogEntry(String location, String time) {
        this.location = location;
        this.time = time;
    }

    // Phương thức so sánh theo thời gian
    public static Comparator<LogEntry> sortByTime() {
        return new Comparator<LogEntry>() {
            @Override
            public int compare(LogEntry e1, LogEntry e2) {
                return e1.time.compareTo(e2.time);
            }
        };
    }

    // Phương thức so sánh theo địa điểm (stable)
    public static Comparator<LogEntry> sortByLocationStable() {
        return new Comparator<LogEntry>() {
            @Override
            public int compare(LogEntry e1, LogEntry e2) {
                return e1.location.compareTo(e2.location);
            }
        };
    }

    // Phương thức so sánh theo địa điểm (unstable)
    public static Comparator<LogEntry> sortByLocationUnstable() {
        return new Comparator<LogEntry>() {
            @Override
            public int compare(LogEntry e1, LogEntry e2) {
                return e1.location.compareTo(e2.location);
            }
        };
    }

    @Override
    public String toString() {
        return location + " " + time;
    }
}

public class LogSorter {
    public static void main(String[] args) {
        // Danh sách bản ghi ban đầu
        List<LogEntry> logs = new ArrayList<>();
        logs.add(new LogEntry("Chicago", "09:00:00"));
        logs.add(new LogEntry("Phoenix", "09:00:03"));
        logs.add(new LogEntry("Houston", "09:00:13"));
        logs.add(new LogEntry("Chicago", "09:00:59"));
        logs.add(new LogEntry("Houston", "09:01:10"));
        logs.add(new LogEntry("Chicago", "09:03:13"));
        logs.add(new LogEntry("Seattle", "09:10:11"));
        logs.add(new LogEntry("Seattle", "09:10:25"));
        logs.add(new LogEntry("Phoenix", "09:14:25"));
        logs.add(new LogEntry("Chicago", "09:19:32"));
        logs.add(new LogEntry("Chicago", "09:19:46"));
        logs.add(new LogEntry("Chicago", "09:21:05"));
        logs.add(new LogEntry("Seattle", "09:22:43"));
        logs.add(new LogEntry("Seattle", "09:22:54"));
        logs.add(new LogEntry("Chicago", "09:25:52"));
        logs.add(new LogEntry("Chicago", "09:35:21"));
        logs.add(new LogEntry("Seattle", "09:36:14"));
        logs.add(new LogEntry("Phoenix", "09:37:44"));

        // Sắp xếp theo thời gian
        Collections.sort(logs, LogEntry.sortByTime());
        System.out.println("Sorted by time:");
        for (LogEntry log : logs) {
            System.out.println(log);
        }

        // Sắp xếp theo địa điểm (stable)
        Collections.sort(logs, LogEntry.sortByLocationStable());
        System.out.println("\nSorted by location (stable):");
        for (LogEntry log : logs) {
            System.out.println(log);
        }

        // Sắp xếp theo địa điểm (unstable)
        logs.sort(LogEntry.sortByLocationUnstable());
        System.out.println("\nSorted by location (unstable):");
        for (LogEntry log : logs) {
            System.out.println(log);
        }
    }
}
