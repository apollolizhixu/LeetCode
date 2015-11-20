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
    Comparator<Interval> comparator = new Comparator<Interval>(){
        //Time: O(nlogn), Space: O(1)
        public int compare(Interval i1, Interval i2) {
            if (i1.start < i2.start){
                return -1;
            } else if (i1.start > i2.start) {
                return 1;
            }
            return 0;
        }
    };
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }
        Arrays.sort(intervals, comparator);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }
}