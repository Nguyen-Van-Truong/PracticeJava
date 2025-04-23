package WishdomInterview.InterviewQuestion1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
    private static void printLocationTimes(List<LocationTime> locationTimes) {
        for (LocationTime record : locationTimes) {
            System.out.println(record);
        }
    }

    public static void main(String[] args) {
        List<LocationTime> locationTimes = new ArrayList<>();
        locationTimes.add(new LocationTime("Chicago", "09:00:00"));
        locationTimes.add(new LocationTime("Phoenix", "09:00:03"));
        locationTimes.add(new LocationTime("Houston", "09:00:13"));
        locationTimes.add(new LocationTime("Chicago", "09:00:59"));
        locationTimes.add(new LocationTime("Houston", "09:01:10"));
        locationTimes.add(new LocationTime("Chicago", "09:03:13"));
        locationTimes.add(new LocationTime("Seattle", "09:10:11"));
        locationTimes.add(new LocationTime("Seattle", "09:10:25"));
        locationTimes.add(new LocationTime("Phoenix", "09:14:25"));
        locationTimes.add(new LocationTime("Chicago", "09:19:32"));
        locationTimes.add(new LocationTime("Chicago", "09:19:46"));
        locationTimes.add(new LocationTime("Chicago", "09:21:05"));
        locationTimes.add(new LocationTime("Seattle", "09:22:43"));
        locationTimes.add(new LocationTime("Seattle", "09:22:54"));
        locationTimes.add(new LocationTime("Chicago", "09:25:52"));
        locationTimes.add(new LocationTime("Chicago", "09:35:21"));
        locationTimes.add(new LocationTime("Seattle", "09:36:14"));
        locationTimes.add(new LocationTime("Phoenix", "09:37:44"));

        System.out.println("Sort by time:");
        Collections.sort(locationTimes, new TimeComparator());
        printLocationTimes(locationTimes);

        System.out.println("\nSort by location time:");
        Collections.sort(locationTimes, new LocationComparator());
        printLocationTimes(locationTimes);

        System.out.println("\nSort by stable location time :");
        Collections.sort(locationTimes, new StableLocationComparator());
        printLocationTimes(locationTimes);
    }
}
