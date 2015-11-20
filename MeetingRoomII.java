/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        //Time: O(n), Space: O(n)
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int rst = 0;
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        HashMap<Integer, Integer> starts = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> ends = new HashMap<Integer, Integer>();
        for (Interval i : intervals) {
            start = Math.min(start, i.start);
            end = Math.max(end, i.end);
            if (!starts.containsKey(i.start)) {
                starts.put(i.start, 0);
            }
            starts.put(i.start, starts.get(i.start) + 1);
            if (!ends.containsKey(i.end)) {
                ends.put(i.end, 0);
            }
            ends.put(i.end, ends.get(i.end) + 1);
        }
        int room = 0;
        for (int i = start; i <= end; i++) {
            if (starts.containsKey(i)) {
                room += starts.get(i);
            }
            if (ends.containsKey(i)) {
                room -= ends.get(i);
            }
            rst = Math.max(rst, room);
        }
        return rst;
    }
}