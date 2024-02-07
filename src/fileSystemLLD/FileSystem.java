package com.example.jeetendra.files;

import java.util.List;

public class FileSystem {

    private final Directory root;

    public FileSystem() {
        this.root = new Directory("root");
    }

    public void createFile(String path) {
        String[] pathElements = path.split("/");
        Directory currDirectory = root;

        for (int i = 0; i < pathElements.length - 1; i++) {
            String directName = pathElements[i];
            List<Directory> subDirectories = currDirectory.getSubDirectories();
            boolean found = false;

            for (Directory subDir : subDirectories) {
                if (subDir.getName().equals(directName)) {
                    currDirectory = subDir;
                    found = true;
                    break;
                }
            }

            if (!found) {
                Directory newSubDirectory = new Directory(directName);
                subDirectories.add(newSubDirectory);
                currDirectory = newSubDirectory;
            }
        }

        String fileName = pathElements[pathElements.length - 1];
        currDirectory.addFile(new File(fileName));
    }
}
