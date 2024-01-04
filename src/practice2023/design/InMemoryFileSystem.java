package practice2023.design;

import java.util.*;

/**
 * https://leetcode.com/problems/design-in-memory-file-system/submissions/
 *
 * Snowflake phone screen.
 */
public class InMemoryFileSystem {
    File root;

    public InMemoryFileSystem() {
        root = new File();
    }

    public List<String> ls(String path) {
        File file = root;
        if (!path.equals("/")) {
            String[] dirs = path.split("/");
            int len = dirs.length;
            for (int i = 1; i < len; i++) {
                file = file.files.get(dirs[i]);
            }
            if (!file.isDir) {
                return Collections.singletonList(dirs[len - 1]);
            }
        }
        List<String> allFiles = new ArrayList<>(file.files.keySet());
        Collections.sort(allFiles);
        return allFiles;
    }

    public void mkdir(String path) {
        File file = root;
        String[] dirs = path.split("/");
        int len = dirs.length;
        for (int i = 1; i < len; i++) {
            String dir = dirs[i];
            if (!file.files.containsKey(dir)) {
                file.files.put(dir, new File());
            }
            file = file.files.get(dir);
        }
    }

    public void addContentToFile(String filePath, String content) {
        File file = root;
        String[] dirs = filePath.split("/");
        int len = dirs.length;
        for (int i = 1; i < len - 1; i++) {
            file = file.files.get(dirs[i]);
        }
        if (!file.files.containsKey(dirs[len - 1])) {
            file.files.put(dirs[len - 1], new File());
        }
        file = file.files.get(dirs[len - 1]);
        file.isDir = false;
        file.content = file.content + content;
    }

    public String readContentFromFile(String filePath) {
        File file = root;
        String[] dirs = filePath.split("/");
        int len = dirs.length;
        for (int i = 1; i < len - 1; i++) {
            file = file.files.get(dirs[i]);
        }
        return file.files.get(dirs[len - 1]).content;
    }

    class File {
        boolean isDir = true;
        Map<String, File> files = new HashMap<>();
        String content;
    }
}