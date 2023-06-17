import java.util.*;


public class SmallestSetOfIntegers {
    public static void main(String[] args) {
        int[] first = {0, 1, 2};
        int[] last = {2, 3, 3};

        int result = smallestSetSize(first, last);
        System.out.println("Smallest set size: " + result);
    }

    public static int smallestSetSize(int[] first, int[] last) {
        List<Interval> intervals = new ArrayList<>();

        // Create Interval objects from the given arrays
        for (int i = 0; i < first.length; i++) {
            intervals.add(new Interval(first[i], last[i]));
        }

        // Sort the intervals based on their end points
        intervals.sort(Comparator.comparingInt(Interval::getLast));

        Set<Integer> set = new HashSet<>();
        int setSize = 0;

        for (Interval interval : intervals) {
            // Add the numbers from the current interval to the set
            for (int i = interval.getFirst(); i <= interval.getLast(); i++) {
                set.add(i);
                setSize++;
            }

            // Remove numbers that exceed the count of 2 from previous intervals
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()) {
                int num = iterator.next();
                if (countOccurrences(num, intervals) < 2) {
                    iterator.remove();
                    setSize--;
                }
            }
        }

        return setSize;
    }

    private static int countOccurrences(int num, List<Interval> intervals) {
        int count = 0;
        for (Interval interval : intervals) {
            if (num >= interval.getFirst() && num <= interval.getLast()) {
                count++;
            }
        }
        return count;
    }

    static class Interval {
        private final int first;
        private final int last;

        public Interval(int first, int last) {
            this.first = first;
            this.last = last;
        }

        public int getFirst() {
            return first;
        }

        public int getLast() {
            return last;
        }
    }
}
