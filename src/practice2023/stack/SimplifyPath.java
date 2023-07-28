package practice2023.stack;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        String str = "/home/";
        System.out.println("Simplfied Path: " + simplifyPath(str));

        str = "/../";
        System.out.println("Simplfied Path: " + simplifyPath(str));

        str = "/home//foo/";
        System.out.println("Simplfied Path: " + simplifyPath(str));
    }

    public static String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }

        String[] segments = path.split("/");
        Stack<String> canonical = new Stack<>();

        for (String segment : segments) {
            if (segment.isBlank() || segment.equals(".")) {
                continue;
            }
            if (segment.equals("..")) {
                if (!canonical.isEmpty()) {
                    canonical.pop();
                }
            } else {
                canonical.push(segment);
            }
        }
        return "/" + String.join("/", canonical);
    }
}
