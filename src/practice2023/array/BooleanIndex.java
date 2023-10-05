package practice2023.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BooleanIndex {

    private final boolean[] toggle;

    public BooleanIndex(int size) {
        this.toggle = new boolean[size];
    }

    public static void main(String[] args) {
        int N = 5;
        List<Query> queries = new ArrayList<>(5);
        Query query = new Query(2, 3);
        queries.add(query);
        query = new Query(1, 2);
        queries.add(query);
        query = new Query(2, 1);
        queries.add(query);
        query = new Query(2, 3);
        queries.add(query);
        query = new Query(2, 2);
        queries.add(query);

        BooleanIndex booleanIndex = new BooleanIndex(N + 1);
        System.out.println(Arrays.toString(booleanIndex.answerQueries(queries, N)));
    }

    public int[] answerQueries(List<Query> queries, int n) {
        if (n < 0 || queries == null || queries.isEmpty()) {
            return null;
        }
        int noOfQueries = queries.size();
        List<Integer> indices = new ArrayList<>();
        int len = toggle.length;

        for (int i = 0; i < noOfQueries; i++) {
            Query query = queries.get(i);
            int type = query.getType();
            int index = query.getIndex();
            if (type == 1) {
                toggle[i + 1] = !toggle[i + 1];
            } else if (type == 2) {
                indices.add(findTrue(index, len));
            }
        }
        int[] firstPositive = new int[indices.size()];
        for (int i = 0; i < firstPositive.length; i++) {
            firstPositive[i] = indices.get(i);
        }
        return firstPositive;
    }

    private int findTrue(int start, int n) {
        int index = -1;
        for (int j = start; j < n; j++) {
            if (toggle[j]) {
                index = j;
                break;
            }
        }
        return index;
    }
}

class Query {
    int type;
    int index;

    public Query(int type, int index) {
        this.type = type;
        this.index = index;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}