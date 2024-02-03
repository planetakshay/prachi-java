package practice2023.strings;

public class findPattern {
    StringBuilder pat = new StringBuilder();
    StringBuilder stream = new StringBuilder();

    /**
     * Need to write a better implementation using KMP algorithm
     * for pattern matching in a stream.
     *
     * The below implementation is exceeding time limit in Leetcode.
     * @param infiniteStream
     * @param pattern
     * @return
     */
    public int findPattern(InfiniteStream infiniteStream, int[] pattern) {
        for (int num : pattern) {
            pat.append(num);
        }
        String temp = pat.toString();
        while (stream.indexOf(temp) < 0) {
            stream.append(infiniteStream.next());
        }
        return stream.indexOf(temp);
    }
}

class InfiniteStream {
    int index = 0;
    String text = "101010101010000111111110000110101010110101010101111010101010010001111110010101010100101010110101010101010";
    public int next() {
        char ch = text.charAt(index++);
        return 1 - ch;
    }
}