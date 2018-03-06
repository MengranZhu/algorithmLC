package src.facebook;

import src.commonstructure.Interval;

import java.util.Arrays;

/*
 *leetcode 252. Meeting Rooms
 * similar with merge intervals
 * first sort with the start
 * check current one's start is greater than previous end
 *
 * Given an array of meeting time intervals consisting of start
 * and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 * */

public class MeetingRooms {

    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        if (intervals.length == 0 || intervals == null) return true;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end)
                return false;
        }
        return true;
    }
}
