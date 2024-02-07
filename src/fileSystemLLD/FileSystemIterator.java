package fileSystemLLD;

import java.util.LinkedList;
import java.util.Queue;

public class FileSystemIterator {
    private final Queue<File> fileQueue;

    public FileSystemIterator(Directory root) {
        this.fileQueue = new LinkedList<>();
        intializeFileQueue(root);
    }

    private void intializeFileQueue(Directory root) {
        fileQueue.addAll(root.getFiles());
        for (Directory directory : root.getSubDirectories()) {
            intializeFileQueue(directory);
        }
    }

    public boolean hasNext(){
        return !fileQueue.isEmpty();
    }

    public File moveNext(){
        if(hasNext()){
            return fileQueue.poll();
        }
        return null;
    }
}
