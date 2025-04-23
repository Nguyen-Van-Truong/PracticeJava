package WishdomInterview.InterviewQuestion1;

import java.util.Comparator;

class StableLocationComparator implements Comparator<LocationTime> {
    @Override
    public int compare(LocationTime lt1, LocationTime lt2) {
        int locationComparison = lt1.location.compareTo(lt2.location);
//        System.out.println("locationComparison:" + locationComparison + ", lt1.location:" + lt1.location + ", lt2.location:" + lt2.location);
        if (locationComparison != 0) {
            return locationComparison;
        }
        return lt1.time.compareTo(lt2.time);
    }
}
