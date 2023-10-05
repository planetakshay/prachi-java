package practice2023.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Coupang phone interview
 */
public class ImplementLinuxFindCommand {
    File root;

    public ImplementLinuxFindCommand(File root) {
        this.root = root;
    }

    public List<String> findMatchingFiles(String filePath, String size, File.FileType type) {
        Filter filter = new Filter(filePath, size, type);
        List<String> files = new LinkedList<>();
        Queue<File> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            File curr = queue.poll();
            if (curr.isDir) {
                for (File file : curr.subDirs) {
                    queue.add(file);
                }
            } else {
                if (filter.applyFilters(curr)) {
                    files.add(curr.filePath);
                }
            }
        }
        return files;
    }
}

class File {
    String filePath;
    FileType type;
    String size;
    boolean isDir;
    List<File> subDirs;

    enum FileType {
        XML("XML"),
        TXT("txt");
        String type;

        FileType(String type) {
            this.type = type;
        }
    }
}

class Filter {
    File.FileType type;
    String size;

    String filePath;

    public Filter(String filePath, String size, File.FileType type) {
        this.type = type;
        this.size = size;
        this.filePath = filePath;
    }

    public boolean applyFilters(File file) {
        return sizeCriteriaMatches(file) &&
                typeCriteriaMatches(file) &&
                nameCriteriaMatches(file);
    }

    public boolean sizeCriteriaMatches(File file) {
        return file.size == this.size;
    }

    public boolean typeCriteriaMatches(File file) {
        return file.type == this.type;
    }

    public boolean nameCriteriaMatches(File file) {
        return file.filePath == this.filePath;
    }
}