package tutor;

/**
 * Tutor.com problems.
 */
public class MathI {
    public static IntObject someMethod(IntObject obj) {
        IntObject ans = obj;
        ans.increment();
        return ans;
    }
    public static void main(String[] args) {
        IntObject x = new IntObject(2);
        IntObject y = new IntObject(7);
        IntObject a = y;
        x = someMethod(y);
        a = someMethod(x);
        System.out.println(x);
        System.out.println(x.num);
        System.out.println(y);
        System.out.println(y.num);
        System.out.println(a);
        System.out.println(a.num);
    }
}

class IntObject {
    int num;

    public int getNum() {
        return num;
    }

    public IntObject(int num) {
        this.num = num;
    }

    public void increment() {
        num++;
    }
}