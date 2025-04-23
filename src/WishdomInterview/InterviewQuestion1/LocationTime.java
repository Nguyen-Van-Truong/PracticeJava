package WishdomInterview.InterviewQuestion1;

class LocationTime {
    String location;
    String time;

    LocationTime(String location, String time) {
        this.location = location;
        this.time = time;
    }

    @Override
    public String toString() {
        return location + " " + time;
    }
}

