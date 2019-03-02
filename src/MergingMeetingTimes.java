import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergingMeetingTimes {

    public static void main(String[] args) {
        List<Meeting> meetings = new ArrayList<>(Arrays.asList(new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8), new Meeting(10, 12), new Meeting(9, 10)));
        MergingMeetingTimes mergingMeetingTimes = new MergingMeetingTimes();
        mergingMeetingTimes.quickSort(meetings, 0, meetings.size() - 1);
        char[] chars = new char[]{'a', 'b', 'c'};

        for (Meeting meeting : meetings) {
            System.out.println("Meeting(" + meeting.startTime + ", " + meeting.endTime + ")");
        }

        int i = 0;
        while (i < meetings.size() - 1) {
            Meeting meeting1 = meetings.get(i);
            Meeting meeting2 = meetings.get(i + 1);
            if (meeting1.endTime >= meeting2.startTime && meeting1.endTime >= meeting2.endTime) {
                meetings.remove(meeting2);
            } else if (meeting1.endTime >= meeting2.startTime) {
                Meeting meeting = new Meeting(meeting1.startTime, meeting2.endTime);
                meetings.remove(meeting1);
                meetings.remove(meeting2);
                meetings.add(i, meeting);
            } else {
                i += 1;
            }
        }

        for (Meeting meeting : meetings) {
            System.out.println("Meeting(" + meeting.startTime + ", " + meeting.endTime + ")");
        }
    }

    private void quickSort(List<Meeting> meetings, int start, int end) {
        if (start < end) {
            int partition = partition(meetings, start, end);
            quickSort(meetings, start, partition - 1);
            quickSort(meetings, partition + 1, end);
        }
    }

    private int partition(List<Meeting> meetings, int start, int end) {
        Meeting pivot = meetings.get(end);
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (meetings.get(j).compareTo(pivot) <= 0) {
                i += 1;
                Collections.swap(meetings, i, j);
            }
        }
        Collections.swap(meetings, i + 1, end);
        return i + 1;
    }

    private static class Meeting implements Comparable<Meeting> {
        private Integer startTime;
        private Integer endTime;

        public Meeting(Integer startTime, Integer endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meeting meeting) {
            return startTime.compareTo(meeting.startTime);
        }
    }
}
