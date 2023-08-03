package practice2023.intervals;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/range-module/description/
 */
class RangeModule {
    private TreeMap<Integer, Integer> rangeMap;
    public RangeModule() {
        rangeMap = new TreeMap<Integer, Integer>();
    }

    public static void main(String[] args) {
        RangeModule module = new RangeModule();
        module.addRange(10, 20);
        module.removeRange(14,16);
        boolean covered = module.queryRange(10, 14);
        covered = module.queryRange(13,15);
        covered = module.queryRange(16,17);
        module.addRange(22, 24);
        module.addRange(24, 28);

        covered = module.queryRange(10,28);
        module.addRange(8,30);
        covered = module.queryRange(14,16);
    }

    public void addRange(int left, int right) {
        Integer pre = rangeMap.floorKey(left);
        Integer next = rangeMap.floorKey(right);
        // Check if a lower than left key exists in the map,
        // if yes that means pre needs to be preserved as left
        // higher than pre.
        if(pre != null && rangeMap.get(pre) >= left) {
            left = pre;
        }
        // Check if higher than right value exists in the tree map
        // if yes then that means right is less than existing range
        // preserve the higher value in the map.
        if(next != null && rangeMap.get(next) > right) {
            right = rangeMap.get(next);
        }
        // This is important as if the map is not cleared of the already
        // existing range when an inclusive range is inserted we will have
        // duplicate ranges and that will impact getting correct result
        // from queryRange method.

        rangeMap.subMap(left, true, right, false).clear();
        rangeMap.put(left, right);
    }
    public boolean queryRange(int left, int right) {
        Integer pre = rangeMap.floorKey(left);
        if(pre != null && rangeMap.get(pre) >= right) {
            return true;
        }
        return false;
    }
    public void removeRange(int left, int right) {
        Integer pre = rangeMap.floorKey(left);
        Integer next = rangeMap.floorKey(right);
        if(next != null && rangeMap.get(next) > right) {
            rangeMap.put(right, rangeMap.get(next));
        }
        if(pre != null && rangeMap.get(pre) >= left) {
            rangeMap.put(pre, left);
        }
        rangeMap.subMap(left, true, right, false).clear();
    }
}
