package algo;

import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

public class Array {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,24,13,44,14,20,40,12,24,1,13};
        System.out.println(dedupArray(arr));
    }

    public static List<Integer> dedupArray(Integer[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }
        return Arrays.stream(arr).distinct().collect(Collectors.toList());
    }

    public void findFirstDate(String quarter, int year) {
        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.with(IsoFields.DAY_OF_QUARTER, 1L);
        LocalDate lastDay = firstDay.plusMonths(2).with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(firstDay);
        System.out.println(lastDay);
    }
}