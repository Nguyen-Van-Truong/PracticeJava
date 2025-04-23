package WishdomInterview.InterviewQuestion1;

import java.util.Comparator;

class TimeComparator implements Comparator<LocationTime> {
    @Override
    public int compare(LocationTime lt1, LocationTime lt2) {
        return lt1.time.compareTo(lt2.time);
    }
}
