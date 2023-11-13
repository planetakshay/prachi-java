package practice2023.basics;

public class Basic {
    public static void main(String[] args) {
        int i = 0;
        for(; i< 5;i++);
        System.out.println(i);
        System.out.println(mystery(new int[]{2,3,4,1}, 1, 1));

        Vegetables veges = new Vegetables("Potato");
        System.out.println(veges.getName());

        int x = 3;
        int y = (x > 2 ? 2 * x : 3 * x);
        System.out.println(y);

        x = 2147483647;
        System.out.println(x + 1);

        System.out.println(xValid(2));
        System.out.println(xValid(8));
        System.out.println(xValid(18));
        System.out.println(xValid(28));
        System.out.println(xValid(128));

        int a = 3;

        switch(a) {
            case 1: System.out.println(1);
            case 2:
            case 3: System.out.println(3);
            case 4:
            case 5: System.out.println(5);
            default: System.out.println(0);
        }

        int num = 100;
        int zero = 0;
        System.out.println(100/--zero);

        String[] arr = new String[] {"a", "b", "c", "d"};
        for(int ii = 0;ii < 3; ii++) {
            for(String test : arr) {
                System.out.print(test + " ");
                if(ii == 2) {
                    break;
                }
            }
        }
    }

    public static boolean xValid(int x) {
        return x == 2 * (x / 10 + x % 10);
    }

    static int mystery(int[] a, int index, int result) {
        if(index < a.length) {
            return mystery(a, index + 1, result * a[index]);
        }
        return result;
    }
}

class Vegetables {
    final String name;

    public Vegetables(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}