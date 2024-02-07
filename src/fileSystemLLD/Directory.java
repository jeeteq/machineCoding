package fileSystemLLD;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Directory {
    private String name;
    private List<Directory> subDirectories;
    private List<File> files;

    public Directory(String name) {
        this.name = name;
        this.subDirectories = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    public Queue<File> getAllFiles() {
        Queue<File> fileList = new LinkedList<>(files);
        for (Directory subDirectory : subDirectories) {
            fileList.addAll(subDirectory.getAllFiles());
        }
        return fileList;
    }

    public void addSubDirectory(Directory directory) {
        subDirectories.add(directory);
    }

    public void addFile(File file) {
        files.add(file);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Directory> getSubDirectories() {
        return subDirectories;
    }

    public void setSubDirectories(List<Directory> subDirectories) {
        this.subDirectories = subDirectories;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
