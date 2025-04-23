package WishdomInterview.InterviewQuestion1;

import java.util.Comparator;

class LocationComparator implements Comparator<LocationTime> {
    @Override
    public int compare(LocationTime lt1, LocationTime lt2) {
        return lt1.location.compareTo(lt2.location);
    }
}
