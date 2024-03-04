package practice2023.design;

import java.util.*;

/**
 * https://leetcode.com/problems/design-in-memory-file-system/submissions/
 * <p>
 * Snowflake phone screen.
 * Nvidia Onsite.
 * <p>
 * Starting from the root
 * At each level the children map will contain files and folders under it.
 * <p>
 * Design a cloud service like AWS Lambda.
 */
public class InMemoryFileSystem {
    File root;

    public InMemoryFileSystem() {
        root = new File(true);
    }

    public static void main(String[] args) {
        InMemoryFileSystem inMemoryFileSystem = new InMemoryFileSystem();
        inMemoryFileSystem.mkdir("/a");
        inMemoryFileSystem.mkdir("/a/b");
        inMemoryFileSystem.mkdir("/a/b/c");
        inMemoryFileSystem.mkdir("/a/b/c/d");
        String path = "/a/b";
        try {
            System.out.println(inMemoryFileSystem.ls(path));
            path = "/";
            System.out.println(inMemoryFileSystem.ls(path));
            path = "/a/x/y/z";
            System.out.println(inMemoryFileSystem.ls(path));
        } catch (Exception e) {
            System.out.println(e.getMessage() + ": " + path);
        }
        inMemoryFileSystem.addContentToFile("/a/b/c/d/text.txt", "Prachi Deodhar");
        System.out.println("File contents: ");
        System.out.println(inMemoryFileSystem.readContentFromFile("/a/b/c/d/text.txt"));
        inMemoryFileSystem.addContentToFile("/a/b/c/d/text.txt", "\n10141 Prado Vista Avenue, Cupertino, CA 95014");
        System.out.println(inMemoryFileSystem.readContentFromFile("/a/b/c/d/text.txt"));
    }

    public List<String> ls(String path) throws Exception {
        File file = root;
        List<String> allFiles = new ArrayList<>();
        String[] dirs = path.split("/");
        int len = dirs.length;
        if(len < 1) {
            allFiles.addAll(root.files.keySet());
        } else {
            for (int i = 1; i < len; i++) {
                if (file.files.containsKey(dirs[i])) {
                    file = file.files.get(dirs[i]);
                } else {
                    throw new Exception("Invalid path");
                }
            }
            if (!file.isDir) {
                if (file.files.containsKey(dirs[len - 1])) {
                    return Collections.singletonList(dirs[len - 1]);
                }
            } else {
                allFiles.addAll(file.files.keySet());
            }
            // The list must be sorted alphabetically.
            Collections.sort(allFiles);
        }
        return allFiles;
    }

    public void mkdir(String path) {
        File file = root;
        String[] dirs = path.split("/");
        int len = dirs.length;
        for (int i = 1; i < len; i++) {
            String dir = dirs[i];
            if (!file.files.containsKey(dir)) {
                file.files.put(dir, new File(true));
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
            file.files.put(dirs[len - 1], new File(false));
        }
        file = file.files.get(dirs[len - 1]);
        file.isDir = false;
        String originalContent = file.content;
        if(originalContent == null || originalContent.isBlank()) {
            originalContent = content;
        } else {
            originalContent += content;
        }
        file.content = originalContent;
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

    private File find(String path) throws Exception {
        File file = root;
        String[] dirs = path.split("/");
        int len = dirs.length;
        for (int i = 1; i < len; i++) {
            if (file.files.containsKey(dirs[i])) {
                file = file.files.get(dirs[i]);
            }
        }
        if (file == root) {
            throw new Exception("File not found.");
        }
        return file;
    }

    class File {
        // This might create a situation where files is null and
        // content is null but isDir is set to true.
        // Treat it as an empty directory in that case.
        boolean isDir;
        Map<String, File> files = new HashMap<>();
        String content;

        public File(boolean isDir) {
            this.isDir = isDir;
        }
    }
}